package projetoFinal.logica.dto;

import projetoFinal.logica.modelos.Elemento;
import projetoFinal.logica.modelos.Jogo;
import projetoFinal.logica.modelos.Pokemon;
import projetoFinal.logica.modelos.PokemonElemento;

public class PokemonElementoDTO {
    private Pokemon pokemon;
    private Elemento elemento;
    private Jogo jogo;
    private PokemonElemento pe;

    public void setJogo(Jogo jogo){
        this.jogo = jogo;
    }
    public Jogo getJogo(){
        return jogo;
    }

    public void setPokemonElemento(PokemonElemento pe){
        this.pe = pe;
    }
    public PokemonElemento getPokemonElemento(){
        return pe;
    }

    public Pokemon getPokemon(){
        return this.pokemon;
    }
    public void setPokemon(Pokemon p){
        this.pokemon = p;
    }

    public Elemento getElemento(){
        return this.elemento;
    }
    public void setElemento(Elemento e ){
        this.elemento = e;
    }
}
