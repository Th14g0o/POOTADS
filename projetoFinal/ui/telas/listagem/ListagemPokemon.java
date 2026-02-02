package projetoFinal.ui.telas.listagem;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import projetoFinal.logica.modelos.Pokedex;
import projetoFinal.ui.componentes.CardComum;
import projetoFinal.ui.componentes.botoes.BotaoIconeTexto;
import projetoFinal.ui.componentes.tab.BotaoTab;
import projetoFinal.ui.componentes.tab.Rolagem;
import projetoFinal.ui.componentes.tab.TabPadrao;
import projetoFinal.ui.util.Imagens;

import java.awt.*;

public class ListagemPokemon extends TabPadrao  {
    private JPanel conteudoPokemon = new JPanel();
    private JPanel conteudoPokemonElemento = new JPanel();
    private JPanel conteudoEvolucao = new JPanel();
    private JPanel conteudoPokedex = new JPanel();

    private int iconeAcoesLargura = 20;
    private int iconeAcoesAltura = 20;

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
        configurarConteudoPokemon();
        configurarConteudoPokemonElemento();
        configurarConteudoEvolucao();
        configurarConteudoPokedex();
    }

    private void configurarConteudoPokemon(){
        conteudoPokemon.setOpaque(false);
    }

    private void configurarConteudoPokemonElemento(){
        conteudoPokemonElemento.setOpaque(false);
    }

    private void configurarConteudoEvolucao(){
        conteudoEvolucao.setOpaque(false);
    }

    private void configurarConteudoPokedex(){
        conteudoPokedex.setOpaque(false);
        conteudoPokedex.setLayout(new BorderLayout());

        Rolagem rolagem = new Rolagem(true);
        
        for (int i = 0; i < 500; i++){
            Pokedex pokedex = new Pokedex();
            rolagem.conteudo.add(this.cardPokedex(pokedex));
        }

        conteudoPokedex.add(rolagem.rolagem, BorderLayout.CENTER);

    }

    private CardComum gerarCard(JPanel painel){
        CardComum pr = new CardComum();
        pr.setMargin(5, 5, 5, 5);
        pr.setRadiusCard(10);
        pr.addConteudo(painel);
        return pr;
    }

    private CardComum cardPokedex(Pokedex pokedex){
        JPanel painel = new JPanel();
        painel.setOpaque(false);

        CardComum pr = this.gerarCard(painel);

        pr.addBotaoAcao(new BotaoIconeTexto("", Imagens.iconeLapisVerde(iconeAcoesLargura, iconeAcoesAltura)));
        pr.addBotaoAcao(new BotaoIconeTexto("", Imagens.iconeLixeiraVermelha(iconeAcoesLargura, iconeAcoesAltura)));
    
        return pr;
    }
    
}
