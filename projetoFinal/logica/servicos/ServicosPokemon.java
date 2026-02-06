package projetoFinal.logica.servicos;

import java.util.List;

import projetoFinal.logica.modelos.Evolucao;
import projetoFinal.logica.modelos.Pokemon;
import projetoFinal.logica.modelos.PokemonElemento;
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

    public static void adicionarElemento(PokemonElemento obj){
        daoPE.inserir(obj);
    }
    public static void atualizarElemento(PokemonElemento obj){
        daoPE.atualizar(obj);
    }
    public static PokemonElemento acharElemento(Long id){
        PokemonElemento obj = daoPE.buscarPorId(id);
        return obj;
    }
    public static List<PokemonElemento> listarElemento(){
        return daoPE.listarTodos();
    }
    public static void apagarElemento(Long id){
        daoPokemon.deletar(id);
    }

    public static void adicionarEvolucao(Evolucao obj){
        daoEvolucao.inserir(obj);
    }
    public static void atualizarEvolucao(Evolucao obj){
        daoEvolucao.atualizar(obj);
    }
    public static Evolucao acharEvolucao(Long id){
        Evolucao obj = daoEvolucao.buscarPorId(id);
        return obj;
    }
    public static List<Evolucao> listarEvolucao(){
        return daoEvolucao.listarTodos();
    }
    public static void apagarEvolucao(Long id){
        daoEvolucao.deletar(id);
    }
}
