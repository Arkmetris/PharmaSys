package br.univ.pharmasys.ui;

public class TelaEstoquista extends javax.swing.JFrame {

    public TelaEstoquista() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabelLogo = new javax.swing.JLabel();
        jLabelSair = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelHora = new javax.swing.JLabel();
        jLabelSeparador = new javax.swing.JLabel();
        jTextFieldBusca = new javax.swing.JTextField();
        jLabelLupa = new javax.swing.JLabel();
        jButtonCadastroMed = new javax.swing.JButton();
        jButtonFornecedores = new javax.swing.JButton();
        jButtonEstoque = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(700, 450));

        jLabelLogo.setFont(new java.awt.Font("SF Pro", 1, 16));
        jLabelLogo.setForeground(new java.awt.Color(51, 204, 255));
        jLabelLogo.setText("LOGO PHARMASYS");

        jLabelSair.setFont(new java.awt.Font("SF Pro", 0, 14));
        jLabelSair.setForeground(new java.awt.Color(204, 0, 51));
        jLabelSair.setText("Sair");
        jLabelSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSairMouseClicked(evt);
            }
        });

        jLabelUsuario.setFont(new java.awt.Font("SF Pro", 0, 14));
        jLabelUsuario.setText("Ana Souza (Estoquista)");

        jLabelHora.setFont(new java.awt.Font("SF Pro", 0, 14));
        jLabelHora.setText("00:00");

        jLabelSeparador.setText("|");

        jTextFieldBusca.setFont(new java.awt.Font("SF Pro", 2, 14));
        jTextFieldBusca.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldBusca.setText("Buscar no estoque");

        jLabelLupa.setText("LUPA");

        jButtonCadastroMed.setFont(new java.awt.Font("SF Pro", 0, 18));
        jButtonCadastroMed.setText("Cadastrar Medicamento");
        jButtonCadastroMed.addActionListener(evt -> abrirCadastroMedicamento());

        jButtonFornecedores.setFont(new java.awt.Font("SF Pro", 0, 18));
        jButtonFornecedores.setText("Gerenciar Fornecedores");
        jButtonFornecedores.addActionListener(evt -> abrirFornecedores());

        jButtonEstoque.setFont(new java.awt.Font("SF Pro", 0, 18));
        jButtonEstoque.setText("Visualizar Estoque");
        jButtonEstoque.addActionListener(evt -> abrirEstoque());

        // Layout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabelLogo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 230, Short.MAX_VALUE)
                                .addComponent(jLabelUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelSeparador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelHora)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelSair)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jTextFieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelLupa)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jButtonCadastroMed, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jButtonFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jButtonEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 30, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelLogo)
                                        .addComponent(jLabelSair)
                                        .addComponent(jLabelUsuario)
                                        .addComponent(jLabelHora)
                                        .addComponent(jLabelSeparador))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelLupa))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonCadastroMed, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(220, Short.MAX_VALUE))
        );

        pack();
    }

    private void jLabelSairMouseClicked(java.awt.event.MouseEvent evt) {
        new TelaInicial().setVisible(true);
        this.dispose();
    }

    private void abrirCadastroMedicamento() {
        new TelaCadastroMedicamento().setVisible(true);
        this.dispose();
    }

    private void abrirFornecedores() {
        new TelaFornecedores().setVisible(true);
        this.dispose();
    }

    private void abrirEstoque() {
        new TelaEstoque().setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new TelaEstoquista().setVisible(true));
    }

    private javax.swing.JButton jButtonCadastroMed;
    private javax.swing.JButton jButtonFornecedores;
    private javax.swing.JButton jButtonEstoque;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelSair;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JLabel jLabelSeparador;
    private javax.swing.JLabel jLabelLupa;
    private javax.swing.JTextField jTextFieldBusca;
}
