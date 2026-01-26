package projetoFinal.ui.telas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import projetoFinal.ui.componentes.BotaoTab;
import projetoFinal.ui.componentes.TabCadastros;
import projetoFinal.ui.telas.tabs.CadastroElemento;
import projetoFinal.ui.telas.tabs.CadastroVantagem;

public class CadastrosElemento extends TabCadastros  {
    public CadastrosElemento() {
        List<BotaoTab> bts = new ArrayList<>();
        bts.add(new BotaoTab("Elemento", "CADASTRO_ELEMENTO"));
        bts.add(new BotaoTab("Vantagem/Desvantagem", "CADASTRO_VANTAGEM_DESVANTAGEM"));
        setBotoes(bts);
        adicionarConteudo(new CadastroElemento(), "CADASTRO_ELEMENTO");
        adicionarConteudo(new CadastroVantagem(), "CADASTRO_VANTAGEM_DESVANTAGEM");
        iniciarTab();
    }
    
}
