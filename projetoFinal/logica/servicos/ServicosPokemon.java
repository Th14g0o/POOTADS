package projetoFinal.logica.servicos;

import java.util.List;

import projetoFinal.logica.modelos.Pokemon;
import projetoFinal.logica.persistencia.DAO.EvolucaoDAO;
import projetoFinal.logica.persistencia.DAO.PokemonDAO;
import projetoFinal.logica.persistencia.DAO.PokemonElementoDAO;

public class ServicosPokemon {
    private static PokemonDAO daoPokemon = new PokemonDAO();
    private static EvolucaoDAO daoEvolucao = new EvolucaoDAO();
    private static PokemonElementoDAO daoPE = new PokemonElementoDAO();

    public static void criar(Pokemon obj){
        daoPokemon.inserir(obj);
    }
    public static void atualizar(Pokemon obj){
        daoPokemon.atualizar(obj);
    }
    public static Pokemon achar(Long id){
        Pokemon obj = daoPokemon.buscarPorId(id);
        return obj;
    }
    public static List<Pokemon> listar(){
        return daoPokemon.listarTodos();
    }
    public static void apagar(Long id){
        daoPokemon.deletar(id);
    }

    public static void adicionarElemento(Pokemon obj){
        daoPokemon.inserir(obj);
    }
    public static void atualizarElemento(Pokemon obj){
        daoPokemon.atualizar(obj);
    }
    public static Pokemon acharElemento(Long id){
        Pokemon obj = daoPokemon.buscarPorId(id);
        return obj;
    }
    public static List<Pokemon> listarElemento(){
        return daoPokemon.listarTodos();
    }
    public static void apagarElemento(Long id){
        daoPokemon.deletar(id);
    }

    public static void adicionarEvolucao(Pokemon obj){
        daoPokemon.inserir(obj);
    }
    public static void atualizarEvolucao(Pokemon obj){
        daoPokemon.atualizar(obj);
    }
    public static Pokemon acharEvolucao(Long id){
        Pokemon obj = daoPokemon.buscarPorId(id);
        return obj;
    }
    public static List<Pokemon> listarEvolucao(){
        return daoPokemon.listarTodos();
    }
    public static void apagarEvolucao(Long id){
        daoPokemon.deletar(id);
    }
}
