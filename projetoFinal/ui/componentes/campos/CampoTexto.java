package projetoFinal.ui.componentes.campos;

import javax.swing.*;
import java.awt.*;

public class CampoTexto extends JPanel {
    public CampoTexto(String labelTexto){
        this(labelTexto, 20);
    }
    public CampoTexto(String labelTexto, int colunas){
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setOpaque(false);

        JLabel label = new JLabel(labelTexto);
        label.setForeground(Color.WHITE);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(label);
        
        add(Box.createRigidArea(new Dimension(0,5)));
    
        JTextField campo = new JTextField(colunas);
        campo.setAlignmentX(Component.LEFT_ALIGNMENT);
        campo.setBorder(null);
        campo.setBorder(BorderFactory.createEmptyBorder(4, 6, 4, 6));
        add(campo);
    }
}
