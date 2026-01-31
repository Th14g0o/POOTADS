package projetoFinal.ui.telas.listagem;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import projetoFinal.ui.componentes.BarraRolagem;
import projetoFinal.ui.componentes.LayoutQuebravel;
import projetoFinal.ui.componentes.botoes.BotaoVermelho;
import projetoFinal.ui.componentes.tab.BotaoTab;
import projetoFinal.ui.componentes.tab.Rolagem;
import projetoFinal.ui.componentes.tab.TabPadrao;
import projetoFinal.ui.formularios.CadastroPokedex;
import projetoFinal.ui.util.Cores;

import java.awt.*;

public class ListagemPokemon extends TabPadrao  {
    private JPanel conteudoPokemon = new JPanel();
    private JPanel conteudoPokemonElemento = new JPanel();
    private JPanel conteudoEvolucao = new JPanel();
    private JPanel conteudoPokedex = new JPanel();

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
            BotaoVermelho bt = new BotaoVermelho("Teste");
            rolagem.conteudo.add(bt);
        }

        conteudoPokedex.add(rolagem.rolagem, BorderLayout.CENTER);

    }
    
}
