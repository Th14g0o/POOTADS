package aulas_lucena.projetoFinal.ui.componentes;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JButton;

import aulas_lucena.projetoFinal.ui.util.Cores;

public class BotaoTab extends JButton {
    public String idTab;
    private boolean selecionado = false;

    public BotaoTab(String texto, String idTab) {
        super(texto);
        this.idTab = idTab;

        setOpaque(true);
        setContentAreaFilled(true);
        setBorderPainted(false);
        setFocusPainted(false);

        setForeground(Color.WHITE);
        setBackground(Cores.AZUL);
        setIconTextGap(6);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void setSelecionado(boolean ativo) {
        this.selecionado = ativo;

        if (ativo) {
            setForeground(Cores.AMARELO);
        } else {
            setForeground(Color.WHITE);
        }
    }
}



