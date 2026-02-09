package projetoFinal.logica.dto;

import java.util.List;
import projetoFinal.logica.modelos.Elemento;
import projetoFinal.logica.modelos.Pokemon;

public class PokemonElementosDTO {
    private Pokemon pokemon;
    private List<Elemento> elementos;

    public Pokemon getPokemon(){
        return this.pokemon;
    }
    public void setPokemon(Pokemon p){
        this.pokemon = p;
    }

    public List<Elemento> getElementos(){
        return this.elementos;
    }
    public void setElementos(List<Elemento> p){
        this.elementos = p;
    }
    
}
