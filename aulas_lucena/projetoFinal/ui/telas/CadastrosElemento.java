package aulas_lucena.projetoFinal.ui.telas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import aulas_lucena.projetoFinal.ui.componentes.BotaoTab;
import aulas_lucena.projetoFinal.ui.componentes.TabCadastros;
import aulas_lucena.projetoFinal.ui.telas.tabs.CadastroElemento;
import aulas_lucena.projetoFinal.ui.telas.tabs.CadastroVantagem;

public class CadastrosElemento extends TabCadastros  {
    public CadastrosElemento() {
        List<BotaoTab> bts = new ArrayList<>();
        bts.add(new BotaoTab("Elemento", "CADASTRO_ELEMENTO"));
        bts.add(new BotaoTab("Vantagem/Desvantagem", "CADASTRO_VANTAGEM_DESVANTAGEM"));
        super(bts);
        adicionarConteudo(new CadastroElemento(), "CADASTRO_ELEMENTO");
        adicionarConteudo(new CadastroVantagem(), "CADASTRO_VANTAGEM_DESVANTAGEM");
        iniciarTab();
    }
    
}
