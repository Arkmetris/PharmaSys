package br.univ.pharmasys.ui;

import javax.swing.*;

public class TelaCadastroDeEstoque extends JFrame {

    public TelaCadastroDeEstoque() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        PanelMedicamento = new JPanel();
        LabelMedicamento = new JLabel();
        CampoNomeComercial = new JTextField();
        CampoSKU = new JTextField();
        CampoDosagem = new JTextField();
        CampoPrincipioAtivo = new JTextField();
        CampoEstoqueMinimo = new JTextField();
        CampoEstoqueMaximo = new JTextField();
        ComboBoxForma = new JComboBox<>();
        CampoEstoqueAtual = new JTextField();
        CampoPreco = new JTextField();
        ButtonCancelar = new JButton();
        ButtonCadastrar = new JButton();
        LabelCadastroDeEstoque = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Estoque");
        setResizable(false);

        PanelMedicamento.setBackground(new java.awt.Color(255, 255, 255));

        LabelMedicamento.setFont(new java.awt.Font("Segoe UI", 0, 18));
        LabelMedicamento.setText("Medicamento");

        CampoNomeComercial.setBorder(BorderFactory.createTitledBorder("Nome Comercial"));
        CampoSKU.setBorder(BorderFactory.createTitledBorder("SKU"));
        CampoDosagem.setBorder(BorderFactory.createTitledBorder("Dosagem"));
        CampoPrincipioAtivo.setBorder(BorderFactory.createTitledBorder("Princípio Ativo"));
        CampoEstoqueMinimo.setBorder(BorderFactory.createTitledBorder("Estoque Mínimo"));
        CampoEstoqueMaximo.setBorder(BorderFactory.createTitledBorder("Estoque Máximo"));
        CampoEstoqueAtual.setBorder(BorderFactory.createTitledBorder("Estoque Atual"));
        CampoPreco.setBorder(BorderFactory.createTitledBorder("Preço"));

        ComboBoxForma.setModel(new DefaultComboBoxModel<>(new String[]{
                "Sólido", "Semissólido", "Líquido", "Gasoso", "Injetável"
        }));
        ComboBoxForma.setBorder(BorderFactory.createTitledBorder("Forma"));

        ButtonCancelar.setText("Cancelar");
        ButtonCancelar.addActionListener(evt -> dispose());

        ButtonCadastrar.setText("Cadastrar");
        ButtonCadastrar.addActionListener(evt -> cadastrar());

        LabelCadastroDeEstoque.setFont(new java.awt.Font("Segoe UI", 1, 24));
        LabelCadastroDeEstoque.setText("Cadastro De Estoque");

        // ------------------ LAYOUT ------------------
        GroupLayout PanelMedicamentoLayout = new GroupLayout(PanelMedicamento);
        PanelMedicamento.setLayout(PanelMedicamentoLayout);

        PanelMedicamentoLayout.setHorizontalGroup(
                PanelMedicamentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(PanelMedicamentoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PanelMedicamentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelMedicamentoLayout.createSequentialGroup()
                                                .addComponent(CampoNomeComercial, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(CampoPreco, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelMedicamentoLayout.createSequentialGroup()
                                                .addComponent(CampoSKU, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(CampoEstoqueMinimo, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelMedicamentoLayout.createSequentialGroup()
                                                .addComponent(CampoDosagem, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(CampoEstoqueMaximo, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelMedicamentoLayout.createSequentialGroup()
                                                .addComponent(CampoPrincipioAtivo, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(CampoEstoqueAtual, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(ComboBoxForma, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(PanelMedicamentoLayout.createSequentialGroup()
                                                .addGap(230, 230, 230)
                                                .addComponent(LabelMedicamento))
                                        .addGroup(GroupLayout.Alignment.TRAILING, PanelMedicamentoLayout.createSequentialGroup()
                                                .addComponent(ButtonCancelar)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ButtonCadastrar))
                                        .addGroup(GroupLayout.Alignment.TRAILING, PanelMedicamentoLayout.createSequentialGroup()
                                                .addComponent(LabelCadastroDeEstoque)
                                                .addGap(200, 200, 200)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelMedicamentoLayout.setVerticalGroup(
                PanelMedicamentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(PanelMedicamentoLayout.createSequentialGroup()
                                .addGap(12)
                                .addComponent(LabelCadastroDeEstoque)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LabelMedicamento)
                                .addGap(24)
                                .addGroup(PanelMedicamentoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(CampoNomeComercial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CampoPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(PanelMedicamentoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(CampoSKU, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CampoEstoqueMinimo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(PanelMedicamentoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(CampoDosagem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CampoEstoqueMaximo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(PanelMedicamentoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(CampoPrincipioAtivo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CampoEstoqueAtual, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addComponent(ComboBoxForma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addGroup(PanelMedicamentoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(ButtonCadastrar)
                                        .addComponent(ButtonCancelar))
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().setLayout(new GroupLayout(getContentPane()));
        getContentPane().add(PanelMedicamento);

        pack();
    }

    // -------------------------
    //  LÓGICA DO BOTÃO CADASTRAR
    // -------------------------
    private void cadastrar() {
        String nome = CampoNomeComercial.getText();
        String sku = CampoSKU.getText();
        String dosagem = CampoDosagem.getText();

        JOptionPane.showMessageDialog(this,
                "Cadastrado com sucesso:\n" +
                "Nome: " + nome + "\nSKU: " + sku + "\nDosagem: " + dosagem);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaCadastroDeEstoque().setVisible(true));
    }

    // Variables (mantidas por causa do NetBeans)
    private JButton ButtonCadastrar;
    private JButton ButtonCancelar;
    private JTextField CampoDosagem;
    private JTextField CampoEstoqueAtual;
    private JTextField CampoEstoqueMaximo;
    private JTextField CampoEstoqueMinimo;
    private JTextField CampoNomeComercial;
    private JTextField CampoPreco;
    private JTextField CampoPrincipioAtivo;
    private JTextField CampoSKU;
    private JComboBox<String> ComboBoxForma;
    private JLabel LabelCadastroDeEstoque;
    private JLabel LabelMedicamento;
    private JPanel PanelMedicamento;
}
