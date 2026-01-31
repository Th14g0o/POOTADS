package projetoFinal.ui.componentes.botoes;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import projetoFinal.ui.util.Cores;
import java.awt.Cursor;

public class BotaoIconeTexto extends JButton{
    private ImageIcon icone;
    private ImageIcon iconeSelecionado;

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
}
