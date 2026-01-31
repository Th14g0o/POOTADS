package projetoFinal.ui.telas.cadastros;

import projetoFinal.ui.componentes.tab.BotaoTab;
import projetoFinal.ui.componentes.tab.TabPadrao;
import projetoFinal.ui.formularios.CadastroJogo;
import java.util.List;
import java.util.ArrayList;

public class CadastrosJogo extends TabPadrao  {
    public CadastrosJogo() {
        List<BotaoTab> bts = new ArrayList<>();
        bts.add(new BotaoTab("Jogo", "CADASTRO_JOGO"));
        setBotoes(bts);
        adicionarConteudo(new CadastroJogo(), "CADASTRO_JOGO");
        iniciarTab();
    }
    
}
