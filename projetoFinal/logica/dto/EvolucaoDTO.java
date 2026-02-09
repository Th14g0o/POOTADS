package projetoFinal.logica.dto;

import projetoFinal.logica.modelos.Evolucao;
import projetoFinal.logica.modelos.Pokemon;

public class EvolucaoDTO {
    private Pokemon pokemon;
    private Pokemon pokeEvolucao;
    private Evolucao evolucao;

    public void setEvolucao(Evolucao evolucao){
        this.evolucao = evolucao;
    }
    public Evolucao getEvolucao(){
        return evolucao;
    }

    public Pokemon getPokemon(){
        return this.pokemon;
    }
    public void setPokemon(Pokemon p){
        this.pokemon = p;
    }

    public Pokemon getPokeEvolucao(){
        return this.pokeEvolucao;
    }
    public void setPokeEvolucao(Pokemon pokeEvolucao){
        this.pokeEvolucao = pokeEvolucao;
    }
}
