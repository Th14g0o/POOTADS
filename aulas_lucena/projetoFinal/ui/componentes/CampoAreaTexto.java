package aulas_lucena.projetoFinal.ui.componentes;

import javax.swing.*;
import java.awt.*;

public class CampoAreaTexto extends JPanel {
    public CampoAreaTexto(String labelTexto){
        this(labelTexto, 20, 5);
    }
    public CampoAreaTexto(String labelTexto, int colunas, int linhas){
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setOpaque(false);

        JLabel label = new JLabel(labelTexto);
        label.setForeground(Color.WHITE);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(label);
        
        add(Box.createRigidArea(new Dimension(0,5)));
    
        JTextArea campo = new JTextArea(linhas, colunas);
        campo.setAlignmentX(Component.LEFT_ALIGNMENT);
        campo.setBorder(null);
        campo.setBorder(BorderFactory.createEmptyBorder(4, 6, 4, 6));
        add(campo);
    }
    
}
