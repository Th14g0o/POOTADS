package projetoFinal.ui.telas.listagem.cards.abstracao;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import projetoFinal.ui.componentes.CardComum;
import projetoFinal.ui.componentes.botoes.BotaoIconeTexto;
import projetoFinal.ui.util.Imagens;

public abstract class CardListagemModelo<T> extends CardComum {
    protected JPanel conteudoCard = new JPanel();
    protected BotaoIconeTexto btEditar;
    protected BotaoIconeTexto btApagar;
    public T obj;
    protected int iconeAcoesLargura; 
    protected int iconeAcoesAltura;

    public CardListagemModelo(int iconeAcoesLargura, int iconeAcoesAltura){
        super();
        conteudoCard = new JPanel();
        this.setOpaque(false);
        setMargin(5, 5, 5, 5);
        setRadiusCard(10);
        addConteudo(conteudoCard);

        btEditar = new BotaoIconeTexto("", Imagens.iconeLapisVerde(iconeAcoesLargura, iconeAcoesAltura));
        btEditar.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        addBotaoAcao(btEditar);

        btApagar = new BotaoIconeTexto("", Imagens.iconeLixeiraVermelha(iconeAcoesLargura, iconeAcoesAltura));
        btApagar.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));
        addBotaoAcao(btApagar);

        btEditar.addActionListener(e -> {
            mostrarEdicao();  
        });

        btApagar.addActionListener(e -> {
            mostrarExclusão();  
        });

        conteudoCard.setOpaque(false);  
        this.iconeAcoesAltura = iconeAcoesAltura;
        this.iconeAcoesLargura = iconeAcoesLargura;
    }

    protected void limparConteudoCard(){
        conteudoCard.removeAll(); 
    }

    public abstract void mostrarExclusão();
    public abstract void mostrarEdicao();
    public abstract void apagar();
    public abstract void recarregarConteudo();
    protected abstract void setModelo(T obj);
    protected abstract void gerarConteudo(T obj);

}
