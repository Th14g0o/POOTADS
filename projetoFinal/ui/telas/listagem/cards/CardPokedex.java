package projetoFinal.ui.telas.listagem.cards;

import javax.swing.*;
import java.awt.*;

import projetoFinal.logica.dto.PokedexDTO;
import projetoFinal.logica.modelos.Elemento;
import projetoFinal.ui.componentes.TagElementoArredondada;
import projetoFinal.ui.telas.listagem.cards.abstracao.CardListagemModelo;
import projetoFinal.ui.util.Imagens;

public class CardPokedex extends CardListagemModelo<PokedexDTO>{
    public CardPokedex(int iconeAcoesLargura, int iconeAcoesAltura, PokedexDTO obj){
        super(iconeAcoesLargura, iconeAcoesAltura);
        setModelo(obj);
    }

    public void setModelo(PokedexDTO obj){
        if (obj != null) gerarConteudo(obj);
    }

    protected void gerarConteudo(PokedexDTO obj){
        JPanel leiaute = new JPanel();
        leiaute.setLayout(new BoxLayout(leiaute, BoxLayout.PAGE_AXIS));
        leiaute.setOpaque(false);
        leiaute.setAlignmentX(Component.LEFT_ALIGNMENT);
        leiaute.setAlignmentY(Component.TOP_ALIGNMENT);
        conteudoCard.add(leiaute);

        if (obj.getPokemon().getPokemon().getImagem() != null){
            JLabel imagem;
            imagem = new JLabel(Imagens.escalaIcone(obj.getPokemon().getPokemon().getImagem(), 100, 100));
            imagem.setOpaque(false);
            imagem.setAlignmentX(Component.CENTER_ALIGNMENT);
            imagem.setAlignmentY(Component.CENTER_ALIGNMENT);
            leiaute.add(imagem);  
            
        }
        else{
            leiaute.add(Box.createRigidArea(new Dimension(0,50)));
        }

        leiaute.add(Box.createRigidArea(new Dimension(100,5)));

        JLabel nomePokemon = new JLabel(obj.getPokemon().getPokemon().getNome()); 
        nomePokemon.setForeground(Color.WHITE);
        nomePokemon.setOpaque(false);
        nomePokemon.setAlignmentX(Component.CENTER_ALIGNMENT);
        nomePokemon.setAlignmentY(Component.CENTER_ALIGNMENT);
        leiaute.add(nomePokemon);

        leiaute.add(Box.createRigidArea(new Dimension(100,5)));

        JLabel numeroPokedex = new JLabel("#" + obj.getPokedex().getNumeroPokemon()); 
        numeroPokedex.setForeground(Color.WHITE);
        numeroPokedex.setOpaque(false);
        numeroPokedex.setAlignmentX(Component.CENTER_ALIGNMENT);
        numeroPokedex.setAlignmentY(Component.CENTER_ALIGNMENT);
        leiaute.add(numeroPokedex);

        leiaute.add(Box.createRigidArea(new Dimension(100,5)));

        for (Elemento e : obj.getPokemon().getElementos()){
            TagElementoArredondada painelElemento =  new TagElementoArredondada(e);
            conteudoCard.add(painelElemento);
        }

        leiaute.add(Box.createRigidArea(new Dimension(100,5)));
       
        if (obj.getJogo().getImagem() == null)  leiaute.add(Box.createRigidArea(new Dimension(0,50)));

        JLabel jogo = new JLabel(obj.getJogo().getNome()); 
        jogo.setForeground(Color.WHITE);
        jogo.setOpaque(false);
        jogo.setAlignmentX(Component.CENTER_ALIGNMENT);
        jogo.setAlignmentY(Component.CENTER_ALIGNMENT);
        leiaute.add(jogo);

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
            leiaute.add(Box.createRigidArea(new Dimension(0,50)));
        }

        leiaute.add(Box.createRigidArea(new Dimension(100,5)));

        JLabel regiao = new JLabel("Região: " + obj.getRegiao().getNome()); 
        regiao.setForeground(Color.WHITE);
        regiao.setOpaque(false);
        regiao.setAlignmentX(Component.CENTER_ALIGNMENT);
        regiao.setAlignmentY(Component.CENTER_ALIGNMENT);
        leiaute.add(regiao);

