package br.univ.pharmasys.ui;

import javax.swing.*;
import javax.swing.table.*;

public class TelaEstoque extends JFrame {

    public TelaEstoque() {
        initComponents();
    }

    private void initComponents() {

        jLabelTitulo = new JLabel();
        jScrollPane1 = new JScrollPane();
        tabelaEstoque = new JTable();
        btnAtualizar = new JButton();
        btnVoltar = new JButton();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Estoque de Medicamentos");

        jLabelTitulo.setFont(new java.awt.Font("SF Pro", 1, 20));
        jLabelTitulo.setText("Estoque de Medicamentos");

        tabelaEstoque.setModel(new DefaultTableModel(
                new Object [][] {},
                new String [] { "SKU", "Nome", "Quantidade", "Validade", "Preço" }
        ));
        jScrollPane1.setViewportView(tabelaEstoque);

        btnAtualizar.setText("Atualizar Dados");
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(evt -> voltar());

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelTitulo)
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 650, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnAtualizar)
                                                .addGap(440, 440, 440)
                                                .addComponent(btnVoltar)))
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabelTitulo)
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAtualizar)
                                        .addComponent(btnVoltar))
                                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void voltar() {
        new TelaEstoquista().setVisible(true);
        this.dispose();
    }

    private JButton btnAtualizar;
    private JButton btnVoltar;
    private JLabel jLabelTitulo;
    private JScrollPane jScrollPane1;
    private JTable tabelaEstoque;
}
