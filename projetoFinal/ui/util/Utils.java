package projetoFinal.ui.util;

import javax.swing.*;
import java.awt.*;

public class Utils {
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

    public static void aplicarOpaco(Component c, boolean ehOpaco) {
        if (c instanceof JComponent jc) {
            jc.setOpaque(ehOpaco);
        }

        if (c instanceof Container container) {
            for (Component filho : container.getComponents()) {
                aplicarOpaco(filho, ehOpaco);
            }
        }
    }
    
}
