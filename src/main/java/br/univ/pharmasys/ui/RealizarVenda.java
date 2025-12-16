package br.univ.pharmasys.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("serial")
public class RealizarVenda extends JFrame {
    
    public RealizarVenda() {
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
    
    // Método para definir o labelNome do usuário mostrado na tela
    public void definirUsuarioLogado(String nome) {
        labelNome.setText(nome);
    }

    private void initComponents() {

        labelLogo = new JLabel();
        labelNome = new JLabel();
        labelSeparador = new JLabel();
        labelPagamento = new JLabel();
        relogio = new JLabel();
        jPanel1 = new JPanel();
        labelItens = new JLabel();
        labelQuantidade = new JLabel();
        labelPrecoUnitario = new JLabel();
        labelSubtotal = new JLabel();
        jScrollBar1 = new JScrollBar();
        labelTotal = new JLabel();
        buttonAdicionarProduto = new JButton();
        buttonAdicionarProduto.addActionListener(e -> abrirDialogAdicionarProduto());
        buttonFinalizarCompra = new JButton();
        buttonVoltar = new JButton();
        rbPix = new JRadioButton();
        rbDebito = new JRadioButton();
        rbCredito = new JRadioButton();
        rbEspecie = new JRadioButton();
        grupoPagamento = new ButtonGroup();
        grupoPagamento.add(rbPix);
        grupoPagamento.add(rbDebito);
        grupoPagamento.add(rbCredito);
        grupoPagamento.add(rbEspecie);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

     try {   
        labelLogo.setIcon(new ImageIcon(getClass().getResource("/pharmasys_logo.png")));
    } catch (Exception e) {
        labelLogo.setText("Imagem não encontrada");
    }

        labelNome.setFont(new Font("SF Pro", 0, 14)); 

        labelSeparador.setFont(new Font("Segoe UI", 0, 14)); 
        labelSeparador.setText("|");

        relogio.setFont(new Font("SF Pro", 0, 14)); 

        labelItens.setFont(new Font("SF Pro", 0, 12)); 
        labelItens.setText("ITENS");

        labelQuantidade.setFont(new Font("SF Pro", 0, 12)); 
        labelQuantidade.setText("QUANT.");

        labelPrecoUnitario.setFont(new Font("SF Pro", 0, 12)); 
        labelPrecoUnitario.setText("PREÇO UN.");

        labelSubtotal.setFont(new Font("SF Pro", 0, 12)); 
        labelSubtotal.setText("SUBTOTAL");

        labelTotal.setFont(new Font("SF Pro", 0, 14)); 
        labelTotal.setText("Total:");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(labelItens, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(labelQuantidade, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(labelPrecoUnitario)
                        .addGap(76, 76, 76)
                        .addComponent(labelSubtotal, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelTotal, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)))
                .addComponent(jScrollBar1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(labelItens)
                            .addComponent(labelQuantidade)
                            .addComponent(labelPrecoUnitario)
                            .addComponent(labelSubtotal))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelTotal)
                        .addContainerGap())
                    .addComponent(jScrollBar1, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)))
        );

        buttonAdicionarProduto.setBackground(new Color(153, 153, 153));
        buttonAdicionarProduto.setFont(new Font("Yu Gothic UI", 0, 12)); 
        buttonAdicionarProduto.setForeground(new Color(255, 255, 255));
        buttonAdicionarProduto.setText("+ ADICIONAR PRODUTOS");

        buttonFinalizarCompra.setBackground(new Color(0, 153, 153));
        buttonFinalizarCompra.setFont(new Font("SF Pro", 0, 12)); 
        buttonFinalizarCompra.setForeground(new Color(255, 255, 255));
        buttonFinalizarCompra.setText("FINALIZAR COMPRA");

        labelPagamento.setFont(new Font("SF Pro", 0, 15)); 
        labelPagamento.setText("Método de pagamento:");

        rbPix.setText("Pix");
        rbDebito.setText("Débito");
        rbCredito.setText("Crédito");
        rbEspecie.setText("Em espécie");

        buttonVoltar.setFont(new Font("SF Pro", 0, 12)); 
        buttonVoltar.setText("<< Voltar");
        buttonVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(labelPagamento)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbPix)
                        .addGap(18, 18, 18)
                        .addComponent(rbDebito)
                        .addGap(18, 18, 18)
                        .addComponent(rbCredito)
                        .addGap(18, 18, 18)
                        .addComponent(rbEspecie)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonFinalizarCompra)
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelLogo)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelNome, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelSeparador, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(relogio))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(buttonVoltar)
                        .addGap(139, 139, 139)
                        .addComponent(buttonAdicionarProduto, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 252, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLogo)
                    .addComponent(labelNome)
                    .addComponent(relogio)
                    .addComponent(labelSeparador))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(buttonAdicionarProduto, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonVoltar))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(buttonFinalizarCompra, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelPagamento)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(rbPix)
                            .addComponent(rbDebito)
                            .addComponent(rbCredito)
                            .addComponent(rbEspecie))))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jCheckBox1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed
    private void abrirDialogAdicionarProduto() {
        DialogAdicionarProduto dialog =
        new DialogAdicionarProduto(this, true);
        dialog.setVisible(true);
}
    
    private void jButton3ActionPerformed(ActionEvent evt) {                                         
     Object[] opcoes = { "Sim, cancelar", "Voltar" };

    int escolha = JOptionPane.showOptionDialog(
            this,
            "Tem certeza que deseja cancelar a venda?",
            "",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.WARNING_MESSAGE,
            null,
            opcoes,
            opcoes[1]
    );

    if (escolha == 0) {
        new NovaTelaFuncionario().setVisible(true);
        this.dispose();
    }
    else if (escolha == 1) {
        System.out.println("Voltando...");
    }
    }
    public static void main(String args[]) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RealizarVenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(RealizarVenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RealizarVenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(RealizarVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RealizarVenda().setVisible(true);
            }
        });
    }

    private JButton buttonAdicionarProduto;
    private JButton buttonFinalizarCompra;
    private JButton buttonVoltar;
    private JRadioButton rbPix;
    private JRadioButton rbDebito;
    private JRadioButton rbCredito;
    private JRadioButton rbEspecie;
    private ButtonGroup grupoPagamento;
    private JLabel labelLogo;
    private JLabel labelTotal;
    private JLabel labelPagamento;
    private JLabel labelNome;
    private JLabel relogio;
    private JLabel labelSeparador;
    private JLabel labelItens;
    private JLabel labelQuantidade;
    private JLabel labelPrecoUnitario;
    private JLabel labelSubtotal;
    private JPanel jPanel1;
    private JScrollBar jScrollBar1;

}
