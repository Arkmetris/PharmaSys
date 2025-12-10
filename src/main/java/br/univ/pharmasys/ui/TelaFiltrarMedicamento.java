package br.univ.pharmasys.ui;

public class TelaFiltrarMedicamento extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(TelaFiltrarMedicamento.class.getName());

    public TelaFiltrarMedicamento() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        LabelFiltrarMedicamento = new javax.swing.JLabel();
        LabelBuscarPor = new javax.swing.JLabel();
        ButtonFiltrar = new javax.swing.JButton();
        CampoBusca = new javax.swing.JTextField();
        PanelInformacoes = new javax.swing.JPanel();
        CampoNomeComercial = new javax.swing.JTextField();
        CampoSKU = new javax.swing.JTextField();
        CampoLote = new javax.swing.JTextField();
        CampoDosagem = new javax.swing.JTextField();
        CampoForma = new javax.swing.JTextField();
        CampoPrincipioAtivo = new javax.swing.JTextField();
        CampoPreco = new javax.swing.JTextField();
        LabelInformaçoes = new javax.swing.JLabel();
        CampoEstoqueMinimo = new javax.swing.JTextField();
        CampoEstoqueMaximo = new javax.swing.JTextField();
        CampoEstoqueAtual = new javax.swing.JTextField();
        ButtonVoltar = new javax.swing.JButton();
        ComboBoxTiposDeBusca = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(java.awt.Color.white);
        setMaximumSize(new java.awt.Dimension(500, 600));
        setMinimumSize(new java.awt.Dimension(500, 600));
        setResizable(false);

        LabelFiltrarMedicamento.setFont(new java.awt.Font("Segoe UI", 1, 24));
        LabelFiltrarMedicamento.setText("Filtrar Medicamento");

        LabelBuscarPor.setText("Buscar Por:");

        ButtonFiltrar.setText("Filtrar");

        PanelInformacoes.setBackground(new java.awt.Color(255, 255, 255));
        PanelInformacoes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        CampoNomeComercial.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome Comercial"));
        CampoSKU.setBorder(javax.swing.BorderFactory.createTitledBorder("SKU"));
        CampoLote.setBorder(javax.swing.BorderFactory.createTitledBorder("Lote"));
        CampoDosagem.setBorder(javax.swing.BorderFactory.createTitledBorder("Dosagem"));
        CampoForma.setBorder(javax.swing.BorderFactory.createTitledBorder("Forma"));
        CampoPrincipioAtivo.setBorder(javax.swing.BorderFactory.createTitledBorder("Princípio Ativo"));
        CampoPreco.setBorder(javax.swing.BorderFactory.createTitledBorder("Preço"));
        CampoEstoqueMinimo.setBorder(javax.swing.BorderFactory.createTitledBorder("Estoque Mínimo"));
        CampoEstoqueMaximo.setBorder(javax.swing.BorderFactory.createTitledBorder("Estoque Máximo"));
        CampoEstoqueAtual.setBorder(javax.swing.BorderFactory.createTitledBorder("Estoque Atual"));

        LabelInformaçoes.setFont(new java.awt.Font("Segoe UI", 1, 14));
        LabelInformaçoes.setText("Informações");

        javax.swing.GroupLayout PanelInformacoesLayout = new javax.swing.GroupLayout(PanelInformacoes);
        PanelInformacoes.setLayout(PanelInformacoesLayout);
        PanelInformacoesLayout.setHorizontalGroup(
            PanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoNomeComercial, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoSKU, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoLote, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoEstoqueAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(PanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoDosagem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoForma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoPrincipioAtivo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoEstoqueMinimo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoEstoqueMaximo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInformacoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelInformaçoes)
                .addGap(186, 186, 186))
        );
        PanelInformacoesLayout.setVerticalGroup(
            PanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInformacoesLayout.createSequentialGroup()
                .addComponent(LabelInformaçoes)
                .addGap(24, 24, 24)
                .addGroup(PanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoNomeComercial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoDosagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoSKU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoForma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoPrincipioAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoEstoqueMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoEstoqueMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoEstoqueAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ButtonVoltar.setText("Voltar");

        ComboBoxTiposDeBusca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome Comercial", "SKU" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(CampoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(LabelFiltrarMedicamento))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(LabelBuscarPor)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(ComboBoxTiposDeBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(68, 68, 68)))
                    .addComponent(ButtonFiltrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonVoltar))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(LabelFiltrarMedicamento)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelBuscarPor)
                    .addComponent(ComboBoxTiposDeBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(CampoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(ButtonFiltrar)
                .addGap(18, 18, 18)
                .addComponent(PanelInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonVoltar)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info :
                    javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() ->
                new TelaFiltrarMedicamento().setVisible(true)
        );
    }

    private javax.swing.JButton ButtonFiltrar;
    private javax.swing.JButton ButtonVoltar;
    private javax.swing.JTextField CampoBusca;
    private javax.swing.JTextField CampoDosagem;
    private javax.swing.JTextField CampoEstoqueAtual;
    private javax.swing.JTextField CampoEstoqueMaximo;
    private javax.swing.JTextField CampoEstoqueMinimo;
    private javax.swing.JTextField CampoForma;
    private javax.swing.JTextField CampoLote;
    private javax.swing.JTextField CampoNomeComercial;
    private javax.swing.JTextField CampoPreco;
    private javax.swing.JTextField CampoPrincipioAtivo;
    private javax.swing.JTextField CampoSKU;
    private javax.swing.JComboBox<String> ComboBoxTiposDeBusca;
    private javax.swing.JLabel LabelBuscarPor;
    private javax.swing.JLabel LabelFiltrarMedicamento;
    private javax.swing.JLabel LabelInformaçoes;
    private javax.swing.JPanel PanelInformacoes;
}
