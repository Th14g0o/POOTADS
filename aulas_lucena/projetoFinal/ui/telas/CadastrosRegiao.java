package aulas_lucena.projetoFinal.ui.telas;

import javax.swing.*;
import java.awt.*;

public class CadastrosRegiao extends JPanel  {
    public CadastrosRegiao() {
        setLayout(new GridBagLayout());
        JLabel texto = new JLabel("Cadastros Região");
        texto.setForeground(Color.WHITE);
        add(texto);
        setOpaque(false);
    }
    
}
