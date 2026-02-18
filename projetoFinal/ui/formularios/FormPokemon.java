package projetoFinal.ui.formularios;

import projetoFinal.logica.modelos.Pokemon;
import projetoFinal.logica.servicos.ServicosPokemon;
import projetoFinal.ui.componentes.ModalErro;
import projetoFinal.ui.componentes.ModalSucesso;
import projetoFinal.ui.componentes.botoes.BotaoSalvar;
import projetoFinal.ui.componentes.campos.CampoImagem;
import projetoFinal.ui.componentes.campos.CampoTexto;
import projetoFinal.ui.formularios.abstracao.FormModelo;

import java.awt.*;
import javax.swing.*;

public class FormPokemon extends FormModelo<Pokemon>{
    private CampoTexto campoNome;
    private CampoImagem campoFoto;

    public void recarregarConteudos(){
        
    };

    public void carregarForm(boolean ehCadastro, Pokemon p){
        setTipo(ehCadastro);
        setModelo(p);
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
        campoNome = new CampoTexto("Nome:");
        if (!this.ehCadastro && this.obj != null) campoNome.setValor(this.obj.getNome());
        formulario.add(campoNome, gbc);

        gbc.gridy = 1;
        campoFoto = new CampoImagem("Imagem do Pokemon:");
        if (!this.ehCadastro && this.obj != null) campoFoto.setImagem(this.obj.getImagem());
        formulario.add(campoFoto, gbc);

        gbc.gridy = 2;
        btSalvar = new BotaoSalvar();
        btSalvar.addActionListener(e ->{
           salvar();            
        });
        formulario.add(btSalvar, gbc); 
    }

    public boolean salvar(){
        Pokemon poke = new Pokemon();
        if(campoNome.temTexto())
        {
            poke.setNome(campoNome.getValor());
            poke.setImagem(campoFoto.getByteImagem());
            if (!this.ehCadastro && this.obj != null){
                poke.setId(this.obj.getId());
                ServicosPokemon.atualizar(poke);
            } else {
                ServicosPokemon.criar(poke);
            }
            ModalSucesso.ExibirModal("Sucesso ao " + (this.ehCadastro ? "criar" : "atualizar") + " Pokemon!");
            if (ehCadastro){
                campoNome.limparValor();
                campoFoto.limpar();
            }   
            return true;
        }
        else{
            ModalErro.ExibirModal("Faltou preencher o nome do Pokemon.");
            return false;
        } 
    }

    public FormPokemon(){ this.carregarForm(true, null); }
    public FormPokemon(boolean ehCadastro){ this.carregarForm(ehCadastro, null); }
    public FormPokemon(boolean ehCadastro, Pokemon p){ this.carregarForm(ehCadastro, p); }
    
}
