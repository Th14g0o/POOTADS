package projetoFinal.ui.telas.listagem.cards;

import javax.swing.*;
import java.awt.*;

import projetoFinal.logica.modelos.Pokemon;
import projetoFinal.logica.servicos.ServicosPokemon;
import projetoFinal.ui.formularios.CadastroPokemon;
import projetoFinal.ui.telas.listagem.cards.abstracao.CardListagemModelo;
import projetoFinal.ui.telas.listagem.cards.popup.PopPupEdicao;
import projetoFinal.ui.telas.listagem.cards.popup.PopPupExclusao;
import projetoFinal.ui.util.Imagens;

public class CardPokemon extends CardListagemModelo<Pokemon>{
    public CardPokemon(int iconeAcoesLargura, int iconeAcoesAltura, Pokemon obj){
        super(iconeAcoesLargura, iconeAcoesAltura);
        setModelo(obj);
    }

    public void mostrarExclusão(){
        PopPupExclusao ppe = new PopPupExclusao("Excluir Elementop", this,  (obj != null ? obj.getNome() : "o elemento"));
        ppe.mostrar(true);
    }

    public void mostrarEdicao(){
        CadastroPokemon form = new CadastroPokemon(false, this.obj);
        PopPupEdicao<Pokemon> ppe = new PopPupEdicao<Pokemon>("Editar Pokemon", this, form);
        ppe.mostrar(true);
    }

    public void apagar(){
        if (this.obj != null) ServicosPokemon.apagar(this.obj.getId());
        this.obj = null;
        conteudoCard.setVisible(false);
        setVisible(false);
    }

    public void recarregarConteudo(){
        this.limparConteudoCard();
        if (this.obj != null) setModelo(ServicosPokemon.achar(this.obj.getId()));
        conteudoCard.revalidate();
        conteudoCard.repaint();
    }

    public void setModelo(Pokemon obj){
        if (obj != null){ 
            this.obj = obj;
            gerarConteudo(obj);
        }
    }

    protected void gerarConteudo(Pokemon obj){
        JPanel leiaute = new JPanel();
        leiaute.setLayout(new BoxLayout(leiaute, BoxLayout.PAGE_AXIS));
        leiaute.setOpaque(false);
        leiaute.setAlignmentX(Component.LEFT_ALIGNMENT);
        leiaute.setAlignmentY(Component.TOP_ALIGNMENT);
        conteudoCard.add(leiaute);

        leiaute.add(Box.createRigidArea(new Dimension(150,0)));

        if (obj.getImagem() != null){
            JLabel imagem;
            imagem = new JLabel(Imagens.escalaIcone(obj.getImagem(), 100, 100));
            imagem.setOpaque(false);
            imagem.setAlignmentX(Component.CENTER_ALIGNMENT);
            imagem.setAlignmentY(Component.CENTER_ALIGNMENT);
            leiaute.add(imagem);  
            
        }
        else{
            leiaute.add(Box.createRigidArea(new Dimension(0,50)));
        }
        
        leiaute.add(Box.createRigidArea(new Dimension(100,5)));

        JLabel texto = new JLabel(obj.getNome()); 
        texto.setForeground(Color.WHITE);
        texto.setOpaque(false);
        texto.setAlignmentX(Component.CENTER_ALIGNMENT);
        texto.setAlignmentY(Component.CENTER_ALIGNMENT);
        leiaute.add(texto);

        if (obj.getImagem() == null)  leiaute.add(Box.createRigidArea(new Dimension(0,50)));
    }
}
