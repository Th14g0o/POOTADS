package projetoFinal.ui.telas.cadastros;

import projetoFinal.ui.componentes.tab.BotaoTab;
import projetoFinal.ui.componentes.tab.TabPadrao;
import projetoFinal.ui.formularios.FormJogo;
import projetoFinal.ui.interfaces.IRecarregarConteudo;

import java.util.List;
import java.util.ArrayList;

public class CadastrosJogo extends TabPadrao implements IRecarregarConteudo {
    public void recarregarConteudos(){}
    public CadastrosJogo() {
        List<BotaoTab> bts = new ArrayList<>();
        bts.add(new BotaoTab("Jogo", "CADASTRO_JOGO"));
        setBotoes(bts);
        adicionarConteudo(new FormJogo(), "CADASTRO_JOGO");
        iniciarTab();
    }
    
}
