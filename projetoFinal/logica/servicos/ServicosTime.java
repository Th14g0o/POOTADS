package projetoFinal.logica.servicos;

import java.util.List;

import projetoFinal.logica.modelos.Time;
import projetoFinal.logica.modelos.TimePokemon;
import projetoFinal.logica.persistencia.DAO.TimeDAO;
import projetoFinal.logica.persistencia.DAO.TimePokemonDAO;

public class ServicosTime {
    private TimeDAO daoTime = new TimeDAO();
    private TimePokemonDAO daoTimePokemon = new TimePokemonDAO();

    public void criar(Time obj){
        daoTime.inserir(obj);
    }
    public void atualizar(Time obj){
        daoTime.atualizar(obj);
    }
    public Time achar(Long id){
        Time obj = daoTime.buscarPorId(id);
        return obj;
    }
    public void listar(Time obj){
        daoTime.inserir(obj);
    }
    public void apagar(Long id){
        daoTime.deletar(id);
    }

    public void adicionarPokemon(TimePokemon obj){
        if (daoTimePokemon.listarPokemons(obj.getIdTime()).size() < 6)
            daoTimePokemon.inserir(obj);
    }
    public void substituir(long idAntigo, TimePokemon obj){
        daoTimePokemon.deletar(idAntigo);
        this.adicionarPokemon(obj);
    }
    public List<TimePokemon> listarPokemons(long idTime){
        List<TimePokemon> objs = daoTimePokemon.listarPokemons(idTime);
        return objs;
    }
}
