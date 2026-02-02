package projetoFinal.ui.telas.listagem;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import projetoFinal.ui.componentes.tab.BotaoTab;
import projetoFinal.ui.componentes.tab.TabPadrao;
import java.awt.*;

public class ListagemJogo extends TabPadrao  {
    private JPanel conteudoJogo = new JPanel();
    public ListagemJogo() {
        List<BotaoTab> bts = new ArrayList<>();
        bts.add(new BotaoTab("Jogo", "LISTA_JOGO"));
        setBotoes(bts);
        this.configurarConteudoJogo();
        adicionarConteudo(conteudoJogo, "LISTA_JOGO");
        iniciarTab();
    }
    private void configurarConteudoJogo(){
        conteudoJogo.setOpaque(false);
    }
    
}
