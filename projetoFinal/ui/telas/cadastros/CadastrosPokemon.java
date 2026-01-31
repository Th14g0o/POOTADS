package projetoFinal.ui.telas.cadastros;

import projetoFinal.ui.componentes.tab.BotaoTab;
import projetoFinal.ui.componentes.tab.TabPadrao;
import projetoFinal.ui.formularios.CadastroEvolucao;
import projetoFinal.ui.formularios.CadastroPokedex;
import projetoFinal.ui.formularios.CadastroPokemon;
import projetoFinal.ui.formularios.CadastroPokemonElemento;
import java.util.ArrayList;
import java.util.List;

public class CadastrosPokemon extends TabPadrao  {
    public CadastrosPokemon() {
        List<BotaoTab> bts = new ArrayList<>();
        bts.add(new BotaoTab("Pokemon", "CADASTRO_POKEMON"));
        bts.add(new BotaoTab("Elemento para Pokemon", "CADASTRO_ELEMENTO_POKEMON"));
        bts.add(new BotaoTab("Evolução", "CADASTRO_EVOLUCAO"));
        bts.add(new BotaoTab("Pokedex", "CADASTRO_POKEDEX"));
        setBotoes(bts);
        adicionarConteudo(new CadastroPokemon(), "CADASTRO_POKEMON");
        adicionarConteudo(new CadastroPokemonElemento(), "CADASTRO_ELEMENTO_POKEMON");
        adicionarConteudo(new CadastroEvolucao(), "CADASTRO_EVOLUCAO");
        adicionarConteudo(new CadastroPokedex(), "CADASTRO_POKEDEX");
        iniciarTab();
    }
    
}
