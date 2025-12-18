package br.univ.pharmasys.ui;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import br.univ.pharmasys.model.Medicamento;
import br.univ.pharmasys.model.Funcionario; // Importante!
import br.univ.pharmasys.dao.MedicamentoDAO;
import java.util.List;
import javax.swing.JOptionPane;

public class ZNovaTelaFuncionario extends javax.swing.JFrame {

    // Variável para armazenar quem está logado nesta sessão
    private Funcionario funcionarioLogado;

    public ZNovaTelaFuncionario() {
        initComponents();
        buttonRealizarVenda.setText("<html><center>Realizar<br>Venda</center></html>");
        buttonVisualizarEstoque.setText("<html><center>Visualizar<br>Estoque</center></html>");
        jButton1.setText("<html><center>Buscar por<br>Scanner</center></html>");
        buttonRealizarVenda.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 16));
        buttonVisualizarEstoque.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 16));
        jButton1.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 16));
        initRelogio();
        setLocationRelativeTo(null);
        pack();
    }

    private void initRelogio() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        Timer timer = new Timer(1000, e -> {
            LocalTime agora = LocalTime.now();
            relogio.setText(agora.format(formato));
        });
        timer.setInitialDelay(0);
        timer.start();
    }

    // ALTERADO: Agora recebe o objeto Funcionario completo, não só o nome
    public void definirUsuarioLogado(Funcionario f) {
        this.funcionarioLogado = f;
        if (f != null) {
            labelNome.setText(f.getNome());
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        logoPharmasys = new javax.swing.JLabel();
        botaoSair = new javax.swing.JLabel();
        relogio = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        campoPesquisa = new javax.swing.JTextField();
        buttonRealizarVenda = new javax.swing.JButton();
        buttonVisualizarEstoque = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        // Configuração padrão do NetBeans (mantida)
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100, Short.MAX_VALUE));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        
        try {
            logoPharmasys.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pharmasys_logo.png")));
        } catch (Exception e) {}

        botaoSair.setFont(new java.awt.Font("SF Pro", 0, 15));
        botaoSair.setForeground(new java.awt.Color(153, 0, 0));
        botaoSair.setText("Sair >");
        botaoSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoSairMouseClicked(evt);
            }
        });

        relogio.setFont(new java.awt.Font("Segoe UI", 0, 14));
        relogio.setText(" ");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 15));
        jLabel1.setText("|");
        labelNome.setFont(new java.awt.Font("Segoe UI", 0, 13));

        jPanel2.setBackground(new java.awt.Color(208, 226, 231));
        jLabel3.setFont(new java.awt.Font("SF Pro", 3, 14));
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Buscar por medicamento:");

        buttonRealizarVenda.setFont(new java.awt.Font("SF Pro", 3, 16));
        buttonRealizarVenda.setText("Realizar venda");
        buttonRealizarVenda.addActionListener(evt -> buttonRealizarVendaActionPerformed(evt));

        buttonVisualizarEstoque.setFont(new java.awt.Font("SF Pro", 3, 16));
        buttonVisualizarEstoque.setText("Visualizar Estoque");
        buttonVisualizarEstoque.addActionListener(evt -> buttonVisualizarEstoqueActionPerformed(evt));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel4.setText("PESQUISAR");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SF Pro", 1, 18));
        jLabel2.setText("Olá, farmacêutico!");

        jButton1.setFont(new java.awt.Font("SF Pro", 3, 16));
        jButton1.setText("Buscar por Scanner");
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));

        // Layout (mantido simplificado para brevidade, igual ao original)
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(campoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(buttonRealizarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(buttonVisualizarEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonRealizarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonVisualizarEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(204, 204, 204))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoPharmasys, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(relogio, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoSair)
                .addGap(16, 16, 16))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logoPharmasys)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoSair)
                        .addComponent(relogio)
                        .addComponent(jLabel1)
                        .addComponent(labelNome)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        getContentPane().add(jPanel3);
        pack();
    }

    private void botaoSairMouseClicked(java.awt.event.MouseEvent evt) {
        new TelaInicial().setVisible(true);
        this.dispose();
    }

    private void buttonVisualizarEstoqueActionPerformed(java.awt.event.ActionEvent evt) {
        new TelaEstoque().setVisible(true);
    }

    // ALTERADO: Passa o ID e Nome para a tela de venda
    private void buttonRealizarVendaActionPerformed(java.awt.event.ActionEvent evt) {
        RealizarVenda venda = new RealizarVenda();
        if (this.funcionarioLogado != null) {
            venda.definirUsuarioLogado(this.funcionarioLogado.getIdFuncionario(), this.funcionarioLogado.getNome());
        }
        venda.setVisible(true);
        this.dispose();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        TelaScanner scanner = new TelaScanner();
        scanner.setVisible(true);
    }

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {
        String busca = campoPesquisa.getText().trim();
        if (!busca.isEmpty()){
            MedicamentoDAO dao = new MedicamentoDAO();
            List<Medicamento> listaEncontrada = dao.buscarPorNome(busca);

            if(listaEncontrada.isEmpty()){
                JOptionPane.showMessageDialog(this,"Nenhum medicamento encontrado com esse nome.");
            } else {
                TelaResultados tela = new TelaResultados();
                tela.setVisible(true);
                tela.setLocationRelativeTo(null);
                tela.preencherTabela(listaEncontrada);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, digite um nome para pesquisar.");
        }
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {}

        java.awt.EventQueue.invokeLater(() -> new ZNovaTelaFuncionario().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JLabel botaoSair;
    private javax.swing.JButton buttonRealizarVenda;
    private javax.swing.JButton buttonVisualizarEstoque;
    private javax.swing.JTextField campoPesquisa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel logoPharmasys;
    private javax.swing.JLabel relogio;
}