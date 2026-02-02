package projetoFinal.logica.servicos;

import projetoFinal.logica.modelos.Jogo;
import projetoFinal.logica.persistencia.DAO.JogoDAO;

public class ServicosJogo {
    private JogoDAO daoJogo = new JogoDAO();

    public void criar(Jogo obj){
        daoJogo.inserir(obj);
    }
    public void atualizar(Jogo obj){
        daoJogo.atualizar(obj);
    }
    public Jogo achar(Long id){
        Jogo obj = daoJogo.buscarPorId(id);
        return obj;
    }
    public void listar(Jogo obj){
        daoJogo.inserir(obj);
    }
    public void apagar(Long id){
        daoJogo.deletar(id);
    }
    
}
