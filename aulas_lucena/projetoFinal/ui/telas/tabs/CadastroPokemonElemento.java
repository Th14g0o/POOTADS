package aulas_lucena.projetoFinal.ui.telas.tabs;

import java.awt.*;
import javax.swing.*;
import aulas_lucena.projetoFinal.ui.componentes.BotaoSalvar;
import aulas_lucena.projetoFinal.ui.componentes.CampoSelect;

public class CadastroPokemonElemento extends JPanel{
    public CadastroPokemonElemento() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        setOpaque(false);

        // Organização do form em grid
        JPanel formulario = new JPanel(new GridBagLayout());
        formulario.setOpaque(false);
        add(formulario);

        // criação do grid
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        CampoSelect campoPokemon = new CampoSelect("Pokemon:");
        formulario.add(campoPokemon, gbc);

        gbc.gridy = 1;
        CampoSelect campoElemento = new CampoSelect("Elemento:");
        formulario.add(campoElemento, gbc);

        gbc.gridy = 2;
        BotaoSalvar btSalvar = new BotaoSalvar();
        formulario.add(btSalvar, gbc); 
    }
}
