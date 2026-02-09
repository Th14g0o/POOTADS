package projetoFinal.ui.telas.listagem.cards.popup;

import java.awt.Color;

import javax.swing.JPanel;

import projetoFinal.ui.componentes.PopPup;
import projetoFinal.ui.componentes.botoes.BotaoVermelho;
import projetoFinal.ui.formularios.abstracao.FormModelo;
import projetoFinal.ui.interfaces.AoClicar;
import projetoFinal.ui.telas.listagem.cards.abstracao.CardListagemModelo;
import projetoFinal.ui.util.Cores;

public class PopPupEdicao<T> extends PopPup {
    public PopPupEdicao(String Titulo, CardListagemModelo<T> card, FormModelo<T> form){
        super(Titulo, card, form);
        form.carregarForm(false, card.obj);
        BotaoVermelho ok = new BotaoVermelho("Confirmar", Cores.VERDE, Color.WHITE);
        BotaoVermelho cancelar = new BotaoVermelho("Cancelar", Cores.VERMELHO, Color.WHITE);
        addBotao(
            ok, true, 
            new AoClicar() {
                public void acao() { card.recarregarConteudo(); }
            }
        );
        addBotao(
            cancelar, true,
            new AoClicar() {
                public void acao() { card.recarregarConteudo(); }
            }
        );
        mostrar(true);
    }
}
