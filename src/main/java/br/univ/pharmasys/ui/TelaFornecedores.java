package br.univ.pharmasys.ui;

public class TelaFornecedores extends javax.swing.JFrame {

    public TelaFornecedores() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFornecedores = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Fornecedores");

        jLabelTitulo.setFont(new java.awt.Font("SF Pro", 1, 20));
        jLabelTitulo.setText("Gerenciamento de Fornecedores");

        tabelaFornecedores.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] { "ID", "Nome", "CNPJ", "Email", "Telefone" }
        ));
        jScrollPane1.setViewportView(tabelaFornecedores);

        btnNovo.setText("Novo Fornecedor");
        btnEditar.setText("Editar");
        btnExcluir.setText("Excluir");
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
                                                .addComponent(btnNovo)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnEditar)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnExcluir)
                                                .addGap(220, 220, 220)
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
                                        .addComponent(btnNovo)
                                        .addComponent(btnEditar)
                                        .addComponent(btnExcluir)
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

    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaFornecedores;
}
