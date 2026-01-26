package aulas_lucena.projetoFinal.ui.telas;

import aulas_lucena.projetoFinal.ui.componentes.BotaoTab;
import aulas_lucena.projetoFinal.ui.componentes.TabCadastros;
import aulas_lucena.projetoFinal.ui.telas.tabs.CadastroRegiao;
import java.util.ArrayList;
import java.util.List;

public class CadastrosRegiao extends TabCadastros  {
    public CadastrosRegiao() {
        List<BotaoTab> bts = new ArrayList<>();
        bts.add(new BotaoTab("Região", "CADASTRO_REGIAO"));
        setBotoes(bts);
        adicionarConteudo(new CadastroRegiao(), "CADASTRO_REGIAO");
        iniciarTab();
    } 
}
