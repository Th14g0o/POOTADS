package projetoFinal.ui.componentes;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.util.List;

public class CampoSelect extends JPanel {
    public record Opcao(int id, String texto){
        @Override
        public String toString(){
            return texto;
        }
    }

    private JComboBox<Opcao> campo;
    private DefaultComboBoxModel<Opcao> opcoes;

    public void setOpcao(Opcao op){
        this.opcoes.addElement(op);
    }
    public void setOpcoes(List<Opcao> ops){
        for (Opcao op : ops){
            this.setOpcao(op);
        }
    }
    public int getValorSelecionado(){
        Opcao selecionada = (Opcao)campo.getSelectedItem();
        if (selecionada == null) return -1;
        return selecionada.id();
    }

    public CampoSelect(String labelTexto){
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setOpaque(false);

        JLabel label = new JLabel(labelTexto);
        label.setForeground(Color.WHITE);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(label);
        
        add(Box.createRigidArea(new Dimension(0,5)));
    
        opcoes = new DefaultComboBoxModel<Opcao>();
        campo = new JComboBox<Opcao>(opcoes);
        campo.setAlignmentX(Component.LEFT_ALIGNMENT);
        campo.setBackground(Color.WHITE);
        campo.setForeground(Color.BLACK);
        campo.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.WHITE));
        campo.setFocusable(false);
        campo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        campo.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton btn = new JButton("▼");
                btn.setBorder(null);
                btn.setContentAreaFilled(false);
                btn.setFocusPainted(false);
                return btn;
            }
        });
        add(campo);
    }
    
}
