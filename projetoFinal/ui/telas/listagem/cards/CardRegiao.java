package projetoFinal.ui.telas.listagem.cards;

import javax.swing.*;
import java.awt.*;

import projetoFinal.logica.modelos.Regiao;
import projetoFinal.logica.servicos.ServicosRegiao;
import projetoFinal.ui.formularios.FormRegiao;
import projetoFinal.ui.telas.listagem.cards.abstracao.CardListagemModelo;
import projetoFinal.ui.telas.listagem.cards.popup.PopPupEdicao;
import projetoFinal.ui.telas.listagem.cards.popup.PopPupExclusao;

public class CardRegiao extends CardListagemModelo<Regiao>{
    public CardRegiao(int iconeAcoesLargura, int iconeAcoesAltura, Regiao obj){
        super(iconeAcoesLargura, iconeAcoesAltura);
        setModelo(obj);
    }

    public void mostrarExclusão(){
        PopPupExclusao ppe = new PopPupExclusao("Excluir Elementop", this,  (obj != null ? obj.getNome() : "o elemento"));
        ppe.mostrar(true);
    }

    public void mostrarEdicao(){
        FormRegiao form = new FormRegiao(false, this.obj);
        PopPupEdicao<Regiao> ppe = new PopPupEdicao<Regiao>("Editar Região", this, form);
        ppe.mostrar(true);
    }

    public void apagar(){
        if (this.obj != null) ServicosRegiao.apagar(this.obj.getId());
        this.obj = null;
        conteudoCard.setVisible(false);
        setVisible(false);
    }

    public void recarregarConteudo(){
        this.limparConteudoCard();
        if (this.obj != null) setModelo(ServicosRegiao.achar(this.obj.getId()));
        conteudoCard.revalidate();
        conteudoCard.repaint();
    }

    public void setModelo(Regiao obj){
        if (obj != null) { 
            this.obj = obj;
            gerarConteudo(obj);
        }
    }

    protected void gerarConteudo(Regiao obj){
        JPanel leiaute = new JPanel();
        leiaute.setLayout(new BoxLayout(leiaute, BoxLayout.PAGE_AXIS));
        leiaute.setOpaque(false);
        leiaute.setAlignmentX(Component.LEFT_ALIGNMENT);
        leiaute.setAlignmentY(Component.TOP_ALIGNMENT);
        conteudoCard.add(leiaute);

        leiaute.add(Box.createRigidArea(new Dimension(150,5)));

        JLabel texto = new JLabel(obj.getNome()); 
        texto.setForeground(Color.WHITE);
        texto.setOpaque(false);
        texto.setAlignmentX(Component.CENTER_ALIGNMENT);
        texto.setAlignmentY(Component.CENTER_ALIGNMENT);
        leiaute.add(texto);

        leiaute.add(Box.createRigidArea(new Dimension(50,5)));
    }
    
}
