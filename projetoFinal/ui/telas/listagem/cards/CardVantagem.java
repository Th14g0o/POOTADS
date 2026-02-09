package projetoFinal.ui.telas.listagem.cards;

import javax.swing.*;
import java.awt.*;

import projetoFinal.logica.dto.ElementoFraquezaVantagemDTO;
import projetoFinal.ui.componentes.TagElementoArredondada;
import projetoFinal.ui.telas.listagem.cards.abstracao.CardListagemModelo;

public class CardVantagem extends CardListagemModelo<ElementoFraquezaVantagemDTO>{
    public CardVantagem(int iconeAcoesLargura, int iconeAcoesAltura, ElementoFraquezaVantagemDTO obj){
        super(iconeAcoesLargura, iconeAcoesAltura);
        setModelo(obj);
    }

    public void setModelo(ElementoFraquezaVantagemDTO obj){
        if (obj != null) gerarConteudo(obj);
    }

    protected void gerarConteudo(ElementoFraquezaVantagemDTO obj){
        TagElementoArredondada painelElementoAlvo =  new TagElementoArredondada(obj.elementoAlvo);
        conteudoCard.add(painelElementoAlvo);

        String texto = String.format(
            "É %.2f %s mais %s contra",
            obj.getMultiplicador(),
            obj.getMultiplicador() > 1 ? "vezes" : "vez",
            obj.getEhFraqueza() ? "fraco" : "forte"
        );
        JLabel label = new JLabel(texto);
        label.setFont(new Font(null, Font.BOLD, 14));
        label.setForeground(Color.WHITE);
        conteudoCard.add(label);

        TagElementoArredondada painelElementoFV =  new TagElementoArredondada(obj.elementoFV);
        conteudoCard.add(painelElementoFV);
    }
    
}
