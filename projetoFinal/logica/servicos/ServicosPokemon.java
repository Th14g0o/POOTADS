package projetoFinal.logica.servicos;

import projetoFinal.logica.modelos.Pokemon;
import projetoFinal.logica.persistencia.DAO.PokemonDAO;

public class ServicosPokemon {
    private PokemonDAO daoPokemon = new PokemonDAO();

    public void criar(Pokemon obj){
        daoPokemon.inserir(obj);
    }
    public void atualizar(Pokemon obj){
        daoPokemon.atualizar(obj);
    }
    public Pokemon achar(Long id){
        Pokemon obj = daoPokemon.buscarPorId(id);
        return obj;
    }
    public void listar(Pokemon obj){
        daoPokemon.inserir(obj);
    }
    public void apagar(Long id){
        daoPokemon.deletar(id);
    }
}
