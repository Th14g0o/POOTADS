package projetoFinal.ui.telas.listagem.cards;

import javax.swing.*;
import java.awt.*;
import projetoFinal.logica.modelos.Jogo;
import projetoFinal.ui.telas.listagem.cards.abstracao.CardListagemModelo;
import projetoFinal.ui.util.Imagens;

public class CardJogo extends CardListagemModelo<Jogo>{
    public CardJogo(int iconeAcoesLargura, int iconeAcoesAltura, Jogo obj){
        super(iconeAcoesLargura, iconeAcoesAltura);
       setModelo(obj);
    }

    public void setModelo(Jogo obj){
        if (obj != null) gerarConteudo(obj);
    }

    protected void gerarConteudo(Jogo obj){
        JPanel leiaute = new JPanel();
        leiaute.setLayout(new BoxLayout(leiaute, BoxLayout.PAGE_AXIS));
        leiaute.setOpaque(false);
        leiaute.setAlignmentX(Component.LEFT_ALIGNMENT);
        leiaute.setAlignmentY(Component.TOP_ALIGNMENT);
        conteudoCard.add(leiaute);

        leiaute.add(Box.createRigidArea(new Dimension(150,0)));

        if (obj.getImagem() == null)  leiaute.add(Box.createRigidArea(new Dimension(0,50)));

        JLabel texto = new JLabel(obj.getNome()); 
        texto.setForeground(Color.WHITE);
        texto.setOpaque(false);
        texto.setAlignmentX(Component.CENTER_ALIGNMENT);
        texto.setAlignmentY(Component.CENTER_ALIGNMENT);
        leiaute.add(texto);

        leiaute.add(Box.createRigidArea(new Dimension(100,5)));

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
    }
    
}
