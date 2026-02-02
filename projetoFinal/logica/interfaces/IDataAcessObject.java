package projetoFinal.logica.interfaces;

import java.util.List;

public interface IDataAcessObject<T> { 
    public T inserir(T o);
    public void atualizar(T o);
    public T buscarPorId(Long id);
    public List<T> listarTodos();
    public void deletar(Long id);
}
