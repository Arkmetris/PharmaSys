package br.univ.pharmasys.ui;

import br.univ.pharmasys.dao.*;
import br.univ.pharmasys.model.*;

import javax.swing.*;
import java.awt.Font;
import java.awt.EventQueue;
import java.awt.CardLayout;
import java.time.LocalDate;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class TelaCadastroMedicamento extends JFrame {

    private JPanel panelCards;
    private CardLayout cardLayout;

    private JTextField txtSku, txtNome, txtCodigo, txtDosagem, txtForma,
            txtFabricante, txtLab, txtEstMin, txtEstMax,
            txtEstAtual, txtPreco;

    private JComboBox<String> boxDia, boxMes, boxAno, comboTipo;

    private JTextField txtQtdComp, txtVolume, txtRecipiente,
            txtVia, txtTempMin, txtTempMax,
            txtPeso, txtEmbalagem;

    public TelaCadastroMedicamento() {
        initComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Medicamento");
        setSize(700, 700);
        setResizable(false);

        JLabel labelTitulo = new JLabel("Cadastro de Medicamento");
        labelTitulo.setFont(new Font("SF Pro", Font.BOLD, 26));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblTipo = new JLabel("Tipo de Medicamento:");
        comboTipo = new JComboBox<>(new String[]{
                "Selecione...", "Comprimido", "Líquido", "Injetável", "Tópico"
        });

        JLabel lblSku = new JLabel("SKU:");
        txtSku = new JTextField();

        JLabel lblNome = new JLabel("Nome Comercial:");
        txtNome = new JTextField();

        JLabel lblCodigo = new JLabel("Código de Barras:");
        txtCodigo = new JTextField();

        JLabel lblDosagem = new JLabel("Dosagem:");
        txtDosagem = new JTextField();

        JLabel lblForma = new JLabel("Forma Farmacêutica:");
        txtForma = new JTextField();

        JLabel lblFabricante = new JLabel("Fabricante:");
        txtFabricante = new JTextField();

        JLabel lblLab = new JLabel("Laboratório:");
        txtLab = new JTextField();

        JLabel lblData = new JLabel("Data de Expiração:");
        boxDia = new JComboBox<>(dias());
        boxMes = new JComboBox<>(meses());
        boxAno = new JComboBox<>(anos());

        JLabel lblEstMin = new JLabel("Estoque Mínimo:");
        txtEstMin = new JTextField();

        JLabel lblEstMax = new JLabel("Estoque Máximo:");
        txtEstMax = new JTextField();

        JLabel lblEstAtual = new JLabel("Estoque Atual:");
        txtEstAtual = new JTextField("0");

        JLabel lblPreco = new JLabel("Preço:");
        txtPreco = new JTextField();


        cardLayout = new CardLayout();
        panelCards = new JPanel(cardLayout);
        panelCards.setBorder(BorderFactory.createTitledBorder("Dados Específicos"));

        JPanel panelVazio = new JPanel();
        panelVazio.add(new JLabel("Selecione o tipo do medicamento."));

        JPanel panelComprimido = new JPanel();
        txtQtdComp = new JTextField(10);
        panelComprimido.add(new JLabel("Qtd. Comprimidos:"));
        panelComprimido.add(txtQtdComp);

        JPanel panelLiquido = new JPanel();
        txtVolume = new JTextField(8);
        txtRecipiente = new JTextField(10);
        panelLiquido.add(new JLabel("Volume (ml):"));
        panelLiquido.add(txtVolume);
        panelLiquido.add(new JLabel("Recipiente:"));
        panelLiquido.add(txtRecipiente);

        JPanel panelInjetavel = new JPanel();
        txtVia = new JTextField(8);
        txtTempMin = new JTextField(5);
        txtTempMax = new JTextField(5);
        panelInjetavel.add(new JLabel("Via Admin.:"));
        panelInjetavel.add(txtVia);
        panelInjetavel.add(new JLabel("Temp. Min:"));
        panelInjetavel.add(txtTempMin);
        panelInjetavel.add(new JLabel("Temp. Max:"));
        panelInjetavel.add(txtTempMax);

        JPanel panelTopico = new JPanel();
        txtPeso = new JTextField(8);
        txtEmbalagem = new JTextField(10);
        panelTopico.add(new JLabel("Peso (g):"));
        panelTopico.add(txtPeso);
        panelTopico.add(new JLabel("Embalagem:"));
        panelTopico.add(txtEmbalagem);

        panelCards.setPreferredSize(new java.awt.Dimension(600, 90));
        panelCards.setMinimumSize(new java.awt.Dimension(600, 90));
        panelCards.setMaximumSize(new java.awt.Dimension(600, 90));
        panelCards.add(panelVazio, "Vazio");
        panelCards.add(panelComprimido, "Comprimido");
        panelCards.add(panelLiquido, "Líquido");
        panelCards.add(panelInjetavel, "Injetável");
        panelCards.add(panelTopico, "Tópico");

        comboTipo.addActionListener(e -> {
            String tipo = comboTipo.getSelectedItem().toString();
            cardLayout.show(panelCards,
                    tipo.equals("Selecione...") ? "Vazio" : tipo);
        });

        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnCancelar = new JButton("Cancelar");

        btnCadastrar.addActionListener(e -> cadastrar());
        btnCancelar.addActionListener(e -> dispose());

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
                                                .addComponent(boxMes)
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

                                        .addComponent(panelCards)

                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnCancelar)
                                                .addGap(20)
                                                .addComponent(btnCadastrar))
                                )
                                .addGap(40))
        );


        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGap(20)
                        .addComponent(labelTitulo)
                        .addGap(30)

                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblTipo)
                                .addComponent(comboTipo))

                        .addGap(10)
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

                        .addGap(10)
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

                        .addGap(20)
                        .addComponent(panelCards)

                        .addGap(20)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btnCancelar)
                                .addComponent(btnCadastrar))
        );

        setLocationRelativeTo(null);
    }


    private void cadastrar() {
        try {
            String tipo = comboTipo.getSelectedItem().toString();


            if (tipo.equals("Selecione...") ||
                    txtSku.getText().isEmpty() ||
                    txtNome.getText().isEmpty() ||
                    txtCodigo.getText().isEmpty() ||
                    txtDosagem.getText().isEmpty() ||
                    txtForma.getText().isEmpty() ||
                    txtFabricante.getText().isEmpty() ||
                    txtLab.getText().isEmpty() ||
                    txtEstMin.getText().isEmpty() ||
                    txtEstMax.getText().isEmpty() ||
                    txtEstAtual.getText().isEmpty() ||
                    txtPreco.getText().isEmpty() ||
                    boxDia.getSelectedIndex() == 0 ||
                    boxMes.getSelectedIndex() == 0 ||
                    boxAno.getSelectedIndex() == 0) {

                JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos obrigatórios!");
                return;
            }

            if ("Comprimido".equals(tipo)) {
                if (txtQtdComp.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Informe a quantidade de comprimidos.");
                    return;
                }
                MedicamentoComprimido m = new MedicamentoComprimido();
                preencherDadosComuns(m);
                m.setQuantidadeComprimidos(Integer.parseInt(txtQtdComp.getText()));
                new MedicamentoComprimidoDAO().create(m);
            }


            else if ("Líquido".equals(tipo)) {
                Medicamento m = new Medicamento();
                preencherDadosComuns(m);
                new MedicamentoDAO().create(m); // só cadastra os dados comuns
            }
            else if ("Injetável".equals(tipo)) {
                Medicamento m = new Medicamento();
                preencherDadosComuns(m);
                new MedicamentoDAO().create(m);
            }
            else if ("Tópico".equals(tipo)) {
                Medicamento m = new Medicamento();
                preencherDadosComuns(m);
                new MedicamentoDAO().create(m);
            }

            JOptionPane.showMessageDialog(this, "Medicamento cadastrado com sucesso!");
            dispose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erro: valores numéricos inválidos!");
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private void preencherDadosComuns(Medicamento med) {
        int dia = Integer.parseInt(boxDia.getSelectedItem().toString());
        int mes = converterMes(boxMes.getSelectedItem().toString());
        int ano = Integer.parseInt(boxAno.getSelectedItem().toString());

        med.setSku(txtSku.getText());
        med.setNomeComercial(txtNome.getText());
        med.setCodigoBarras(txtCodigo.getText());
        med.setDosagem(txtDosagem.getText());
        med.setFormaFarmaceutica(txtForma.getText());
        med.setFabricante(txtFabricante.getText());
        med.setLaboratorio(txtLab.getText());
        med.setDataExpiracao(LocalDate.of(ano, mes, dia));
        med.setEstoqueMin(Integer.parseInt(txtEstMin.getText()));
        med.setEstoqueMax(Integer.parseInt(txtEstMax.getText()));
        med.setEstoqueAtual(Integer.parseInt(txtEstAtual.getText()));
        med.setPreco(new BigDecimal(txtPreco.getText().replace(",", ".")));
    }

    private String[] dias() {
        String[] d = new String[32];
        d[0] = "Dia";
        for (int i = 1; i <= 31; i++) d[i] = String.valueOf(i);
        return d;
    }

    private String[] meses() {
        return new String[]{"Mês","janeiro","fevereiro","março","abril","maio","junho",
                "julho","agosto","setembro","outubro","novembro","dezembro"};
    }

    private String[] anos() {
        String[] a = new String[122];
        a[0] = "Ano";
        int idx = 1;
        for (int i = 2070; i >= 1950; i--) a[idx++] = String.valueOf(i);
        return a;
    }

    private int converterMes(String mes) {
        switch (mes.toLowerCase()) {
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
