package aulas_lucena.projetoFinal.ui.telas.tabs;

import java.awt.*;
import javax.swing.*;
import aulas_lucena.projetoFinal.ui.componentes.BotaoSalvar;
import aulas_lucena.projetoFinal.ui.componentes.CampoAreaTexto;
import aulas_lucena.projetoFinal.ui.componentes.CampoSelecionaCor;
import aulas_lucena.projetoFinal.ui.componentes.CampoSelect;
import aulas_lucena.projetoFinal.ui.componentes.CampoTexto;
import aulas_lucena.projetoFinal.ui.util.Cores;
import aulas_lucena.projetoFinal.ui.util.Utils;

public class CadastroPokedex extends JPanel{
    public CadastroPokedex() {
        setLayout(new BorderLayout()); 
        setOpaque(false);

        JPanel alinhamento = new JPanel();
        alinhamento.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        alinhamento.setOpaque(false);

        // Organização do form em grid
        JPanel formulario = new JPanel(new GridBagLayout());
        formulario.setOpaque(false);
        formulario.setAlignmentX(Component.LEFT_ALIGNMENT);
        alinhamento.add(formulario);

        // criação do grid
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        CampoSelect campoJogo = new CampoSelect("Jogo:");
        formulario.add(campoJogo, gbc);

        gbc.gridy = 1;
        CampoSelect campoRegiao = new CampoSelect("Região:");
        formulario.add(campoRegiao, gbc);

        gbc.gridy = 2;
        CampoSelect campoPokemon = new CampoSelect("Pokemon:");
        formulario.add(campoPokemon, gbc);

        gbc.gridy = 3;
        CampoTexto campoNumero = new CampoTexto("Número:");
        formulario.add(campoNumero, gbc);

        gbc.gridy = 4;
        CampoAreaTexto campoDescricao = new CampoAreaTexto("Número:");
        formulario.add(campoDescricao, gbc);

        gbc.gridy = 5;
        CampoSelecionaCor campoCor = new CampoSelecionaCor("Selecione a cor representante:");
        formulario.add(campoCor, gbc);

        gbc.gridy = 6;
        CampoSelect campoAnterior = new CampoSelect("Pokemon Anterior:");
        formulario.add(campoAnterior, gbc);

        gbc.gridy = 7;
        CampoSelect campoProximo = new CampoSelect("Proximo Pokemon:");
        formulario.add(campoProximo, gbc);

        gbc.gridy = 8;
        BotaoSalvar btSalvar = new BotaoSalvar();
        formulario.add(btSalvar, gbc); 

        JScrollPane scrollPane = new JScrollPane(alinhamento);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setOpaque(false);
        scrollPane.setBackground(Cores.TRANSPARENTE);
        //Utils.aplicarTema(scrollPane, Cores.TRANSPARENTE, Color.WHITE);

        add(scrollPane, BorderLayout.CENTER);
    }
}
