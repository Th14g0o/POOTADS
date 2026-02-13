package projetoFinal.ui.telas.listagem.cards.popup;

import java.awt.Color;
import projetoFinal.ui.componentes.PopPup;
import projetoFinal.ui.componentes.botoes.BotaoVermelho;
import projetoFinal.ui.formularios.abstracao.FormModelo;
import projetoFinal.ui.interfaces.AoClicar;
import projetoFinal.ui.telas.listagem.cards.abstracao.CardListagemModelo;
import projetoFinal.ui.util.Cores;

public class PopPupEdicao<T> extends PopPup {
    public PopPupEdicao(String Titulo, CardListagemModelo<T> card, FormModelo<T> form){
        super(Titulo, card, form);
        BotaoVermelho ok = new BotaoVermelho("Confirmar", Cores.VERDE, Color.WHITE);
        BotaoVermelho cancelar = new BotaoVermelho("Cancelar", Cores.VERMELHO, Color.WHITE);
        form.setVisibilidadeBtSalvar(false);
        addBotao(
            ok, false, 
            new AoClicar() {
                public void acao() { 
                    boolean resposta = form.salvar(); 
                    if (resposta == true)
                    {
                        card.recarregarConteudo();
                        dispose(); 
                    }
                }
            }
        );
        addBotao(
            cancelar, true,
            new AoClicar() {
                public void acao() {  }
            }
        );
    }

    public void setVisibilidade(boolean mostra){
        mostrar(mostra);
    }
}
