package br.univ.pharmasys.ui;

import javax.swing.*;

import br.univ.pharmasys.dao.FornecedorDAO;
import br.univ.pharmasys.exceptions.ErroDePreenchimentoInvalidoException;
import br.univ.pharmasys.exceptions.IdInvalidoException;
import br.univ.pharmasys.exceptions.NomeInvalidoException;
import br.univ.pharmasys.exceptions.TelefoneInvalidoException;
import br.univ.pharmasys.model.Fornecedor;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.Logger;

@SuppressWarnings("serial")
public class TelaCadastroFornecedor extends JFrame {
    
    private static final Logger logger = Logger.getLogger(TelaCadastroFornecedor.class.getName());

    public TelaCadastroFornecedor() {
        initComponents();
        configurarBotoes();
    }

    private void initComponents() {

        LabelCadastroFornecedor = new JLabel();
        LabelCnpj = new JLabel();
        LabelEmpresa = new JLabel();
        LabelID = new JLabel();
        LabelTelefone = new JLabel();
        LabelEmail = new JLabel();
        CampoCnpj = new JTextField();
        CampoEmpresa = new JTextField();
        CampoID = new JTextField();
        CampoTelefone = new JTextField();
        CampoEmail = new JTextField();
        ButtonCancelar = new JButton();
        ButtonCadastrar = new JButton();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMaximumSize(new Dimension(701, 447));
        setMinimumSize(new Dimension(701, 447));

        LabelCadastroFornecedor.setFont(new Font("Segoe UI", 1, 24)); 
        LabelCadastroFornecedor.setText("Cadastro de Fornecedor");

        LabelCnpj.setText("CNPJ:");
        LabelEmpresa.setText("Empresa:");
        LabelID.setText("ID:");
        LabelTelefone.setText("Telefone: ");
        LabelEmail.setText("Email:");

        CampoID.setEditable(false); 
        CampoID.setText("Automático");
        
        CampoEmpresa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CampoEmpresaActionPerformed(evt);
            }
        });

        ButtonCancelar.setText("Cancelar");

        ButtonCadastrar.setText("Cadastrar");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LabelCadastroFornecedor)
                        .addGap(191, 191, 191))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ButtonCancelar)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonCadastrar)
                        .addGap(33, 33, 33))))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelID)
                        .addGap(16, 16, 16)
                        .addComponent(CampoID, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(LabelTelefone)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CampoTelefone, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelEmpresa)
                                .addGap(4, 4, 4))
                            .addComponent(LabelCnpj, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(CampoEmpresa, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                            .addComponent(CampoCnpj)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelEmail, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CampoEmail, GroupLayout.PREFERRED_SIZE, 535, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(LabelCadastroFornecedor)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCnpj)
                    .addComponent(CampoCnpj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelEmpresa)
                    .addComponent(CampoEmpresa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(LabelID)
                        .addComponent(CampoID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(LabelTelefone)
                    .addComponent(CampoTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelEmail)
                    .addComponent(CampoEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonCancelar)
                    .addComponent(ButtonCadastrar))
                .addGap(26, 26, 26))
        );

        pack();
    }
    
    private void configurarBotoes() {
        ButtonCadastrar.addActionListener(evt -> cadastrarFornecedor());
        
        ButtonCancelar.addActionListener(evt -> {
            this.dispose(); // Fecha a janela
        });
    }

    private void cadastrarFornecedor() {
        try {
            FornecedorDAO dao = new FornecedorDAO();

            String cnpjDigitado = CampoCnpj.getText();
            if (dao.buscarPorCnpj(cnpjDigitado) != null) {
                throw new IllegalArgumentException("Este CNPJ já está cadastrado no sistema.");
            }

            Fornecedor fornecedor = new Fornecedor();

            fornecedor.setNome(CampoEmpresa.getText());
            fornecedor.setCnpj(cnpjDigitado);
            fornecedor.setEmail(CampoEmail.getText());
            fornecedor.setTelefoneId(CampoTelefone.getText());

            //Tem que atualziar a tela com isso ainda
            fornecedor.setEstado("PE"); 
            fornecedor.setCep("00000000");
            fornecedor.setRua("Sem Rua");
            fornecedor.setBairro("Sem Bairro");
            fornecedor.setCidade("Sem Cidade");
            dao.create(fornecedor);

            JOptionPane.showMessageDialog(this, "Fornecedor cadastrado com sucesso!");
            limparCampos();

        } catch (NomeInvalidoException | IdInvalidoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro de Validação", JOptionPane.WARNING_MESSAGE);
            
        } catch (TelefoneInvalidoException | ErroDePreenchimentoInvalidoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Telefone Inválido", JOptionPane.WARNING_MESSAGE);
            
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE); 
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro inesperado: " + e.getMessage(), "Erro Crítico", JOptionPane.ERROR_MESSAGE);

            Fornecedor fornecedor = new Fornecedor();

            fornecedor.setNome(CampoEmpresa.getText());
            fornecedor.setCnpj(CampoCnpj.getText());
            fornecedor.setEmail(CampoEmail.getText());
            fornecedor.setTelefoneId(CampoTelefone.getText());

            // Tem que criar as caixa de escrever os dados de endereço
            fornecedor.setEstado("");
            fornecedor.setCep("");
            fornecedor.setRua("");
            fornecedor.setBairro("");
            fornecedor.setCidade("");

            FornecedorDAO dao = new FornecedorDAO();
            dao.create(fornecedor);

            JOptionPane.showMessageDialog(this, "Fornecedor cadastrado com sucesso!");
            
            limparCampos();
            this.dispose(); 

//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Erro ao cadastrar: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
//            e.printStackTrace();
        }
    }

    private void limparCampos() {
        CampoEmpresa.setText("");
        CampoCnpj.setText("");
        CampoEmail.setText("");
        CampoTelefone.setText("");
        CampoID.setText("");
    }
    
    private void CampoEmpresaActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
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

        EventQueue.invokeLater(() -> new TelaCadastroFornecedor().setVisible(true));
    }

    private JButton ButtonCadastrar;
    private JButton ButtonCancelar;
    private JTextField CampoCnpj;
    private JTextField CampoEmail;
    private JTextField CampoEmpresa;
    private JTextField CampoID;
    private JTextField CampoTelefone;
    private JLabel LabelCadastroFornecedor;
    private JLabel LabelCnpj;
    private JLabel LabelEmail;
    private JLabel LabelEmpresa;
    private JLabel LabelID;
    private JLabel LabelTelefone;
}
