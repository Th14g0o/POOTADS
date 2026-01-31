package projetoFinal.ui.formularios;

import java.awt.*;
import javax.swing.*;
import projetoFinal.ui.componentes.botoes.BotaoSalvar;
import projetoFinal.ui.componentes.campos.CampoAreaTexto;
import projetoFinal.ui.componentes.campos.CampoNumero;
import projetoFinal.ui.componentes.campos.CampoSelecionaCor;
import projetoFinal.ui.componentes.campos.CampoSelect;
import projetoFinal.ui.componentes.tab.Rolagem;
public class CadastroPokedex extends JPanel{
    public CadastroPokedex() {
        setLayout(new BorderLayout()); 
        setOpaque(false);

        Rolagem rolagem = new Rolagem();

        // Organização do form em grid
        JPanel formulario = new JPanel(new GridBagLayout());
        formulario.setOpaque(false);
        formulario.setAlignmentX(Component.LEFT_ALIGNMENT);
        rolagem.conteudo.add(formulario);

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
        CampoNumero campoNumero = new CampoNumero("Número:");
        formulario.add(campoNumero, gbc);

        gbc.gridy = 4;
        CampoAreaTexto campoDescricao = new CampoAreaTexto("Descrição:");
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
        
        add(rolagem.rolagem, BorderLayout.CENTER);
    }
}
