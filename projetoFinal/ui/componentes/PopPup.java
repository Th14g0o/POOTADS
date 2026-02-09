package projetoFinal.ui.componentes;

import javax.swing.*;

import projetoFinal.ui.componentes.botoes.BotaoVermelho;
import projetoFinal.ui.interfaces.AoClicar;
import projetoFinal.ui.util.Cores;

import java.awt.*;

public class PopPup extends JDialog{
    private JPanel conteudo;
    private JPanel botoes;
    private JPanel raiz;

    public PopPup(String nomePopPup, Component painelPai, JPanel conteudo){
        super(
                SwingUtilities.getWindowAncestor(painelPai),
                nomePopPup,
                Dialog.ModalityType.APPLICATION_MODAL
        );
        setUndecorated(true);
        setLayout(new BorderLayout());
        setBackground(Cores.TRANSPARENTE);
        getContentPane().setBackground(Cores.TRANSPARENTE);


        raiz = new JPanel(new BorderLayout());
        raiz.setBackground(Cores.AZUL);
        raiz.setBorder(
            BorderFactory.createLineBorder(Color.WHITE, 1)
        );

        if (conteudo == null){
            this.conteudo = new JPanel();
            this.conteudo.setOpaque(false);
        }
        else this.conteudo = conteudo; 
        raiz.add(this.conteudo, BorderLayout.CENTER);

        BarraJanela bj = new BarraJanela(this);
        bj.visibilidadeBtnMaximizar(false);
        bj.visibilidadeBtnMinizar(false);
        bj.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        raiz.add(bj, BorderLayout.NORTH);  

        botoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        botoes.setOpaque(false);
        botoes.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        raiz.add(botoes, BorderLayout.SOUTH);
        setContentPane(raiz);
    }

    public void mostrar(boolean visibilidade){
        pack();
        Dimension size = getSize();
        setSize(600, size.height);
        setLocationRelativeTo(null);
        setVisible(visibilidade);
    }

    public void setConteudo(JPanel conteudo){
        this.conteudo = conteudo;
        this.raiz.setBackground(conteudo.getBackground());
        this.botoes.setBackground(conteudo.getBackground());
        repaint();
    
    }

    public void addBotao(BotaoVermelho bt, boolean dispensar, AoClicar aoClicar){
        bt.addActionListener(e -> {
            if (aoClicar != null) aoClicar.acao();
            if (dispensar) dispose();   
        });
        botoes.add(bt);
    }
}
