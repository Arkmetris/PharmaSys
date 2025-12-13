package br.univ.pharmasys.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import br.univ.pharmasys.dao.FuncionarioDAO;
import br.univ.pharmasys.model.Funcionario;
import br.univ.pharmasys.util.InicializadorDatabase;


@SuppressWarnings("serial")
public class TelaInicial extends JFrame {

    public TelaInicial() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {

    	// Declaração dos componentes
        jLabel2 = new JLabel();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        
        // Campos de texto
        textSenha = new JPasswordField(); // Campo da senha
        textLogin = new JTextField(); 	  // Campo do login
        buttonEntrar = new JButton(); 	  // Botão de entrar

        // Configurações da janela
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login - PharmaSys");
        setPreferredSize(new Dimension(700, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new Font("SansSerif", 1, 36));
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("PHARMASYS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        // Painel da Logo
        jPanel1.setBackground(new Color(51, 166, 178));
        jPanel1.setPreferredSize(new Dimension(350, 450));

        // Carregar a imagem da logo
        try {
            jLabel1.setIcon(new ImageIcon(getClass().getResource("/br/univ/pharmasys/ui/Frame_23.png")));
        } catch (Exception e) {
            jLabel1.setText("Imagem não encontrada");
        }

        // Layout do painel da logo
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 450));

        //
        jLabel3.setFont(new Font("SansSerif", 1, 24));
        jLabel3.setText("Seja bem vindo!");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, -1, -1));

        //
        jLabel4.setFont(new Font("SansSerif", 0, 16));
        jLabel4.setText("Faça o seu login aqui:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, -1, -1));

        //
        jLabel5.setFont(new Font("SansSerif", 1, 12));
        jLabel5.setText("Login:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, -1));

        //
        jLabel6.setFont(new Font("SansSerif", 1, 12));
        jLabel6.setText("Senha:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, -1, -1));
        
        // Campos de senha
        textSenha.setForeground(Color.black);
        textSenha.setText("");
        getContentPane().add(textSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 280, -1));

        // Campos de login
        textLogin.setForeground(Color.black);
        textLogin.setText("");
        getContentPane().add(textLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 280, -1));

        // Botão de entrar
        buttonEntrar.setBackground(new Color(102, 102, 102));
        buttonEntrar.setForeground(new Color(255, 255, 255));
        buttonEntrar.setText("Entrar");
        
        // Ação do botão entrar
        buttonEntrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		buttonEntrarAction(e);
        	}
        });
        
        getContentPane().add(buttonEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 280, -1));

        pack();
    }

    // Ação do botão entrar
    private void buttonEntrarAction(ActionEvent evt) {                                          
        
        String cpf = textLogin.getText();
        String senha = new String(textSenha.getPassword());

        if (cpf.trim().isEmpty() || senha.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha CPF e Senha.");
            return;
        }

        try {
            FuncionarioDAO dao = new FuncionarioDAO();
            
            // Chama o DAO para autenticar
            Funcionario usuario = dao.autenticar(cpf, senha);

            if (usuario != null) {
                
                // Verifica o tipo de usuário
                if (usuario.getTipo() == 3) {
                    
                    TelaGerencia tela = new TelaGerencia();
                    tela.definirUsuarioLogado(usuario.getNome());
                    tela.definirUsuarioLogado(usuario.getNome());
                    tela.setVisible(true);
                    this.dispose();
                    
                } else if (usuario.getTipo() == 2) {
                    JOptionPane.showMessageDialog(this, "Bem-vindo Farmacêutico(a) " + usuario.getNome());
                    TelaFuncionario tela = new TelaFuncionario();
                    tela.setVisible(true);
                    tela.definirUsuarioLogado(usuario.getNome());
                    this.dispose();
                } else if (usuario.getTipo() == 1) {
                    JOptionPane.showMessageDialog(this, "Bem-vindo Esoquista " + usuario.getNome());
                    TelaEstoquista tela = new TelaEstoquista();
                    tela.setVisible(true);
                    tela.definirUsuarioLogado(usuario.getNome());
                    this.dispose();
                }

            } else {
                JOptionPane.showMessageDialog(this, "CPF ou Senha inválidos.", "Acesso Negado", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro de conexão com o banco de dados:\n" + e.getMessage());
            e.printStackTrace();
        }
    }
    
	public static void main(String args[]) {

	    try {
	        System.out.println("Iniciando PharmaSys...");
	        InicializadorDatabase.verificarEInicializar();
	    } catch (Exception e) {
	        System.err.println("Erro ao inicializar banco: " + e.getMessage());
	    }
	
	    
	    try {
	        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	            if ("Nimbus".equals(info.getName())) {
	                UIManager.setLookAndFeel(info.getClassName());
	                break;
	            }
	        }
	    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
	        java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    }
	    
	    EventQueue.invokeLater(() -> {
	        new TelaInicial().setVisible(true);
	    });
}

    private JButton buttonEntrar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JPanel jPanel1;
    private JPasswordField textSenha;
    private JTextField textLogin;
}

