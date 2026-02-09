package projetoFinal.ui.telas.cadastros;

import projetoFinal.ui.componentes.tab.BotaoTab;
import projetoFinal.ui.componentes.tab.TabPadrao;
import projetoFinal.ui.formularios.CadastroEvolucao;
import projetoFinal.ui.formularios.CadastroPokedex;
import projetoFinal.ui.formularios.CadastroPokemon;
import projetoFinal.ui.formularios.CadastroPokemonElemento;
import projetoFinal.ui.interfaces.AoClicar;

import java.util.ArrayList;
import java.util.List;

public class CadastrosPokemon extends TabPadrao {
    private CadastroPokemon cadastroPokemon = new CadastroPokemon();
    private CadastroPokemonElemento cadastroElemento = new CadastroPokemonElemento();
    private CadastroEvolucao cadastroEvolucao = new CadastroEvolucao();
    private CadastroPokedex cadastroPokedex = new CadastroPokedex();
    public CadastrosPokemon() {
        List<BotaoTab> bts = new ArrayList<>();
        bts.add(new BotaoTab("Pokemon", "CADASTRO_POKEMON"));
        bts.add(
            new BotaoTab(
                "Elemento para Pokemon", "CADASTRO_ELEMENTO_POKEMON",
                new AoClicar() {public void acao() {cadastroElemento.recarregarListas();};}
            )
        );
        bts.add(
            new BotaoTab(
                "Evolução", "CADASTRO_EVOLUCAO",
                new AoClicar() {public void acao() {cadastroEvolucao.recarregarListas();};}
            )
        );
        bts.add(
            new BotaoTab(
                "Pokedex", "CADASTRO_POKEDEX",
                new AoClicar() {public void acao() {cadastroPokedex.recarregarListas();};}
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
