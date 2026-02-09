package projetoFinal.ui.componentes.tab;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JButton;

import projetoFinal.ui.interfaces.AoClicar;
import projetoFinal.ui.util.Cores;

public class BotaoTab extends JButton {
    public String idTab;
    private boolean selecionado = false;
    private AoClicar aoClicar = null;

    public BotaoTab(String texto, String idTab) {
        this(texto, idTab, null);
    }

    public BotaoTab(String texto, String idTab, AoClicar func) {
        
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

        setAoClicar(func);
        addActionListener(e -> {
            if (aoClicar != null) aoClicar.acao();
        });
    }

    public void setAoClicar(AoClicar func){
        aoClicar = func;
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



