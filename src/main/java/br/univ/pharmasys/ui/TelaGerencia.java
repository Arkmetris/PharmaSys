package br.univ.pharmasys.ui;

public class TelaGerencia extends javax.swing.JFrame {

    public TelaGerencia() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        popupMedicamentos = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        popupFornecedor = new javax.swing.JPopupMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        popupFuncionarios = new javax.swing.JPopupMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        popupRelatorios = new javax.swing.JPopupMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ButtonFuncionarios = new javax.swing.JButton();
        ButtonRelatorios = new javax.swing.JButton();
        ButtonFornecedor = new javax.swing.JButton();
        ButtonMedicamentos = new javax.swing.JButton();

        jButton3.setFont(new java.awt.Font("SF Pro", 0, 18));
        jButton3.setText("Visualizar estoque");

        jButton4.setText("jButton4");

        popupMedicamentos.setBackground(new java.awt.Color(204, 204, 204));

        jMenuItem1.setText("Visualizar estoque");
        jMenuItem1.addActionListener(evt -> jMenuItem1ActionPerformed(evt));
        popupMedicamentos.add(jMenuItem1);

        jMenuItem2.setText("Cadastrar novo medicamento");
        jMenuItem2.addActionListener(evt -> jMenuItem2ActionPerformed(evt));
        popupMedicamentos.add(jMenuItem2);

        jMenuItem3.setText("Cadastrar novo fornecedor");
        jMenuItem3.addActionListener(evt -> jMenuItem3ActionPerformed(evt));
        popupFornecedor.add(jMenuItem3);

        jMenuItem4.setText("Cadastrar novo funcionário");
        jMenuItem4.addActionListener(evt -> jMenuItem4ActionPerformed(evt));
        popupFuncionarios.add(jMenuItem4);

        jMenuItem5.setText("Emitir relatório");
        jMenuItem5.addActionListener(evt -> jMenuItem5ActionPerformed(evt));
        popupRelatorios.add(jMenuItem5);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SF Pro", 1, 16));
        jLabel1.setForeground(new java.awt.Color(51, 204, 255));
        jLabel1.setText("LOGO PHARMASYS");

        jLabel2.setFont(new java.awt.Font("SF Pro", 0, 14));
        jLabel2.setForeground(new java.awt.Color(204, 0, 51));
        jLabel2.setText("Sair");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SF Pro", 0, 14));
        jLabel3.setText("José Vieira dos Santos");

        jLabel4.setFont(new java.awt.Font("SF Pro", 0, 14));
        jLabel4.setText("00:00");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel5.setText("|");

        ButtonFuncionarios.setFont(new java.awt.Font("SF Pro", 3, 16));
        ButtonFuncionarios.setText("Funcionários");
        ButtonFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonFuncionariosMouseClicked(evt);
            }
        });

        ButtonRelatorios.setFont(new java.awt.Font("SF Pro", 3, 16));
        ButtonRelatorios.setText("Relatórios");
        ButtonRelatorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonRelatoriosMouseClicked(evt);
            }
        });

        ButtonFornecedor.setFont(new java.awt.Font("SF Pro", 3, 16));
        ButtonFornecedor.setText("Fornecedor");
        ButtonFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonFornecedorMouseClicked(evt);
            }
        });
        ButtonFornecedor.addActionListener(evt -> ButtonFornecedorActionPerformed(evt));

        ButtonMedicamentos.setFont(new java.awt.Font("SF Pro", 3, 16));
        ButtonMedicamentos.setText("Medicamentos");
        ButtonMedicamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonMedicamentosMouseClicked(evt);
            }
        });
        ButtonMedicamentos.addActionListener(evt -> ButtonMedicamentosActionPerformed(evt));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ButtonMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(202, Short.MAX_VALUE))
        );

        pack();
    }

    private void ButtonFornecedorActionPerformed(java.awt.event.ActionEvent evt) {
        popupFornecedor.setVisible(true);
    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {}

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
        TelaCadastroDeEstoque telaCadastro = new TelaCadastroDeEstoque();
        telaCadastro.setVisible(true);
    }

    private void ButtonMedicamentosMouseClicked(java.awt.event.MouseEvent evt) {}

    private void ButtonMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {
        popupMedicamentos.setVisible(true);
    }

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {
        TelaCadastroFornecedor telaCadastro = new TelaCadastroFornecedor();
        telaCadastro.setVisible(true);
    }

    private void ButtonFornecedorMouseClicked(java.awt.event.MouseEvent evt) {}

    private void ButtonFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {
        popupFuncionarios.setVisible(true);
    }

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {
        TelaRelatorios telaRelatorios = new TelaRelatorios();
        telaRelatorios.setVisible(true);
    }

    private void ButtonRelatoriosMouseClicked(java.awt.event.MouseEvent evt) {
        popupRelatorios.setVisible(true);
    }

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {
        TelaCadastroFuncionario telaCadastro = new TelaCadastroFuncionario();
        telaCadastro.setVisible(true);
    }

    private void formComponentShown(java.awt.event.ComponentEvent evt) {}

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {
        new TelaInicial().setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {}

        java.awt.EventQueue.invokeLater(() -> new TelaGerencia().setVisible(true));
    }

    private javax.swing.JButton ButtonFornecedor;
    private javax.swing.JButton ButtonFuncionarios;
    private javax.swing.JButton ButtonMedicamentos;
    private javax.swing.JButton ButtonRelatorios;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPopupMenu popupFornecedor;
    private javax.swing.JPopupMenu popupFuncionarios;
    private javax.swing.JPopupMenu popupMedicamentos;
    private javax.swing.JPopupMenu popupRelatorios;
}
