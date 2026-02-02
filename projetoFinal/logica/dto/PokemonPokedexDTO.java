package projetoFinal.logica.dto;

import java.util.List;

import projetoFinal.logica.abstracoes.PokemonPokedex;


public class PokemonPokedexDTO extends PokemonPokedex {
    private List<ElementoDTO> elementos;
    private List<PokemonPokedexDTO> evolucoes;

    public void setElementos(List<ElementoDTO> elementos){
        this.elementos = elementos;
    }
    public void addElemento(ElementoDTO elemento){
        this.elementos.add(elemento);
    }
    public void addElemento(List<ElementoDTO> elementos){
        for (ElementoDTO e : elementos)
            this.addElemento(e);
    }
    public List<ElementoDTO> getElementos(){
        return this.elementos;
    }

    public void setEvolucoes(List<PokemonPokedexDTO> evolucoes){
        this.evolucoes = evolucoes;
    }
    public void addEvolucao(PokemonPokedexDTO evolucao){
        this.evolucoes.add(evolucao);
    }
    public void addEvolucao(List<PokemonPokedexDTO> evolucoes){
        for (PokemonPokedexDTO fv : evolucoes)
            this.addEvolucao(fv);
    }
    public List<PokemonPokedexDTO> getEvolucoes(){
        return this.evolucoes;
    }
}
