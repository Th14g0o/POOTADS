package projetoFinal.ui.componentes.tab;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import projetoFinal.ui.componentes.BarraRolagem;
import projetoFinal.ui.componentes.LayoutQuebravel;
import projetoFinal.ui.util.Cores;

public class Rolagem extends JPanel {
    public JScrollPane rolagem;
    public JScrollBar barraRolagem; 
    public JPanel conteudo; 

    public Rolagem(){ 
        this(false);
    }

    public Rolagem(boolean quebra){ 
        super();
        setLayout(new BorderLayout());
        setOpaque(false);

        conteudo = new JPanel();
        conteudo.setOpaque(false);
        if(quebra) conteudo.setLayout(new LayoutQuebravel(FlowLayout.LEFT, 0, 0));
        else conteudo.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        add(conteudo);

        setRolagem();
    }

    private void setRolagem(){
        rolagem = new JScrollPane(conteudo);
        rolagem.setBorder(null);
        rolagem.getVerticalScrollBar().setUnitIncrement(16);
        rolagem.setOpaque(false);
        rolagem.setBackground(Cores.TRANSPARENTE);
        rolagem.getViewport().setOpaque(false);

        barraRolagem = rolagem.getVerticalScrollBar();
        barraRolagem.setUI(new BarraRolagem());
        barraRolagem.setPreferredSize(new Dimension(12, Integer.MAX_VALUE)); 
        barraRolagem.setOpaque(false);
    }
}