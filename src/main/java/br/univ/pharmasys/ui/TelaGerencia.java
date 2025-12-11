package br.univ.pharmasys.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("serial")
public class TelaGerencia extends JFrame {

    public TelaGerencia() {
        initComponents();
        initRelogio();
    }

    // Método que inicializa o relógio
    private void initRelogio() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        Timer timer = new Timer(1000, e -> {
            LocalTime agora = LocalTime.now();
            relogio.setText(agora.format(formato));
        });
        timer.setInitialDelay(0);
        timer.start();
    }
    
    // Método para definir o nome do usuário mostrado na tela
    public void definirUsuarioLogado(String nome) {
        labelNome.setText(nome);
    }
    
    private void initComponents() {

        jButton3 = new JButton();
        jButton4 = new JButton();
        popupMedicamentos = new JPopupMenu();
        jMenuItem1 = new JMenuItem();
        jMenuItem2 = new JMenuItem();
        popupFornecedor = new JPopupMenu();
        jMenuItem3 = new JMenuItem();
        popupFuncionarios = new JPopupMenu();
        jMenuItem4 = new JMenuItem();
        popupRelatorios = new JPopupMenu();
        jMenuItem5 = new JMenuItem();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        labelNome = new JLabel();
        relogio = new JLabel();
        ButtonFuncionarios = new JButton();
        ButtonRelatorios = new JButton();
        ButtonFornecedor = new JButton();
        ButtonMedicamentos = new JButton();

        jButton3.setFont(new Font("SF Pro", 0, 18)); // NOI18N
        jButton3.setText("Visualizar estoque");

        jButton4.setText("jButton4");

        popupMedicamentos.setBackground(new Color(204, 204, 204));
        popupMedicamentos.setComponentPopupMenu(popupMedicamentos);

        jMenuItem1.setText("Visualizar estoque");
        jMenuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        popupMedicamentos.add(jMenuItem1);

        jMenuItem2.setText("Cadastrar novo medicamento");
        jMenuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        popupMedicamentos.add(jMenuItem2);

        jMenuItem3.setText("Cadastar novo fornecedor");
        jMenuItem3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        popupFornecedor.add(jMenuItem3);

        jMenuItem4.setText("Cadastrar novo funcionário");
        jMenuItem4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        popupFuncionarios.add(jMenuItem4);

        jMenuItem5.setText("Emitir relatório");
        jMenuItem5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        popupRelatorios.add(jMenuItem5);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setFont(new Font("SF Pro", 1, 16));
        jLabel1.setForeground(new Color(51, 204, 255));
        jLabel1.setText("LOGO PHARMASYS");

        jLabel2.setFont(new Font("SF Pro", 0, 14));
        jLabel2.setForeground(new Color(204, 0, 51));
        jLabel2.setText("Sair");
        jLabel2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        labelNome.setFont(new Font("SF Pro", 0, 14));

        relogio.setFont(new Font("SF Pro", 0, 14));
        relogio.setText("00:00");

        ButtonFuncionarios.setFont(new Font("SF Pro", 3, 16));
        ButtonFuncionarios.setText("Funcionários");
        ButtonFuncionarios.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ButtonFuncionariosMouseClicked(evt);
            }
        });

        ButtonRelatorios.setFont(new Font("SF Pro", 3, 16));
        ButtonRelatorios.setText("Relatórios");
        ButtonRelatorios.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ButtonRelatoriosMouseClicked(evt);
            }
        });

        ButtonFornecedor.setFont(new Font("SF Pro", 3, 16));
        ButtonFornecedor.setText("Fornecedor");
        ButtonFornecedor.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ButtonFornecedorMouseClicked(evt);
            }
        });
        ButtonFornecedor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonFornecedorActionPerformed(evt);
            }
        });

        ButtonMedicamentos.setFont(new Font("SF Pro", 3, 16));
        ButtonMedicamentos.setText("Medicamentos");
        ButtonMedicamentos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ButtonMedicamentosMouseClicked(evt);
            }
        });
        ButtonMedicamentos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonMedicamentosActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(33)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(0, 7, Short.MAX_VALUE)
        							.addComponent(ButtonMedicamentos, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(ButtonFuncionarios, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(ButtonFornecedor, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(ButtonRelatorios, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
        						.addComponent(jLabel1, Alignment.LEADING))
        					.addGap(18)
        					.addComponent(jLabel2))
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(labelNome, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 431, Short.MAX_VALUE)
        					.addComponent(relogio)))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(jLabel2))
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(97)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(ButtonFuncionarios, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
        						.addComponent(ButtonRelatorios, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
        						.addComponent(ButtonFornecedor, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
        						.addComponent(ButtonMedicamentos, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
        					.addComponent(labelNome, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())
        				.addGroup(layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(relogio))))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonFornecedorActionPerformed(ActionEvent evt) {//GEN-FIRST:event_ButtonFornecedorActionPerformed
        // TODO add your handling code here:
        popupFornecedor.setVisible(true);
    }//GEN-LAST:event_ButtonFornecedorActionPerformed

    private void jMenuItem1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        TelaCadastroDeEstoque telaCadastro = new TelaCadastroDeEstoque();
            telaCadastro.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void ButtonMedicamentosMouseClicked(MouseEvent evt) {//GEN-FIRST:event_ButtonMedicamentosMouseClicked
        
    }//GEN-LAST:event_ButtonMedicamentosMouseClicked

    private void ButtonMedicamentosActionPerformed(ActionEvent evt) {//GEN-FIRST:event_ButtonMedicamentosActionPerformed
        popupMedicamentos.setVisible(true);
    }//GEN-LAST:event_ButtonMedicamentosActionPerformed

    private void jMenuItem3ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        TelaCadastroFornecedor telaCadastro = new TelaCadastroFornecedor();
        telaCadastro.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void ButtonFornecedorMouseClicked(MouseEvent evt) {//GEN-FIRST:event_ButtonFornecedorMouseClicked
        //
    }//GEN-LAST:event_ButtonFornecedorMouseClicked

    private void ButtonFuncionariosMouseClicked(MouseEvent evt) {//GEN-FIRST:event_ButtonFuncionariosMouseClicked
    popupFuncionarios.setVisible(true);
    }//GEN-LAST:event_ButtonFuncionariosMouseClicked

    private void jMenuItem5ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
    TelaRelatorios telaRelatorios = new TelaRelatorios();
            telaRelatorios.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void ButtonRelatoriosMouseClicked(MouseEvent evt) {//GEN-FIRST:event_ButtonRelatoriosMouseClicked
        popupRelatorios.setVisible(true);
    }//GEN-LAST:event_ButtonRelatoriosMouseClicked

    private void jMenuItem4ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
     TelaCadastroFuncionario telaCadastro = new TelaCadastroFuncionario();
            telaCadastro.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void formComponentShown(ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentShown

    private void jLabel2MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        new TelaInicial().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaGerencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGerencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGerencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGerencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGerencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton ButtonFornecedor;
    private JButton ButtonFuncionarios;
    private JButton ButtonMedicamentos;
    private JButton ButtonRelatorios;
    private JButton jButton3;
    private JButton jButton4;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel labelNome;
    private JLabel relogio;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem3;
    private JMenuItem jMenuItem4;
    private JMenuItem jMenuItem5;
    private JPopupMenu popupFornecedor;
    private JPopupMenu popupFuncionarios;
    private JPopupMenu popupMedicamentos;
    private JPopupMenu popupRelatorios;
    // End of variables declaration//GEN-END:variables
}
