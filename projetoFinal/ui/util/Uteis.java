package projetoFinal.ui.util;

import javax.swing.*;
import java.awt.*;

public class Uteis {
    public static void aplicarTema(Component c, Color fundo, Color texto) {
        c.setBackground(fundo);
        c.setForeground(texto);

        if (c instanceof JComponent jc) {
            jc.setOpaque(true);
        }

        if (c instanceof Container container) {
            for (Component filho : container.getComponents()) {
                aplicarTema(filho, fundo, texto);
            }
        }
    } 
}
