package projetoFinal.logica.servicos;

import projetoFinal.logica.modelos.Regiao;
import projetoFinal.logica.persistencia.DAO.RegiaoDAO;

public class ServicosRegiao {
    private RegiaoDAO daoRegiao = new RegiaoDAO();

    public void criar(Regiao obj){
        daoRegiao.inserir(obj);
    }
    public void atualizar(Regiao obj){
        daoRegiao.atualizar(obj);
    }
    public Regiao achar(Long id){
        Regiao obj = daoRegiao.buscarPorId(id);
        return obj;
    }
    public void listar(Regiao obj){
        daoRegiao.inserir(obj);
    }
    public void apagar(Long id){
        daoRegiao.deletar(id);
    }
}
