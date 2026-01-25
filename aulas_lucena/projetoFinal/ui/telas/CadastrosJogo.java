package aulas_lucena.projetoFinal.ui.telas;

import javax.swing.*;
import java.awt.*;

public class CadastrosJogo extends JPanel  {
    public CadastrosJogo() {
        setLayout(new GridBagLayout());
        JLabel texto = new JLabel("Cadastros Jogo");
        texto.setForeground(Color.WHITE);
        add(texto);
        setOpaque(false);
    }
    
}
