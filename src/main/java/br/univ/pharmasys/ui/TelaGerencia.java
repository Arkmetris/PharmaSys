package br.univ.pharmasys.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("serial")
public class TelaGerencia extends JFrame {

    public TelaGerencia() {
        initComponents();
        initRelogio();
    }

    // ================= RELÓGIO =================
    private void initRelogio() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        Timer timer = new Timer(1000, e -> {
            relogio.setText(LocalTime.now().format(formato));
        });
        timer.setInitialDelay(0);
        timer.start();
    }

    // ================= USUÁRIO =================
    public void definirUsuarioLogado(String nome) {
        labelNome.setText(nome);
    }

    private void initComponents() {

        // ================= POPUPS =================
        popupMedicamentos = new JPopupMenu();
        popupFornecedor = new JPopupMenu();
        popupFuncionarios = new JPopupMenu();
        popupRelatorios = new JPopupMenu();

        jMenuItem1 = new JMenuItem("Visualizar estoque");
        jMenuItem2 = new JMenuItem("Cadastrar novo medicamento");
        jMenuItem3 = new JMenuItem("Cadastrar novo fornecedor");
        jMenuItem4 = new JMenuItem("Cadastrar novo funcionário");
        jMenuItem5 = new JMenuItem("Emitir relatório");

        // 🔧 CORREÇÃO: largura suficiente para não cortar texto
        Dimension tamanhoMenu = new Dimension(300, 30);
        jMenuItem1.setPreferredSize(tamanhoMenu);
        jMenuItem2.setPreferredSize(tamanhoMenu);
        jMenuItem3.setPreferredSize(tamanhoMenu);
        jMenuItem4.setPreferredSize(tamanhoMenu);
        jMenuItem5.setPreferredSize(tamanhoMenu);

        popupMedicamentos.add(jMenuItem1);
        popupMedicamentos.add(jMenuItem2);
        popupFornecedor.add(jMenuItem3);
        popupFuncionarios.add(jMenuItem4);
        popupRelatorios.add(jMenuItem5);

        // ================= LABELS =================
        jLabel1 = new JLabel("LOGO PHARMASYS");
        jLabel2 = new JLabel("Sair");
        labelNome = new JLabel();
        relogio = new JLabel("00:00");

        // ================= BOTÕES =================
        ButtonMedicamentos = new JButton("Medicamentos");
        ButtonFuncionarios = new JButton("Funcionários");
        ButtonFornecedor = new JButton("Fornecedor");
        ButtonRelatorios = new JButton("Relatórios");

        // ================= AÇÕES MENUS =================
        jMenuItem1.addActionListener(e ->
                new TelaEstoque().setVisible(true)
        );

        jMenuItem2.addActionListener(e ->
                new TelaCadastroDeEstoque().setVisible(true)
        );

        jMenuItem3.addActionListener(e ->
                new TelaCadastroFornecedor().setVisible(true)
        );

        jMenuItem4.addActionListener(e ->
                new TelaCadastroFuncionario().setVisible(true)
        );

        jMenuItem5.addActionListener(e ->
                new TelaRelatorios().setVisible(true)
        );

        // ================= AÇÕES BOTÕES =================
        ButtonMedicamentos.addActionListener(e ->
                popupMedicamentos.show(
                        ButtonMedicamentos,
                        0,
                        ButtonMedicamentos.getHeight()
                )
        );

        ButtonFuncionarios.addActionListener(e ->
                popupFuncionarios.show(
                        ButtonFuncionarios,
                        0,
                        ButtonFuncionarios.getHeight()
                )
        );

        ButtonFornecedor.addActionListener(e ->
                popupFornecedor.show(
                        ButtonFornecedor,
                        0,
                        ButtonFornecedor.getHeight()
                )
        );

        ButtonRelatorios.addActionListener(e ->
                popupRelatorios.show(
                        ButtonRelatorios,
                        0,
                        ButtonRelatorios.getHeight()
                )
        );

        // ================= SAIR =================
        jLabel2.setForeground(Color.RED);
        jLabel2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new TelaInicial().setVisible(true);
                dispose();
            }
        });

        // ================= FONTES =================
        jLabel1.setFont(new Font("SF Pro", Font.BOLD, 16));
        ButtonMedicamentos.setFont(new Font("SF Pro", Font.BOLD, 16));
        ButtonFuncionarios.setFont(new Font("SF Pro", Font.BOLD, 16));
        ButtonFornecedor.setFont(new Font("SF Pro", Font.BOLD, 16));
        ButtonRelatorios.setFont(new Font("SF Pro", Font.BOLD, 16));
        labelNome.setFont(new Font("SF Pro", Font.PLAIN, 14));
        relogio.setFont(new Font("SF Pro", Font.PLAIN, 14));

        // ================= LAYOUT =================
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20)
                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(ButtonMedicamentos, 170, 170, 170)
                                                .addGap(18)
                                                .addComponent(ButtonFuncionarios, 160, 160, 160)
                                                .addGap(18)
                                                .addComponent(ButtonFornecedor, 160, 160, 160)
                                                .addGap(18)
                                                .addComponent(ButtonRelatorios, 160, 160, 160))
                                        .addComponent(jLabel1))
                                .addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelNome, 220, 220, 220)
                                .addPreferredGap(ComponentPlacement.RELATED, 360, Short.MAX_VALUE)
                                .addComponent(relogio)
                                .addContainerGap())
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                .addGap(80)
                                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(ButtonMedicamentos, 140, 140, 140)
                                        .addComponent(ButtonFuncionarios, 140, 140, 140)
                                        .addComponent(ButtonFornecedor, 140, 140, 140)
                                        .addComponent(ButtonRelatorios, 140, 140, 140))
                                .addPreferredGap(ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(labelNome)
                                        .addComponent(relogio))
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }

    // ================= VARIÁVEIS =================
    private JButton ButtonFornecedor;
    private JButton ButtonFuncionarios;
    private JButton ButtonMedicamentos;
    private JButton ButtonRelatorios;
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

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new TelaGerencia().setVisible(true));
    }
}
