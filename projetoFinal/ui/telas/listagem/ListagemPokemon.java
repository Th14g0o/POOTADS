package projetoFinal.ui.telas.listagem;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import projetoFinal.logica.dto.EvolucaoDTO;
import projetoFinal.logica.dto.PokedexDTO;
import projetoFinal.logica.dto.PokemonElementoDTO;
import projetoFinal.logica.modelos.Pokemon;
import projetoFinal.logica.servicos.ServicosPokemon;
import projetoFinal.logica.servicos.ServicosPokedex;
import projetoFinal.ui.componentes.tab.BotaoTab;
import projetoFinal.ui.componentes.tab.TabPadrao;
import projetoFinal.ui.interfaces.IRecarregarConteudo;
import projetoFinal.ui.interfaces.InstanciarGenerica;
import projetoFinal.ui.telas.listagem.cards.CardEvolucao;
import projetoFinal.ui.telas.listagem.cards.CardPokedex;
import projetoFinal.ui.telas.listagem.cards.CardPokemon;
import projetoFinal.ui.telas.listagem.cards.CardPokemonElemento;
import projetoFinal.ui.util.Uteis;

public class ListagemPokemon extends TabPadrao implements IRecarregarConteudo  {
    private JPanel conteudoPokemon = new JPanel();
    private JPanel conteudoPokemonElemento = new JPanel();
    private JPanel conteudoEvolucao = new JPanel();
    private JPanel conteudoPokedex = new JPanel();

    private int iconeAcoesLargura = 20;
    private int iconeAcoesAltura = 20;

    private List<Pokemon> pokemons = new ArrayList<Pokemon>();
    private List<EvolucaoDTO> evolucoes = new ArrayList<EvolucaoDTO>();
    private List<PokedexDTO> pokedexs = new ArrayList<PokedexDTO>();
    private List<PokemonElementoDTO> pes = new ArrayList<PokemonElementoDTO>();

    public void recarregarListaPokemon(){
        this.pokemons = ServicosPokemon.listar();
        this.configurarConteudoPokemon();
    }

    public void recarregarListaPokedex(){
        this.pokedexs = ServicosPokedex.listarPokedexDTO();
        this.configurarConteudoPokedex();
    }

    public void recarregarListaPE(){
        this.pes = ServicosPokemon.listarPokemonElementoDTO();
        this.configurarConteudoPokemonElemento();
    }

    public void recarregarListaEvolucao(){
        this.evolucoes = ServicosPokemon.listarEvolucaoDTO();
        this.configurarConteudoEvolucao();;
    }

    public void recarregarConteudos(){
        recarregarListaPokemon();
        recarregarListaEvolucao();
        recarregarListaPE();
        recarregarListaPokedex();
    }

    public ListagemPokemon() {
        List<BotaoTab> bts = new ArrayList<>();
        bts.add(new BotaoTab("Pokemon", "LISTA_POKEMON"));
        bts.add(new BotaoTab("Elemento para Pokemon", "LISTA_POKEMON_ELEMENTO"));
        bts.add(new BotaoTab("Evolução", "LISTA_EVOLUCAO"));
        bts.add(new BotaoTab("Pokedex", "LISTA_POKEDEX"));
        setBotoes(bts);
        adicionarConteudo(conteudoPokemon, "LISTA_POKEMON");
        adicionarConteudo(conteudoPokemonElemento, "LISTA_POKEMON_ELEMENTO");
        adicionarConteudo(conteudoEvolucao, "LISTA_EVOLUCAO");
        adicionarConteudo(conteudoPokedex, "LISTA_POKEDEX");
        iniciarTab();
        recarregarConteudos();
    }

    private void configurarConteudoPokemon(){
        Uteis.conteudoCardListagemComun(
            conteudoPokemon, pokemons, 
            new InstanciarGenerica<Pokemon>() {
                public CardPokemon novo(Pokemon obj) {return new CardPokemon(iconeAcoesLargura, iconeAcoesAltura, obj);}
            }
        );
    }

    private void configurarConteudoPokemonElemento(){
        conteudoPokemonElemento.setOpaque(false);
        Uteis.conteudoCardListagemComun(
            conteudoPokemonElemento, pes, 
            new InstanciarGenerica<PokemonElementoDTO>() {
                public CardPokemonElemento novo(PokemonElementoDTO obj) {return new CardPokemonElemento(iconeAcoesLargura, iconeAcoesAltura, obj);}
            }
        );
    }

    private void configurarConteudoEvolucao(){
        conteudoEvolucao.setOpaque(false);
        Uteis.conteudoCardListagemComun(
            conteudoEvolucao, evolucoes, 
            new InstanciarGenerica<EvolucaoDTO>() {
                public CardEvolucao novo(EvolucaoDTO obj) {return new CardEvolucao(iconeAcoesLargura, iconeAcoesAltura, obj);}
            }
        );
    }

    private void configurarConteudoPokedex(){
        conteudoPokedex.setOpaque(false);
        Uteis.conteudoCardListagemComun(
            conteudoPokedex, pokedexs, 
            new InstanciarGenerica<PokedexDTO>() {
                public CardPokedex novo(PokedexDTO obj) {return new CardPokedex(iconeAcoesLargura, iconeAcoesAltura, obj);}
            }
        );

    }
    
}
