package projetoFinal.ui.telas.listagem.cards;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
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
        PopPupExclusao ppe = new PopPupExclusao("Excluir Elementop", this,  (obj != null ? obj.getNome() : "o elemento"));
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
        setVisible(false);
    }

    public void recarregarConteudo(){
        setModelo(ServicosElemento.achar(this.obj.getId()));
    }

    public void setModelo(Elemento obj){
        if (obj != null){ 
            this.obj = obj;
            gerarConteudo(this.obj);
        }
    }
   
    protected void gerarConteudo(Elemento obj){
        conteudoCard = new JPanel();
        JPanel leiaute = new JPanel();
        leiaute.setLayout(new BoxLayout(leiaute, BoxLayout.PAGE_AXIS));
        leiaute.setOpaque(false);
        leiaute.setAlignmentX(Component.LEFT_ALIGNMENT);
        leiaute.setAlignmentY(Component.TOP_ALIGNMENT);
        conteudoCard.add(leiaute);

        leiaute.add(Box.createRigidArea(new Dimension(150,5)));

        TagElementoArredondada painelElemento =  new TagElementoArredondada(obj);
        Dimension pref = painelElemento.getPreferredSize();
        painelElemento.setMaximumSize(pref);
        painelElemento.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelElemento.setAlignmentY(Component.TOP_ALIGNMENT);
        leiaute.add(painelElemento);
    }
    
}
