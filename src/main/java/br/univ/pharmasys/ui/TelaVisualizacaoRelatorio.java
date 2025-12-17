package br.univ.pharmasys.ui;

import br.univ.pharmasys.model.Fornecedor;
import br.univ.pharmasys.model.Funcionario;
import br.univ.pharmasys.model.Medicamento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

@SuppressWarnings("serial")
public class TelaVisualizacaoRelatorio extends JFrame {

    private JTable tabela;
    private JScrollPane scrollPane;

    public TelaVisualizacaoRelatorio(Frame parent, String titulo, List<?> lista) {
        setTitle(titulo);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents(lista);
        pack();
        setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
	private void initComponents(List<?> lista) {

        setLayout(new BorderLayout());
        
        JLabel lblTitulo = new JLabel("Visualização de Relatório");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(lblTitulo, BorderLayout.NORTH);

        DefaultTableModel model = new DefaultTableModel();
        tabela = new JTable(model);
        scrollPane = new JScrollPane(tabela);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dispose());
        JPanel panelBotoes = new JPanel();
        panelBotoes.add(btnFechar);
        add(panelBotoes, BorderLayout.SOUTH);

        if (lista != null && !lista.isEmpty()) {
            Object primeiroItem = lista.get(0);

            if (primeiroItem instanceof Funcionario) {
                configurarTabelaFuncionarios(model, (List<Funcionario>) lista);
            } else if (primeiroItem instanceof Fornecedor) {
                configurarTabelaFornecedores(model, (List<Fornecedor>) lista);
            }
            else if(primeiroItem instanceof Medicamento) {
                configurarTabelaEstoque(model, (List<Medicamento>) lista);
            }
        } else {
            JOptionPane.showMessageDialog(this, "A lista está vazia.");
        }
    }

    private void configurarTabelaFuncionarios(DefaultTableModel model, List<Funcionario> lista) {

        model.addColumn("Nome");
        model.addColumn("CPF");
        model.addColumn("Email");
        model.addColumn("Telefone");
        model.addColumn("Cargo");

        for (Funcionario f : lista) {
            String cargo = "Desconhecido";
            if (f.getTipo() == 1) cargo = "Estoquista";
            else if (f.getTipo() == 2) cargo = "Atendente";
            else if (f.getTipo() == 3) cargo = "Gerente";

            model.addRow(new Object[]{
                f.getNome(),
                f.getCpf(),
                f.getEmail(),
                f.getTelefone(),
                cargo
            });
        }
	}


    private void configurarTabelaFornecedores(DefaultTableModel model, List<Fornecedor> lista) {

        model.addColumn("ID");
        model.addColumn("Nome / Empresa");
        model.addColumn("CNPJ");
        model.addColumn("Email");
        model.addColumn("Telefone");

        for (Fornecedor f : lista) {
            model.addRow(new Object[]{
                f.getIdFornecedor(),
                f.getNome(),
                f.getCnpj(),
                f.getEmail(),
                f.getTelefoneId()
            });
        }
    }

    private void configurarTabelaEstoque(DefaultTableModel model, List<Medicamento> lista) {

        model.addColumn("SKU");
        model.addColumn("Nome");
        model.addColumn("Data Expiração");
        model.addColumn("Estoque Atual");
        model.addColumn("Laboratório");
        model.addColumn("Fabricante");
        model.addColumn("Preço");


        for (Medicamento m : lista) {
            model.addRow(new Object[]{
                    m.getSku(),
                    m.getNomeComercial(),
                    m.getDataExpiracao(),
                    m.getEstoqueAtual(),
                    m.getLaboratorio(),
                    m.getFabricante(),
                    m.getPreco()

            });
        }
    }

}

       