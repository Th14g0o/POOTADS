package projetoFinal.ui.componentes.campos;

import javax.swing.*;

import projetoFinal.ui.componentes.BarraJanela;
import projetoFinal.ui.componentes.PopPup;
import projetoFinal.ui.componentes.botoes.BotaoVermelho;
import projetoFinal.ui.interfaces.AoClicar;
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
        JPanel conteudo = new JPanel(new BorderLayout());
        conteudo.setBackground(Cores.AZUL);
        conteudo.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        JColorChooser chooser = new JColorChooser(corSelecionada != null ? corSelecionada : Color.WHITE);
        for (var panel : chooser.getChooserPanels()) {
            if (!panel.getDisplayName().equalsIgnoreCase("RGB")) {
                chooser.removeChooserPanel(panel);
            }
        }
        chooser.setPreviewPanel(new JPanel());
        chooser.setOpaque(true);
        Uteis.aplicarTema(chooser, Cores.AZUL, Color.WHITE);
        conteudo.add(chooser, BorderLayout.CENTER);

        PopPup pp = new PopPup("Seleção de cor", this, conteudo);
        BotaoVermelho ok = new BotaoVermelho("Confirmar", Cores.VERDE, Color.WHITE);
        BotaoVermelho cancelar = new BotaoVermelho("Cancelar", Cores.VERMELHO, Color.WHITE);
        pp.addBotao(
            ok, true, 
            new AoClicar() {
                public void acao() { setCor(chooser.getColor()); }
            }
        );
         pp.addBotao(
            cancelar, true,
            new AoClicar() {
                public void acao() { limpar(); }
            }
        );
        pp.mostrar(true);
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
