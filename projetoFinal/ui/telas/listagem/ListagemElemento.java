package projetoFinal.ui.telas.listagem;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import projetoFinal.logica.dto.ElementoFraquezaVantagemDTO;
import projetoFinal.logica.modelos.Elemento;
import projetoFinal.logica.servicos.ServicosElemento;
import projetoFinal.ui.componentes.tab.BotaoTab;
import projetoFinal.ui.componentes.tab.TabPadrao;
import projetoFinal.ui.interfaces.InstanciarGenerica;
import projetoFinal.ui.telas.listagem.cards.CardElemento;
import projetoFinal.ui.telas.listagem.cards.CardVantagem;
import projetoFinal.ui.util.Uteis;


public class ListagemElemento extends TabPadrao  {
    private JPanel conteudoElemento = new JPanel();
    private JPanel conteudoVantagem = new JPanel();
    private int iconeAcoesLargura = 20;
    private int iconeAcoesAltura = 20;

    private List<Elemento> elementos = new ArrayList<Elemento>();
    private List<ElementoFraquezaVantagemDTO> efvs = new ArrayList<ElementoFraquezaVantagemDTO>();

    public void recarregarListaElementoFraquezaVantagemDTO(){
        this.efvs = ServicosElemento.listarElementoFraquezaVantagemDTO();
        this.configurarConteudoVantagem();
    }

    public void recarregarListaElemento(){
        this.elementos = ServicosElemento.listar();
        this.configurarConteudoElemento();
    }

    public ListagemElemento() {
        List<BotaoTab> bts = new ArrayList<>();
        bts.add(new BotaoTab("Elemento", "CADASTRO_ELEMENTO"));
        bts.add(new BotaoTab("Vantagem/Desvantagem", "CADASTRO_VANTAGEM_DESVANTAGEM"));
        setBotoes(bts);
        this.configurarConteudoElemento();
        this.configurarConteudoVantagem();
        adicionarConteudo(conteudoElemento, "CADASTRO_ELEMENTO");
        adicionarConteudo(conteudoVantagem, "CADASTRO_VANTAGEM_DESVANTAGEM");
        iniciarTab();

        recarregarListaElemento();
        recarregarListaElementoFraquezaVantagemDTO();
    }

    private void configurarConteudoElemento(){
        Uteis.conteudoCardListagemComun(
            conteudoElemento, this.elementos, 
            new InstanciarGenerica<Elemento>() {
                public CardElemento novo(Elemento obj) {return new CardElemento(iconeAcoesLargura, iconeAcoesAltura, obj);}
            }
        );
    }

    private void configurarConteudoVantagem(){
        Uteis.conteudoCardListagemComun(
            conteudoVantagem, efvs, 
            new InstanciarGenerica<ElementoFraquezaVantagemDTO>() {
                public CardVantagem novo(ElementoFraquezaVantagemDTO obj) {return new CardVantagem(iconeAcoesLargura, iconeAcoesAltura, obj);}
            }
        );
    }
    
}
