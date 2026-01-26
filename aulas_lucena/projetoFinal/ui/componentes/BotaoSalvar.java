package aulas_lucena.projetoFinal.ui.componentes;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JButton;
import aulas_lucena.projetoFinal.ui.util.Cores;
import aulas_lucena.projetoFinal.ui.util.Imagens;

public class BotaoSalvar extends JButton{
    public BotaoSalvar() {
        super("SALVAR", Imagens.iconeBtSalvar(16, 16));
        setBackground(Cores.VERDE);
        setForeground(Color.WHITE);
        setBorderPainted(false);
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
}
