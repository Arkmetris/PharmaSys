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

    private void initRelogio() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        Timer timer = new Timer(1000, e -> {
            relogio.setText(LocalTime.now().format(formato));
        });
        timer.setInitialDelay(0);
        timer.start();
    }

    public void definirUsuarioLogado(String nome) {
        labelNome.setText(nome);
    }

    private void initComponents() {

        labelLogo = new JLabel();
        jLabelSair = new JLabel();
        labelNome = new JLabel();
        relogio = new JLabel("00:00");
        textFieldBusca = new JTextField("Buscar no estoque");
        labelLupa = new JLabel("LUPA");

        buttonCadastroMed = new JButton("Cadastrar Medicamento");
        buttonFornecedores = new JButton("Gerenciar Fornecedores");
        buttonEstoque = new JButton("Visualizar Estoque");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            labelLogo.setIcon(new ImageIcon(getClass().getResource("/pharmasys_logo.png")));
        } catch (Exception e) {
            labelLogo.setText("LOGO");
        }

        jLabelSair.setFont(new Font("SF Pro", Font.PLAIN, 14));
        jLabelSair.setForeground(Color.RED);
        jLabelSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jLabelSair.setText("Sair");
        jLabelSair.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new TelaInicial().setVisible(true);
                dispose();
            }
        });

        labelNome.setFont(new Font("SF Pro", Font.PLAIN, 14));
        relogio.setFont(new Font("SF Pro", Font.PLAIN, 14));

        textFieldBusca.setFont(new Font("SF Pro", Font.ITALIC, 14));
        textFieldBusca.setForeground(Color.GRAY);

        labelLupa = new JLabel("🔍");
        Dimension tamanhoBotao = new Dimension(260, 100);
        buttonCadastroMed.setPreferredSize(tamanhoBotao);
        buttonFornecedores.setPreferredSize(tamanhoBotao);
        buttonEstoque.setPreferredSize(tamanhoBotao);

        buttonCadastroMed.setFont(new Font("SF Pro", Font.PLAIN, 18));
        buttonFornecedores.setFont(new Font("SF Pro", Font.PLAIN, 18));
        buttonEstoque.setFont(new Font("SF Pro", Font.PLAIN, 18));

        buttonCadastroMed.addActionListener(e -> {
            new TelaCadastroMedicamento().setVisible(true);
            dispose();
        });

        buttonFornecedores.addActionListener(e -> {
            new TelaFornecedores().setVisible(true);
            dispose();
        });

        buttonEstoque.addActionListener(e -> {
            new TelaEstoque().setVisible(true);
            dispose();
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20)
                                .addComponent(labelLogo)
                                .addPreferredGap(ComponentPlacement.RELATED, 400, Short.MAX_VALUE)
                                .addComponent(jLabelSair)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30)
                                .addComponent(textFieldBusca, GroupLayout.PREFERRED_SIZE, 580, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(labelLupa))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15)
                                .addComponent(buttonCadastroMed)
                                .addGap(15)
                                .addComponent(buttonFornecedores)
                                .addGap(15)
                                .addComponent(buttonEstoque))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelNome, 250, 250, 250)
                                .addPreferredGap(ComponentPlacement.RELATED, 380, Short.MAX_VALUE)
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
                                .addGap(40)
                                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(textFieldBusca, 26, 26, 26)
                                        .addComponent(labelLupa))
                                .addGap(40)
                                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(buttonCadastroMed)
                                        .addComponent(buttonFornecedores)
                                        .addComponent(buttonEstoque))
                                .addPreferredGap(ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(labelNome)
                                        .addComponent(relogio))
                        )
        );

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
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
