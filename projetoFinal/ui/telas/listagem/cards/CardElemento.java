package projetoFinal.ui.telas.listagem.cards;

import projetoFinal.logica.modelos.Elemento;
import projetoFinal.logica.servicos.ServicosElemento;
import projetoFinal.ui.componentes.TagElementoArredondada;
import projetoFinal.ui.formularios.CadastroElemento;
import projetoFinal.ui.telas.listagem.cards.abstracao.CardListagemModelo;
import projetoFinal.ui.telas.listagem.cards.popup.PopPupEdicao;
import projetoFinal.ui.telas.listagem.cards.popup.PopPupExclusao;

public class CardElemento extends CardListagemModelo<Elemento> {
    
    public CardElemento(int iconeAcoesLargura, int iconeAcoesAltura, Elemento obj){
        super(iconeAcoesLargura, iconeAcoesAltura);
        setModelo(obj);
    }

    public void mostrarExclusão(){
        PopPupExclusao ppe = new PopPupExclusao("Excluir Elemento", this,  (obj != null ? obj.getNome() : "o elemento"));
        ppe.mostrar(true);
    }

    public void mostrarEdicao(){
        CadastroElemento form = new CadastroElemento(false, obj);
        PopPupEdicao<Elemento> ppe = new PopPupEdicao<Elemento>("Editar Elemento", this, form);
        ppe.mostrar(true);
    }

    public void apagar(){
        if (this.obj != null) ServicosElemento.apagar(this.obj.getId());
        this.obj = null;
        conteudoCard.setVisible(false);
        setVisible(false);
    }

    public void recarregarConteudo(){
        this.limparConteudoCard();
        if (this.obj != null) setModelo(ServicosElemento.achar(this.obj.getId()));
        conteudoCard.revalidate();
        conteudoCard.repaint();
    }

    public void setModelo(Elemento obj){
         if (obj != null) { 
            this.obj = obj;
            gerarConteudo(obj);
        }
    }
   
    protected void gerarConteudo(Elemento obj){
        TagElementoArredondada painelElementoAlvo = new TagElementoArredondada(obj);
        conteudoCard.add(painelElementoAlvo);
    }
    
}
