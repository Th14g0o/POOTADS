package projetoFinal.ui.componentes.botoes;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Cursor;
import projetoFinal.ui.util.Cores;

public class BotaoVermelho extends JButton{
    public BotaoVermelho(String texto) {
        super(texto);
        setBackground(Cores.VERMELHO);
        setForeground(Color.WHITE);
        setBorderPainted(false);
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
