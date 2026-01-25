package aulas_lucena.projetoFinal.ui.componentes;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Cursor;

public class BotaoIconeTexto extends JButton{
    public BotaoIconeTexto(String texto, ImageIcon icone) {
        super(texto, icone);
        setOpaque(false);
        setForeground(Color.WHITE);
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
