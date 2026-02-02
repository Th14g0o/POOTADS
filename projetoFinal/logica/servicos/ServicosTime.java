package projetoFinal.logica.servicos;

import java.util.List;

import projetoFinal.logica.modelos.Time;
import projetoFinal.logica.modelos.TimePokemon;
import projetoFinal.logica.persistencia.DAO.TimeDAO;
import projetoFinal.logica.persistencia.DAO.TimePokemonDAO;

public class ServicosTime {
    private static TimeDAO daoTime = new TimeDAO();
    private static TimePokemonDAO daoTimePokemon = new TimePokemonDAO();

    public static void criar(Time obj){
        daoTime.inserir(obj);
    }
    public static void atualizar(Time obj){
        daoTime.atualizar(obj);
    }
    public static Time achar(Long id){
        Time obj = daoTime.buscarPorId(id);
        return obj;
    }
    public static List<Time> listar(){
        return daoTime.listarTodos();
    }
    public static void apagar(Long id){
        daoTime.deletar(id);
    }

    public static void adicionarPokemon(TimePokemon obj){
        if (daoTimePokemon.listarPokemons(obj.getIdTime()).size() < 6)
            daoTimePokemon.inserir(obj);
    }
    public static void substituir(long idAntigo, TimePokemon obj){
        daoTimePokemon.deletar(idAntigo);
        adicionarPokemon(obj);
    }
    public static List<TimePokemon> listarPokemons(long idTime){
        List<TimePokemon> objs = daoTimePokemon.listarPokemons(idTime);
        return objs;
    }
}
