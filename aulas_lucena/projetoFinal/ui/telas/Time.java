package aulas_lucena.projetoFinal.ui.telas;

import javax.swing.*;
import java.awt.*;

public class Time extends JPanel  {
    public Time() {
        setLayout(new GridBagLayout());
        JLabel texto = new JLabel("Time");
        texto.setForeground(Color.WHITE);
        add(texto);
        setOpaque(false);
    }
}
