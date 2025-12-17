package br.univ.pharmasys.ui;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.univ.pharmasys.dao.FuncionarioDAO;
import br.univ.pharmasys.model.Funcionario;

import br.univ.pharmasys.dao.FornecedorDAO;
import br.univ.pharmasys.model.Fornecedor;

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

/*@SuppressWarnings("serial")
public class TelaRelatorios extends JFrame {
    
    private static final Logger logger = Logger.getLogger(TelaRelatorios.class.getName());
    private final FuncionarioDAO funDAO = new FuncionarioDAO();
    private final FornecedorDAO fornDAO = new FornecedorDAO();
    
    public TelaRelatorios() {
        initComponents();
        configurarEventos();
    }

    private void initComponents() {

        JLabel LabelRelatorios = new JLabel("Relatórios");
        LabelRelatorios.setFont(new Font("Segoe UI", 1, 24));
        JLabel LabelCategoria = new JLabel("Categoria:");
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
        
        ButtonVisualizar.addActionListener(this::acaoVisualizar);

        ButtonGerarPDF.addActionListener(this::acaoGerarPDF);
    }

    private void acaoVisualizar(ActionEvent evt) {
    	String categoria = (String) ComboBoxCategoria.getSelectedItem();
    	try {
    		if ("Funcionários".equals(categoria)) {
    			List<Funcionario> lista = funDAO.listarTodos();
            if (verificarListaVazia(lista)) return;
  
            TelaVisualizacaoRelatorio telaVis = new TelaVisualizacaoRelatorio(this, "Relatório de Funcionários", lista);
            telaVis.setVisible(true);

            } else if ("Fornecedores".equals(categoria)) {
    			List<Fornecedor> lista = fornDAO.listarTodos();
            if (verificarListaVazia(lista)) return;

            TelaVisualizacaoRelatorio telaVis = new TelaVisualizacaoRelatorio(this, "Relatório de Fornecedores", lista);
            telaVis.setVisible(true);

    		} else {
    			JOptionPane.showMessageDialog(this, "Funcionalidade para " + categoria + " ainda não implementada.");
    		}
           
    	} catch (Exception e) {
                logger.log(Level.SEVERE, "Erro ao visualizar", e);
                JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + e.getMessage());
        }
	}

    private void acaoGerarPDF(ActionEvent evt) {
        String categoria = (String) ComboBoxCategoria.getSelectedItem();

        try {
            if ("Funcionários".equals(categoria)) {
                List<Funcionario> lista = funDAO.listarTodos();
                if (verificarListaVazia(lista)) return;
                gerarPdfFuncionarios(lista);

            } else if ("Fornecedores".equals(categoria)) {
                // Nova lógica para Fornecedores
                List<Fornecedor> lista = fornDAO.listarTodos();
                if (verificarListaVazia(lista)) return;
                gerarPdfFornecedores(lista);

            } else {
                JOptionPane.showMessageDialog(this, "PDF para " + categoria + " ainda não implementado.");
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao gerar PDF", e);
            JOptionPane.showMessageDialog(this, "Erro ao gerar PDF: " + e.getMessage());
        }
    }

    private void gerarPdfFornecedores(List<Fornecedor> lista) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar Relatório de Fornecedores");
        fileChooser.setSelectedFile(new java.io.File("Relatorio_Fornecedores.pdf"));

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

                Paragraph titulo = new Paragraph("Relatório de Fornecedores - PharmaSys");
                titulo.setAlignment(Element.ALIGN_CENTER);
                titulo.setSpacingAfter(20);
                document.add(titulo);


                Paragraph data = new Paragraph("Gerado em: " + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()));
                data.setSpacingAfter(20);
                document.add(data);

                PdfPTable table = new PdfPTable(5);
                table.setWidthPercentage(100);
                
                table.setWidths(new float[] { 1f, 3f, 2f, 3f, 2f }); 
                
                table.addCell("ID");
                table.addCell("Nome");
                table.addCell("CNPJ");
                table.addCell("Email");
                table.addCell("Telefone");

                for (Fornecedor f : lista) {
                    table.addCell(String.valueOf(f.getIdFornecedor()));
                    table.addCell(f.getNome() != null ? f.getNome() : "");
                    table.addCell(f.getCnpj() != null ? f.getCnpj() : "");
                    table.addCell(f.getEmail() != null ? f.getEmail() : "");
                    table.addCell(f.getTelefoneId() != null ? f.getTelefoneId() : ""); 
                }

                document.add(table);
                document.close();

                JOptionPane.showMessageDialog(this, "PDF de Fornecedores gerado com sucesso!\nLocal: " + caminhoArquivo);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
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

                Paragraph titulo = new Paragraph("Relatório de Funcionários - PharmaSys");
                titulo.setAlignment(Element.ALIGN_CENTER);
                titulo.setSpacingAfter(20);
                document.add(titulo);

                Paragraph data = new Paragraph("Gerado em: " + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()));
                data.setSpacingAfter(20);
                document.add(data);

                PdfPTable table = new PdfPTable(5);
                table.setWidthPercentage(100);
                
                table.addCell("Nome");
                table.addCell("CPF");
                table.addCell("Email");
                table.addCell("Telefone");
                table.addCell("Cargo");

                String cargoTexto = "";

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
        this.dispose();
    }
    
    private boolean verificarListaVazia(List<?> lista) {
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum registro encontrado para gerar relatório.");
            return true;
        }
        return false;
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

        private JButton ButtonCancelar, ButtonGerarPDF, ButtonVisualizar;
private JComboBox<String> ComboBoxCategoria;
}*/

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.univ.pharmasys.dao.FuncionarioDAO;
import br.univ.pharmasys.model.Funcionario;
import br.univ.pharmasys.dao.FornecedorDAO;
import br.univ.pharmasys.model.Fornecedor;
import br.univ.pharmasys.dao.MedicamentoDAO;
import br.univ.pharmasys.model.Medicamento;

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
    private final FornecedorDAO fornDAO = new FornecedorDAO();
    private final MedicamentoDAO medDAO = new MedicamentoDAO();

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
        ComboBoxCategoria = new JComboBox<>(new String[]{"Funcionários", "Fornecedores", "Estoque"});

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(440, 380));
        setResizable(false);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LabelRelatorios)
                                .addGap(164, 164, 164))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(LabelCategoria)
                                                .addGap(18, 18, 18)
                                                .addComponent(ComboBoxCategoria, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(ButtonCancelar)
                                                .addGap(18, 18, 18)
                                                .addComponent(ButtonVisualizar)
                                                .addGap(18, 18, 18)
                                                .addComponent(ButtonGerarPDF)))
                                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(LabelRelatorios)
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(LabelCategoria)
                                        .addComponent(ComboBoxCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(ButtonCancelar)
                                        .addComponent(ButtonVisualizar)
                                        .addComponent(ButtonGerarPDF))
                                .addGap(50, 50, 50))
        );

        pack();
    }

    private void configurarEventos() {
        ButtonCancelar.addActionListener(this::ButtonCancelarActionPerformed);
        ButtonVisualizar.addActionListener(this::acaoVisualizar);
        ButtonGerarPDF.addActionListener(this::acaoGerarPDF);
    }

    private void acaoVisualizar(ActionEvent evt) {
        String categoria = (String) ComboBoxCategoria.getSelectedItem();
        try {
            if ("Funcionários".equals(categoria)) {
                List<Funcionario> lista = funDAO.listarTodos();
                if (verificarListaVazia(lista)) return;
                new TelaVisualizacaoRelatorio(this, "Relatório de Funcionários", lista).setVisible(true);
            } else if ("Fornecedores".equals(categoria)) {
                // Nova lógica para Fornecedores
                List<Fornecedor> lista = fornDAO.listarTodos();
                if (verificarListaVazia(lista)) return;
                new TelaVisualizacaoRelatorio(this, "Relatório de Fornecedores", lista).setVisible(true);
            } else if ("Estoque".equals(categoria)) {
                List<Medicamento> lista = medDAO.listarTodos();
                if (verificarListaVazia(lista)) return;
                new TelaVisualizacaoRelatorio(this, "Relatório de Estoque", lista).setVisible(true);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao visualizar", e);
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + e.getMessage());
        }
    }

    private void acaoGerarPDF(ActionEvent evt) {
        String categoria = (String) ComboBoxCategoria.getSelectedItem();
        try {
            if ("Funcionários".equals(categoria)) {
                List<Funcionario> lista = funDAO.listarTodos();
                if (verificarListaVazia(lista)) return;
                gerarPdfFuncionarios(lista);
            } else if ("Fornecedores".equals(categoria)) {
                List<Fornecedor> lista = fornDAO.listarTodos();
                if (verificarListaVazia(lista)) return;
                gerarPdfFornecedores(lista);
            } else if ("Estoque".equals(categoria)) {
                List<Medicamento> lista = medDAO.listarTodos();
                if (verificarListaVazia(lista)) return;
                gerarPdfEstoque(lista);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao gerar PDF", e);
            JOptionPane.showMessageDialog(this, "Erro ao gerar PDF: " + e.getMessage());
        }
    }

    private void gerarPdfEstoque(List<Medicamento> lista) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar Relatório de Estoque");
        fileChooser.setSelectedFile(new java.io.File("Relatorio_Estoque.pdf"));

        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            String caminhoArquivo = fileChooser.getSelectedFile().getAbsolutePath();
            if (!caminhoArquivo.endsWith(".pdf")) caminhoArquivo += ".pdf";

            Document document = new Document();
            try {
                PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
                document.open();

                Paragraph titulo = new Paragraph("Relatório de Estoque - PharmaSys");
                titulo.setAlignment(Element.ALIGN_CENTER);
                titulo.setSpacingAfter(20);
                document.add(titulo);

                PdfPTable table = new PdfPTable(4);
                table.setWidthPercentage(100);
                table.addCell("SKU");
                table.addCell("Medicamento");
                table.addCell("Qtd");
                table.addCell("Preço");

                for (Medicamento m : lista) {
                    table.addCell(String.valueOf(m.getSku()));
                    table.addCell(String.valueOf(m.getNomeComercial()));
                    table.addCell(String.valueOf(m.getEstoqueAtual()));
                    table.addCell("R$ " + m.getPreco());
                }

                document.add(table);
                document.close();
                JOptionPane.showMessageDialog(this, "PDF de Estoque gerado com sucesso!");
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Erro PDF Estoque", e);
            }
        }
    }

    private void gerarPdfFornecedores(List<Fornecedor> lista) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new java.io.File("Relatorio_Fornecedores.pdf"));
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            String caminho = fileChooser.getSelectedFile().getAbsolutePath();
            Document document = new Document();
            try {
                PdfWriter.getInstance(document, new FileOutputStream(caminho.endsWith(".pdf") ? caminho : caminho + ".pdf"));
                document.open();
                document.add(new Paragraph("Relatório de Fornecedores\n\n"));
                PdfPTable table = new PdfPTable(5);
                table.setWidthPercentage(100);
                table.addCell("ID"); table.addCell("Nome"); table.addCell("CNPJ"); table.addCell("Email"); table.addCell("Telefone");
                for (Fornecedor f : lista) {
                    table.addCell(String.valueOf(f.getIdFornecedor()));
                    table.addCell(f.getNome());
                    table.addCell(f.getCnpj());
                    table.addCell(f.getEmail());
                    table.addCell(f.getTelefoneId());
                }
                document.add(table);
                document.close();
                JOptionPane.showMessageDialog(this, "PDF de Fornecedores gerado com sucesso!");
            } catch (Exception e) { logger.log(Level.SEVERE, null, e); }
        }
    }

    private void gerarPdfFuncionarios(List<Funcionario> lista) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new java.io.File("Relatorio_Funcionarios.pdf"));
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            String caminho = fileChooser.getSelectedFile().getAbsolutePath();
            Document document = new Document();
            try {
                PdfWriter.getInstance(document, new FileOutputStream(caminho.endsWith(".pdf") ? caminho : caminho + ".pdf"));
                document.open();
                document.add(new Paragraph("Relatório de Funcionários\n\n"));
                PdfPTable table = new PdfPTable(5);
                table.setWidthPercentage(100);
                table.addCell("Nome"); table.addCell("CPF"); table.addCell("Email"); table.addCell("Telefone"); table.addCell("Cargo");
                for (Funcionario f : lista) {
                    table.addCell(f.getNome());
                    table.addCell(f.getCpf());
                    table.addCell(f.getEmail());
                    table.addCell(f.getTelefone());
                    String cargo = f.getTipo() == 1 ? "Estoquista" : f.getTipo() == 2 ? "Atendente" : "Gerente";
                    table.addCell(cargo);
                }
                document.add(table);
                document.close();
                JOptionPane.showMessageDialog(this, "PDF de Funcionários gerado com sucesso!");
            } catch (Exception e) { logger.log(Level.SEVERE, null, e); }
        }
    }

    private void ButtonCancelarActionPerformed(ActionEvent evt) {
        this.dispose();
    }

    private boolean verificarListaVazia(List<?> lista) {
        if (lista == null || lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum registro encontrado.");
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(() -> new TelaRelatorios().setVisible(true));
    }

    private JButton ButtonCancelar, ButtonGerarPDF, ButtonVisualizar;
    private JComboBox<String> ComboBoxCategoria;
    private JLabel LabelCategoria, LabelRelatorios;
}