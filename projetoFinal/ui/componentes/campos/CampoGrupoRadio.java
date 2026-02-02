package projetoFinal.ui.componentes.campos;

import javax.swing.*;
import projetoFinal.ui.util.Imagens;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class CampoGrupoRadio extends JPanel{
    private List<JRadioButton> radios = new ArrayList<JRadioButton>();
    public ButtonGroup grupo = new ButtonGroup();

    public CampoGrupoRadio(List<String> textos){
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setOpaque(false);
        addOpcao(textos);
    }

    public void addOpcao(String texto){
        JRadioButton campo = new JRadioButton(texto, Imagens.iconeCheckBox(20, 20));
        campo.setSelectedIcon(Imagens.iconeCheckBoxSelecionado(20, 20));
        campo.setAlignmentX(Component.LEFT_ALIGNMENT);
        campo.setContentAreaFilled(false);
        campo.setOpaque(false);
        campo.setForeground(Color.WHITE);
        campo.setFocusPainted(false);
        campo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        grupo.add(campo);
        radios.add(campo);
        this.add(campo);
    }
    public void addOpcao(List<String> textos){
        for (String texto : textos){
            addOpcao(texto);
        }
    }

    public void limpar() {
        radios = new ArrayList<JRadioButton>();
        grupo.clearSelection();
    }
    public int getValor() {
        if (radios == null || radios.size() < 1) return -1;
        int i = 0;
        for (JRadioButton radio : radios) {
            if (radio.isSelected()) {
                return i;
            }
            i++;
        }
        return -1;
    }
    public void setValor(String valor) {
        for (JRadioButton radio : radios) {
            if (radio.getText().equals(valor)) {
                radio.setSelected(true);
                return;
            }
        }
    }
    public boolean temValor() {
        return getValor() != -1;
    }
    
}
