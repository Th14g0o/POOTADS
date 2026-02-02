package projetoFinal.ui.formularios;

import projetoFinal.logica.modelos.Pokemon;
import projetoFinal.logica.servicos.ServicosPokemon;
import projetoFinal.ui.componentes.ModalErro;
import projetoFinal.ui.componentes.ModalSucesso;
import projetoFinal.ui.componentes.botoes.BotaoSalvar;
import projetoFinal.ui.componentes.campos.CampoImagem;
import projetoFinal.ui.componentes.campos.CampoTexto;

import java.awt.*;
import javax.swing.*;

public class CadastroPokemon extends JPanel{
    public CadastroPokemon() {
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
        CampoImagem campoFoto = new CampoImagem("Imagem do Pokemon:");
        formulario.add(campoFoto, gbc);

        gbc.gridy = 2;
        BotaoSalvar btSalvar = new BotaoSalvar();
        btSalvar.addActionListener(e ->{
            Pokemon poke = new Pokemon();
            if(campoNome.temTexto())
            {
                poke.setNome(campoNome.getValor());
                poke.setImagem(campoFoto.getByteImagem());
                ServicosPokemon.criar(poke);
                ModalSucesso.ExibirModal("Sucesso ao criar Pokemon!");
                campoNome.limparValor();
                campoFoto.limpar();
            }
            else{
                ModalErro.ExibirModal("Faltou preencher o nome do Pokemon.");
            }
            
        });
        formulario.add(btSalvar, gbc); 
    }
    
}
