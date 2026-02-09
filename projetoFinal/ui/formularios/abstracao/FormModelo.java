package projetoFinal.ui.formularios.abstracao;

import javax.swing.JPanel;

public abstract class FormModelo<T> extends JPanel{
    protected boolean ehCadastro = true;
    protected T obj;
    public abstract void setTipo(boolean ehCadastro);
    public abstract void setModelo(T elemento);
    public abstract void carregarForm(boolean ehCadastro, T el);
}
