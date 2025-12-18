package br.univ.pharmasys.ui;

import javax.swing.*;
import javax.swing.LayoutStyle.*;
import javax.swing.GroupLayout.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import br.univ.pharmasys.dao.FuncionarioDAO;
import br.univ.pharmasys.model.Funcionario;
import br.univ.pharmasys.util.MensagemEmailFuncionario;

@SuppressWarnings("serial")
public class TelaCadastroFuncionario extends JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaCadastroFuncionario.class.getName());

    public TelaCadastroFuncionario() {
        initComponents();
    }

    private void initComponents() {

        LabelTituloCadastroFunc = new JLabel();
        BotaoCadastrar = new JButton();
        BotaoCancelar = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        boxDia = new JComboBox<>();
        boxMes = new JComboBox<>();
        boxAno = new JComboBox<>();
        boxSexo = new JComboBox<>();
        //boxSexo.setPreferredSize(new java.awt.Dimension(100, 25));
        TextNome = new JTextField();
        TextCpf = new JTextField();
        TextEmail = new JTextField();
        TextEmailConfirm = new JTextField();
        TextTelefone = new JTextField();
        TextSenha = new JTextField();
        TextSenhaConfirm = new JTextField();
        boxCargo = new JComboBox<>();
        boxCargo.setModel(new DefaultComboBoxModel<>(
                new String[] { "Estoquista", "Atendente", "Gerente" }
        ));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setMinimumSize(new java.awt.Dimension(660, 500));
        setResizable(false);

        LabelTituloCadastroFunc.setBackground(new java.awt.Color(255, 255, 255));
        LabelTituloCadastroFunc.setFont(new java.awt.Font("SF Pro", 1, 24)); // NOI18N
        LabelTituloCadastroFunc.setHorizontalAlignment(SwingConstants.CENTER);
        LabelTituloCadastroFunc.setText("Cadastro de Funcionário");

        BotaoCadastrar.setText("Cadastrar");
        BotaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCadastrarAction(evt);
            }
        });

        BotaoCancelar.setText("Cancelar");
        BotaoCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotaoCancelarActionPerformed(evt);
            }
        });

        //
        jLabel1.setFont(new java.awt.Font("SF Pro", 0, 14)); // NOI18N
        jLabel1.setText("Nome completo:");

        jLabel2.setFont(new java.awt.Font("SF Pro", 0, 14)); // NOI18N
        jLabel2.setText("Data de nascimento:");

        jLabel3.setFont(new java.awt.Font("SF Pro", 0, 13)); // NOI18N
        jLabel3.setText("Sexo:");

        jLabel4.setFont(new java.awt.Font("SF Pro", 0, 14)); // NOI18N
        jLabel4.setText("CPF:");

        jLabel5.setFont(new java.awt.Font("SF Pro", 0, 14)); // NOI18N
        jLabel5.setText("Cargo:");

        jLabel6.setFont(new java.awt.Font("SF Pro", 0, 14)); // NOI18N
        jLabel6.setText("Email:");

        jLabel7.setFont(new java.awt.Font("SF Pro", 0, 14)); // NOI18N
        jLabel7.setText("Confirmar email:");

        jLabel8.setFont(new java.awt.Font("SF Pro", 0, 14)); // NOI18N
        jLabel8.setText("Definir senha:");

        jLabel9.setFont(new java.awt.Font("SF Pro", 0, 14)); // NOI18N
        jLabel9.setText("Confirmar a senha:");

        boxDia.setModel(new DefaultComboBoxModel<>(new String[] { "  ", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", " " }));

        boxMes.setModel(new DefaultComboBoxModel<>(new String[] { "janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro", " " }));

        boxAno.setModel(new DefaultComboBoxModel<>(new String[] { "  ", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", " " }));

        boxSexo.setModel(new DefaultComboBoxModel<>(new String[] { "  ", "Fem", "Masc" }));

        //TextCargo.setText(" ");

        TextEmail.setText(" ");

        jLabel10.setForeground(new java.awt.Color(153, 0, 51));
        jLabel10.setText("* Apenas números");

        jLabel11.setText("Telefone 1:");

        TextSenha.setFont(new java.awt.Font("SF Pro", 0, 12)); // NOI18N

        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(jLabel1)
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addComponent(TextNome, GroupLayout.PREFERRED_SIZE, 554, GroupLayout.PREFERRED_SIZE))
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(jLabel2)
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(boxDia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(boxMes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(boxAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        								.addComponent(LabelTituloCadastroFunc)
        								.addComponent(jLabel8)
        								.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
        								.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        									.addGroup(layout.createSequentialGroup()
        										.addComponent(jLabel7)
        										.addPreferredGap(ComponentPlacement.RELATED)
        										.addComponent(TextEmailConfirm))
        									.addGroup(layout.createSequentialGroup()
        										.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        										.addPreferredGap(ComponentPlacement.RELATED)
        										.addComponent(TextEmail, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))))
        							.addGap(0, 0, Short.MAX_VALUE))
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(TextTelefone, 131, 131, 131))
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        									.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
        									.addComponent(TextCpf, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(jLabel10)
        							.addGap(362)))
        					.addGap(19))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(0, 363, Short.MAX_VALUE)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(boxCargo, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(BotaoCancelar)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(boxSexo, GroupLayout.PREFERRED_SIZE,45,GroupLayout.PREFERRED_SIZE)))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(BotaoCadastrar)
        					.addGap(16))
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(TextSenhaConfirm, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
        						.addComponent(TextSenha, Alignment.LEADING))
        					.addContainerGap(412, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(17)
        			.addComponent(LabelTituloCadastroFunc, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(TextNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(jLabel3)
        				.addComponent(boxDia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(boxMes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(boxAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(boxSexo, GroupLayout.PREFERRED_SIZE,25, GroupLayout.PREFERRED_SIZE))
        			.addGap(7)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel4)
        				.addComponent(TextCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel5)
                            .addComponent(boxCargo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel11)
        				.addComponent(TextTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel6)
        				.addComponent(TextEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel7)
        				.addComponent(TextEmailConfirm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(41)
        			.addComponent(jLabel8)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(TextSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(jLabel9)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(TextSenhaConfirm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(BotaoCadastrar)
        				.addComponent(BotaoCancelar))
        			.addGap(14))
        );
        getContentPane().setLayout(layout);

        pack();
    }

    private void BotaoCadastrarAction(java.awt.event.ActionEvent evt) {
        try {
 
            String senha1 = TextSenha.getText();
            String senha2 = TextSenhaConfirm.getText();
            
            // Verifica se as senhas são iguais
            if (!senha1.equals(senha2)) {
                JOptionPane.showMessageDialog(this, "As senhas não coincidem!", "Erro", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String email1 = TextEmail.getText();
            String email2 = TextEmailConfirm.getText();
            
            // Verifica se os emails são iguais
            if (!email1.equals(email2)) {
                JOptionPane.showMessageDialog(this, "Os emails não coincidem!", "Erro", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Funcionario func = new Funcionario();
            
            func.setNome(TextNome.getText());
            func.setCpf(TextCpf.getText());
            func.setEmail(email1);
            
            String sexoSelecionado = (String) boxSexo.getSelectedItem();
            if (sexoSelecionado == null || sexoSelecionado.trim().isEmpty()) {
                 throw new IllegalArgumentException("Selecione o sexo.");
            }
            func.setSexo(sexoSelecionado); 
            
            func.setTelefone(TextTelefone.getText());
            

            func.setSenha(senha1);

            String diaStr = (String) boxDia.getSelectedItem();
            String mesStr = (String) boxMes.getSelectedItem(); 
            String anoStr = (String) boxAno.getSelectedItem();
            
            if (diaStr == null || diaStr.trim().isEmpty() || 
                mesStr == null || mesStr.trim().isEmpty() || 
                anoStr == null || anoStr.trim().isEmpty()) {
                throw new IllegalArgumentException("Data de nascimento incompleta.");
            }
            
            int dia = Integer.parseInt(diaStr.trim());
            int ano = Integer.parseInt(anoStr.trim());
            int mes = converterMesParaNumero(mesStr); // Chama o método auxiliar
            
            func.setDataNascimento(LocalDate.of(ano, mes, dia));


            String cargoTexto = (String) boxCargo.getSelectedItem();
            cargoTexto = cargoTexto.toLowerCase().trim();


            int tipoCargo = 1;


            if (cargoTexto.contains("gerente") || cargoTexto.equals("3")) {
                tipoCargo = 3; // Gerente
            } else if (cargoTexto.contains("atendente") || cargoTexto.equals("2")) {
                tipoCargo = 2; // Atendente
            } else if ((cargoTexto.contains("estoquista") || cargoTexto.equals("1"))) { 
                tipoCargo = 1; // Estoquista
            }
            func.setTipo(tipoCargo);


            FuncionarioDAO dao = new FuncionarioDAO();

            MensagemEmailFuncionario mensagem = new MensagemEmailFuncionario();

            dao.create(func);

            mensagem.enviarConfirmacao(func.getEmail(), func.getNome());

            JOptionPane.showMessageDialog(this, "Funcionário cadastrado com sucesso!");
           
            this.dispose();

        } catch (NumberFormatException e) {
             JOptionPane.showMessageDialog(this, "Erro nos campos numéricos (Data ou Cargo).", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
             JOptionPane.showMessageDialog(this, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + e.getMessage(), "Erro Crítico", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); 
        }
    }

    private int converterMesParaNumero(String mesNome) {
        if (mesNome == null) return 1;
        mesNome = mesNome.trim().toLowerCase();
        
        switch (mesNome) {
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
            default: return 1; 
        }
    }

    private void BotaoCancelarActionPerformed(ActionEvent evt) {
        this.dispose();
    }

    public static void main(String args[]) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new TelaCadastroFuncionario().setVisible(true));
    }

    private JButton BotaoCadastrar;
    private JButton BotaoCancelar;
    private JLabel LabelTituloCadastroFunc;
    private JComboBox<String> boxDia;
    private JComboBox<String> boxMes;
    private JComboBox<String> boxAno;
    private JComboBox<String> boxSexo;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JTextField TextNome;
    private JTextField TextCpf;
    private JComboBox<String> boxCargo ;
    private JTextField TextEmail;
    private JTextField TextEmailConfirm;
    private JTextField TextTelefone;
    private JTextField TextSenha;
    private JTextField TextSenhaConfirm;
}
