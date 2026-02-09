package projetoFinal.ui.componentes;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import projetoFinal.logica.modelos.Elemento;
import projetoFinal.ui.util.Cores;
import projetoFinal.ui.util.Imagens;

public class TagElementoArredondada extends PainelArredondado {
    public TagElementoArredondada(Elemento e, int padCima, int padEsquerda, int padBaixo, int padDireita){
        setRadius(50);
        Color bg = Cores.HexParaColor(e.getCor());
        Color corTexto = Cores.CorDeContraste(bg);
        setBackground(bg);
        setBorder(BorderFactory.createEmptyBorder(padCima, padEsquerda, padBaixo, padDireita));

        if (e.getImagem() != null){
            JLabel imagem;
            imagem = new JLabel(Imagens.escalaIcone(e.getImagem(), 20, 20));
            imagem.setOpaque(false);
            add(imagem);
        }

        JLabel texto = new JLabel(e.getNome()); 
        texto.setForeground(corTexto);
        texto.setOpaque(false);
        add(texto);
    }
    public TagElementoArredondada(Elemento e){
        this(e, 5, 5, 5, 5);
    }
}
