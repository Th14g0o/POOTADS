package projetoFinal.ui.componentes.campos;

import javax.swing.*;
import projetoFinal.ui.util.Imagens;
import java.awt.*;

public class CampoCheckBox extends JPanel{
    private JCheckBox campo;

    public CampoCheckBox(String labelTexto){
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setOpaque(false);
    
        campo = new JCheckBox(labelTexto, Imagens.iconeCheckBox(20, 20));
        campo.setSelectedIcon(Imagens.iconeCheckBoxSelecionado(20, 20));
        campo.setAlignmentX(Component.LEFT_ALIGNMENT);
        campo.setContentAreaFilled(false);
        campo.setOpaque(false);
        campo.setForeground(Color.WHITE);
        campo.setFocusPainted(false);
        campo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(campo);
    }

    public void limparValor(){
        campo.setSelected(false);
    }
    public Boolean getValor(){
        return campo.isSelected();
    }
    public void setValor(Boolean selecionar){
        campo.setSelected(selecionar);
    }
    public void temTexto(Boolean valor){
        campo.setSelected(valor);
    }
}
