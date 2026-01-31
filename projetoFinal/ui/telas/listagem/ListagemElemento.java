package projetoFinal.ui.telas.listagem;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import projetoFinal.ui.componentes.tab.BotaoTab;
import projetoFinal.ui.componentes.tab.TabPadrao;
import java.awt.*;

public class ListagemElemento extends TabPadrao  {
    private JPanel conteudoElemento = new JPanel();
    private JPanel conteudoVantagem = new JPanel();

    public ListagemElemento() {
        List<BotaoTab> bts = new ArrayList<>();
        bts.add(new BotaoTab("Elemento", "CADASTRO_ELEMENTO"));
        bts.add(new BotaoTab("Vantagem/Desvantagem", "CADASTRO_VANTAGEM_DESVANTAGEM"));
        setBotoes(bts);
        this.configurarConteudoElemento();
        this.configurarConteudoVantagem();
        adicionarConteudo(conteudoElemento, "CADASTRO_ELEMENTO");
        adicionarConteudo(conteudoVantagem, "CADASTRO_VANTAGEM_DESVANTAGEM");
        iniciarTab();
    }

    private void configurarConteudoElemento(){
        conteudoElemento.setOpaque(false);
    }

    private void configurarConteudoVantagem(){
        conteudoVantagem.setOpaque(false);
    }
    
}
