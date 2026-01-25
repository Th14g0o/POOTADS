package aulas_lucena.projetoFinal.ui.telas;

import javax.swing.*;
import java.awt.*;

public class Pokedex extends JPanel {
    public Pokedex() {
        setLayout(new GridBagLayout());
        JLabel texto = new JLabel("Pokedex");
        texto.setForeground(Color.WHITE);
        add(texto);
        setOpaque(false);
    }
}
