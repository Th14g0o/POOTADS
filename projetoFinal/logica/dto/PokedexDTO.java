package projetoFinal.logica.dto;

import projetoFinal.logica.modelos.Jogo;
import projetoFinal.logica.modelos.Pokedex;
import projetoFinal.logica.modelos.Regiao;

public class PokedexDTO {
    private Pokedex px;
    private PokemonElementosDTO pokemon;
    private Jogo jogo;
    private Regiao regiao;
    private PokemonElementosDTO ante;
    private PokemonElementosDTO prox;

    public Pokedex getPokedex(){
        return this.px;
    }
    public void setPokedex(Pokedex px){
        this.px = px;
    }

    public PokemonElementosDTO getPokemon(){
        return this.pokemon;
    }
    public void setPokemon(PokemonElementosDTO p){
        this.pokemon = p;
    }

    public PokemonElementosDTO getAnte(){
        return this.ante;
    }
    public void setAnte(PokemonElementosDTO p){
        this.ante = p;
    }

    public PokemonElementosDTO getProx(){
        return this.prox;
    }
    public void setProx(PokemonElementosDTO e){
        this.prox = e;
    }

    public Jogo getJogo(){
        return this.jogo;
    }
    public void setJogo(Jogo p){
        this.jogo = p;
    }

    public Regiao getRegiao(){
        return this.regiao;
    }
    public void setRegiao(Regiao e ){
        this.regiao = e;
    }
}
