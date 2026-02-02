package projetoFinal.logica.modelos;

public class FraquezaVantagem {
    private Long id;
    private Long idElementoAlvo;
    private Long idElementoFraquezaVantagem;
    private boolean ehFraqueza;
    private double multiplicador;
    private Long idJogo;

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return this.id;
    }

    public void setIdElementoAlvo(Long idElementoAlvo){
        this.idElementoAlvo = idElementoAlvo;
    }
    public Long getIdElementoAlvo(){
        return this.idElementoAlvo;
    }

    public void setIdElementoFraquezaVantagem(Long idElementoFraquezaVantagem){
        this.idElementoFraquezaVantagem = idElementoFraquezaVantagem;
    }
    public Long getIdElementoFraquezaVantagem(){
        return this.idElementoFraquezaVantagem;
    }

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

    public void setIdJogo(Long idJogo){
        this.idJogo = idJogo;
    }
    public Long getIdJogo(){
        return this.idJogo;
    }
}
