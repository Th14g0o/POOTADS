package projetoFinal.logica.dto;

import projetoFinal.logica.modelos.Elemento;
import projetoFinal.logica.modelos.FraquezaVantagem;

public class ElementoFraquezaVantagemDTO extends FraquezaVantagem {
    public Elemento elementoAlvo;
    public Elemento elementoFV;
    
    public void setFraquezaVantagem(FraquezaVantagem fv){
        setId(fv.getId());
        setIdElementoAlvo(fv.getIdElementoAlvo());
        setIdElementoFraquezaVantagem(fv.getIdElementoFraquezaVantagem());
        setEhFraqueza(fv.getEhFraqueza());
        setMultiplicador(fv.getMultiplicador());
        setIdJogo(fv.getIdJogo());

    }

    public FraquezaVantagem getFraquezaVantagem(){
        FraquezaVantagem fv = new FraquezaVantagem();
        fv.setId(getId());
        fv.setIdElementoAlvo(getIdElementoAlvo());
        fv.setIdElementoFraquezaVantagem(getIdElementoFraquezaVantagem());
        fv.setEhFraqueza(getEhFraqueza());
        fv.setMultiplicador(getMultiplicador());
        fv.setIdJogo(getIdJogo());
        return fv;

    }
}
