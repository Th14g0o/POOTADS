package projetoFinal.ui.telas.listagem.cards;

import javax.swing.*;
import java.awt.*;

import projetoFinal.logica.dto.ElementoFraquezaVantagemDTO;
import projetoFinal.logica.modelos.Elemento;
import projetoFinal.logica.modelos.FraquezaVantagem;
import projetoFinal.logica.servicos.ServicosElemento;
import projetoFinal.ui.componentes.TagElementoArredondada;
import projetoFinal.ui.formularios.CadastroVantagem;
import projetoFinal.ui.telas.listagem.cards.abstracao.CardListagemModelo;
import projetoFinal.ui.telas.listagem.cards.popup.PopPupEdicao;
import projetoFinal.ui.telas.listagem.cards.popup.PopPupExclusao;

public class CardVantagem extends CardListagemModelo<ElementoFraquezaVantagemDTO>{
    public CardVantagem(int iconeAcoesLargura, int iconeAcoesAltura, ElementoFraquezaVantagemDTO obj){
        super(iconeAcoesLargura, iconeAcoesAltura);
        setModelo(obj);
    }

    public void mostrarExclusão(){
        String nome = "a vantagem/desvantagem";
        if (obj != null){
            if (obj.elementoAlvo != null) nome = obj.elementoAlvo.getNome();
        }
        PopPupExclusao ppe = new PopPupExclusao("Excluir Vantagem/Desvantagem", this, nome);
        ppe.mostrar(true);
    }

    public void mostrarEdicao(){
        CadastroVantagem form = new CadastroVantagem(false, this.obj.getFraquezaVantagem());
        PopPupEdicao<ElementoFraquezaVantagemDTO> ppe = new PopPupEdicao("Editar Vantagem/Desvantagem", this, form);
        ppe.mostrar(true);
    }

    public void apagar(){
        if (this.obj != null) ServicosElemento.apagarFraquezaVantagem(this.obj.getId());
        this.obj = null;
        setVisible(false);
    }

    public void recarregarConteudo(){
        // Re-render the same DTO
        if (this.obj != null) setModelo(this.obj);
    }

    public void setModelo(ElementoFraquezaVantagemDTO obj){
        if (obj != null) { 
            this.obj = obj;
            gerarConteudo(obj);
        }
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
