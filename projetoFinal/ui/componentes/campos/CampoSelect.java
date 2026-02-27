package projetoFinal.ui.componentes.campos;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import projetoFinal.ui.interfaces.AoMudar;

public class CampoSelect extends JPanel {

    public record Opcao(Long id, String texto){
        @Override
        public String toString(){
            return texto;
        }
    }

    public JComboBox<Opcao> campo;
    private DefaultComboBoxModel<Opcao> opcoes;
    private List<Opcao> todasOpcoes = new ArrayList<Opcao>();
    private AoMudar aoMudar;

    public void addOpcao(Long id, String texto){
        Opcao op = new Opcao(id, texto);
        this.setOpcao(op);
    }

    public void setOpcao(Opcao op){
        this.opcoes.addElement(op);
        this.todasOpcoes.add(op);
    }
    public void setOpcoes(List<Opcao> ops){
        for (Opcao op : ops){
            this.setOpcao(op);
        }
    }
    public Long getValorSelecionado(){
        if (this.opcoes == null || this.opcoes.getSize() < 1) return null;
        Opcao selecionada = (Opcao)this.campo.getSelectedItem();
        return selecionada.id();
    }
    public boolean temValor(){
        return this.getValorSelecionado() != null;
    }
    public void limpar(){
        this.recarregarOpcoes();
    }

    public CampoSelect(String labelTexto){
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setOpaque(false);

        if (!labelTexto.isBlank()){
            JLabel label = new JLabel(labelTexto);
            label.setForeground(Color.WHITE);
            label.setAlignmentX(Component.LEFT_ALIGNMENT);
            add(label);
            add(Box.createRigidArea(new Dimension(0,5)));
        }
        
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
        campo.addActionListener(e -> {
            if (aoMudar != null) aoMudar.mudou(getValorSelecionado());
        });
        addOpcao(null, "Selecione uma opção");
        add(campo);
    }

    public void filtrarIdDiferentes(Long id){
        Long sel = this.getValorSelecionado();
        this.opcoes.removeAllElements();
        for (Opcao op : this.todasOpcoes){
            if (!Objects.equals(op.id(), (id)) || Objects.equals(op.id(), null)) this.opcoes.addElement(op);
        }
        this.selecionarPorId(sel);
    }

    public void filtrarIdDiferentes(List<Long> ids){ 
        if (ids == null || ids.size() < 1) return;
        Long sel = this.getValorSelecionado();
        this.opcoes.removeAllElements();
        for (Opcao op : this.todasOpcoes){
            if (!ids.contains(op.id()) || Objects.equals(op.id(), null)) this.opcoes.addElement(op);
        }

        this.selecionarPorId(sel);
    }

    public void retirarFiltros(Long id){
        Long sel = this.getValorSelecionado();
        this.opcoes.removeAllElements();
        for (Opcao op : this.todasOpcoes){
            this.opcoes.addElement(op);
        }
        this.selecionarPorId(sel);
    }

    public void recarregarOpcoes(){
        this.opcoes.removeAllElements();
        this.todasOpcoes = new ArrayList<Opcao>();
        addOpcao(null, "Selecione uma opção");
        if (opcoes.getSize() > 0) campo.setSelectedIndex(0);
    }

    private void selecionarPorId(Long id){
        for (int i = 0; i < opcoes.getSize(); i++){
            Opcao op = opcoes.getElementAt(i);
            if (Objects.equals(op.id(), id))
                campo.setSelectedIndex(i);
        }
        if (Objects.equals(id, null) && opcoes.getSize() > 0) campo.setSelectedIndex(0);
    }

    // Public helper to allow forms to select an option by id when editing
    public void selecionar(Long id){
        selecionarPorId(id);
    }

    public void setOnChange(AoMudar fn){
         this.aoMudar = fn;
    }

    public void dispararAoMudar(){
        if (aoMudar != null) aoMudar.mudou(getValorSelecionado());
    }
    
}
