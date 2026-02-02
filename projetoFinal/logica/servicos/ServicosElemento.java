package projetoFinal.logica.servicos;

import java.util.List;

import projetoFinal.logica.modelos.Elemento;
import projetoFinal.logica.modelos.FraquezaVantagem;
import projetoFinal.logica.persistencia.DAO.ElementoDAO;
import projetoFinal.logica.persistencia.DAO.FraquezaVantagemDAO;

public class ServicosElemento {
    private static ElementoDAO daoElemento = new ElementoDAO();
    private static FraquezaVantagemDAO daoFV = new FraquezaVantagemDAO();

    public static void criar(Elemento obj){
        daoElemento.inserir(obj);
    }
    public static void atualizar(Elemento obj){
        daoElemento.atualizar(obj);
    }
    public static Elemento achar(Long id){
        Elemento obj = daoElemento.buscarPorId(id);
        return obj;
    }
    public static List<Elemento> listar(){
        return daoElemento.listarTodos();
    }
    public static void apagar(Long id){
        daoElemento.deletar(id);
    }

    public static void criarFraquezaVantagem(FraquezaVantagem obj){
        daoFV.inserir(obj);
    }
    public static void atualizarFraquezaVantagem(FraquezaVantagem obj){
        daoFV.atualizar(obj);
    }
    public static FraquezaVantagem acharFraquezaVantagem(Long id){
        FraquezaVantagem obj = daoFV.buscarPorId(id);
        return obj;
    }
    public static List<FraquezaVantagem> listarFraquezaVantagem(){
        return daoFV.listarTodos();
    }
    public static void apagarFraquezaVantagem(Long id){
        daoFV.deletar(id);
    }

}
