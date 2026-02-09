package projetoFinal.ui.telas.listagem;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import projetoFinal.logica.modelos.Regiao;
import projetoFinal.logica.servicos.ServicosRegiao;
import projetoFinal.ui.componentes.tab.BotaoTab;
import projetoFinal.ui.componentes.tab.TabPadrao;
import projetoFinal.ui.interfaces.InstanciarGenerica;
import projetoFinal.ui.telas.listagem.cards.CardRegiao;
import projetoFinal.ui.util.Uteis;

public class ListagemRegiao extends TabPadrao  {
    private int iconeAcoesLargura = 20;
    private int iconeAcoesAltura = 20;

    private JPanel conteudoRegiao = new JPanel();
    private List<Regiao> regioes = new ArrayList<Regiao>();
    public void recarregarListaJogos(){
        this.regioes = ServicosRegiao.listar();
        this.configurarConteudoRegiao();
    }

    public ListagemRegiao() {
        List<BotaoTab> bts = new ArrayList<>();
        bts.add(new BotaoTab("Região", "LISTA_REGIAO"));
        setBotoes(bts);
        this.configurarConteudoRegiao();
        adicionarConteudo(conteudoRegiao, "LISTA_REGIAO");
        iniciarTab();
        recarregarListaJogos();
    }
    private void configurarConteudoRegiao(){
        Uteis.conteudoCardListagemComun(
            conteudoRegiao, regioes, 
            new InstanciarGenerica<Regiao>() {
                public CardRegiao novo(Regiao obj) {return new CardRegiao(iconeAcoesLargura, iconeAcoesAltura, obj);}
            }
        );
    }
    
}
