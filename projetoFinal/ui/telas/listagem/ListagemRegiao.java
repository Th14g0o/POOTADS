package projetoFinal.ui.telas.listagem;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import projetoFinal.ui.componentes.tab.BotaoTab;
import projetoFinal.ui.componentes.tab.TabPadrao;
import java.awt.*;

public class ListagemRegiao extends TabPadrao  {
    private JPanel conteudoRegiao = new JPanel();
    public ListagemRegiao() {
        List<BotaoTab> bts = new ArrayList<>();
        bts.add(new BotaoTab("Região", "LISTA_REGIAO"));
        setBotoes(bts);
        this.configurarConteudoRegiao();
        adicionarConteudo(conteudoRegiao, "LISTA_REGIAO");
        iniciarTab();
    }
    private void configurarConteudoRegiao(){
        conteudoRegiao.setOpaque(false);
    }
    
}
