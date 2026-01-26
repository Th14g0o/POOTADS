package aulas_lucena.projetoFinal.ui.componentes;

import javax.swing.*;
import aulas_lucena.projetoFinal.ui.util.Imagens;
import java.awt.*;
import java.util.List;

public class CampoGrupoRadio extends JPanel{
    public ButtonGroup grupo = new ButtonGroup();
    public CampoGrupoRadio(List<String> textos){
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setOpaque(false);
        ButtonGroup grupo = new ButtonGroup();
        for (String texto : textos){
            JRadioButton campo = new JRadioButton(texto, Imagens.iconeCheckBox(20, 20));
            campo.setSelectedIcon(Imagens.iconeCheckBoxSelecionado(20, 20));
            campo.setAlignmentX(Component.LEFT_ALIGNMENT);
            campo.setContentAreaFilled(false);
            campo.setOpaque(false);
            campo.setForeground(Color.WHITE);
            campo.setFocusPainted(false);
            campo.setCursor(new Cursor(Cursor.HAND_CURSOR));
            grupo.add(campo);
            add(campo);
        }
    }
    
}
