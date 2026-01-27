package projetoFinal.ui.util;

import javax.swing.text.*;
import projetoFinal.ui.util.Enuns.TipoNumero;

public class FiltroNumero extends DocumentFilter {

    private final TipoNumero tipo;

    public FiltroNumero(TipoNumero tipo) {
        this.tipo = tipo;
    }

    private boolean valido(String texto) {
        if (texto.isEmpty()) return true;

        return switch (tipo) {
            case INT -> texto.matches("\\d*");
            case DOUBLE -> texto.matches("\\d*(\\.\\d*)?");
        };
    }

    @Override
    public void insertString(FilterBypass fb, int offset,
                             String string, AttributeSet attr)
            throws BadLocationException {

        String novo = fb.getDocument().getText(0, fb.getDocument().getLength());
        novo = new StringBuilder(novo).insert(offset, string).toString();

        if (valido(novo)) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length,
                        String text, AttributeSet attrs)
            throws BadLocationException {

        String atual = fb.getDocument().getText(0, fb.getDocument().getLength());
        String novo = atual.substring(0, offset)
                + text
                + atual.substring(offset + length);

        if (valido(novo)) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
}
