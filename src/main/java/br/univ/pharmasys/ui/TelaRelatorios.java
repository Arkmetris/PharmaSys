package br.univ.pharmasys.ui;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TelaRelatorios extends JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaRelatorios.class.getName());

    public TelaRelatorios() {
        initComponents();
    }

    private void initComponents() {

        LabelRelatorios = new javax.swing.JLabel();
        LabelCategoria = new javax.swing.JLabel();
        ButtonCancelar = new javax.swing.JButton();
        ButtonVisualizar = new javax.swing.JButton();
        ButtonGerarPDF = new javax.swing.JButton();
        ComboBoxCategoria = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(440, 380));
        setMinimumSize(new java.awt.Dimension(440, 380));
        setResizable(false);

        LabelRelatorios.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LabelRelatorios.setText("Relatórios");

        LabelCategoria.setText("Categoria:");

        ButtonCancelar.setText("Cancelar");
        ButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelarActionPerformed(evt);
            }
        });

        ButtonVisualizar.setText("Visualizar");

        ButtonGerarPDF.setText("Gerar PDF");

        ComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Funcionários", "Fornecedores", "Estoque" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LabelCategoria)
                .addGap(18, 18, 18)
                .addComponent(ComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(ButtonCancelar)
                        .addGap(41, 41, 41)
                        .addComponent(ButtonVisualizar)
                        .addGap(37, 37, 37)
                        .addComponent(ButtonGerarPDF))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(LabelRelatorios)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(LabelRelatorios)
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCategoria)
                    .addComponent(ComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonGerarPDF)
                    .addComponent(ButtonVisualizar)
                    .addComponent(ButtonCancelar))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new TelaRelatorios().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCancelar;
    private javax.swing.JButton ButtonGerarPDF;
    private javax.swing.JButton ButtonVisualizar;
    private javax.swing.JComboBox<String> ComboBoxCategoria;
    private javax.swing.JLabel LabelCategoria;
    private javax.swing.JLabel LabelRelatorios;
    // End of variables declaration//GEN-END:variables
}
