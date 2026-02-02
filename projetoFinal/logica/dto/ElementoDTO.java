package projetoFinal.logica.dto;

import java.util.ArrayList;
import java.util.List;

import projetoFinal.logica.abstracoes.ElementoCompleto;

public class ElementoDTO extends ElementoCompleto {
    private List<FraquezaVantagemDTO> vantagensFraquezas = new ArrayList<FraquezaVantagemDTO>();

    public void setVantagensFraquezas(List<FraquezaVantagemDTO> vantagensFraquezas){
        this.vantagensFraquezas = vantagensFraquezas;
    }
    public void addVantagemFraqueza(FraquezaVantagemDTO vantagensFraqueza){
        this.vantagensFraquezas.add(vantagensFraqueza);
    }
    public void addVantagemFraqueza(List<FraquezaVantagemDTO> vantagensFraquezas){
        for (FraquezaVantagemDTO fv : vantagensFraquezas)
            this.addVantagemFraqueza(fv);
    }
    public List<FraquezaVantagemDTO> getVantagensFraquezas(){
        return this.vantagensFraquezas;
    }
}
