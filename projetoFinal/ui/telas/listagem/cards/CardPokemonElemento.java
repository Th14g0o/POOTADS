package projetoFinal.ui.telas.listagem.cards;

import javax.swing.*;
import java.awt.*;
import projetoFinal.logica.dto.PokemonElementoDTO;
import projetoFinal.logica.modelos.Elemento;
import projetoFinal.logica.modelos.PokemonElemento;
import projetoFinal.logica.servicos.ServicosPokemon;
import projetoFinal.ui.componentes.TagElementoArredondada;
import projetoFinal.ui.formularios.CadastroPokemonElemento;
import projetoFinal.ui.telas.listagem.cards.abstracao.CardListagemModelo;
import projetoFinal.ui.telas.listagem.cards.popup.PopPupEdicao;
import projetoFinal.ui.telas.listagem.cards.popup.PopPupExclusao;
import projetoFinal.ui.util.Imagens;

public class CardPokemonElemento extends CardListagemModelo<PokemonElementoDTO>{
    public CardPokemonElemento(int iconeAcoesLargura, int iconeAcoesAltura, PokemonElementoDTO obj){
        super(iconeAcoesLargura, iconeAcoesAltura);
        setModelo(obj);
    }

    public void mostrarExclusão(){
        String nome = "o Pokemon-Elemento";
        if (obj != null && obj.getPokemon() != null) nome = obj.getPokemon().getNome();
        PopPupExclusao ppe = new PopPupExclusao("Excluir Pokemon-Elemento", this, nome);
        ppe.mostrar(true);
    }

    public void mostrarEdicao(){
        CadastroPokemonElemento form = new CadastroPokemonElemento(false, this.obj.getPokemonElemento());
        PopPupEdicao<PokemonElemento> ppe = new PopPupEdicao("Editar Pokemon-Elemento", this, form);
        ppe.mostrar(true);
    }

    public void apagar(){
        if (this.obj != null && this.obj.getPokemonElemento() != null) ServicosPokemon.apagarElemento(this.obj.getPokemonElemento().getId());
        this.obj = null;
        setVisible(false);
    }

    public void recarregarConteudo(){
        if (this.obj != null && this.obj.getPokemonElemento() != null) setModelo(this.obj);
    }

    public void setModelo(PokemonElementoDTO obj){
        if (obj != null){ 
            this.obj = obj;
            gerarConteudo(obj);
        }
    }

    protected void gerarConteudo(PokemonElementoDTO obj){
        JPanel leiaute = new JPanel();
        leiaute.setLayout(new BoxLayout(leiaute, BoxLayout.PAGE_AXIS));
        leiaute.setOpaque(false);
        leiaute.setAlignmentX(Component.LEFT_ALIGNMENT);
        leiaute.setAlignmentY(Component.TOP_ALIGNMENT);
        conteudoCard.add(leiaute);

        leiaute.add(Box.createRigidArea(new Dimension(150,0)));

        if (obj.getPokemon().getImagem() != null){
            JLabel imagem;
            imagem = new JLabel(Imagens.escalaIcone(obj.getPokemon().getImagem(), 100, 100));
            imagem.setOpaque(false);
            imagem.setAlignmentX(Component.CENTER_ALIGNMENT);
            imagem.setAlignmentY(Component.CENTER_ALIGNMENT);
            leiaute.add(imagem);  
            
        }
        else{
            leiaute.add(Box.createRigidArea(new Dimension(0,50)));
        }
        leiaute.add(Box.createRigidArea(new Dimension(120,5)));

        JLabel texto = new JLabel(obj.getPokemon().getNome()); 
        texto.setForeground(Color.WHITE);
        texto.setOpaque(false);
        texto.setAlignmentX(Component.CENTER_ALIGNMENT);
        texto.setAlignmentY(Component.CENTER_ALIGNMENT);
        leiaute.add(texto);

        leiaute.add(Box.createRigidArea(new Dimension(0,5)));

        TagElementoArredondada painelElemento = new TagElementoArredondada(
            obj.getElemento(), 2, 10, 2, 10
        );
        painelElemento.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelElemento.setAlignmentY(Component.CENTER_ALIGNMENT);
        Dimension pref = painelElemento.getPreferredSize();
        painelElemento.setMaximumSize(pref);  
        painelElemento.setAlignmentX(Component.CENTER_ALIGNMENT);
        leiaute.add(painelElemento);

        leiaute.add(Box.createRigidArea(new Dimension(0,5)));

        JLabel textoJogo = new JLabel(obj.getJogo().getNome()); 
        textoJogo.setForeground(Color.WHITE);
        textoJogo.setOpaque(false);
        textoJogo.setAlignmentX(Component.CENTER_ALIGNMENT);
        textoJogo.setAlignmentY(Component.CENTER_ALIGNMENT);
        leiaute.add(textoJogo);
        
        leiaute.add(Box.createRigidArea(new Dimension(100,5)));

        if (obj.getJogo().getImagem() != null){
            JLabel imagem;
            imagem = new JLabel(Imagens.escalaIcone(obj.getJogo().getImagem(), 100, 100));
            imagem.setOpaque(false);
            imagem.setAlignmentX(Component.CENTER_ALIGNMENT);
            imagem.setAlignmentY(Component.CENTER_ALIGNMENT);
            leiaute.add(imagem);  
        }
        else{
            leiaute.add(Box.createRigidArea(new Dimension(0,100)));
        }


    }
    
}
