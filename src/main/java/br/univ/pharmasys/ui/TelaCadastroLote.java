package br.univ.pharmasys.ui;

import java.time.LocalDate;
import java.time.YearMonth;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import br.univ.pharmasys.dao.MedicamentoDAO;
import br.univ.pharmasys.model.Medicamento;

public class TelaCadastroLote extends javax.swing.JPanel {

    public TelaCadastroLote() {
        initComponents();
        carregarMesesAnos();

        CampoSkuMedicamento.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                preencherValidadePorSku();
            }
        });

        ButtonVoltar.addActionListener(evt -> ButtonVoltarActionPerformed(evt));
        ButtonCadastrar.addActionListener(evt -> ButtonCadastrarActionPerformed(evt));
    }



    private void carregarMesesAnos() {
        String[] meses = {
                "01", "02", "03", "04", "05", "06",
                "07", "08", "09", "10", "11", "12"
        };

        for (String mes : meses) {
            ComboMes.addItem(mes);
        }

        int anoAtual = LocalDate.now().getYear();
        for (int i = 0; i <= 45; i++) {
            ComboAno.addItem(anoAtual + i);
        }
    }

    private LocalDate obterValidadeSelecionada() {
        int mes = Integer.parseInt(ComboMes.getSelectedItem().toString());
        int ano = (Integer) ComboAno.getSelectedItem();
        return LocalDate.of(ano, mes, 1);
    }

    private void preencherValidadePorSku() {
        String sku = CampoSkuMedicamento.getText().trim();
        if (sku.isEmpty()) return;

        MedicamentoDAO dao = new MedicamentoDAO();
        Medicamento med = dao.buscarPorSku(sku);

        if (med != null && med.getDataExpiracao() != null) {
            LocalDate data = med.getDataExpiracao();
            ComboMes.setSelectedItem(String.format("%02d", data.getMonthValue()));
            ComboAno.setSelectedItem(data.getYear());
        }
    }



    @SuppressWarnings("unchecked")
    private void initComponents() {

        javax.swing.JPanel formPanel = new javax.swing.JPanel();

        LabelCadastroDeLote = new javax.swing.JLabel();
        CampoNumeroLote = new javax.swing.JTextField();
        CampoSkuMedicamento = new javax.swing.JTextField();
        CampoQuantidadeRecebida = new javax.swing.JTextField();
        CampoQuantidadeAtual = new javax.swing.JTextField();
        CampoPreco = new javax.swing.JTextField();
        ComboMes = new javax.swing.JComboBox<>();
        ComboAno = new javax.swing.JComboBox<>();
        ButtonVoltar = new javax.swing.JButton();
        ButtonCadastrar = new javax.swing.JButton();

        LabelCadastroDeLote.setFont(new java.awt.Font("Segoe UI", 1, 24));
        LabelCadastroDeLote.setText("Cadastro de Lote");

        CampoNumeroLote.setBorder(javax.swing.BorderFactory.createTitledBorder("Número do Lote"));
        CampoSkuMedicamento.setBorder(javax.swing.BorderFactory.createTitledBorder("SKU Medicamento"));
        CampoQuantidadeRecebida.setBorder(javax.swing.BorderFactory.createTitledBorder("Quantidade Recebida"));
        CampoQuantidadeAtual.setBorder(javax.swing.BorderFactory.createTitledBorder("Quantidade Atual"));
        CampoPreco.setBorder(javax.swing.BorderFactory.createTitledBorder("Preço"));

        ComboMes.setBorder(javax.swing.BorderFactory.createTitledBorder("Mês"));
        ComboAno.setBorder(javax.swing.BorderFactory.createTitledBorder("Ano"));

        ButtonVoltar.setText("Voltar");
        ButtonCadastrar.setText("Cadastrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(formPanel);
        formPanel.setLayout(layout);

        int alturaCampo = 28;

        CampoNumeroLote.setPreferredSize(new java.awt.Dimension(250, alturaCampo));
        CampoSkuMedicamento.setPreferredSize(new java.awt.Dimension(250, alturaCampo));
        CampoQuantidadeRecebida.setPreferredSize(new java.awt.Dimension(250, alturaCampo));
        CampoQuantidadeAtual.setPreferredSize(new java.awt.Dimension(250, alturaCampo));
        CampoPreco.setPreferredSize(new java.awt.Dimension(250, alturaCampo));

        ComboMes.setPreferredSize(new java.awt.Dimension(120, alturaCampo));
        ComboAno.setPreferredSize(new java.awt.Dimension(120, alturaCampo));


        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(LabelCadastroDeLote)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(CampoNumeroLote)
                                        .addComponent(CampoSkuMedicamento)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(ComboMes)
                                                .addGap(10)
                                                .addComponent(ComboAno)))
                                .addGap(40)
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(CampoQuantidadeRecebida)
                                        .addComponent(CampoQuantidadeAtual)
                                        .addComponent(CampoPreco)))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(ButtonVoltar)
                                .addGap(20)
                                .addComponent(ButtonCadastrar))
        );


        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGap(20)
                        .addComponent(LabelCadastroDeLote)
                        .addGap(30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CampoNumeroLote)
                                .addComponent(CampoQuantidadeRecebida))
                        .addGap(20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CampoSkuMedicamento)
                                .addComponent(CampoQuantidadeAtual))
                        .addGap(20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ComboMes)
                                .addComponent(ComboAno)
                                .addComponent(CampoPreco))
                        .addGap(30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ButtonVoltar)
                                .addComponent(ButtonCadastrar))
        );

        this.setLayout(new java.awt.GridBagLayout());
        this.add(formPanel);

    }



    private void ButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
    }

    private void ButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (CampoSkuMedicamento.getText().isEmpty()
                    || CampoQuantidadeRecebida.getText().isEmpty()
                    || CampoQuantidadeAtual.getText().isEmpty()
                    || CampoPreco.getText().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Preencha todos os campos.",
                        "Atenção",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            LocalDate validadeLote = obterValidadeSelecionada();

            YearMonth atual = YearMonth.now();
            YearMonth validade = YearMonth.from(validadeLote);

            if (!validade.isAfter(atual)) {
                JOptionPane.showMessageDialog(
                        this,
                        "A validade deve ser maior que o mês/ano atual.",
                        "Validade inválida",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            MedicamentoDAO medicamentoDAO = new MedicamentoDAO();
            Medicamento medicamento = medicamentoDAO.buscarPorSku(
                    CampoSkuMedicamento.getText().trim()
            );

            if (medicamento == null) {
                JOptionPane.showMessageDialog(
                        this,
                        "Não existe medicamento cadastrado com este SKU.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            if (!validadeLote.equals(medicamento.getDataExpiracao())) {
                JOptionPane.showMessageDialog(
                        this,
                        "A validade do lote deve ser igual à validade do medicamento:\n"
                                + medicamento.getDataExpiracao(),
                        "Validade incompatível",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            br.univ.pharmasys.model.Lote lote = new br.univ.pharmasys.model.Lote();
            lote.setSkuMedicamento(CampoSkuMedicamento.getText().trim());
            lote.setQuantidadeRecebida(Integer.parseInt(CampoQuantidadeRecebida.getText()));
            lote.setQuantidadeAtual(Integer.parseInt(CampoQuantidadeAtual.getText()));
            lote.setPreco(new java.math.BigDecimal(CampoPreco.getText()));
            lote.setValidade(validadeLote);

            br.univ.pharmasys.dao.LoteDAO dao = new br.univ.pharmasys.dao.LoteDAO();
            dao.create(lote);

            JOptionPane.showMessageDialog(this, "Lote cadastrado com sucesso!");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro: verifique os campos numéricos.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao cadastrar lote:\n" + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    private javax.swing.JButton ButtonCadastrar;
    private javax.swing.JButton ButtonVoltar;
    private javax.swing.JTextField CampoNumeroLote;
    private javax.swing.JTextField CampoPreco;
    private javax.swing.JTextField CampoQuantidadeAtual;
    private javax.swing.JTextField CampoQuantidadeRecebida;
    private javax.swing.JTextField CampoSkuMedicamento;
    private javax.swing.JComboBox<String> ComboMes;
    private javax.swing.JComboBox<Integer> ComboAno;
    private javax.swing.JLabel LabelCadastroDeLote;



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Cadastro de Lote");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new TelaCadastroLote());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
