package aulas_lucena.projetoFinal.telas;

import javax.swing.*;
import java.awt.*;

public class Home extends JPanel {
    public Home() {
        setLayout(new GridBagLayout());
        JLabel texto = new JLabel("Página Home");
        texto.setForeground(Color.WHITE);
        add(texto);
        setOpaque(false);
    }
}
