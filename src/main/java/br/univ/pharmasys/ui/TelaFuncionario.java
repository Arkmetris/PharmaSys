package br.univ.pharmasys.ui;


import javax.swing.LayoutStyle.*;
import javax.swing.GroupLayout.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


@SuppressWarnings("serial")
public class TelaFuncionario extends JFrame {

    public TelaFuncionario() {
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
    
    
    // Método para definir o labelNome do usuário mostrado na tela
    public void definirUsuarioLogado(String nome) {
        labelNome.setText(nome);
    }
    
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(700, 450));

        jLabel2.setFont(new java.awt.Font("SF Pro", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 51));
        jLabel2.setText("Sair");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        labelNome.setFont(new Font("SF Pro", 0, 14));

        relogio.setFont(new Font("SF Pro", 0, 14));
        relogio.setText("00:00");

        jLabel6.setFont(new java.awt.Font("SF Pro", 1, 12)); // NOI18N
        jLabel6.setText("PESQUISAR");

        textBusca.setFont(new Font("SF Pro", 2, 14));
        textBusca.setForeground(new Color(102, 102, 102));
        textBusca.setText("Buscar por medicamento");
        textBusca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                textBuscaActionPerformed(evt);
            }
        });

        buttonVenda.setFont(new Font("SF Pro", 0, 18)); 
        buttonVenda.setText("Realizar venda");
        buttonVenda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonVendaActionPerformed(evt);
            }
        });

        buttonEstoque.setFont(new Font("SF Pro", 0, 18)); 
        buttonEstoque.setText("Visualizar estoque");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pharmasys_logo.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(213, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }

    private void textBuscaActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void buttonVendaActionPerformed(ActionEvent evt) {
            RealizarVenda venda = new RealizarVenda();
            venda.setVisible(true);
            this.dispose();
    }

    private void SairMouseClicked(MouseEvent evt) {
        new TelaInicial().setVisible(true);
        this.dispose();
    }


    public static void main(String args[]) {
        
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFuncionario().setVisible(true);
            }
        });
    }

    private JButton buttonVenda;
    private JButton buttonEstoque;
    private JLabel labelLogo;
    private JLabel labelSair;
    private JLabel labelNome;
    private JLabel relogio;
    private JLabel labelLupa;
    private JTextField textBusca;
}
