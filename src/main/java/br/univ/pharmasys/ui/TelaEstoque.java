package br.univ.pharmasys.ui;

public class TelaEstoque extends javax.swing.JFrame {

    public TelaEstoque() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEstoque = new javax.swing.JTable();
        btnAtualizar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Estoque de Medicamentos");

        jLabelTitulo.setFont(new java.awt.Font("SF Pro", 1, 20));
        jLabelTitulo.setText("Estoque de Medicamentos");

        tabelaEstoque.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] { "SKU", "Nome", "Quantidade", "Validade", "Preço" }
        ));
        jScrollPane1.setViewportView(tabelaEstoque);

        btnAtualizar.setText("Atualizar Dados");
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(evt -> voltar());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelTitulo)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnAtualizar)
                                                .addGap(440, 440, 440)
                                                .addComponent(btnVoltar)))
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabelTitulo)
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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

    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaEstoque;
}
