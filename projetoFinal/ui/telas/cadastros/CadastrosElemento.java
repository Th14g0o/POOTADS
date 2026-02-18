package projetoFinal.ui.telas.cadastros;

import java.util.ArrayList;
import java.util.List;
import projetoFinal.ui.componentes.tab.BotaoTab;
import projetoFinal.ui.componentes.tab.TabPadrao;
import projetoFinal.ui.formularios.FormElemento;
import projetoFinal.ui.formularios.FormVantagem;
import projetoFinal.ui.interfaces.AoClicar;
import projetoFinal.ui.interfaces.IRecarregarConteudo;

public class CadastrosElemento extends TabPadrao implements IRecarregarConteudo {
    private FormVantagem cadVantagem = new FormVantagem();

    public void recarregarConteudos(){
        cadVantagem.recarregarConteudos();
    }

    public CadastrosElemento() {
        List<BotaoTab> bts = new ArrayList<>();
        bts.add(new BotaoTab("Elemento", "CADASTRO_ELEMENTO"));
        bts.add(
            new BotaoTab(
                "Vantagem/Desvantagem", "CADASTRO_VANTAGEM_DESVANTAGEM",
                new AoClicar() {public void acao() {cadVantagem.recarregarConteudos();}}
            )
        );
        setBotoes(bts);
        adicionarConteudo(new FormElemento(), "CADASTRO_ELEMENTO");
        adicionarConteudo(cadVantagem, "CADASTRO_VANTAGEM_DESVANTAGEM");
        iniciarTab();
    }
    
}
