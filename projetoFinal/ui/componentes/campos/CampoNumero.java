package projetoFinal.ui.componentes.campos;

import javax.swing.*;
import javax.swing.text.AbstractDocument;

import projetoFinal.ui.util.FiltroNumero;
import projetoFinal.ui.util.Enuns.TipoNumero;

import java.awt.*;

public class CampoNumero extends JPanel {

    private final JTextField campo;
    private final TipoNumero tipo;

    public CampoNumero(String labelTexto) {
        this(labelTexto, 5, TipoNumero.INT);
    }

    public CampoNumero(String labelTexto, int colunas) {
        this(labelTexto, colunas, TipoNumero.INT);
    }

    public CampoNumero(String labelTexto, int colunas, TipoNumero tipo) {
        this.tipo = tipo;

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setOpaque(false);

        JLabel label = new JLabel(labelTexto);
        label.setForeground(Color.WHITE);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(label);

        add(Box.createRigidArea(new Dimension(0, 5)));

        campo = new JTextField(colunas);
        campo.setAlignmentX(Component.LEFT_ALIGNMENT);
        campo.setBorder(BorderFactory.createEmptyBorder(4, 6, 4, 6));

        ((AbstractDocument) campo.getDocument())
                .setDocumentFilter(new FiltroNumero(tipo));

        add(campo);
    }

    public Integer getInt() {
        String txt = campo.getText();
        return txt.isEmpty() ? null : Integer.parseInt(txt);
    }
    public Double getDouble() {
        String txt = campo.getText();
        return txt.isEmpty() ? null : Double.parseDouble(txt);
    }

    public void setValor(Number valor) {
        campo.setText(valor == null ? "" : valor.toString());
    }
    public void limpar() {
        campo.setText("");
    }
}
