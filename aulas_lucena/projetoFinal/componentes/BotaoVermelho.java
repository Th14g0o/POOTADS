package aulas_lucena.projetoFinal.componentes;

import java.awt.Color;
import javax.swing.JButton;
import aulas_lucena.projetoFinal.util.Cores;

public class BotaoVermelho extends JButton{
    public BotaoVermelho(String texto) {
        super(texto);
        setBackground(Cores.VERMELHO);
        setForeground(Color.WHITE);
    }
}
