package aulas_lucena.projetoFinal.ui.componentes;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;

import aulas_lucena.projetoFinal.ui.util.Cores;

import java.awt.*;

public class CampoSelecionaCor extends JPanel {
    private JPanel preview;
    private Color corSelecionada = Color.WHITE;
    public CampoSelecionaCor(String labelTexto){
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setOpaque(false);

        JLabel label = new JLabel(labelTexto);
        label.setForeground(Color.WHITE);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(label);
        
        add(Box.createRigidArea(new Dimension(5,0)));
    
        preview = new JPanel();
        preview.setPreferredSize(new Dimension(20, 20));
        preview.setMaximumSize(new Dimension(20, 20));
        preview.setBackground(corSelecionada);
        preview.setCursor(new Cursor(Cursor.HAND_CURSOR));
        preview.setBorder(null);
        preview.setBorder(BorderFactory.createEmptyBorder(4, 6, 4, 6));
        preview.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                abrirDialogo();
            }
        });
        add(preview);
    }

    private void aplicarTema(Component c, Color fundo, Color texto) {
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

    private void abrirDialogo() {
        JColorChooser chooser = new JColorChooser(corSelecionada);
        // mantém só RGB
        for (var panel : chooser.getChooserPanels()) {
            if (!panel.getDisplayName().equalsIgnoreCase("RGB")) {
                chooser.removeChooserPanel(panel);
            }
        }
        chooser.setPreviewPanel(new JPanel());
        chooser.setOpaque(true);
        aplicarTema(chooser, Cores.AZUL, Color.WHITE);

        JDialog dialog = new JDialog(
                SwingUtilities.getWindowAncestor(this),
                "Selecione uma Cor",
                Dialog.ModalityType.APPLICATION_MODAL
        );
        dialog.setUndecorated(true);

        // 🎨 fundo do modal
        
        dialog.setLayout(new BorderLayout());
        dialog.getContentPane().setBackground(Cores.TRANSPARENTE);

        // painel wrapper (ajuda na estilização)
        JPanel conteudo = new JPanel(new BorderLayout());
        conteudo.setBackground(Cores.AZUL);
        conteudo.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        BarraJanela bj = new BarraJanela(dialog);
        bj.visibilidadeBtnMaximizar(false);
        bj.visibilidadeBtnMinizar(false);
        conteudo.add(bj, BorderLayout.NORTH);  
        conteudo.setBorder(
            BorderFactory.createLineBorder(Color.WHITE, 1)
        );

        conteudo.add(chooser, BorderLayout.CENTER);

        // botões custom
        JButton ok = new JButton("Confirmar");
        ok.setBackground(Cores.VERDE);
        ok.setForeground(Color.WHITE);
        ok.setBorderPainted(false);
        ok.setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        JButton cancelar = new JButton("Cancelar");
        cancelar.setBackground(Cores.VERMELHO);
        cancelar.setForeground(Color.WHITE);
        cancelar.setBorderPainted(false);
        cancelar.setFocusPainted(false);
        
        ok.addActionListener(e -> {
            setCor(chooser.getColor());
            dialog.dispose();
        });

        cancelar.addActionListener(e -> dialog.dispose());

        JPanel botoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        botoes.setOpaque(false);
        botoes.add(ok);
        botoes.add(cancelar);

        conteudo.add(botoes, BorderLayout.SOUTH);
        dialog.setContentPane(conteudo);
        dialog.pack();
        Dimension size = dialog.getSize();
        dialog.setSize(600, size.height);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    public Color getCorSelecionada() {
        return corSelecionada;
    }

    public void setCor(Color cor) {
        this.corSelecionada = cor;
        preview.setBackground(cor);
        repaint();
    }
    
}
