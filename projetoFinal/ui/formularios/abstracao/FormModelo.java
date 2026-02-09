package projetoFinal.ui.formularios.abstracao;

import javax.swing.JPanel;

public abstract class FormModelo<T> extends JPanel{
    protected boolean ehCadastro = true;
    protected T obj;

    // Default implementations so older forms that don't override them still work.
    public void setTipo(boolean ehCadastro){
        this.ehCadastro = ehCadastro;
    }

    public void setModelo(T elemento){
        this.obj = elemento;
    }

    public abstract void carregarForm(boolean ehCadastro, T el);
}
