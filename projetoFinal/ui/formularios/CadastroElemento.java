package projetoFinal.ui.formularios;

import java.awt.*;
import javax.swing.*;

import projetoFinal.ui.componentes.botoes.BotaoSalvar;
import projetoFinal.ui.componentes.campos.CampoImagem;
import projetoFinal.ui.componentes.campos.CampoSelecionaCor;
import projetoFinal.ui.componentes.campos.CampoTexto;

public class CadastroElemento extends JPanel{
    public CadastroElemento() {
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
        CampoTexto campoNome = new CampoTexto("Nome:");
        formulario.add(campoNome, gbc);

        gbc.gridy = 1;
        CampoImagem campoFoto = new CampoImagem("Imagem do Jogo:");
        formulario.add(campoFoto, gbc);

        gbc.gridy = 2;
        CampoSelecionaCor campoCor = new CampoSelecionaCor("Selecione a cor representante:");
        formulario.add(campoCor, gbc);

        gbc.gridy = 3;
        BotaoSalvar btSalvar = new BotaoSalvar();
        formulario.add(btSalvar, gbc); 
    }
}
