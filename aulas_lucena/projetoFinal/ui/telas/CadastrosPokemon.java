package aulas_lucena.projetoFinal.ui.telas;

import aulas_lucena.projetoFinal.ui.componentes.BotaoTab;
import aulas_lucena.projetoFinal.ui.componentes.TabCadastros;
import aulas_lucena.projetoFinal.ui.telas.tabs.CadastroEvolucao;
import aulas_lucena.projetoFinal.ui.telas.tabs.CadastroPokedex;
import aulas_lucena.projetoFinal.ui.telas.tabs.CadastroPokemon;
import aulas_lucena.projetoFinal.ui.telas.tabs.CadastroPokemonElemento;
import java.util.ArrayList;
import java.util.List;

public class CadastrosPokemon extends TabCadastros  {
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
