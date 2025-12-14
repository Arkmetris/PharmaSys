package br.univ.pharmasys.ui;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class TelaEstoquista extends JFrame {

    public TelaEstoquista() {
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

        labelLogo = new JLabel();
        jLabelSair = new JLabel();
        labelNome = new JLabel();
        relogio = new JLabel();
        textFieldBusca = new JTextField();
        labelLupa = new JLabel();
        buttonCadastroMed = new JButton();
        buttonFornecedores = new JButton();
        buttonEstoque = new JButton();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(700, 450));

  try {   
        labelLogo.setIcon(new ImageIcon(getClass().getResource("/pharmasys_logo.png")));
    } catch (Exception e) {
        labelLogo.setText("Imagem não encontrada");
    }

        jLabelSair.setFont(new Font("SF Pro", 0, 14));
        jLabelSair.setForeground(new Color(204, 0, 51));
        jLabelSair.setText("Sair");
        jLabelSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabelSair.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jLabelSairMouseClicked(evt);
            }
        });

        labelNome.setFont(new Font("SF Pro", 0, 14));

        relogio.setFont(new Font("SF Pro", 0, 14));
        relogio.setText("00:00");

        textFieldBusca.setFont(new Font("SF Pro", 2, 14));
        textFieldBusca.setForeground(new Color(102, 102, 102));
        textFieldBusca.setText("Buscar no estoque");

        labelLupa.setText("LUPA");

        buttonCadastroMed.setFont(new Font("SF Pro", 0, 18));
        buttonCadastroMed.setText("Cadastrar Medicamento");
        buttonCadastroMed.addActionListener(evt -> abrirCadastroMedicamento());

        buttonFornecedores.setFont(new Font("SF Pro", 0, 18));
        buttonFornecedores.setText("Gerenciar Fornecedores");
        buttonFornecedores.addActionListener(evt -> abrirFornecedores());

        buttonEstoque.setFont(new Font("SF Pro", 0, 18));
        buttonEstoque.setText("Visualizar Estoque");
        buttonEstoque.addActionListener(evt -> abrirEstoque());

        // Layout
        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(23)
        			.addComponent(labelLogo)
        			.addPreferredGap(ComponentPlacement.RELATED, 610, Short.MAX_VALUE)
        			.addComponent(jLabelSair)
        			.addContainerGap())
        		.addGroup(layout.createSequentialGroup()
        			.addGap(34)
        			.addComponent(textFieldBusca, GroupLayout.PREFERRED_SIZE, 631, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(labelLupa)
        			.addContainerGap())
        		.addGroup(layout.createSequentialGroup()
        			.addGap(50)
        			.addComponent(buttonCadastroMed, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
        			.addGap(40)
        			.addComponent(buttonFornecedores, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
        			.addGap(40)
        			.addComponent(buttonEstoque, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
        			.addGap(0, 30, Short.MAX_VALUE))
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(labelNome, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 490, Short.MAX_VALUE)
        			.addComponent(relogio)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(labelLogo)
        				.addComponent(jLabelSair))
        			.addGap(42)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(textFieldBusca, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
        				.addComponent(labelLupa))
        			.addGap(40)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(buttonCadastroMed, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        				.addComponent(buttonFornecedores, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        				.addComponent(buttonEstoque, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(labelNome)
        				.addComponent(relogio)))
        );
        getContentPane().setLayout(layout);

        pack();
    }

    private void jLabelSairMouseClicked(MouseEvent evt) {
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

        EventQueue.invokeLater(() -> new TelaEstoquista().setVisible(true));
    }

    private JButton buttonCadastroMed;
    private JButton buttonFornecedores;
    private JButton buttonEstoque;
    private JLabel labelLogo;
    private JLabel jLabelSair;
    private JLabel labelNome;
    private JLabel relogio;
    private JLabel labelLupa;
    private JTextField textFieldBusca;
}
