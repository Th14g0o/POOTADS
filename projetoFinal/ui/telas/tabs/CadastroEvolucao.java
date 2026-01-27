package projetoFinal.ui.telas.tabs;

import java.awt.*;
import javax.swing.*;
import projetoFinal.ui.componentes.BotaoSalvar;
import projetoFinal.ui.componentes.CampoNumero;
import projetoFinal.ui.componentes.CampoSelect;

public class CadastroEvolucao extends JPanel{
    public CadastroEvolucao() {
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
        CampoSelect campoNome = new CampoSelect("Pokemon:");
        formulario.add(campoNome, gbc);

        gbc.gridy = 1;
        CampoNumero campoEstagio = new CampoNumero("Estagio:");
        formulario.add(campoEstagio, gbc);

        gbc.gridy = 2;
        CampoSelect campoEvolucao = new CampoSelect("Pokemon Evolução:");
        formulario.add(campoEvolucao, gbc);

        gbc.gridy = 3;
        BotaoSalvar btSalvar = new BotaoSalvar();
        formulario.add(btSalvar, gbc); 
    }
}
