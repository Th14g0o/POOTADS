package projetoFinal.logica.servicos;

import projetoFinal.logica.modelos.Elemento;
import projetoFinal.logica.persistencia.DAO.ElementoDAO;
import projetoFinal.logica.persistencia.DAO.FraquezaVantagemDAO;

public class ServicosElemento {
    private ElementoDAO daoElemento = new ElementoDAO();
    private FraquezaVantagemDAO daoFV = new FraquezaVantagemDAO();

    public void criar(Elemento obj){
        daoElemento.inserir(obj);
    }
    public void atualizar(Elemento obj){
        daoElemento.atualizar(obj);
    }
    public Elemento achar(Long id){
        Elemento obj = daoElemento.buscarPorId(id);
        return obj;
    }
    public void listar(Elemento obj){
        daoElemento.inserir(obj);
    }
    public void apagar(Long id){
        daoElemento.deletar(id);
    }

    public Elemento acharElemento(Long id){
        Elemento obj = daoElemento.buscarPorId(id);

        return obj;
    }
    public void listarElemento(Elemento obj){
        daoElemento.inserir(obj);
    }

}
