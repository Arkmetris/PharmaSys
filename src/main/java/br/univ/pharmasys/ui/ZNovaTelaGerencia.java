package br.univ.pharmasys.ui;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.Timer;

public class ZNovaTelaGerencia extends javax.swing.JPanel {

    public ZNovaTelaGerencia() {
        initComponents();
        initRelogio();
    }
    
    private void initRelogio() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        Timer timer = new Timer(1000, e -> {
            LocalTime agora = LocalTime.now();
            relogio.setText(agora.format(formato));
        });
        timer.setInitialDelay(0);
        timer.start();
    }
    
        public void definirUsuarioLogado(String nome) {
        labelNome.setText(nome);
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        TabbedPanePrincipal = new javax.swing.JTabbedPane();
        AbaMedicamentos = new javax.swing.JPanel();
        ButtonCadastrarMedicamento = new javax.swing.JButton();
        ButtonVIsualizarEstoque = new javax.swing.JButton();
        AbaFuncionarios = new javax.swing.JPanel();
        ButtonCadastrarFuncionario = new javax.swing.JButton();
        AbaFornecedor = new javax.swing.JPanel();
        ButtonCadastrarFornecedor = new javax.swing.JButton();
        AbaRelatorios = new javax.swing.JPanel();
        ButtonEmitirRelatorio = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        logoPharmasys = new javax.swing.JLabel();
        buttonSair = new javax.swing.JLabel();
        relogio = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(208, 226, 231));

        TabbedPanePrincipal.setBackground(new java.awt.Color(255, 255, 245));

        AbaMedicamentos.setBackground(new java.awt.Color(219, 238, 245));

        ButtonCadastrarMedicamento.setFont(new java.awt.Font("SF Pro", 0, 14)); // NOI18N
        ButtonCadastrarMedicamento.setText("Cadastrar Medicamento");
        ButtonCadastrarMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCadastrarMedicamentoActionPerformed(evt);
            }
        });

        ButtonVIsualizarEstoque.setFont(new java.awt.Font("SF Pro", 0, 14)); // NOI18N
        ButtonVIsualizarEstoque.setText("Visualizar Estoque");
        ButtonVIsualizarEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonVIsualizarEstoqueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AbaMedicamentosLayout = new javax.swing.GroupLayout(AbaMedicamentos);
        AbaMedicamentos.setLayout(AbaMedicamentosLayout);
        AbaMedicamentosLayout.setHorizontalGroup(
            AbaMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AbaMedicamentosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AbaMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonVIsualizarEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonCadastrarMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(440, Short.MAX_VALUE))
        );
        AbaMedicamentosLayout.setVerticalGroup(
            AbaMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AbaMedicamentosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ButtonVIsualizarEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonCadastrarMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        TabbedPanePrincipal.addTab("Medicamentos", AbaMedicamentos);

        AbaFuncionarios.setBackground(new java.awt.Color(219, 238, 245));

        ButtonCadastrarFuncionario.setFont(new java.awt.Font("SF Pro", 0, 14)); // NOI18N
        ButtonCadastrarFuncionario.setText("Cadastrar Funcionário");
        ButtonCadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCadastrarFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AbaFuncionariosLayout = new javax.swing.GroupLayout(AbaFuncionarios);
        AbaFuncionarios.setLayout(AbaFuncionariosLayout);
        AbaFuncionariosLayout.setHorizontalGroup(
            AbaFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AbaFuncionariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ButtonCadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(440, Short.MAX_VALUE))
        );
        AbaFuncionariosLayout.setVerticalGroup(
            AbaFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AbaFuncionariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ButtonCadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        TabbedPanePrincipal.addTab("Funcionários", AbaFuncionarios);

        AbaFornecedor.setBackground(new java.awt.Color(219, 238, 245));

        ButtonCadastrarFornecedor.setFont(new java.awt.Font("SF Pro", 0, 14)); // NOI18N
        ButtonCadastrarFornecedor.setText("Cadastrar Fornecedor");
        ButtonCadastrarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCadastrarFornecedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AbaFornecedorLayout = new javax.swing.GroupLayout(AbaFornecedor);
        AbaFornecedor.setLayout(AbaFornecedorLayout);
        AbaFornecedorLayout.setHorizontalGroup(
            AbaFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AbaFornecedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ButtonCadastrarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(441, Short.MAX_VALUE))
        );
        AbaFornecedorLayout.setVerticalGroup(
            AbaFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AbaFornecedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ButtonCadastrarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        TabbedPanePrincipal.addTab("Fornecedor", AbaFornecedor);

        AbaRelatorios.setBackground(new java.awt.Color(219, 238, 245));

        ButtonEmitirRelatorio.setFont(new java.awt.Font("SF Pro", 0, 14)); // NOI18N
        ButtonEmitirRelatorio.setText("Emitir Relatório");
        ButtonEmitirRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEmitirRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AbaRelatoriosLayout = new javax.swing.GroupLayout(AbaRelatorios);
        AbaRelatorios.setLayout(AbaRelatoriosLayout);
        AbaRelatoriosLayout.setHorizontalGroup(
            AbaRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AbaRelatoriosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ButtonEmitirRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(441, Short.MAX_VALUE))
        );
        AbaRelatoriosLayout.setVerticalGroup(
            AbaRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AbaRelatoriosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ButtonEmitirRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        TabbedPanePrincipal.addTab("Relatórios", AbaRelatorios);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        logoPharmasys.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pharmasys_logo.png"))); // NOI18N

        buttonSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonSair.setForeground(new java.awt.Color(153, 0, 51));
        buttonSair.setText("Sair >");

        relogio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel3.setText("|");

        labelNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(logoPharmasys)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(relogio, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonSair)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(relogio)
                        .addComponent(buttonSair))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(labelNome)
                        .addComponent(logoPharmasys))))
        );

        jLabel4.setFont(new java.awt.Font("SF Pro", 1, 20)); // NOI18N
        jLabel4.setText("Olá, gerente!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(TabbedPanePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(TabbedPanePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(197, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonVIsualizarEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonVIsualizarEstoqueActionPerformed
        new TelaEstoque().setVisible(true);
    }//GEN-LAST:event_ButtonVIsualizarEstoqueActionPerformed

    private void ButtonCadastrarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCadastrarMedicamentoActionPerformed
        new TelaCadastroDeEstoque() .setVisible(true);
    }//GEN-LAST:event_ButtonCadastrarMedicamentoActionPerformed

    private void ButtonCadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCadastrarFuncionarioActionPerformed
        new TelaCadastroFuncionario() .setVisible(true);
    }//GEN-LAST:event_ButtonCadastrarFuncionarioActionPerformed

    private void ButtonCadastrarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCadastrarFornecedorActionPerformed
        new TelaCadastroFornecedor() .setVisible(true);
    }//GEN-LAST:event_ButtonCadastrarFornecedorActionPerformed

    private void ButtonEmitirRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEmitirRelatorioActionPerformed
        new TelaRelatorios() .setVisible(true);
    }//GEN-LAST:event_ButtonEmitirRelatorioActionPerformed

    private void ButtonSairActionPerformed(java.awt.event.ActionEvent evt) { 
        new TelaInicial().setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AbaFornecedor;
    private javax.swing.JPanel AbaFuncionarios;
    private javax.swing.JPanel AbaMedicamentos;
    private javax.swing.JPanel AbaRelatorios;
    private javax.swing.JButton ButtonCadastrarFornecedor;
    private javax.swing.JButton ButtonCadastrarFuncionario;
    private javax.swing.JButton ButtonCadastrarMedicamento;
    private javax.swing.JButton ButtonEmitirRelatorio;
    private javax.swing.JButton ButtonVIsualizarEstoque;
    private javax.swing.JTabbedPane TabbedPanePrincipal;
    private javax.swing.JLabel buttonSair;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel logoPharmasys;
    private javax.swing.JLabel relogio;
    // End of variables declaration//GEN-END:variables
// End of variables declaration                   

public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(() -> {
        javax.swing.JFrame frame = new javax.swing.JFrame("Tela do Gerente");
        frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(new ZNovaTelaGerencia()); 
        frame.pack(); 
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true); 
    });
}
}



