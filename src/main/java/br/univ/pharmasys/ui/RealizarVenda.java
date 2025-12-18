package br.univ.pharmasys.ui;

import br.univ.pharmasys.dao.MedicamentoDAO;
import br.univ.pharmasys.dao.NotaFiscalDAO;
import br.univ.pharmasys.model.ItemNotaFiscal;
import br.univ.pharmasys.model.Medicamento;
import br.univ.pharmasys.model.NotaFiscal;
import br.univ.pharmasys.util.ConnectionFactory;
import br.univ.pharmasys.util.GeradorQrCode;

import javax.swing.*;
import javax.swing.table.DefaultTableModel; // Importante para a tabela
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class RealizarVenda extends JFrame {

    // --- Variáveis de Lógica ---
    private List<ItemNotaFiscal> carrinho = new ArrayList<>();
    private BigDecimal totalVenda = BigDecimal.ZERO;
    private Long idFuncionarioLogado; // Armazena o ID do funcionário

    // --- Variáveis da Tabela ---
    private JTable tabelaItens;
    private DefaultTableModel tableModel;
    
    public RealizarVenda() {
        initComponents();
        configurarTabela(); // Configura a tabela visual
        initRelogio();
        
        // Ações dos botões
        buttonFinalizarCompra.addActionListener(e -> finalizarVendaEExibirQrCode());
        buttonScanner.addActionListener(e -> abrirScanner());
    }

    // --- MÉTODO PARA CONFIGURAR A TABELA ---
    private void configurarTabela() {
        // Define as colunas
        String[] colunas = {"Cód/SKU", "Produto", "Qtd", "Preço Unit.", "Subtotal"};
        
        // Cria o modelo da tabela (dados + colunas)
        tableModel = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Impede edição direta na célula
            }
        };
        
        tabelaItens = new JTable(tableModel);
        tabelaItens.setRowHeight(25);
        tabelaItens.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tabelaItens.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        // Adiciona a tabela dentro de um ScrollPane para ter barra de rolagem
        JScrollPane scrollPane = new JScrollPane(tabelaItens);
        
        // Adiciona o scrollPane ao jPanel1 (painel central)
        jPanel1.setLayout(new BorderLayout());
        jPanel1.removeAll(); // Remove labels antigos
        jPanel1.add(scrollPane, BorderLayout.CENTER);
        jPanel1.revalidate();
        jPanel1.repaint();
    }

    // --- LÓGICA DE NEGÓCIO ---

    /**
     * Define o usuário logado (ID e Nome) para usar na Nota Fiscal
     */
    public void definirUsuarioLogado(Long id, String nome) {
        this.idFuncionarioLogado = id;
        labelNome.setText(nome);
    }

    private void abrirScanner() {
        TelaScanner scanner = new TelaScanner();
        scanner.setListener(skuOuCodigo -> {
            buscarEAdicionarProduto(skuOuCodigo);
            scanner.dispose(); 
        });
        scanner.setVisible(true);
    }

    private void buscarEAdicionarProduto(String sku) {
        MedicamentoDAO dao = new MedicamentoDAO();
        Medicamento med = dao.buscarPorSku(sku);

        if (med != null) {
            String qtdStr = JOptionPane.showInputDialog(this, 
                    "Produto encontrado: " + med.getNomeComercial() + "\nQuantidade:", "1");
            
            if (qtdStr != null && !qtdStr.isEmpty()) {
                try {
                    int quantidade = Integer.parseInt(qtdStr);
                    // Valida estoque
                    if(quantidade > med.getEstoqueAtual()){
                         JOptionPane.showMessageDialog(this, "Estoque insuficiente! Disponível: " + med.getEstoqueAtual(), "Erro", JOptionPane.ERROR_MESSAGE);
                         return;
                    }
                    
                    if(quantidade > 0) {
                        adicionarProdutoAoCarrinho(med, quantidade);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Quantidade inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Produto não encontrado com o código: " + sku, "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Adiciona ao carrinho lógico E atualiza a tabela visual.
     */
    public void adicionarProdutoAoCarrinho(Medicamento med, int quantidade) {
        ItemNotaFiscal item = new ItemNotaFiscal(med, quantidade, med.getPreco());
        carrinho.add(item);
        
        // Atualiza o total
        totalVenda = totalVenda.add(item.getSubtotal());
        labelTotal.setText("Total: R$ " + totalVenda.toString().replace(".", ","));
        
        // --- ATUALIZA A TABELA VISUAL ---
        tableModel.addRow(new Object[]{
            med.getSku(),
            med.getNomeComercial(),
            quantidade,
            "R$ " + med.getPreco(),
            "R$ " + item.getSubtotal()
        });
        
        // Rola a tabela para a última linha adicionada
        tabelaItens.scrollRectToVisible(tabelaItens.getCellRect(tabelaItens.getRowCount()-1, 0, true));
    }

    private void finalizarVendaEExibirQrCode() {
        if (carrinho.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O carrinho está vazio! Adicione produtos antes de finalizar.");
            return;
        }

        if (idFuncionarioLogado == null) {
            JOptionPane.showMessageDialog(this, "Erro: Funcionário não identificado. Faça login novamente.");
            return;
        }

        try {
            // 1. Criar a Nota Fiscal e vincular ID DO FUNCIONÁRIO
            NotaFiscal nf = new NotaFiscal();
            nf.setNumeroNota("NF-" + System.currentTimeMillis());
            nf.setValorTotal(totalVenda);
            nf.setCpfCliente("000.000.000-00");
            
            // Supondo que sua classe NotaFiscal tenha este método (adicione-o no modelo se não tiver)
             nf.setId(idFuncionarioLogado); 

            // 2. Salvar Nota Fiscal (Gera ID)
            NotaFiscalDAO nfDao = new NotaFiscalDAO();
            Long idNota = nfDao.salvar(nf); 
            nf.setId(idNota);

            // 3. Salvar Itens e Atualizar Estoque
            MedicamentoDAO medDao = new MedicamentoDAO();
            
            for (ItemNotaFiscal item : carrinho) {
                salvarItemNoBanco(nf.getId(), item);

                Medicamento med = item.getMedicamento();
                int novoEstoque = med.getEstoqueAtual() - item.getQuantidade();
                med.setEstoqueAtual(novoEstoque);
                medDao.update(med);
            }

            // 4. Gerar QR Code
            String payloadPix = "00020126580014BR.GOV.BCB.PIX0114+551199999999520400005303986540"
                     + totalVenda.toString().replace(".", "")
                     + "5802BR5913PharmaSys6008SaoPaulo62070503***6304";
            
            String nomeArquivo = "qrcode_venda_" + idNota + ".png";
            GeradorQrCode.gerarImagemArquivo(payloadPix, nomeArquivo);

            // 5. Exibir
            mostrarDialogoQrCode(nomeArquivo, totalVenda);

            // 6. Limpar
            limparVenda();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao finalizar venda: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void mostrarDialogoQrCode(String caminhoImagem, BigDecimal valor) {
        ImageIcon icon = new ImageIcon(caminhoImagem);
        Image image = icon.getImage(); 
        Image newimg = image.getScaledInstance(250, 250,  java.awt.Image.SCALE_SMOOTH);  
        icon = new ImageIcon(newimg);  

        JOptionPane.showMessageDialog(this, 
            "Venda Registrada com Sucesso!\nValor a pagar: R$ " + valor + "\n\nEscaneie o QR Code abaixo:", 
            "Pagamento via Pix", 
            JOptionPane.PLAIN_MESSAGE, 
            icon);
    }

    private void salvarItemNoBanco(Long idNota, ItemNotaFiscal item) throws SQLException {
        String sql = "INSERT INTO ITEM_NOTA_FISCAL (ID_NOTA_FISCAL, SKU_MEDICAMENTO, QUANTIDADE, PRECO_UNITARIO, SUBTOTAL) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, idNota);
            stmt.setString(2, item.getMedicamento().getSku());
            stmt.setInt(3, item.getQuantidade());
            stmt.setBigDecimal(4, item.getPrecoUnitario());
            stmt.setBigDecimal(5, item.getSubtotal());
            stmt.executeUpdate();
        }
    }

    private void limparVenda() {
        carrinho.clear();
        tableModel.setRowCount(0); // Limpa a tabela visual
        totalVenda = BigDecimal.ZERO;
        labelTotal.setText("Total: R$ 0,00");
    }

    // --- CÓDIGO DA INTERFACE ---
    
    private void initRelogio() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        Timer timer = new Timer(1000, e -> {
            LocalTime agora = LocalTime.now();
            relogio.setText(agora.format(formato));
        });
        timer.setInitialDelay(0);
        timer.start();
    }

    private void initComponents() {

        labelLogo = new JLabel();
        labelNome = new JLabel();
        labelSeparador = new JLabel();
        labelPagamento = new JLabel();
        relogio = new JLabel();
        jPanel1 = new JPanel(); // Agora será o container da Tabela
        
        labelTotal = new JLabel();
        buttonAdicionarProduto = new JButton();
        buttonScanner = new JButton(); 
        buttonFinalizarCompra = new JButton();
        buttonVoltar = new JButton();
        rbPix = new JRadioButton();
        rbDebito = new JRadioButton();
        rbCredito = new JRadioButton();
        rbEspecie = new JRadioButton();
        grupoPagamento = new ButtonGroup();

        grupoPagamento.add(rbPix);
        grupoPagamento.add(rbDebito);
        grupoPagamento.add(rbCredito);
        grupoPagamento.add(rbEspecie);
        rbPix.setSelected(true);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        try {   
            labelLogo.setIcon(new ImageIcon(getClass().getResource("/pharmasys_logo.png")));
        } catch (Exception e) {
            labelLogo.setText("PharmaSys");
        }

        labelNome.setFont(new Font("SF Pro", 0, 14)); 
        labelNome.setText("Vendedor");

        labelSeparador.setFont(new Font("Segoe UI", 0, 14)); 
        labelSeparador.setText("|");

        relogio.setFont(new Font("SF Pro", 0, 14)); 

        labelTotal.setFont(new Font("SF Pro", 1, 16)); 
        labelTotal.setText("Total: R$ 0,00");

        // Configuração do Painel (Vai receber a tabela depois no método configurarTabela)
        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));

        buttonAdicionarProduto.setBackground(new Color(153, 153, 153));
        buttonAdicionarProduto.setText("BUSCAR MANUAL");
        buttonAdicionarProduto.addActionListener(e -> abrirDialogAdicionarProduto());

        buttonScanner.setBackground(new Color(70, 130, 180));
        buttonScanner.setForeground(Color.WHITE);
        buttonScanner.setText("SCANNER (CÓD. BARRAS)");

        buttonFinalizarCompra.setBackground(new Color(0, 153, 153));
        buttonFinalizarCompra.setForeground(Color.WHITE);
        buttonFinalizarCompra.setText("FINALIZAR COMPRA");

        labelPagamento.setFont(new Font("SF Pro", 0, 15)); 
        labelPagamento.setText("Método de pagamento:");

        rbPix.setText("Pix");
        rbDebito.setText("Débito");
        rbCredito.setText("Crédito");
        rbEspecie.setText("Em espécie");

        buttonVoltar.setText("<< Voltar");
        buttonVoltar.addActionListener(evt -> jButton3ActionPerformed(evt));

        // Layout Principal
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelLogo)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 300, Short.MAX_VALUE)
                        .addComponent(labelNome)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelSeparador)
                        .addGap(12, 12, 12)
                        .addComponent(relogio))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonVoltar)
                        .addGap(50, 50, 50)
                        .addComponent(buttonAdicionarProduto, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonScanner, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(labelPagamento)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbPix).addGap(18, 18, 18)
                                .addComponent(rbDebito).addGap(18, 18, 18)
                                .addComponent(rbCredito).addGap(18, 18, 18)
                                .addComponent(rbEspecie)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(labelTotal, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonFinalizarCompra, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLogo).addComponent(labelNome).addComponent(relogio).addComponent(labelSeparador))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAdicionarProduto, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonScanner, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonVoltar))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE) // Altura fixa para a tabela
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelTotal) // Label total logo abaixo da tabela
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(buttonFinalizarCompra, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelPagamento)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(rbPix).addComponent(rbDebito).addComponent(rbCredito).addComponent(rbEspecie))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void abrirDialogAdicionarProduto() {
        DialogAdicionarProduto dialog = new DialogAdicionarProduto(this, true);
        dialog.setVisible(true);
        Medicamento medSelecionado = dialog.getMedicamentoSelecionado();
        
        if (medSelecionado != null) {
            String qtdStr = JOptionPane.showInputDialog(this, 
                    "Produto: " + medSelecionado.getNomeComercial() + 
                    "\nPreço Unitário: R$ " + medSelecionado.getPreco() +
                    "\n\nDigite a quantidade:", "1");
            
            if (qtdStr != null && !qtdStr.isEmpty()) {
                try {
                    int quantidade = Integer.parseInt(qtdStr);
                    if (quantidade > medSelecionado.getEstoqueAtual()) {
                        JOptionPane.showMessageDialog(this, "Estoque insuficiente!", "Aviso", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if (quantidade > 0) {
                        adicionarProdutoAoCarrinho(medSelecionado, quantidade);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Quantidade inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    private void jButton3ActionPerformed(ActionEvent evt) {                           
        int escolha = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja cancelar?", "Cancelar Venda", JOptionPane.YES_NO_OPTION);
        if (escolha == JOptionPane.YES_OPTION) {
            new ZNovaTelaFuncionario().setVisible(true);
            this.dispose();
        }
    }
    
    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new RealizarVenda().setVisible(true));
    }

    private JButton buttonAdicionarProduto;
    private JButton buttonScanner; 
    private JButton buttonFinalizarCompra;
    private JButton buttonVoltar;
    private JRadioButton rbPix, rbDebito, rbCredito, rbEspecie;
    private ButtonGroup grupoPagamento;
    private JLabel labelLogo, labelTotal, labelPagamento, labelNome, relogio, labelSeparador;
    private JPanel jPanel1;
}


