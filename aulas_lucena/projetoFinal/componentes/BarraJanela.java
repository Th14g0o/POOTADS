package aulas_lucena.projetoFinal.componentes;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;

import aulas_lucena.projetoFinal.util.Cores;
import aulas_lucena.projetoFinal.util.Imagens;

public class BarraJanela extends JPanel {
    private boolean maximizado = false;
    private Rectangle tamanhoAnterior;

    public BarraJanela(JFrame frame) {
        setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        setBackground(Cores.VERMELHO);
        setPreferredSize(new Dimension(1000, 35));

        JButton btnMinimizar = new JButton(Imagens.iconeBarraJanelaMinimizar(16, 16));
        JButton btnMaximizar = new JButton(Imagens.iconeBarraJanelaMaximizar(16, 16));
        JButton btnFechar = new JButton(Imagens.iconeBarraJanelaFechar(16, 16));

        btnMinimizar.addActionListener(e -> frame.setState(JFrame.ICONIFIED));
        btnFechar.addActionListener(e -> System.exit(0));
        btnMaximizar.addActionListener(e -> alternarMaximizacao(frame));

        btnMinimizar.setFocusPainted(false);
        btnFechar.setFocusPainted(false);
        btnMaximizar.setFocusPainted(false);

        btnMinimizar.setOpaque(false);
        btnFechar.setOpaque(false);
        btnMaximizar.setOpaque(false);

        btnMinimizar.setBackground(Cores.VERMELHO);
        btnFechar.setBackground(Cores.VERMELHO);
        btnMaximizar.setBackground(Cores.VERMELHO);

        btnMinimizar.setBorderPainted(false);
        btnFechar.setBorderPainted(false);
        btnMaximizar.setBorderPainted(false);

        add(btnMinimizar);
        add(btnMaximizar);
        add(btnFechar);

        habilitarArraste(frame);
    }

    private void habilitarArraste(JFrame frame) {
        final Point[] mouseDown = { null };

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseDown[0] = e.getPoint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point p = e.getLocationOnScreen();
                frame.setLocation(
                    p.x - mouseDown[0].x,
                    p.y - mouseDown[0].y
                );
            }
        });
    }

    private void alternarMaximizacao(JFrame frame) {
        GraphicsEnvironment ge =
            GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle areaUtil = ge.getMaximumWindowBounds();

        if (!maximizado) {
            tamanhoAnterior = frame.getBounds();
            frame.setBounds(areaUtil);
            maximizado = true;
        } else {
            frame.setBounds(tamanhoAnterior);
            maximizado = false;
        }
    }
}
