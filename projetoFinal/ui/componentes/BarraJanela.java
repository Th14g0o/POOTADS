package projetoFinal.ui.componentes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import projetoFinal.ui.util.Cores;
import projetoFinal.ui.util.Imagens;

public class BarraJanela extends JPanel {
    private boolean maximizado = false;
    private Rectangle tamanhoAnterior;
    private JButton btnMinimizar;
    private JButton btnMaximizar;
    private JButton btnFechar;

    public BarraJanela(Window janela) {
        setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        setBackground(Cores.VERMELHO);
        setPreferredSize(new Dimension(1000, 32));

        btnMinimizar = new JButton(Imagens.iconeBarraJanelaMinimizar(12, 12));
        btnMaximizar = new JButton(Imagens.iconeBarraJanelaMaximizar(12, 12));
        btnFechar = new JButton(Imagens.iconeBarraJanelaFechar(12, 12));

        btnMinimizar.addActionListener(e -> {
            if (janela instanceof Frame f) {
                f.setState(Frame.ICONIFIED);
            }
        });

        btnMaximizar.addActionListener(e -> alternarMaximizacao(janela));
        btnFechar.addActionListener(e -> janela.dispose());

        configurarBotao(btnMinimizar);
        configurarBotao(btnMaximizar);
        configurarBotao(btnFechar);

        add(btnMinimizar);
        add(btnMaximizar);
        add(btnFechar);

        habilitarArraste(janela);
    }

    public void visibilidadeBtnMaximizar(boolean visivel){
        btnMaximizar.setVisible(visivel);
    }
    public void visibilidadeBtnMinizar(boolean visivel){
        btnMinimizar.setVisible(visivel);
    }

    private void configurarBotao(JButton btn) {
        btn.setFocusPainted(false);
        btn.setOpaque(false);
        btn.setBackground(Cores.VERMELHO);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void habilitarArraste(Window janela) {
        final Point[] mouseDown = { null };

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseDown[0] = e.getPoint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point p = e.getLocationOnScreen();
                janela.setLocation(
                    p.x - mouseDown[0].x,
                    p.y - mouseDown[0].y
                );
            }
        });
    }

    private void alternarMaximizacao(Window janela) {
        if (!(janela instanceof Frame frame)) return;

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
