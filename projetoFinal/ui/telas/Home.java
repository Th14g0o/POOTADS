package projetoFinal.ui.telas;

import javax.swing.*;
import java.awt.*;

public class Home extends JPanel {
    public Home() {
        setLayout(new GridBagLayout());
        JLabel texto = new JLabel("Home");
        texto.setForeground(Color.WHITE);
        add(texto);
        setOpaque(false);
    }
}