        leiaute.add(Box.createRigidArea(new Dimension(100,5)));

        JPanel painelHorizotal = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelHorizotal.setOpaque(false);
        painelHorizotal.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelHorizotal.setAlignmentY(Component.CENTER_ALIGNMENT);
        leiaute.add(painelHorizotal);

        if (obj.getAnte().getPokemon() != null){
            JPanel cardAnte = new JPanel();
            cardAnte.setLayout(new BoxLayout(cardAnte, BoxLayout.PAGE_AXIS));
            cardAnte.setOpaque(false);
            cardAnte.setAlignmentX(Component.LEFT_ALIGNMENT);
            cardAnte.setAlignmentY(Component.TOP_ALIGNMENT);
            painelHorizotal.add(cardAnte);

            if (obj.getAnte().getPokemon().getImagem() != null){
                JLabel imagem;
                imagem = new JLabel(Imagens.escalaIcone(obj.getAnte().getPokemon().getImagem(), 100, 100));
                imagem.setOpaque(false);
                imagem.setAlignmentX(Component.CENTER_ALIGNMENT);
                imagem.setAlignmentY(Component.CENTER_ALIGNMENT);
                cardAnte.add(imagem);  
            }
            else{
                cardAnte.add(Box.createRigidArea(new Dimension(0,50)));
            }

            cardAnte.add(Box.createRigidArea(new Dimension(0,5)));

            JLabel texto = new JLabel(obj.getAnte().getPokemon().getNome()); 
            texto.setForeground(Color.WHITE);
            texto.setOpaque(false);
            texto.setAlignmentX(Component.CENTER_ALIGNMENT);
            texto.setAlignmentY(Component.CENTER_ALIGNMENT);
            cardAnte.add(texto);

            cardAnte.add(Box.createRigidArea(new Dimension(0,5)));

            if (obj.getPokemon().getPokemon().getImagem() == null)  cardAnte.add(Box.createRigidArea(new Dimension(0,50)));
        }
        else{
            leiaute.add(Box.createRigidArea(new Dimension(0,60)));
        }

        painelHorizotal.add(Box.createRigidArea(new Dimension(20,0)));

        if (obj.getProx().getPokemon() != null){
            JPanel cardProx = new JPanel();
            cardProx.setLayout(new BoxLayout(cardProx, BoxLayout.PAGE_AXIS));
            cardProx.setOpaque(false);
            cardProx.setAlignmentX(Component.LEFT_ALIGNMENT);
            cardProx.setAlignmentY(Component.TOP_ALIGNMENT);
            painelHorizotal.add(cardProx);

            if (obj.getPokemon().getPokemon().getImagem() != null){
                JLabel imagem;
                imagem = new JLabel(Imagens.escalaIcone(obj.getPokemon().getPokemon().getImagem(), 100, 100));
                imagem.setOpaque(false);
                imagem.setAlignmentX(Component.CENTER_ALIGNMENT);
                imagem.setAlignmentY(Component.CENTER_ALIGNMENT);
                cardProx.add(imagem);  
                
            }
            else{
                cardProx.add(Box.createRigidArea(new Dimension(0,50)));
            }

            cardProx.add(Box.createRigidArea(new Dimension(0,5)));

            JLabel textoEvolucao = new JLabel(obj.getPokemon().getPokemon().getNome()); 
            textoEvolucao.setForeground(Color.WHITE);
            textoEvolucao.setOpaque(false);
            textoEvolucao.setAlignmentX(Component.CENTER_ALIGNMENT);
            textoEvolucao.setAlignmentY(Component.CENTER_ALIGNMENT);
            cardProx.add(textoEvolucao);

            cardProx.add(Box.createRigidArea(new Dimension(0,5)));

            if (obj.getPokemon().getPokemon().getImagem() == null)  cardProx.add(Box.createRigidArea(new Dimension(0,50)));
        }
        else{
            leiaute.add(Box.createRigidArea(new Dimension(0,65)));
        }
        
    }
    
}
