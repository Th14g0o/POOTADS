package projetoFinal.ui.componentes;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import projetoFinal.ui.util.Cores;
import java.awt.*;

public class BarraRolagem  extends BasicScrollBarUI {

    @Override
    protected void configureScrollBarColors() {
        thumbColor = Cores.AMARELO;     
        trackColor = new Color(0, 0, 0, 0);            
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return criarBotaoInvisivel();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return criarBotaoInvisivel();
    }

    private JButton criarBotaoInvisivel() {
        JButton btn = new JButton();
        btn.setPreferredSize(new Dimension(0, 0));
        btn.setMinimumSize(new Dimension(0, 0));
        btn.setMaximumSize(new Dimension(0, 0));
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        return btn;
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        g2.setColor(thumbColor);
        g2.fillRoundRect(
            r.x + 2,
            r.y + 2,
            r.width - 4,
            r.height - 4,
            0,
            0
        );

        g2.dispose();
    }
    
}
