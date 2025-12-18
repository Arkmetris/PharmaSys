package br.univ.pharmasys.ui;

import br.univ.pharmasys.dao.MedicamentoDAO;
import br.univ.pharmasys.model.Medicamento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class DialogAdicionarProduto extends javax.swing.JDialog {

    private Medicamento medicamentoSelecionado = null;
    private MedicamentoDAO dao = new MedicamentoDAO();
    
    // Componentes
    private javax.swing.JTextField txtBusca;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JTable tabelaProdutos;
    private javax.swing.JScrollPane scrollPane;

    public DialogAdicionarProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        configurarTabela();
    }

    // Método para retornar o objeto selecionado para a tela de vendas
    public Medicamento getMedicamentoSelecionado() {
        return medicamentoSelecionado;
    }

    private void initComponents() {
        setTitle("Buscar Medicamento Manualmente");
        setSize(600, 450);
        setLocationRelativeTo(getParent());
        setLayout(new BorderLayout(10, 10));

        // Painel Superior (Busca)
        JPanel panelTopo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTopo.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        
        JLabel lblBusca = new JLabel("Buscar por nome:");
        txtBusca = new JTextField(30);
        btnBuscar = new JButton("Buscar");
        
        // Ação do botão buscar
        btnBuscar.addActionListener(e -> buscarMedicamentos());
        // Ação ao dar Enter no campo de texto
        txtBusca.addActionListener(e -> buscarMedicamentos());

        panelTopo.add(lblBusca);
        panelTopo.add(txtBusca);
        panelTopo.add(btnBuscar);
        
        add(panelTopo, BorderLayout.NORTH);

        // Painel Central (Tabela)
        tabelaProdutos = new JTable();
        scrollPane = new JScrollPane(tabelaProdutos);
        // Seleção ao clicar duas vezes
        tabelaProdutos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    confirmarSelecao();
                }
            }
        });
        
        add(scrollPane, BorderLayout.CENTER);

        // Painel Inferior (Botões)
        JPanel panelSul = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnSelecionar = new JButton("Adicionar à Venda");
        btnSelecionar.setBackground(new Color(0, 153, 153));
        btnSelecionar.setForeground(Color.WHITE);
        btnSelecionar.setPreferredSize(new Dimension(150, 40));
        
        btnSelecionar.addActionListener(e -> confirmarSelecao());
        
        panelSul.add(btnSelecionar);
        add(panelSul, BorderLayout.SOUTH);
    }

    private void configurarTabela() {
        DefaultTableModel model = new DefaultTableModel(
            new Object[][]{},
            new String[]{"SKU", "Nome Comercial", "Dosagem", "Preço (R$)", "Estoque"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabelaProdutos.setModel(model);
        tabelaProdutos.setRowHeight(25);
        tabelaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void buscarMedicamentos() {
        String termo = txtBusca.getText().trim();
        DefaultTableModel model = (DefaultTableModel) tabelaProdutos.getModel();
        model.setRowCount(0); // Limpa tabela

        List<Medicamento> resultados;
        // Se vazio, lista todos, senão busca por nome
        if (termo.isEmpty()) {
            resultados = dao.listarTodos();
        } else {
            resultados = dao.buscarPorNome(termo);
        }

        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum medicamento encontrado.");
            return;
        }

        for (Medicamento m : resultados) {
            model.addRow(new Object[]{
                m.getSku(),
                m.getNomeComercial(),
                m.getDosagem(),
                m.getPreco(),
                m.getEstoqueAtual()
            });
        }
    }

    private void confirmarSelecao() {
        int row = tabelaProdutos.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um produto na tabela.");
            return;
        }

        String sku = (String) tabelaProdutos.getValueAt(row, 0);
        medicamentoSelecionado = dao.buscarPorSku(sku);
        
        if (medicamentoSelecionado != null) {
            dispose(); // Fecha o diálogo retornando sucesso
        }
    }
}


