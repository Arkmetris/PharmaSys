package br.univ.pharmasys.model;
//a
import br.univ.pharmasys.exceptions.ErroDePreenchimentoInvalidoException;

public class medicamentoTopico extends Medicamento {

    private double pesoGramas;   
    private String tipoEmbalagem; 

    public medicamentoTopico() {
        super();
    }

    public double getpesoGramas() {
        return pesoGramas;
    }

    public void setpesoGramas(double pesoGramas) {
        
        if (pesoGramas <= 0) {
            throw new ErroDePreenchimentoInvalidoException("O peso em gramas deve ser maior que zero.");
        }
        this.pesoGramas = pesoGramas;
    }

    public String gettipoEmbalagem() {
        return tipoEmbalagem;
    }

    public void settipoEmbalagem(String tipoEmbalagem) {
        if (tipoEmbalagem == null || tipoEmbalagem.trim().isEmpty()) {
            throw new ErroDePreenchimentoInvalidoException("O tipo de embalagem é obrigatório.");
        }

        tipoEmbalagem = tipoEmbalagem.trim();

        if (!tipoEmbalagem.matches("\\S+")) {
            throw new ErroDePreenchimentoInvalidoException("O tipo de embalagem não pode conter espaços.");
        }

        this.tipoEmbalagem = tipoEmbalagem;
    }
    
    @Override
    public String toString() {
        return "MedicamentoTopico [SKU=" + getSku() + ", Peso=" + pesoGramas + "g, Embalagem=" + tipoEmbalagem + "]";
    }
}