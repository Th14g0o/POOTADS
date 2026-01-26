package aulas_lucena.projetoFinal.ui.telas;

import aulas_lucena.projetoFinal.ui.componentes.BotaoTab;
import aulas_lucena.projetoFinal.ui.componentes.TabCadastros;
import aulas_lucena.projetoFinal.ui.telas.tabs.CadastroJogo;
import java.util.List;
import java.util.ArrayList;

public class CadastrosJogo extends TabCadastros  {
    public CadastrosJogo() {
        List<BotaoTab> bts = new ArrayList<>();
        bts.add(new BotaoTab("Jogo", "CADASTRO_JOGO"));
        setBotoes(bts);
        adicionarConteudo(new CadastroJogo(), "CADASTRO_JOGO");
        iniciarTab();
    }
    
}
