package projetoFinal.ui.telas.cadastros;

import projetoFinal.ui.componentes.tab.BotaoTab;
import projetoFinal.ui.componentes.tab.TabPadrao;
import projetoFinal.ui.formularios.FormRegiao;
import projetoFinal.ui.interfaces.IRecarregarConteudo;
import java.util.ArrayList;
import java.util.List;

public class CadastrosRegiao extends TabPadrao implements IRecarregarConteudo {
    public void recarregarConteudos(){}
    public CadastrosRegiao() {
        List<BotaoTab> bts = new ArrayList<>();
        bts.add(new BotaoTab("Região", "CADASTRO_REGIAO"));
        setBotoes(bts);
        adicionarConteudo(new FormRegiao(), "CADASTRO_REGIAO");
        iniciarTab();
    } 
}
