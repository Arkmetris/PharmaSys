package br.univ.pharmasys.ui;

import br.univ.pharmasys.model.Funcionario;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

@SuppressWarnings("serial")
public class TelaVisualizacaoRelatorio extends JDialog {

    private JTable tabela;
    private JScrollPane scrollPane;

    public TelaVisualizacaoRelatorio(Frame parent, String titulo, List<Funcionario> listaFuncionarios) {
        super(parent, titulo, true);
        initComponents(listaFuncionarios);
    }

    private void initComponents(List<Funcionario> lista) {
        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        String[] colunas = {"ID", "Nome", "CPF", "Email", "Telefone", "Tipo"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0) {
            @Override 
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

	for (Funcionario f : lista) {
	            
		String cargo;
		switch (f.getTipo()) {
		case 1: cargo = "Estoquista"; break;
		case 2: cargo = "Atendente"; break;
		case 3: cargo = "Gerente"; break;
		default: cargo = "Outro"; break;
		}
	
		Object[] linha = {
				f.getIdFuncionario(),
				f.getNome(),
				f.getCpf(),
				f.getEmail(),
				f.getTelefone(),
				cargo
			        };
		model.addRow(linha);
	}

        tabela = new JTable(model);
        scrollPane = new JScrollPane(tabela);

        add(scrollPane, BorderLayout.CENTER);
        
        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(evt -> dispose());
        JPanel panelSul = new JPanel();
        panelSul.add(btnFechar);
        add(panelSul, BorderLayout.SOUTH);
    }
}