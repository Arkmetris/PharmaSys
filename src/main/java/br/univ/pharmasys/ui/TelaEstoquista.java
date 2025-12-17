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

// Replicando o design das outras telas principais:
private JPanel panelTopo;
private JPanel panelFundo;
private static final Font FONTE_BOTAO_PRINCIPAL = new Font("SF Pro", Font.BOLD | Font.ITALIC, 14);
private static final int LARGURA_BOTAO = 200;
private static final int ALTURA_BOTAO = 100;

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
        textFieldBusca = new JTextField();
        labelLupa = new JLabel();
        labelBemvindo = new JLabel("Olá, estoquista!");
        labelBuscar = new JLabel("Buscar por medicamento:");
        
        
        buttonCadastroMed = new JButton("Cadastrar Medicamento");
        buttonFornecedores = new JButton("Gerenciar Fornecedores");
        buttonEstoque = new JButton("Visualizar Estoque");
        
        Dimension tamanhoBotao = new Dimension(LARGURA_BOTAO, ALTURA_BOTAO);
        buttonCadastroMed.setPreferredSize(tamanhoBotao);
        buttonFornecedores.setPreferredSize(tamanhoBotao);
        buttonEstoque.setPreferredSize(tamanhoBotao);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panelTopo = new JPanel();
        panelFundo = new JPanel();

        panelTopo.setBackground(Color.WHITE);
        panelFundo.setBackground(new Color(208, 226, 231));

        try {
            labelLogo.setIcon(new ImageIcon(getClass().getResource("/pharmasys_logo.png")));
        } catch (Exception e) {
            labelLogo.setText("LOGO");
        }

        labelBemvindo.setFont(new Font("SF Pro", Font.BOLD, 18));
        labelBuscar.setFont(new Font("SF Pro", Font.ITALIC, 14));
        labelBuscar.setForeground(new Color(102, 102, 102));    
        textFieldBusca.setFont(new Font("SF Pro", Font.ITALIC, 14));
        textFieldBusca.setForeground(Color.BLACK); 
        
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
        
        GroupLayout fundoLayout = new GroupLayout(panelFundo);
        panelFundo.setLayout(fundoLayout);

        fundoLayout.setHorizontalGroup(
            fundoLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(fundoLayout.createSequentialGroup()
            .       addGap(30)
                .addGroup(fundoLayout.createParallelGroup(Alignment.LEADING)
                    .addComponent(labelBemvindo)
                    .addComponent(labelBuscar)
                    .addGroup(fundoLayout.createSequentialGroup()
                        .addComponent(textFieldBusca, 580, 580, 580)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(labelLupa)
                        )
                    )
                )
        .addGroup(fundoLayout.createSequentialGroup()
            .addGap(30)
            .addComponent(buttonCadastroMed,
                GroupLayout.PREFERRED_SIZE, LARGURA_BOTAO, GroupLayout.PREFERRED_SIZE)
            .addGap(15)
            .addComponent(buttonFornecedores,
                GroupLayout.PREFERRED_SIZE, LARGURA_BOTAO, GroupLayout.PREFERRED_SIZE)
            .addGap(15)
            .addComponent(buttonEstoque,
                GroupLayout.PREFERRED_SIZE, LARGURA_BOTAO, GroupLayout.PREFERRED_SIZE)
        )
);


            fundoLayout.setVerticalGroup(
                fundoLayout.createSequentialGroup()
                    .addGap(30)
                    .addComponent(labelBemvindo)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(labelBuscar)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(fundoLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(textFieldBusca, 35, 35, 35)
                        .addComponent(labelLupa))
                    .addGap(40)
                    .addGroup(fundoLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(buttonCadastroMed,
                            GroupLayout.PREFERRED_SIZE, ALTURA_BOTAO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonFornecedores,
                            GroupLayout.PREFERRED_SIZE, ALTURA_BOTAO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonEstoque,
                            GroupLayout.PREFERRED_SIZE, ALTURA_BOTAO, GroupLayout.PREFERRED_SIZE)
                    )
                    .addGap(200)
            );

            GroupLayout frameLayout = new GroupLayout(getContentPane());
                getContentPane().setLayout(frameLayout);

            frameLayout.setHorizontalGroup(
            frameLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(panelTopo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelFundo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        frameLayout.setVerticalGroup(
            frameLayout.createSequentialGroup()
                .addComponent(panelTopo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(panelFundo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );


        labelNome.setFont(new Font("SF Pro", Font.PLAIN, 14));
        relogio.setFont(new Font("SF Pro", Font.PLAIN, 14));

        textFieldBusca.setFont(new Font("SF Pro", Font.ITALIC, 14));
        textFieldBusca.setForeground(Color.GRAY);

        labelLupa.setText("🔍");

        buttonCadastroMed.setFont(FONTE_BOTAO_PRINCIPAL);
        buttonFornecedores.setFont(FONTE_BOTAO_PRINCIPAL);
        buttonEstoque.setFont(FONTE_BOTAO_PRINCIPAL);

        buttonCadastroMed.addActionListener(e -> {
            new TelaCadastroMedicamento().setVisible(true);
        });

        buttonFornecedores.addActionListener(e -> {
            new TelaFornecedores().setVisible(true);
            dispose();
        });

        buttonEstoque.addActionListener(e -> {
            new TelaEstoque().setVisible(true);
            dispose();
        });

        
        GroupLayout topoLayout = new GroupLayout(panelTopo);
                panelTopo.setLayout(topoLayout);

                topoLayout.setHorizontalGroup(
                    topoLayout.createSequentialGroup()
                        .addGap(20)
                        .addComponent(labelLogo)
                        .addPreferredGap(ComponentPlacement.RELATED, 300, Short.MAX_VALUE)
                        .addComponent(labelNome, 200, 200, 200)
                        .addGap(10)
                        .addComponent(relogio)
                        .addGap(10)
                        .addComponent(jLabelSair)
                        .addGap(20)
                );

                topoLayout.setVerticalGroup(
                    topoLayout.createParallelGroup(Alignment.CENTER)
                        .addComponent(labelLogo)
                        .addComponent(labelNome)
                        .addComponent(relogio)
                        .addComponent(jLabelSair)
                );

        
        pack();
        
        setSize(700, 500);
        setResizable(false);
        
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new TelaEstoquista().setVisible(true));
    }

    private JLabel labelBemvindo;
    private JLabel labelBuscar;
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