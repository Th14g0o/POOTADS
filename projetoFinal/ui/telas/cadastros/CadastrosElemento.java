package projetoFinal.ui.telas.cadastros;

import java.util.ArrayList;
import java.util.List;
import projetoFinal.ui.componentes.tab.BotaoTab;
import projetoFinal.ui.componentes.tab.TabPadrao;
import projetoFinal.ui.formularios.CadastroElemento;
import projetoFinal.ui.formularios.CadastroVantagem;
import projetoFinal.ui.interfaces.AoClicar;

public class CadastrosElemento extends TabPadrao  {
    private CadastroVantagem cadVantagem = new CadastroVantagem();
    public CadastrosElemento() {
        List<BotaoTab> bts = new ArrayList<>();
        bts.add(new BotaoTab("Elemento", "CADASTRO_ELEMENTO"));
        bts.add(
            new BotaoTab(
                "Vantagem/Desvantagem", "CADASTRO_VANTAGEM_DESVANTAGEM",
                new AoClicar() {public void acao() {cadVantagem.recarregarListas();}}
            )
        );
        setBotoes(bts);
        adicionarConteudo(new CadastroElemento(), "CADASTRO_ELEMENTO");
        adicionarConteudo(new CadastroVantagem(), "CADASTRO_VANTAGEM_DESVANTAGEM");
        iniciarTab();
    }
    
}
