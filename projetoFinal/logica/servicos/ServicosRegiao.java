package projetoFinal.logica.servicos;

import java.util.List;

import projetoFinal.logica.modelos.Regiao;
import projetoFinal.logica.persistencia.DAO.RegiaoDAO;

public class ServicosRegiao {
    private static RegiaoDAO daoRegiao = new RegiaoDAO();

    public static void criar(Regiao obj){
        daoRegiao.inserir(obj);
    }
    public static void atualizar(Regiao obj){
        daoRegiao.atualizar(obj);
    }
    public static Regiao achar(Long id){
        Regiao obj = daoRegiao.buscarPorId(id);
        return obj;
    }
    public static List<Regiao> listar(){
        return daoRegiao.listarTodos();
    }
    public static void apagar(Long id){
        daoRegiao.deletar(id);
    }
}
