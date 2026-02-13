package projetoFinal.ui.interfaces;

import projetoFinal.ui.telas.listagem.cards.abstracao.CardListagemModelo;

public interface InstanciarGenerica<T> {
    CardListagemModelo<T> novo(T obj);
}
