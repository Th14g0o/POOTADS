package aulas_lucena.projetoFinal.modelos;
import aulas_lucena.projetoFinal.interfaces.*;

public class PokemonPokedex implements IPokemon{
    private PokemonPokedex anterior;
    private PokemonPokedex proximo;
    private int numero;
    private String descricao;
}