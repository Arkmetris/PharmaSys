package br.univ.pharmasys.ui;

public class RealizarVenda extends javax.swing.JFrame {

    public RealizarVenda() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("SF Pro", 1, 16));
        jLabel1.setForeground(new java.awt.Color(51, 204, 255));
        jLabel1.setText("LOGO PHARMASYS");

        jLabel3.setFont(new java.awt.Font("SF Pro", 0, 14));
        jLabel3.setText("José Vieira dos Santos");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel5.setText("|");

        jLabel4.setFont(new java.awt.Font("SF Pro", 0, 14));
        jLabel4.setText("00:00");

        jLabel2.setFont(new java.awt.Font("SF Pro", 0, 14));
        jLabel2.setForeground(new java.awt.Color(204, 0, 51));
        jLabel2.setText("Sair");

        jLabel6.setFont(new java.awt.Font("SF Pro", 0, 12));
        jLabel6.setText("ITENS");

        jLabel7.setFont(new java.awt.Font("SF Pro", 0, 12));
        jLabel7.setText("QUANT.");

        jLabel8.setFont(new java.awt.Font("SF Pro", 0, 12));
        jLabel8.setText("PREÇO UN.");

        jLabel9.setFont(new java.awt.Font("SF Pro", 0, 12));
        jLabel9.setText("SUBTOTAL");

        jLabel10.setFont(new java.awt.Font("SF Pro", 0, 14));
        jLabel10.setText("Total:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(22)
                    .addComponent(jLabel6)
                    .addGap(60)
                    .addComponent(jLabel7)
                    .addGap(32)
                    .addComponent(jLabel8)
                    .addGap(76)
                    .addComponent(jLabel9)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                    .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(350, Short.MAX_VALUE)
                    .addComponent(jLabel10)
                    .addGap(40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
                    .addComponent(jLabel10)
                    .addContainerGap())
                .addComponent(jScrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI", 0, 12));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("+ ADICIONAR PRODUTOS");

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setFont(new java.awt.Font("SF Pro", 0, 12));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("FINALIZAR COMPRA");

        jLabel11.setFont(new java.awt.Font("SF Pro", 0, 15));
        jLabel11.setText("Método de pagamento:");

        jCheckBox1.setText("Pix");
        jCheckBox2.setText("Débito");
        jCheckBox3.setText("Crédito");
        jCheckBox4.setText("Em espécie");

        // Layout principal
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(241)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(20)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGap(5)
                    .addComponent(jLabel5)
                    .addGap(5)
                    .addComponent(jLabel4)
                    .addGap(15)
                    .addComponent(jLabel2))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1))
                .addGroup(layout.createSequentialGroup()
                    .addGap(25)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addGap(18)
                                .addComponent(jCheckBox2)
                                .addGap(18)
                                .addComponent(jCheckBox3)
                                .addGap(18)
                                .addComponent(jCheckBox4))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                    .addComponent(jButton2)
                    .addGap(20))
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
                    .addGap(10)
                    .addComponent(jButton1)
                    .addGap(10)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addGap(5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckBox1)
                                .addComponent(jCheckBox2)
                                .addComponent(jCheckBox3)
                                .addComponent(jCheckBox4))))
                    .addContainerGap())
        );

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new RealizarVenda().setVisible(true));
    }

    // Declaração das variáveis
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
}
