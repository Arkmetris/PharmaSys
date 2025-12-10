package br.univ.pharmasys.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.univ.pharmasys.dao.FuncionarioDAO;
import br.univ.pharmasys.model.Funcionario;
import br.univ.pharmasys.util.InicializadorDatabase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class TelaInicial extends JFrame {

    public TelaInicial() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {

    	// Declaração dos componentes
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        
        // Campos de texto
        TextSenha = new javax.swing.JPasswordField(); // Campo da senha
        TextLogin = new javax.swing.JTextField(); 	  // Campo do login
        ButtonEntrar = new javax.swing.JButton(); 	  // Botão de entrar

        // Configurações da janela
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login - PharmaSys");
        setPreferredSize(new java.awt.Dimension(700, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 36));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PHARMASYS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        // Painel da Logo
        jPanel1.setBackground(new java.awt.Color(51, 166, 178));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 450));

        // Carregar a imagem da logo
        try {
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/univ/pharmasys/ui/Frame_23.png")));
        } catch (Exception e) {
            jLabel1.setText("Imagem não encontrada");
        }

        // Layout do painel da logo
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 450));

        //
        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24));
        jLabel3.setText("Seja bem vindo!");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, -1, -1));

        //
        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 16));
        jLabel4.setText("Faça o seu login aqui:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, -1, -1));

        //
        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12));
        jLabel5.setText("Login:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, -1));

        //
        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 12));
        jLabel6.setText("Senha:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, -1, -1));
        
        // Campos de senha
        TextSenha.setForeground(new java.awt.Color(204, 204, 204));
        TextSenha.setText("");
        getContentPane().add(TextSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 280, -1));

        // Campos de login
        TextLogin.setForeground(new java.awt.Color(204, 204, 204));
        TextLogin.setText("");
        getContentPane().add(TextLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 280, -1));

        // Botão de entrar
        ButtonEntrar.setBackground(new java.awt.Color(102, 102, 102));
        ButtonEntrar.setForeground(new java.awt.Color(255, 255, 255));
        ButtonEntrar.setText("Entrar");
        
        // Ação do botão entrar
        ButtonEntrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		buttonEntrarAction(e);
        	}
        });
        
        getContentPane().add(ButtonEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 280, -1));

        pack();
    }

    // Ação do botão entrar
    private void buttonEntrarAction(java.awt.event.ActionEvent evt) {                                          
        
        String cpf = TextLogin.getText();
        String senha = new String(TextSenha.getPassword());

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
                    tela.setVisible(true);
                    this.dispose();
                    
                } else if (usuario.getTipo() == 2) {
                    // Aqui você colocaria a tela do Farmacêutico futuramente
                    JOptionPane.showMessageDialog(this, "Bem-vindo Farmacêutico(a) " + usuario.getNome());
                    // new TelaFarmaceutico().setVisible(true);
                    // this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Bem-vindo " + usuario.getNome());
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
	        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	            if ("Nimbus".equals(info.getName())) {
	                javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                break;
	            }
	        }
	    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
	        java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    }
	
	    /* Abre a tela */
	    java.awt.EventQueue.invokeLater(() -> {
	        new TelaInicial().setVisible(true);
	    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField TextSenha;
    private javax.swing.JTextField TextLogin;
    // End of variables declaration//GEN-END:variables
		public void actionPerformed(ActionEvent e) {
		}
}

