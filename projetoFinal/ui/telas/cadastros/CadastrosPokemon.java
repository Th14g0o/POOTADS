package projetoFinal.ui.telas.cadastros;

import projetoFinal.ui.componentes.tab.BotaoTab;
import projetoFinal.ui.componentes.tab.TabPadrao;
import projetoFinal.ui.formularios.FormEvolucao;
import projetoFinal.ui.formularios.FormPokedex;
import projetoFinal.ui.formularios.FormPokemon;
import projetoFinal.ui.formularios.FormPokemonElemento;
import projetoFinal.ui.interfaces.AoClicar;
import projetoFinal.ui.interfaces.IRecarregarConteudo;

import java.util.ArrayList;
import java.util.List;

public class CadastrosPokemon extends TabPadrao implements IRecarregarConteudo {
    private FormPokemon cadastroPokemon = new FormPokemon();
    private FormPokemonElemento cadastroElemento = new FormPokemonElemento();
    private FormEvolucao cadastroEvolucao = new FormEvolucao();
    private FormPokedex cadastroPokedex = new FormPokedex();

    public void recarregarConteudos(){
        cadastroElemento.recarregarConteudos();
        cadastroEvolucao.recarregarConteudos();
        cadastroPokedex.recarregarConteudos();
    }

    public CadastrosPokemon() {
        List<BotaoTab> bts = new ArrayList<>();
        bts.add(new BotaoTab("Pokemon", "CADASTRO_POKEMON"));
        bts.add(
            new BotaoTab(
                "Elemento para Pokemon", "CADASTRO_ELEMENTO_POKEMON",
                new AoClicar() {public void acao() {cadastroElemento.recarregarConteudos();};}
            )
        );
        bts.add(
            new BotaoTab(
                "Evolução", "CADASTRO_EVOLUCAO",
                new AoClicar() {public void acao() {cadastroEvolucao.recarregarConteudos();};}
            )
        );
        bts.add(
            new BotaoTab(
                "Pokedex", "CADASTRO_POKEDEX",
                new AoClicar() {public void acao() {cadastroPokedex.recarregarConteudos();};}
            )
        );
        setBotoes(bts);
        adicionarConteudo(cadastroPokemon, "CADASTRO_POKEMON");
        adicionarConteudo(cadastroElemento, "CADASTRO_ELEMENTO_POKEMON");
        adicionarConteudo(cadastroEvolucao, "CADASTRO_EVOLUCAO");
        adicionarConteudo(cadastroPokedex, "CADASTRO_POKEDEX");
        iniciarTab();
    }
    
}
