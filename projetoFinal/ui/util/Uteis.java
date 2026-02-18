package projetoFinal.ui.util;

import javax.swing.*;
import java.awt.*;
import projetoFinal.ui.componentes.tab.Rolagem;
import projetoFinal.ui.interfaces.InstanciarGenerica;

import java.util.List;

public class Uteis {
    public static void aplicarTema(Component c, Color fundo, Color texto) {
        c.setBackground(fundo);
        c.setForeground(texto);

        if (c instanceof JComponent jc) {
            jc.setOpaque(true);
        }

        if (c instanceof Container container) {
            for (Component filho : container.getComponents()) {
                aplicarTema(filho, fundo, texto);
            }
        }
    } 

    public static <T> void conteudoCardListagemComun(JPanel painelPai, List<T> objs, InstanciarGenerica<T> card){
        painelPai.removeAll();
        painelPai.setOpaque(false);
        painelPai.setLayout(new BorderLayout());
        
        Rolagem rolagem = new Rolagem(true);
        rolagem.conteudo.removeAll();
        
        for (T obj : objs){
            rolagem.conteudo.add(card.novo(obj));
        }

        painelPai.add(rolagem.rolagem, BorderLayout.CENTER);

        painelPai.revalidate();
        painelPai.repaint();
    }
}
