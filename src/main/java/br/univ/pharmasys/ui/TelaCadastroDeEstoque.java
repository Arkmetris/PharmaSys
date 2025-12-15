package br.univ.pharmasys.ui;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JOptionPane;

import br.univ.pharmasys.dao.MedicamentoDAO;
import br.univ.pharmasys.model.Medicamento;

/**
 *
 * @author kessy
 */
public class TelaCadastroDeEstoque extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaCadastroDeEstoque.class.getName());

    public TelaCadastroDeEstoque() {
        initComponents();
        configurarEstilos();
    }

    private void configurarEstilos() {
        Font fonteInterna = new Font("Segoe UI", Font.PLAIN, 14);

        CampoNomeComercial.setFont(fonteInterna);
        CampoSKU.setFont(fonteInterna);
        CampoDosagem.setFont(fonteInterna);
        CampoPrincipioAtivo.setFont(fonteInterna);
        CampoEstoqueMinimo.setFont(fonteInterna);
        CampoEstoqueMaximo.setFont(fonteInterna);
        CampoEstoqueAtual.setFont(fonteInterna);
        CampoPreco.setFont(fonteInterna);
        CampoDataExpiracao.setFont(fonteInterna);
        ComboBoxFormaFarmaceutica.setFont(fonteInterna);
    }

    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        PanelMedicamento = new javax.swing.JPanel();
        LabelMedicamento = new javax.swing.JLabel();
        CampoNomeComercial = new javax.swing.JTextField();
        CampoSKU = new javax.swing.JTextField();
        CampoDosagem = new javax.swing.JTextField();
        CampoPrincipioAtivo = new javax.swing.JTextField();
        CampoEstoqueMinimo = new javax.swing.JTextField();
        CampoEstoqueMaximo = new javax.swing.JTextField();
        ComboBoxFormaFarmaceutica = new javax.swing.JComboBox<>();
        CampoEstoqueAtual = new javax.swing.JTextField();
        CampoPreco = new javax.swing.JTextField();
        ButtonCancelar = new javax.swing.JButton();
        ButtonCadastrar = new javax.swing.JButton();
        LabelCadastroDeEstoque = new javax.swing.JLabel();
        CampoDataExpiracao = new javax.swing.JTextField();

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TelaCadEstoque");
        setResizable(false);

        PanelMedicamento.setBackground(new java.awt.Color(255, 255, 255));

        LabelMedicamento.setFont(new java.awt.Font("Segoe UI", 0, 18));
        LabelMedicamento.setText("Medicamento");

        CampoNomeComercial.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome Comercial"));
        CampoNomeComercial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoNomeComercialActionPerformed(evt);
            }
        });

        CampoSKU.setBorder(javax.swing.BorderFactory.createTitledBorder("SKU"));
        CampoSKU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoSKUActionPerformed(evt);
            }
        });

        CampoDosagem.setBorder(javax.swing.BorderFactory.createTitledBorder("Dosagem"));
        CampoDosagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoDosagemActionPerformed(evt);
            }
        });

        CampoPrincipioAtivo.setBorder(javax.swing.BorderFactory.createTitledBorder("Princípio Ativo"));

        CampoEstoqueMinimo.setBorder(javax.swing.BorderFactory.createTitledBorder("Estoque Mínimo"));

        CampoEstoqueMaximo.setBorder(javax.swing.BorderFactory.createTitledBorder("Estoque Máximo"));

        ComboBoxFormaFarmaceutica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Comprimido", "Líquido", "Injetável", "Tópico" }));
        ComboBoxFormaFarmaceutica.setBorder(javax.swing.BorderFactory.createTitledBorder("Forma Farmacêutica"));

        CampoEstoqueAtual.setBorder(javax.swing.BorderFactory.createTitledBorder("Estoque Atual"));

        CampoPreco.setBorder(javax.swing.BorderFactory.createTitledBorder("Preço"));
        CampoPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoPrecoActionPerformed(evt);
            }
        });

        ButtonCancelar.setText("Cancelar");
        ButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelarActionPerformed(evt);
            }
        });

        ButtonCadastrar.setText("Cadastrar");
        ButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCadastrarActionPerformed(evt);
            }
        });

        LabelCadastroDeEstoque.setBackground(new java.awt.Color(51, 51, 51));
        LabelCadastroDeEstoque.setFont(new java.awt.Font("Segoe UI", 1, 24));
        LabelCadastroDeEstoque.setText("Cadastro De Estoque");

        CampoDataExpiracao.setBorder(javax.swing.BorderFactory.createTitledBorder("Data de Expiração"));

        javax.swing.GroupLayout PanelMedicamentoLayout = new javax.swing.GroupLayout(PanelMedicamento);
        PanelMedicamento.setLayout(PanelMedicamentoLayout);
        PanelMedicamentoLayout.setHorizontalGroup(
                PanelMedicamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMedicamentoLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(PanelMedicamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMedicamentoLayout.createSequentialGroup()
                                                .addComponent(ButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(24, 24, 24))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMedicamentoLayout.createSequentialGroup()
                                                .addComponent(LabelCadastroDeEstoque)
                                                .addGap(203, 203, 203))))
                        .addGroup(PanelMedicamentoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PanelMedicamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelMedicamentoLayout.createSequentialGroup()
                                                .addGroup(PanelMedicamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(PanelMedicamentoLayout.createSequentialGroup()
                                                                .addComponent(CampoNomeComercial, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(CampoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(PanelMedicamentoLayout.createSequentialGroup()
                                                                .addComponent(CampoSKU, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(CampoEstoqueMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(PanelMedicamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(PanelMedicamentoLayout.createSequentialGroup()
                                                                        .addComponent(CampoDosagem, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(CampoEstoqueMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(PanelMedicamentoLayout.createSequentialGroup()
                                                                        .addGroup(PanelMedicamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(CampoPrincipioAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(ComboBoxFormaFarmaceutica, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(PanelMedicamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(CampoEstoqueAtual, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                                                                .addComponent(CampoDataExpiracao)))))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(PanelMedicamentoLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(LabelMedicamento)
                                                .addGap(261, 261, 261))))
        );
        PanelMedicamentoLayout.setVerticalGroup(
                PanelMedicamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelMedicamentoLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(LabelCadastroDeEstoque)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LabelMedicamento)
                                .addGap(24, 24, 24)
                                .addGroup(PanelMedicamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(CampoNomeComercial, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CampoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(PanelMedicamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(CampoSKU, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CampoEstoqueMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(PanelMedicamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(CampoDosagem, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CampoEstoqueMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(PanelMedicamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(CampoEstoqueAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CampoPrincipioAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(PanelMedicamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(CampoDataExpiracao, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ComboBoxFormaFarmaceutica, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addGroup(PanelMedicamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PanelMedicamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PanelMedicamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void CampoNomeComercialActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void CampoSKUActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void CampoDosagemActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void CampoPrecoActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void ButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Medicamento med = new Medicamento();
            med.setNomeComercial(CampoNomeComercial.getText());
            med.setSku(CampoSKU.getText());
            med.setDosagem(CampoDosagem.getText());
            med.setFormaFarmaceutica(ComboBoxFormaFarmaceutica.getSelectedItem().toString());

            med.setEstoqueMax(Integer.parseInt(CampoEstoqueMaximo.getText().trim()));
            med.setEstoqueMin(Integer.parseInt(CampoEstoqueMinimo.getText().trim()));
            med.setEstoqueAtual(Integer.parseInt(CampoEstoqueAtual.getText().trim()));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dataTxt = CampoDataExpiracao.getText().trim();
            med.setDataExpiracao(LocalDate.parse(dataTxt, formatter));

            String precoTxt = CampoPreco.getText().trim().replace(",", ".");
            med.setPreco(new BigDecimal(precoTxt));

            MedicamentoDAO dao = new MedicamentoDAO();
            dao.create(med);

            JOptionPane.showMessageDialog(this, "Medicamento cadastrado com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao cadastrar medicamento:\n" + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void ButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    public static void main(String args[]) {
        try {
            // Alterado para usar o Look and Feel do sistema
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroDeEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new TelaCadastroDeEstoque().setVisible(true));
    }

    private javax.swing.JButton ButtonCadastrar;
    private javax.swing.JButton ButtonCancelar;
    private javax.swing.JTextField CampoDataExpiracao;
    private javax.swing.JTextField CampoDosagem;
    private javax.swing.JTextField CampoEstoqueAtual;
    private javax.swing.JTextField CampoEstoqueMaximo;
    private javax.swing.JTextField CampoEstoqueMinimo;
    private javax.swing.JTextField CampoNomeComercial;
    private javax.swing.JTextField CampoPreco;
    private javax.swing.JTextField CampoPrincipioAtivo;
    private javax.swing.JTextField CampoSKU;
    private javax.swing.JComboBox<String> ComboBoxFormaFarmaceutica;
    private javax.swing.JLabel LabelCadastroDeEstoque;
    private javax.swing.JLabel LabelMedicamento;
    private javax.swing.JPanel PanelMedicamento;
    private javax.swing.JTextField jTextField2;
}