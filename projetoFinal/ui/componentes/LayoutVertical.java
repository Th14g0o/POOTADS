package projetoFinal.ui.componentes;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import projetoFinal.ui.componentes.tab.Rolagem;

public class LayoutVertical extends JPanel {
    GridBagConstraints gbc;
    JPanel painelConteudo;
    int qtdElemento = 0;
    public LayoutVertical(){
        setLayout(new BorderLayout()); 
        setOpaque(false);

        Rolagem rolagem = new Rolagem();
        add(rolagem.rolagem, BorderLayout.CENTER);

        // Organização do painel em grid
        painelConteudo = new JPanel(new GridBagLayout());
        painelConteudo.setOpaque(false);
        painelConteudo.setAlignmentX(Component.LEFT_ALIGNMENT);
        rolagem.conteudo.add(painelConteudo);

        // estruturação do grid
        gbc = new GridBagConstraints();
        gbc.gridx = 0;                
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL; 
        gbc.weightx = 1.0;   
    }

    public void addPainel(JPanel painel){
        gbc.gridy = this.qtdElemento;
        this.painelConteudo.add(painel, gbc);
        this.qtdElemento += 1;
    }
}
