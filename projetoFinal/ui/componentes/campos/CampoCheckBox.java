package projetoFinal.ui.componentes.campos;

import javax.swing.*;
import projetoFinal.ui.util.Imagens;
import java.awt.*;

public class CampoCheckBox extends JPanel{
    public CampoCheckBox(String labelTexto){
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setOpaque(false);
    
        JCheckBox campo = new JCheckBox(labelTexto, Imagens.iconeCheckBox(20, 20));
        campo.setSelectedIcon(Imagens.iconeCheckBoxSelecionado(20, 20));
        campo.setAlignmentX(Component.LEFT_ALIGNMENT);
        campo.setContentAreaFilled(false);
        campo.setOpaque(false);
        campo.setForeground(Color.WHITE);
        campo.setFocusPainted(false);
        campo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(campo);
    }
}
