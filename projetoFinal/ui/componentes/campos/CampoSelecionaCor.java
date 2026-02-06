package projetoFinal.ui.componentes.campos;

import javax.swing.*;

import projetoFinal.ui.componentes.BarraJanela;
import projetoFinal.ui.util.Cores;
import projetoFinal.ui.util.Uteis;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CampoSelecionaCor extends JPanel {
    private JPanel preview;
    private Color corSelecionada = null;
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
        preview.setOpaque(false);
        preview.setCursor(new Cursor(Cursor.HAND_CURSOR));
        preview.setBorder(null);
        preview.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.WHITE, 1), 
                BorderFactory.createEmptyBorder(4, 6, 4, 6)   
            )
        );
        preview.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                abrirDialogo();
            }
        });
        add(preview);
    }

    private void abrirDialogo() {
        JColorChooser chooser = new JColorChooser(corSelecionada != null ? corSelecionada : Color.WHITE);
        for (var panel : chooser.getChooserPanels()) {
            if (!panel.getDisplayName().equalsIgnoreCase("RGB")) {
                chooser.removeChooserPanel(panel);
            }
        }
        chooser.setPreviewPanel(new JPanel());
        chooser.setOpaque(true);
        Uteis.aplicarTema(chooser, Cores.AZUL, Color.WHITE);

        JDialog dialog = new JDialog(
                SwingUtilities.getWindowAncestor(this),
                "Selecione uma Cor",
                Dialog.ModalityType.APPLICATION_MODAL
        );
        dialog.setUndecorated(true);
        
        dialog.setLayout(new BorderLayout());
        dialog.getContentPane().setBackground(Cores.TRANSPARENTE);

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

        cancelar.addActionListener(e -> {
            limpar();
            dialog.dispose();
    });

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

    public String getCorSelecionadaHex() {
        return Cores.ColorParaHex(corSelecionada);
    }

    public void setCor(Color cor) {
        this.corSelecionada = cor;
        preview.setOpaque(true);
        preview.setBackground(cor);
        repaint();
    }

    public void setCorHex(String cor) {
        setCor(Cores.HexParaColor(cor));
    }

    public boolean temCorSelecionada() {
        return corSelecionada != null;
    }

    public void limpar() {
        this.corSelecionada = null;
        preview.setOpaque(false);
        repaint();
    }
    
}
