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

        jLabelLogo = new JLabel();
        jLabelSair = new JLabel();
        labelNome = new JLabel();
        relogio = new JLabel();
        jTextFieldBusca = new JTextField();
        jLabelLupa = new JLabel();
        jButtonCadastroMed = new JButton();
        jButtonFornecedores = new JButton();
        jButtonEstoque = new JButton();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(new Dimension(700, 450));

        jLabelLogo.setFont(new Font("SF Pro", 1, 16));
        jLabelLogo.setForeground(new Color(51, 204, 255));
        jLabelLogo.setText("LOGO PHARMASYS");

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

        jTextFieldBusca.setFont(new Font("SF Pro", 2, 14));
        jTextFieldBusca.setForeground(new Color(102, 102, 102));
        jTextFieldBusca.setText("Buscar no estoque");

        jLabelLupa.setText("LUPA");

        jButtonCadastroMed.setFont(new Font("SF Pro", 0, 18));
        jButtonCadastroMed.setText("Cadastrar Medicamento");
        jButtonCadastroMed.addActionListener(evt -> abrirCadastroMedicamento());

        jButtonFornecedores.setFont(new Font("SF Pro", 0, 18));
        jButtonFornecedores.setText("Gerenciar Fornecedores");
        jButtonFornecedores.addActionListener(evt -> abrirFornecedores());

        jButtonEstoque.setFont(new Font("SF Pro", 0, 18));
        jButtonEstoque.setText("Visualizar Estoque");
        jButtonEstoque.addActionListener(evt -> abrirEstoque());

        // Layout
        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(23)
        			.addComponent(jLabelLogo)
        			.addPreferredGap(ComponentPlacement.RELATED, 610, Short.MAX_VALUE)
        			.addComponent(jLabelSair)
        			.addContainerGap())
        		.addGroup(layout.createSequentialGroup()
        			.addGap(34)
        			.addComponent(jTextFieldBusca, GroupLayout.PREFERRED_SIZE, 631, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabelLupa)
        			.addContainerGap())
        		.addGroup(layout.createSequentialGroup()
        			.addGap(50)
        			.addComponent(jButtonCadastroMed, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
        			.addGap(40)
        			.addComponent(jButtonFornecedores, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
        			.addGap(40)
        			.addComponent(jButtonEstoque, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
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
        				.addComponent(jLabelLogo)
        				.addComponent(jLabelSair))
        			.addGap(42)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jTextFieldBusca, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabelLupa))
        			.addGap(40)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButtonCadastroMed, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButtonFornecedores, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButtonEstoque, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
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
        EventQueue.invokeLater(() -> new TelaEstoquista().setVisible(true));
    }

    private JButton jButtonCadastroMed;
    private JButton jButtonFornecedores;
    private JButton jButtonEstoque;
    private JLabel jLabelLogo;
    private JLabel jLabelSair;
    private JLabel labelNome;
    private JLabel relogio;
    private JLabel jLabelLupa;
    private JTextField jTextFieldBusca;
}
