/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.univ.pharmasys.ui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.YearMonth;
import br.univ.pharmasys.dao.MedicamentoDAO;
import br.univ.pharmasys.model.Medicamento;



public class TelaCadastroLote extends javax.swing.JPanel {



    public TelaCadastroLote() {
        initComponents();

        try {
            javax.swing.text.MaskFormatter mask =
                    new javax.swing.text.MaskFormatter("##/####");
            mask.setPlaceholderCharacter('_');
            CampoValidade.setFormatterFactory(
                    new javax.swing.text.DefaultFormatterFactory(mask)
            );
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        CampoSkuMedicamento.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                preencherValidadePorSku();
            }
        });

        ButtonVoltar.addActionListener(evt -> ButtonVoltarActionPerformed(evt));
        ButtonCadastrar.addActionListener(evt -> ButtonCadastrarActionPerformed(evt));
    }

    private LocalDate converterValidade(String texto) {
        String[] partes = texto.split("/");
        int mes = Integer.parseInt(partes[0]);
        int ano = Integer.parseInt(partes[1]);
        return LocalDate.of(ano, mes, 1);
    }
    private void preencherValidadePorSku() {

        String sku = CampoSkuMedicamento.getText().trim();
        if (sku.isEmpty()) return;

        MedicamentoDAO dao = new MedicamentoDAO();
        Medicamento med = dao.buscarPorSku(sku);

        if (med != null && med.getDataExpiracao() != null) {
            LocalDate data = med.getDataExpiracao();
            CampoValidade.setText(
                    String.format("%02d/%d",
                            data.getMonthValue(),
                            data.getYear())
            );
        }
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelCadastroDeLote = new javax.swing.JLabel();
        CampoNumeroLote = new javax.swing.JTextField();
        CampoSkuMedicamento = new javax.swing.JTextField();
        CampoQuantidadeRecebida = new javax.swing.JTextField();
        CampoValidade = new javax.swing.JFormattedTextField();
        CampoQuantidadeAtual = new javax.swing.JTextField();
        CampoPreco = new javax.swing.JTextField();
        ButtonVoltar = new javax.swing.JButton();
        ButtonCadastrar = new javax.swing.JButton();
        LabelCadastroDeLote.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LabelCadastroDeLote.setText("Cadastro de Lote");
        CampoNumeroLote.setBorder(javax.swing.BorderFactory.createTitledBorder("Número do Lote:"));
        CampoSkuMedicamento.setBorder(javax.swing.BorderFactory.createTitledBorder("SKU Medicamento:"));
        CampoQuantidadeRecebida.setBorder(javax.swing.BorderFactory.createTitledBorder("Quantidade Recebida:"));
        CampoValidade.setBorder(javax.swing.BorderFactory.createTitledBorder("Validade:"));
        CampoQuantidadeAtual.setBorder(javax.swing.BorderFactory.createTitledBorder("Quantidade Atual:"));
        CampoPreco.setBorder(javax.swing.BorderFactory.createTitledBorder("Preço:"));
        ButtonVoltar.setText("Voltar");
        ButtonCadastrar.setText("Cadastrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(LabelCadastroDeLote))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ButtonVoltar)
                                .addGap(18, 18, 18)
                                .addComponent(ButtonCadastrar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CampoSkuMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CampoNumeroLote, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CampoValidade, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CampoQuantidadeRecebida, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CampoQuantidadeAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CampoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(LabelCadastroDeLote, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoNumeroLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoQuantidadeRecebida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoSkuMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoQuantidadeAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonVoltar)
                    .addComponent(ButtonCadastrar))
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents



    private javax.swing.JButton ButtonCadastrar;
    private javax.swing.JButton ButtonVoltar;
    private javax.swing.JTextField CampoNumeroLote;
    private javax.swing.JTextField CampoPreco;
    private javax.swing.JTextField CampoQuantidadeAtual;
    private javax.swing.JTextField CampoQuantidadeRecebida;
    private javax.swing.JTextField CampoSkuMedicamento;
    private javax.swing.JFormattedTextField CampoValidade;
    private javax.swing.JLabel LabelCadastroDeLote;

    private void ButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {

        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
    }
    private void ButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            if (CampoSkuMedicamento.getText().isEmpty()
                    || CampoQuantidadeRecebida.getText().isEmpty()
                    || CampoQuantidadeAtual.getText().isEmpty()
                    || CampoPreco.getText().isEmpty()
                    || CampoValidade.getText().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Preencha todos os campos.",
                        "Atenção",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            if (CampoValidade.getText().contains("_")) {
                JOptionPane.showMessageDialog(
                        this,
                        "Informe a validade completa (MM/AAAA).",
                        "Validade inválida",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            LocalDate validadeLote = converterValidade(CampoValidade.getText());



            YearMonth mesAtual = YearMonth.now();
            YearMonth mesValidade = YearMonth.from(validadeLote);

            if (!mesValidade.isAfter(mesAtual)) {
                JOptionPane.showMessageDialog(
                        this,
                        "A data de validade deve ser maior que o mês e ano atual.",
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
                        "A validade do lote deve ser IGUAL à validade do medicamento:\n"
                                + medicamento.getDataExpiracao(),
                        "Validade incompatível",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            // Criar Lote
            br.univ.pharmasys.model.Lote lote = new br.univ.pharmasys.model.Lote();
            lote.setSkuMedicamento(CampoSkuMedicamento.getText().trim());
            lote.setQuantidadeRecebida(Integer.parseInt(CampoQuantidadeRecebida.getText()));
            lote.setQuantidadeAtual(Integer.parseInt(CampoQuantidadeAtual.getText()));
            lote.setPreco(new java.math.BigDecimal(CampoPreco.getText()));
            lote.setValidade(validadeLote);

            // Salvar
            br.univ.pharmasys.dao.LoteDAO dao = new br.univ.pharmasys.dao.LoteDAO();
            dao.create(lote);

            JOptionPane.showMessageDialog(
                    this,
                    "Lote cadastrado com sucesso!"
            );

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



    public static void main(String[]args){
        javax.swing.SwingUtilities.invokeLater(() -> {
        javax.swing.JFrame frame = new javax.swing.JFrame("Cadastro De Lote");
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new TelaCadastroLote()); 
        frame.pack(); 
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true); 
    });

    
    }
}

