package projetoFinal.logica.servicos;

import java.util.List;

import projetoFinal.logica.modelos.Jogo;
import projetoFinal.logica.persistencia.DAO.JogoDAO;

public class ServicosJogo {
    private static JogoDAO daoJogo = new JogoDAO();

    public static void criar(Jogo obj){
        daoJogo.inserir(obj);
    }
    public static void atualizar(Jogo obj){
        daoJogo.atualizar(obj);
    }
    public static Jogo achar(Long id){
        Jogo obj = daoJogo.buscarPorId(id);
        return obj;
    }
    public static List<Jogo> listar(){
        return daoJogo.listarTodos();
    }
    public static void apagar(Long id){
        daoJogo.deletar(id);
    }
    
}
