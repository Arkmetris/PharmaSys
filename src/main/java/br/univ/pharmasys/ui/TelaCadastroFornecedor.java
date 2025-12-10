package br.univ.pharmasys.ui;

import javax.swing.*;

public class TelaCadastroFornecedor extends JFrame {

    private final JTextField campoCnpj = new JTextField();
    private final JTextField campoEmpresa = new JTextField();
    private final JTextField campoID = new JTextField();
    private final JTextField campoTelefone = new JTextField();
    private final JTextField campoEmail = new JTextField();
    private final JButton buttonCancelar = new JButton("Cancelar");
    private final JButton buttonCadastrar = new JButton("Cadastrar");

    public TelaCadastroFornecedor() {
        configurarTela();
        initComponents();
    }

    private void configurarTela() {
        setTitle("Cadastro de Fornecedor");
        setSize(700, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // melhor do que EXIT ao abrir várias telas
        setResizable(false);
    }

    private void initComponents() {

        JLabel labelCadastroFornecedor = new JLabel("Cadastro de Fornecedor");
        labelCadastroFornecedor.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 24));

        JLabel labelCnpj = new JLabel("CNPJ:");
        JLabel labelEmpresa = new JLabel("Empresa:");
        JLabel labelID = new JLabel("ID:");
        JLabel labelTelefone = new JLabel("Telefone:");
        JLabel labelEmail = new JLabel("Email:");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(200)
                    .addComponent(labelCadastroFornecedor)
                )
                .addGroup(layout.createSequentialGroup()
                    .addGap(40)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(labelCnpj)
                        .addComponent(labelEmpresa)
                        .addComponent(labelID)
                        .addComponent(labelEmail)
                    )
                    .addGap(10)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(campoCnpj, 540, 540, 540)
                        .addComponent(campoEmpresa, 540, 540, 540)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(campoID, 220, 220, 220)
                            .addGap(25)
                            .addComponent(labelTelefone)
                            .addGap(10)
                            .addComponent(campoTelefone, 220, 220, 220))
                        .addComponent(campoEmail, 540, 540, 540)
                    )
                )
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(500, Short.MAX_VALUE)
                    .addComponent(buttonCancelar)
                    .addGap(10)
                    .addComponent(buttonCadastrar)
                    .addGap(30)
                )
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGap(40)
                .addComponent(labelCadastroFornecedor)
                .addGap(40)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCnpj)
                    .addComponent(campoCnpj, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEmpresa)
                    .addComponent(campoEmpresa, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelID)
                    .addComponent(campoID, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTelefone)
                    .addComponent(campoTelefone, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEmail)
                    .addComponent(campoEmail, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(40)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancelar)
                    .addComponent(buttonCadastrar)
                )
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaCadastroFornecedor().setVisible(true));
    }
}
