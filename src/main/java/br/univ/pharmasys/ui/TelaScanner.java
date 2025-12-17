package br.univ.pharmasys.ui;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class TelaScanner extends javax.swing.JFrame implements Runnable, ThreadFactory {

    private static final long serialVersionUID = 1L;

    private Webcam webcam = null;
    private WebcamPanel panel = null;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    // Componentes da tela
    private javax.swing.JPanel jPanelCamera;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtSku;
    private BotaoArredondado btnLimpar;
    private javax.swing.JLabel lblInstrucao;
    private javax.swing.JLabel lblTitulo;

    public TelaScanner() {
        configurarJanela();
        inicializarComponentes();
        initWebcam();
    }

    private void configurarJanela() {
        setTitle("Scanner PharmaSys");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new Color(245, 245, 250)); // Cor de fundo suave
        // Layout principal
        setLayout(new BorderLayout(10, 10));
    }

    private void inicializarComponentes() {
        JPanel pnlTopo = new JPanel();
        pnlTopo.setBackground(new Color(245, 245, 250));
        pnlTopo.setBorder(new EmptyBorder(15, 0, 10, 0));
        
        lblTitulo = new JLabel("Scanner de Código de Barras");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitulo.setForeground(new Color(50, 50, 80));
        pnlTopo.add(lblTitulo);
        
        add(pnlTopo, BorderLayout.NORTH);

        JPanel pnlCentral = new JPanel();
        pnlCentral.setLayout(new BoxLayout(pnlCentral, BoxLayout.Y_AXIS));
        pnlCentral.setBackground(new Color(245, 245, 250));
        pnlCentral.setBorder(new EmptyBorder(0, 20, 0, 20));

        lblInstrucao = new JLabel("Posicione o código no centro da câmera:");
        lblInstrucao.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblInstrucao.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblInstrucao.setBorder(new EmptyBorder(0, 0, 10, 0));
        pnlCentral.add(lblInstrucao);

        jPanelCamera = new JPanel();
        jPanelCamera.setBackground(Color.BLACK);
        jPanelCamera.setPreferredSize(new Dimension(640, 480)); // Tamanho VGA
        jPanelCamera.setMaximumSize(new Dimension(640, 480));
        jPanelCamera.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanelCamera.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        pnlCentral.add(jPanelCamera);

        pnlCentral.add(Box.createVerticalStrut(20)); // Espaço

        // Campos de Texto
        JPanel pnlCampos = new JPanel(new GridLayout(1, 2, 15, 0));
        pnlCampos.setBackground(new Color(245, 245, 250));
        pnlCampos.setMaximumSize(new Dimension(640, 60));

        txtNomeProduto = criarTextFieldEstilizado("Nome Comercial");
        txtSku = criarTextFieldEstilizado("Código Lido / SKU");

        pnlCampos.add(txtNomeProduto);
        pnlCampos.add(txtSku);
        
        pnlCentral.add(pnlCampos);
        
        add(pnlCentral, BorderLayout.CENTER);

        JPanel pnlInferior = new JPanel();
        pnlInferior.setBackground(new Color(245, 245, 250));
        pnlInferior.setBorder(new EmptyBorder(20, 0, 20, 0));

        btnLimpar = new BotaoArredondado("Limpar / Escanear Outro");
        btnLimpar.setPreferredSize(new Dimension(250, 45)); // Botão maior
        btnLimpar.addActionListener(evt -> limparCampos());

        pnlInferior.add(btnLimpar);
        add(pnlInferior, BorderLayout.SOUTH);

        pack(); 
        setLocationRelativeTo(null);
    }

    private JTextField criarTextFieldEstilizado(String titulo) {
        JTextField campo = new JTextField();
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campo.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(150, 150, 150)), 
                titulo,
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new Font("Segoe UI", Font.BOLD, 12)
        ));
        return campo;
    }

    private void initWebcam() {
        Dimension size = WebcamResolution.VGA.getSize(); 
        webcam = Webcam.getDefault();
        
        if (webcam != null) {
            webcam.setViewSize(size);

            panel = new WebcamPanel(webcam);
            panel.setPreferredSize(size);
            panel.setFPSDisplayed(false);
            panel.setImageSizeDisplayed(false);
            panel.setMirrored(true);

            jPanelCamera.setLayout(new BorderLayout());
            jPanelCamera.add(panel, BorderLayout.CENTER);
            jPanelCamera.revalidate(); 
            
            executor.execute(this);
        } else {
            JOptionPane.showMessageDialog(this, "Nenhuma webcam encontrada!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Result result = null;
            BufferedImage image = null;

            if (webcam != null && webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }

            if (image != null) {
                try {
                    BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(image);
                    BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                    result = new MultiFormatReader().decode(bitmap);
                } catch (NotFoundException e) {
                }
            }

            if (result != null) {
                final String textoLido = result.getText();
                SwingUtilities.invokeLater(() -> {
                    // Evita ficar bipando o mesmo código repetidamente se ja estiver preenchid
                    if (!textoLido.equals(txtSku.getText())) {
                        txtSku.setText(textoLido); 
                        Toolkit.getDefaultToolkit().beep();
                    }
                });
            }
        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "Scanner-Thread");
        t.setDaemon(true);
        return t;
    }
    
    @Override
    public void dispose() {
        if (webcam != null && webcam.isOpen()) {
            webcam.close();
        }
        super.dispose();
    }

    private void limparCampos() {
        txtSku.setText("");
        txtNomeProduto.setText("");
        txtSku.requestFocus();
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(() -> new TelaScanner().setVisible(true));
    }

    class BotaoArredondado extends JButton {
        private Color corNormal = new Color(70, 130, 180);
        private Color corHover = new Color(100, 149, 237); 
        private Color corTexto = Color.WHITE;
        private int raio = 20; 

        public BotaoArredondado(String texto) {
            super(texto);
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setFont(new Font("Segoe UI", Font.BOLD, 14));
            setForeground(corTexto);
            setCursor(new Cursor(Cursor.HAND_CURSOR));

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    setBackground(corHover);
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    setBackground(corNormal);
                }
            });
            setBackground(corNormal);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            g2.setColor(getBackground());
            g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), raio, raio));
            
            // Desenha o texto
            super.paintComponent(g2);
            g2.dispose();
        }
    }
}