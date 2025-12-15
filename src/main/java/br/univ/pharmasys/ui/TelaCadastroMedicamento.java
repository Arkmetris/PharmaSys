package br.univ.pharmasys.ui;

import br.univ.pharmasys.dao.*;
import br.univ.pharmasys.model.*;

import javax.swing.*;
import java.awt.Font;
import java.awt.EventQueue;
import java.awt.CardLayout;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class TelaCadastroMedicamento extends JFrame {

    public TelaCadastroMedicamento() {
        initComponents();
    }

    private JPanel panelCards;
    private CardLayout cardLayout;

    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Medicamento");
        setSize(700, 700);
        setResizable(false);

        JLabel labelTitulo = new JLabel("Cadastro de Medicamento");
        labelTitulo.setFont(new Font("SF Pro", 1, 26));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblTipo = new JLabel("Tipo de Medicamento:");
        JComboBox<String> comboTipo = new JComboBox<>(new String[]{"Comum", "Comprimido", "Líquido", "Injetável", "Tópico"});

        JLabel lblSku = new JLabel("SKU:");
        JTextField txtSku = new JTextField();

        JLabel lblNome = new JLabel("Nome Comercial:");
        JTextField txtNome = new JTextField();

        JLabel lblCodigo = new JLabel("Código de Barras:");
        JTextField txtCodigo = new JTextField();

        JLabel lblDosagem = new JLabel("Dosagem:");
        JTextField txtDosagem = new JTextField();

        JLabel lblForma = new JLabel("Forma Farmacêutica:");
        JTextField txtForma = new JTextField();

        JLabel lblFabricante = new JLabel("Fabricante:");
        JTextField txtFabricante = new JTextField();

        JLabel lblLab = new JLabel("Laboratório:");
        JTextField txtLab = new JTextField();

        JLabel lblData = new JLabel("Data de Expiração:");
        JComboBox<String> boxDia = new JComboBox<>(dias());
        JComboBox<String> boxMes = new JComboBox<>(meses());
        JComboBox<String> boxAno = new JComboBox<>(anos());

        JLabel lblEstMin = new JLabel("Estoque Mínimo:");
        JTextField txtEstMin = new JTextField();

        JLabel lblEstMax = new JLabel("Estoque Máximo:");
        JTextField txtEstMax = new JTextField();

        JLabel lblEstAtual = new JLabel("Estoque Atual:");
        JTextField txtEstAtual = new JTextField("0");

        JLabel lblPreco = new JLabel("Preço:");
        JTextField txtPreco = new JTextField();

        cardLayout = new CardLayout();
        panelCards = new JPanel(cardLayout);
        panelCards.setBorder(BorderFactory.createTitledBorder("Dados Específicos"));

        JPanel panelComum = new JPanel();
        panelComum.add(new JLabel("Nenhum dado específico necessário."));

        JPanel panelComprimido = new JPanel();
        JLabel lblQtdComp = new JLabel("Qtd. Comprimidos:");
        JTextField txtQtdComp = new JTextField(10);
        panelComprimido.add(lblQtdComp);
        panelComprimido.add(txtQtdComp);

        JPanel panelLiquido = new JPanel();
        JLabel lblVolume = new JLabel("Volume (ml):");
        JTextField txtVolume = new JTextField(8);
        JLabel lblRecipiente = new JLabel("Recipiente:");
        JTextField txtRecipiente = new JTextField(10);
        panelLiquido.add(lblVolume);
        panelLiquido.add(txtVolume);
        panelLiquido.add(lblRecipiente);
        panelLiquido.add(txtRecipiente);

        JPanel panelInjetavel = new JPanel();
        JLabel lblVia = new JLabel("Via Admin.:");
        JTextField txtVia = new JTextField(8);
        JLabel lblTempMin = new JLabel("Temp. Min:");
        JTextField txtTempMin = new JTextField(5);
        JLabel lblTempMax = new JLabel("Temp. Max:");
        JTextField txtTempMax = new JTextField(5);
        panelInjetavel.add(lblVia);
        panelInjetavel.add(txtVia);
        panelInjetavel.add(lblTempMin);
        panelInjetavel.add(txtTempMin);
        panelInjetavel.add(lblTempMax);
        panelInjetavel.add(txtTempMax);

        JPanel panelTopico = new JPanel();
        JLabel lblPeso = new JLabel("Peso (g):");
        JTextField txtPeso = new JTextField(8);
        JLabel lblEmbalagem = new JLabel("Embalagem:");
        JTextField txtEmbalagem = new JTextField(10);
        panelTopico.add(lblPeso);
        panelTopico.add(txtPeso);
        panelTopico.add(lblEmbalagem);
        panelTopico.add(txtEmbalagem);

        panelCards.add(panelComum, "Comum");
        panelCards.add(panelComprimido, "Comprimido");
        panelCards.add(panelLiquido, "Líquido");
        panelCards.add(panelInjetavel, "Injetável");
        panelCards.add(panelTopico, "Tópico");

        comboTipo.addActionListener(e -> {
            String selecionado = (String) comboTipo.getSelectedItem();
            cardLayout.show(panelCards, selecionado);
        });

        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnCancelar = new JButton("Cancelar");

        btnCadastrar.addActionListener(evt -> {
            try {
                String tipoSelecionado = (String) comboTipo.getSelectedItem();
                int dia = Integer.parseInt(boxDia.getSelectedItem().toString());
                int ano = Integer.parseInt(boxAno.getSelectedItem().toString());
                int mes = converterMes(boxMes.getSelectedItem().toString());
                LocalDate dataExp = LocalDate.of(ano, mes, dia);
                java.math.BigDecimal preco = new java.math.BigDecimal(txtPreco.getText().replace(",", "."));

                if ("Comprimido".equals(tipoSelecionado)) {
                    MedicamentoComprimido med = new MedicamentoComprimido();
                    preencherDadosComuns(med, txtSku, txtNome, txtCodigo, txtDosagem, txtForma, txtFabricante, txtLab, dataExp, txtEstMin, txtEstMax, txtEstAtual, preco);
                    
                    med.setQuantidadeComprimidos(Integer.parseInt(txtQtdComp.getText()));
                    new MedicamentoComprimidoDAO().create(med);

                } else if ("Líquido".equals(tipoSelecionado)) {
                    MedicamentoLiquido med = new MedicamentoLiquido();
                    preencherDadosComuns(med, txtSku, txtNome, txtCodigo, txtDosagem, txtForma, txtFabricante, txtLab, dataExp, txtEstMin, txtEstMax, txtEstAtual, preco);
                    
                    med.setVolumeMl(Double.parseDouble(txtVolume.getText()));
                    med.setTipoRecipiente(txtRecipiente.getText());
                    new MedicamentoLiquidoDAO().create(med);

                } else if ("Injetável".equals(tipoSelecionado)) {
                    MedicamentoInjetavel med = new MedicamentoInjetavel();
                    preencherDadosComuns(med, txtSku, txtNome, txtCodigo, txtDosagem, txtForma, txtFabricante, txtLab, dataExp, txtEstMin, txtEstMax, txtEstAtual, preco);
                    
                    med.setViaAdministracao(txtVia.getText());
                    med.setTemperaturaMinima(Double.parseDouble(txtTempMin.getText()));
                    med.setTemperaturaMaxima(Double.parseDouble(txtTempMax.getText()));
                    new MedicamentoInjetavelDAO().create(med);

                } else if ("Tópico".equals(tipoSelecionado)) {
                    MedicamentoTopico med = new MedicamentoTopico();
                    preencherDadosComuns(med, txtSku, txtNome, txtCodigo, txtDosagem, txtForma, txtFabricante, txtLab, dataExp, txtEstMin, txtEstMax, txtEstAtual, preco);
                    
                    med.setPesoGramas(Double.parseDouble(txtPeso.getText()));
                    med.setTipoEmbalagem(txtEmbalagem.getText());
                    new MedicamentoTopicoDAO().create(med);

                } else {
                    Medicamento med = new Medicamento();
                    preencherDadosComuns(med, txtSku, txtNome, txtCodigo, txtDosagem, txtForma, txtFabricante, txtLab, dataExp, txtEstMin, txtEstMax, txtEstAtual, preco);
                    new MedicamentoDAO().create(med);
                }

                JOptionPane.showMessageDialog(this, "Medicamento cadastrado com sucesso!");
                this.dispose();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                        "Erro ao cadastrar: " + e.getMessage(),
                        "Erro", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        });

        btnCancelar.addActionListener(evt -> dispose());

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(labelTitulo)

                        .addGroup(layout.createSequentialGroup()
                                .addGap(40)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)

                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblTipo)
                                                .addGap(10)
                                                .addComponent(comboTipo, 200, 200, 200))

                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblSku)
                                                .addGap(10)
                                                .addComponent(txtSku, 150, 150, 150))

                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblNome)
                                                .addGap(10)
                                                .addComponent(txtNome, 400, 400, 400))

                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblCodigo)
                                                .addGap(10)
                                                .addComponent(txtCodigo, 200, 200, 200))

                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblDosagem)
                                                .addGap(10)
                                                .addComponent(txtDosagem, 200, 200, 200))

                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblForma)
                                                .addGap(10)
                                                .addComponent(txtForma, 200, 200, 200))

                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblFabricante)
                                                .addGap(10)
                                                .addComponent(txtFabricante, 200, 200, 200))

                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblLab)
                                                .addGap(10)
                                                .addComponent(txtLab, 250, 250, 250))

                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblData)
                                                .addGap(10)
                                                .addComponent(boxDia)
                                                .addGap(5)
                                                .addComponent(boxMes)
                                                .addGap(5)
                                                .addComponent(boxAno))

                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblEstMin)
                                                .addGap(10)
                                                .addComponent(txtEstMin, 80, 80, 80))

                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblEstMax)
                                                .addGap(10)
                                                .addComponent(txtEstMax, 80, 80, 80))

                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblEstAtual)
                                                .addGap(10)
                                                .addComponent(txtEstAtual, 80, 80, 80))

                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblPreco)
                                                .addGap(10)
                                                .addComponent(txtPreco, 100, 100, 100))

                                        .addComponent(panelCards, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)

                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnCancelar)
                                                .addGap(20)
                                                .addComponent(btnCadastrar))
                                )
                                .addGap(40)
                        )
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGap(20)
                        .addComponent(labelTitulo)
                        .addGap(30)

                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblTipo)
                                .addComponent(comboTipo))
                        .addGap(15)

                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblSku)
                                .addComponent(txtSku))
                        .addGap(10)

                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNome)
                                .addComponent(txtNome))
                        .addGap(10)

                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCodigo)
                                .addComponent(txtCodigo))
                        .addGap(10)

                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblDosagem)
                                .addComponent(txtDosagem))
                        .addGap(10)

                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblForma)
                                .addComponent(txtForma))
                        .addGap(10)

                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblFabricante)
                                .addComponent(txtFabricante))
                        .addGap(10)

                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblLab)
                                .addComponent(txtLab))
                        .addGap(10)

                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblData)
                                .addComponent(boxDia)
                                .addComponent(boxMes)
                                .addComponent(boxAno))
                        .addGap(20)

                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblEstMin)
                                .addComponent(txtEstMin))
                        .addGap(10)

                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblEstMax)
                                .addComponent(txtEstMax))
                        .addGap(10)

                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblEstAtual)
                                .addComponent(txtEstAtual))
                        .addGap(10)

                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblPreco)
                                .addComponent(txtPreco))
                        .addGap(30)

                        .addComponent(panelCards, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(20)

                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btnCancelar)
                                .addComponent(btnCadastrar))
                        .addGap(20)
        );

        setLocationRelativeTo(null);
    }

    private void preencherDadosComuns(Medicamento med, JTextField txtSku, JTextField txtNome, JTextField txtCodigo,
                                      JTextField txtDosagem, JTextField txtForma, JTextField txtFabricante,
                                      JTextField txtLab, LocalDate dataExp, JTextField txtEstMin,
                                      JTextField txtEstMax, JTextField txtEstAtual, java.math.BigDecimal preco) {
        med.setSku(txtSku.getText());
        med.setNomeComercial(txtNome.getText());
        med.setCodigoBarras(txtCodigo.getText());
        med.setDosagem(txtDosagem.getText());
        med.setFormaFarmaceutica(txtForma.getText());
        med.setFabricante(txtFabricante.getText());
        med.setLaboratorio(txtLab.getText());
        med.setDataExpiracao(dataExp);
        med.setEstoqueMin(Integer.parseInt(txtEstMin.getText()));
        med.setEstoqueMax(Integer.parseInt(txtEstMax.getText()));
        med.setEstoqueAtual(Integer.parseInt(txtEstAtual.getText()));
        med.setPreco(preco);
    }

    private String[] dias() {
        String[] d = new String[31];
        for (int i = 1; i <= 31; i++) d[i - 1] = String.valueOf(i);
        return d;
    }

    private String[] meses() {
        return new String[]{"janeiro", "fevereiro", "março", "abril", "maio", "junho",
                "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"};
    }

    private String[] anos() {
        String[] anos = new String[80];
        int idx = 0;
        for (int a = 2025; a >= 1950; a--) anos[idx++] = String.valueOf(a);
        return anos;
    }

    private int converterMes(String mes) {
        mes = mes.toLowerCase();
        switch (mes) {
            case "janeiro": return 1;
            case "fevereiro": return 2;
            case "março": return 3;
            case "abril": return 4;
            case "maio": return 5;
            case "junho": return 6;
            case "julho": return 7;
            case "agosto": return 8;
            case "setembro": return 9;
            case "outubro": return 10;
            case "novembro": return 11;
            case "dezembro": return 12;
        }
        return 1;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new TelaCadastroMedicamento().setVisible(true));
    }
}