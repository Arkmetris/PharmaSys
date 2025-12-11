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

        labelLogo = new JLabel();
        labelSair = new JLabel();
        labelNome = new JLabel();
        relogio = new JLabel();
        labelLupa = new JLabel();
        textBusca = new JTextField();
        buttonVenda = new JButton();
        buttonEstoque = new JButton();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(700, 450));

        labelLogo.setFont(new Font("SF Pro", 1, 16)); 
        labelLogo.setForeground(new Color(51, 204, 255));
        labelLogo.setText("LOGO PHARMASYS");

        labelSair.setFont(new Font("SF Pro", 0, 14)); 
        labelSair.setForeground(new Color(204, 0, 51));
        labelSair.setText("labelSair");
        labelSair.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                SairMouseClicked(evt);
            }
        });

        labelNome.setFont(new Font("SF Pro", 0, 14));

        relogio.setFont(new Font("SF Pro", 0, 14));
        relogio.setText("00:00");

        labelLupa.setText("Lupa");

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

        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(123)
        							.addComponent(buttonVenda, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
        							.addGap(52)
        							.addComponent(buttonEstoque, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addGroup(layout.createSequentialGroup()
        									.addGap(34)
        									.addComponent(textBusca, GroupLayout.PREFERRED_SIZE, 631, GroupLayout.PREFERRED_SIZE))
        								.addGroup(layout.createSequentialGroup()
        									.addContainerGap()
        									.addComponent(labelNome, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        								.addComponent(labelLupa, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        								.addComponent(relogio, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))))
        					.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(23)
        					.addComponent(labelLogo)
        					.addPreferredGap(ComponentPlacement.RELATED, 511, Short.MAX_VALUE)
        					.addComponent(labelSair, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
        			.addGap(0))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(labelLogo)
        				.addComponent(labelSair))
        			.addGap(42)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(textBusca, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
        				.addComponent(labelLupa))
        			.addGap(26)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(buttonEstoque, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        				.addComponent(buttonVenda, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(labelNome)
        				.addComponent(relogio, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
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
