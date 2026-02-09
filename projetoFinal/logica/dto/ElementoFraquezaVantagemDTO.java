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
}
