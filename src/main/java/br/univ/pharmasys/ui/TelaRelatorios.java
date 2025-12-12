package br.univ.pharmasys.ui;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.univ.pharmasys.dao.FuncionarioDAO;
import br.univ.pharmasys.model.Funcionario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("serial")
public class TelaRelatorios extends JFrame {
    
    private static final Logger logger = Logger.getLogger(TelaRelatorios.class.getName());
    private final FuncionarioDAO funDAO = new FuncionarioDAO();
    
    public TelaRelatorios() {
        initComponents();
        configurarEventos();
    }

    private void initComponents() {

        LabelRelatorios = new JLabel("Relatórios");
        LabelRelatorios.setFont(new Font("Segoe UI", 1, 24));
        LabelCategoria = new JLabel("Categoria:");
        ButtonCancelar = new JButton("Cancelar");
        ButtonVisualizar = new JButton("Visualizar");
        ButtonGerarPDF = new JButton("Gerar PDF");
        ComboBoxCategoria = new JComboBox<>(new String[] { "Funcionários", "Fornecedores", "Estoque" });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMaximumSize(new Dimension(440, 380));
        setMinimumSize(new Dimension(440, 380));
        setResizable(false);

        LabelRelatorios.setText("Relatórios");
        LabelCategoria.setText("Categoria:");
        ButtonCancelar.setText("Cancelar");
        ButtonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonCancelarActionPerformed(evt);
            }
        });

        ButtonVisualizar.setText("Visualizar");

        ButtonGerarPDF.setText("Gerar PDF");

        ComboBoxCategoria.setModel(new DefaultComboBoxModel<>(new String[] { "Funcionários", "Fornecedores", "Estoque" }));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LabelCategoria)
                .addGap(18, 18, 18)
                .addComponent(ComboBoxCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(ButtonCancelar)
                        .addGap(41, 41, 41)
                        .addComponent(ButtonVisualizar)
                        .addGap(37, 37, 37)
                        .addComponent(ButtonGerarPDF))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(LabelRelatorios)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(LabelRelatorios)
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCategoria)
                    .addComponent(ComboBoxCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonGerarPDF)
                    .addComponent(ButtonVisualizar)
                    .addComponent(ButtonCancelar))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }

private void configurarEventos() {
        
        ButtonCancelar.addActionListener(evt -> dispose());

        ButtonVisualizar.addActionListener(this::acaoVisualizar);

        ButtonGerarPDF.addActionListener(this::acaoGerarPDF);
    }

    private void acaoVisualizar(ActionEvent evt) {
        String categoria = (String) ComboBoxCategoria.getSelectedItem();

        if ("Funcionários".equals(categoria)) {
            try {
            	
                // 1. Busca dados do banco
                List<Funcionario> lista = funDAO.listarTodos();

                if (lista.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Nenhum funcionário encontrado.");
                    return;
                }

                // 2. Abre a tela de visualização
                TelaVisualizacaoRelatorio telaVis = new TelaVisualizacaoRelatorio(this, "Relatório de Funcionários", lista);
                telaVis.setVisible(true);

            } catch (Exception e) {
                logger.log(Level.SEVERE, "Erro ao visualizar", e);
                JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Funcionalidade para " + categoria + " ainda não implementada.");
        }
    }

    private void acaoGerarPDF(ActionEvent evt) {
        String categoria = (String) ComboBoxCategoria.getSelectedItem();

        if ("Funcionários".equals(categoria)) {
            try {
                List<Funcionario> lista = funDAO.listarTodos();
                if (lista.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Nada para exportar.");
                    return;
                }
                gerarPdfFuncionarios(lista);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Erro ao gerar PDF", e);
                JOptionPane.showMessageDialog(this, "Erro ao gerar PDF: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "PDF para " + categoria + " ainda não implementado.");
        }
    }

    private void gerarPdfFuncionarios(List<Funcionario> lista) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar Relatório em PDF");
        fileChooser.setSelectedFile(new java.io.File("Relatorio_Funcionarios.pdf"));

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            
        	String caminhoArquivo = fileChooser.getSelectedFile().getAbsolutePath();
            if (!caminhoArquivo.endsWith(".pdf")) {
                caminhoArquivo += ".pdf";
            }

            Document document = new Document();
            try {
                PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
                document.open();

                // Título
                Paragraph titulo = new Paragraph("Relatório de Funcionários - PharmaSys");
                titulo.setAlignment(Element.ALIGN_CENTER);
                titulo.setSpacingAfter(20);
                document.add(titulo);

                // Data
                Paragraph data = new Paragraph("Gerado em: " + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()));
                data.setSpacingAfter(20);
                document.add(data);

                // Tabela
                PdfPTable table = new PdfPTable(5);
                table.setWidthPercentage(100);
                
                // Cabeçalho da Tabela
                table.addCell("Nome");
                table.addCell("CPF");
                table.addCell("Email");
                table.addCell("Telefone");
                table.addCell("Cargo");

                String cargoTexto = "";
                // Dados
                for (Funcionario f : lista) {
                    table.addCell(f.getNome());
                    table.addCell(f.getCpf());
                    table.addCell(f.getEmail());
                    table.addCell(f.getTelefone());
                    table.addCell(cargoTexto);
                    if (f.getTipo() == 1) {
                    	cargoTexto = "Estoquista";
                    }
                    else if (f.getTipo() == 2) {
                    	cargoTexto = "Atendente";
                    }
                    else if (f.getTipo() == 3) {
                    	cargoTexto = "Gerente";
                    }
                }

                document.add(table);
                document.close();

                JOptionPane.showMessageDialog(this, "PDF gerado com sucesso em:\n" + caminhoArquivo);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    private void ButtonCancelarActionPerformed(ActionEvent evt) {
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
            logger.log(Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(() -> new TelaRelatorios().setVisible(true));
    }

    private JButton ButtonCancelar;
    private JButton ButtonGerarPDF;
    private JButton ButtonVisualizar;
    private JComboBox<String> ComboBoxCategoria;
    private JLabel LabelCategoria;
    private JLabel LabelRelatorios;
}
