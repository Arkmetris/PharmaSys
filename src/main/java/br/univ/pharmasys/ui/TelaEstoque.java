package br.univ.pharmasys.ui;

import br.univ.pharmasys.dao.EstoqueDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TelaEstoque extends JFrame {

    public TelaEstoque() {
        initComponents();
        carregarDados();
    }

    private void initComponents() {

        JLabel jLabelTitulo = new JLabel("Estoque de Medicamentos");
        JScrollPane jScrollPane1 = new JScrollPane();
        JTable tabelaEstoque = new JTable();
        JButton btnAtualizar = new JButton("Atualizar Dados");
        JButton btnVoltar = new JButton("Voltar");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Estoque");
        setSize(800, 450);
        setLocationRelativeTo(null);

        jLabelTitulo.setFont(new Font("Arial", Font.BOLD, 20));

        tabelaEstoque.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"SKU", "Medicamento", "Estoque Atual", "Mínimo", "Máximo"}
        ));
        jScrollPane1.setViewportView(tabelaEstoque);

        btnAtualizar.addActionListener(e -> carregarDados());
        btnVoltar.addActionListener(e -> voltar());

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelTitulo)
                                        .addComponent(jScrollPane1, 720, 720, 720)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnAtualizar)
                                                .addGap(10)
                                                .addComponent(btnVoltar)))
                                .addContainerGap(30, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20)
                                .addComponent(jLabelTitulo)
                                .addGap(20)
                                .addComponent(jScrollPane1, 300, 300, 300)
                                .addGap(15)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAtualizar)
                                        .addComponent(btnVoltar))
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        // referências
        this.tabelaEstoque = tabelaEstoque;
    }


    private void carregarDados() {

        DefaultTableModel model = (DefaultTableModel) tabelaEstoque.getModel();
        model.setRowCount(0);

        EstoqueDAO dao = new EstoqueDAO();
        List<Object[]> dados = dao.listarEstoque();

        for (Object[] linha : dados) {
            model.addRow(linha);
        }
    }

    private void voltar() {
        new TelaEstoquista().setVisible(true);
        dispose();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaEstoque().setVisible(true);
        });
    }



    private JTable tabelaEstoque;
}
