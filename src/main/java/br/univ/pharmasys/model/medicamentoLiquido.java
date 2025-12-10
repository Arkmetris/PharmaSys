package br.univ.pharmasys.model;

import br.univ.pharmasys.exceptions.ErroDePreenchimentoInvalidoException;

public class medicamentoLiquido extends Medicamento {

    private double volumeMl;      
    private String tipoRecipiente;

    public medicamentoLiquido() {
        super();
    }

    public double getvolumeMl() {
        return volumeMl;
    }

    public void setvolumeMl(double volumeMl) {
    	
        // Validação que o volume não pode ser zero ou negativo
    	
        if (volumeMl <= 0) {
            throw new ErroDePreenchimentoInvalidoException("O volume em ml deve ser maior que zero.");
        }
        this.volumeMl = volumeMl;
    }

    public String gettipoRecipiente() {
        return tipoRecipiente;
    }

    public void settipoRecipiente(String tipoRecipiente) {
        if (tipoRecipiente == null || tipoRecipiente.trim().isEmpty()) {
            throw new ErroDePreenchimentoInvalidoException("O tipo de recipiente é obrigatório.");
        }

        tipoRecipiente = tipoRecipiente.trim();

        // Validação que não permite que fique sem espaços
        
        if (!tipoRecipiente.matches("\\S+")) {
            throw new ErroDePreenchimentoInvalidoException("O tipo de recipiente não pode conter espaços.");
        }

        this.tipoRecipiente = tipoRecipiente;
    }

    @Override
    public String toString() {
        return "MedicamentoLiquido [SKU=" + getSku() + ", Volume=" + volumeMl + "ml, Recipiente=" + tipoRecipiente + "]";
    }
}