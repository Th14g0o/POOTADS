package projetoFinal.ui.componentes.botoes;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

import projetoFinal.ui.util.Cores;
import java.awt.Cursor;

public class BotaoIconeTexto extends JButton{
    private ImageIcon icone;
    private ImageIcon iconeSelecionado;
    private Border padding = BorderFactory.createEmptyBorder();;
    private Border borda = BorderFactory.createEmptyBorder();;

    public void setIconeSelecionado(ImageIcon icone){
        this.iconeSelecionado = icone;
    }
    public void setIcone(ImageIcon icone){
        this.icone = icone;
    }

    public void ativarBt(){
        setIcon(this.iconeSelecionado);
        setForeground(Cores.AMARELO);
    }
    public void normalizarBt(){
        setIcon(this.icone);
        setForeground(Color.WHITE);
    }

    public BotaoIconeTexto(String texto, ImageIcon icone, ImageIcon iconeSelecionado) {
        super(texto, icone);
        this.icone = icone;
        this.iconeSelecionado = iconeSelecionado;
        setOpaque(false);
        setForeground(Color.WHITE);
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    public BotaoIconeTexto(String texto, ImageIcon icone) {
        this(texto, icone, null);
    }

    public void adicionarFundo(Color cor){
        setOpaque(true);
        setBackground(cor);
    }

    public void padding(int cima, int esquerda, int baixo, int direita){
        padding = BorderFactory.createEmptyBorder(cima, esquerda, baixo, direita);
        atualizarComponenteBorda();
    }

    public void setBorda(Color cor, int espessura){
        setBorderPainted(true);
        borda = BorderFactory.createLineBorder(cor, espessura);
        atualizarComponenteBorda();
    }

     public void removeBorda(Color cor, int espessura){
        setBorderPainted(false);
        borda = BorderFactory.createEmptyBorder();
        atualizarComponenteBorda();
    }

    private void atualizarComponenteBorda(){
        setBorder(
            BorderFactory.createCompoundBorder(
                borda, 
                padding
            )
        );
        revalidate();
        repaint();
    }
}
