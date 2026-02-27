package projetoFinal.ui.componentes.botoes;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Dimension;

import projetoFinal.ui.util.Cores;

public class BotaoVermelho extends JButton{
    public BotaoVermelho(String texto) {
        this(texto, Cores.VERMELHO, Color.WHITE);
    }

    public BotaoVermelho(String texto, Color corBG) {
        this(texto, corBG, Cores.CorDeContraste(corBG));
    }

    public BotaoVermelho(String texto, Color corBG, Color corTexto) {
        super(texto);
        setBackground(corBG);
        setForeground(corTexto);
        setBorderPainted(false);
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
    }

    public void altura(int altura){
        Dimension tamanhoAtual = getPreferredSize();
        setPreferredSize(new Dimension(tamanhoAtual.width, altura));
    }

    public void padding(int cima, int esquerda, int baixo, int direita){
        setBorder(BorderFactory.createMatteBorder(cima, esquerda, baixo, direita, Color.WHITE));
    }
}
