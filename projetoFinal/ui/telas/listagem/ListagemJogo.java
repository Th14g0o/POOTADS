package projetoFinal.ui.telas.listagem;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import projetoFinal.logica.modelos.Jogo;
import projetoFinal.logica.servicos.ServicosJogo;
import projetoFinal.ui.componentes.tab.BotaoTab;
import projetoFinal.ui.componentes.tab.TabPadrao;
import projetoFinal.ui.interfaces.IRecarregarConteudo;
import projetoFinal.ui.interfaces.InstanciarGenerica;
import projetoFinal.ui.telas.listagem.cards.CardJogo;
import projetoFinal.ui.util.Uteis;

public class ListagemJogo extends TabPadrao implements IRecarregarConteudo  {
    private int iconeAcoesLargura = 20;
    private int iconeAcoesAltura = 20;

    private JPanel conteudoJogo = new JPanel();
    private List<Jogo> jogos = new ArrayList<Jogo>();
    public void recarregarListaJogos(){
        this.jogos = ServicosJogo.listar();
        this.configurarConteudoJogo();
    }

    public void recarregarConteudos(){
        recarregarListaJogos();
    }
    
    public ListagemJogo() {
        List<BotaoTab> bts = new ArrayList<>();
        bts.add(new BotaoTab("Jogo", "LISTA_JOGO"));
        setBotoes(bts);
        adicionarConteudo(conteudoJogo, "LISTA_JOGO");
        iniciarTab();
        recarregarListaJogos();
    }
    private void configurarConteudoJogo(){
        Uteis.conteudoCardListagemComun(
            conteudoJogo, jogos, 
            new InstanciarGenerica<Jogo>() {
                public CardJogo novo(Jogo obj) {return new CardJogo(iconeAcoesLargura, iconeAcoesAltura, obj);}
            }
        );
    }
    
}
