package aulas_lucena.projetoFinal.ui.telas;

import javax.swing.*;
import java.awt.*;

public class CadastrosPokemon extends JPanel  {
    public CadastrosPokemon() {
        setLayout(new GridBagLayout());
        JLabel texto = new JLabel("Cadastros Pokemon");
        texto.setForeground(Color.WHITE);
        add(texto);
        setOpaque(false);
    }
    
}
