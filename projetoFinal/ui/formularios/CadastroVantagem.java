package projetoFinal.ui.formularios;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import projetoFinal.ui.componentes.botoes.BotaoSalvar;
import projetoFinal.ui.componentes.campos.CampoGrupoRadio;
import projetoFinal.ui.componentes.campos.CampoNumero;
import projetoFinal.ui.componentes.campos.CampoSelect;
import projetoFinal.ui.util.Enuns.TipoNumero;

public class CadastroVantagem extends JPanel{
    public CadastroVantagem() {
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
        CampoSelect campoElementoAlvo  = new CampoSelect("Elemento alvo:");
        formulario.add(campoElementoAlvo, gbc);

        gbc.gridy = 1;
        CampoSelect campoElementoVantagemDesvantagem  = new CampoSelect("Elemento vantagem/desvantagem:");
        formulario.add(campoElementoVantagemDesvantagem, gbc);

        gbc.gridy = 2;
        CampoGrupoRadio radioVantagem = new CampoGrupoRadio(List.of("Vantagem", "Desvantagem"));
        formulario.add(radioVantagem, gbc);

        gbc.gridy = 3;
        CampoNumero campoNome = new CampoNumero("Multiplicador:", 7, TipoNumero.DOUBLE);
        formulario.add(campoNome, gbc);

        gbc.gridy = 5;
        BotaoSalvar btSalvar = new BotaoSalvar();
        btSalvar.addActionListener(e -> {});
        formulario.add(btSalvar, gbc);
    }
}
