package projetoFinal.ui.formularios.abstracao;

import javax.swing.JPanel;

import projetoFinal.ui.componentes.botoes.BotaoSalvar;

public abstract class FormModelo<T> extends JPanel{
    protected boolean ehCadastro = true;
    protected T obj;
    public BotaoSalvar btSalvar = new BotaoSalvar();

    public void setTipo(boolean ehCadastro){
        this.ehCadastro = ehCadastro;
    }

    public void setModelo(T elemento){
        this.obj = elemento;
    }

    public void setVisibilidadeBtSalvar(boolean ehVisivel){
        btSalvar.setVisible(ehVisivel);
    }

    public abstract void carregarForm(boolean ehCadastro, T el);

    public abstract boolean salvar();
}
