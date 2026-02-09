package projetoFinal.logica.dto;

import projetoFinal.logica.abstracoes.ElementoCompleto;

public class FraquezaVantagemDTO extends ElementoCompleto  {
    private Long idFraquezaVantagem;
    private boolean ehFraqueza;
    private double multiplicador;

    public void setEhFraqueza(boolean ehFraqueza){
        this.ehFraqueza = ehFraqueza;
    }
    public boolean getEhFraqueza(){
        return this.ehFraqueza;
    }
    public void setMultiplicador(double multiplicador){
        this.multiplicador = multiplicador;
    }
    public double getMultiplicador(){
        return this.multiplicador;
    }
    public void setIdFraquezaVantagem(Long idFraquezaVantagem){
        this.idFraquezaVantagem = idFraquezaVantagem;
    }
    public Long getIdFraquezaVantagem(){
        return this.idFraquezaVantagem;
    }
}
