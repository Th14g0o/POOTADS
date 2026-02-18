package projetoFinal.ui.formularios;

import java.awt.*;
import javax.swing.*;

import projetoFinal.logica.modelos.Elemento;
import projetoFinal.logica.modelos.Jogo;
import projetoFinal.logica.modelos.Pokemon;
import projetoFinal.logica.modelos.PokemonElemento;
import projetoFinal.logica.servicos.ServicosElemento;
import projetoFinal.logica.servicos.ServicosJogo;
import projetoFinal.logica.servicos.ServicosPokemon;
import projetoFinal.ui.componentes.ModalErro;
import projetoFinal.ui.componentes.ModalSucesso;
import projetoFinal.ui.componentes.botoes.BotaoSalvar;
import projetoFinal.ui.componentes.campos.CampoSelect;
import projetoFinal.ui.formularios.abstracao.FormModelo;

import java.util.List;

public class FormPokemonElemento extends FormModelo<PokemonElemento>{
    private CampoSelect campoPokemon;
    private CampoSelect campoJogo;
    private CampoSelect campoElemento;
    
    private List<Pokemon> pokemons;
    private List<Jogo> jogos;
    private List<Elemento> elementos;

    private void carregarListas(){
        this.jogos = ServicosJogo.listar();
        this.elementos = ServicosElemento.listar();
        this.pokemons = ServicosPokemon.listar();
    }

    public void recarregarConteudos(){
        recarregarListas();
    };

    public void recarregarListas(){
        this.jogos = ServicosJogo.listar();
        this.elementos = ServicosElemento.listar();
        this.pokemons = ServicosPokemon.listar();

        campoPokemon.limpar();
        campoJogo.limpar();
        campoElemento.limpar();

        for (Pokemon p : pokemons) campoPokemon.addOpcao(p.getId(), p.getNome());
        for (Elemento e : elementos) campoElemento.addOpcao(e.getId(), e.getNome());
        for (Jogo j : jogos) campoJogo.addOpcao(j.getId(), j.getNome());
    }

    public void carregarForm(boolean ehCadastro, PokemonElemento modelo){
        this.carregarListas();
        setTipo(ehCadastro);
        setModelo(modelo);
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
        campoPokemon = new CampoSelect("Pokemon:");
        for (Pokemon p : pokemons) campoPokemon.addOpcao(p.getId(), p.getNome());
        if (!this.ehCadastro && this.obj != null) campoPokemon.selecionar(this.obj.getIdPokemon());
        formulario.add(campoPokemon, gbc);

        gbc.gridy = 1;
        campoElemento = new CampoSelect("Elemento:");
        for (Elemento e : elementos) campoElemento.addOpcao(e.getId(), e.getNome());
        if (!this.ehCadastro && this.obj != null) campoElemento.selecionar(this.obj.getIdElemento());
        formulario.add(campoElemento, gbc);

        gbc.gridy = 2;
        campoJogo = new CampoSelect("Jogo:");
        for (Jogo j : jogos) campoJogo.addOpcao(j.getId(), j.getNome());
        if (!this.ehCadastro && this.obj != null) campoJogo.selecionar(this.obj.getIdJogo());
        formulario.add(campoJogo, gbc);

        gbc.gridy = 3;
        btSalvar = new BotaoSalvar();
        btSalvar.addActionListener(e ->{
            salvar();            
        });
        formulario.add(btSalvar, gbc); 
    }

    public boolean salvar(){
        PokemonElemento pe = new PokemonElemento();
        if(campoPokemon.temValor() &&  campoElemento.temValor() && campoJogo.temValor())
        {
            pe.setIdElemento(campoElemento.getValorSelecionado());
            pe.setIdPokemon(campoPokemon.getValorSelecionado());
            pe.setIdJogo(campoJogo.getValorSelecionado());
            if (!this.ehCadastro && this.obj != null){
                pe.setId(this.obj.getId());
                ServicosPokemon.atualizarElemento(pe);
            } else {
                ServicosPokemon.adicionarElemento(pe);
            }
            ModalSucesso.ExibirModal("Sucesso ao " + (this.ehCadastro ? "criar" : "atualizar") + " Elemento do Pokemon!");
            if (ehCadastro){
                campoPokemon.limpar();
                campoElemento.limpar();
                campoJogo.limpar();
            }
            return true;
        }
        else{
            String erros = "";
            if (!campoJogo.temValor()) 
                erros = erros + "o Jogo"; 
            if (!campoPokemon.temValor()) 
                erros = erros + (erros.length() > 0 ? ", " : "") + "o pokemon"; 
            if (!campoElemento.temValor()) 
                erros = erros + (erros.length() > 0 ? ", " : "") + "o elemento";  
            ModalErro.ExibirModal("Faltou preencher " + erros + " do Elemento do Pokemon.");
            return false;
        }
    }

    public FormPokemonElemento(){ this.carregarForm(true, null); }
    public FormPokemonElemento(boolean ehCadastro){ this.carregarForm(ehCadastro, null); }
    public FormPokemonElemento(boolean ehCadastro, PokemonElemento pe){ this.carregarForm(ehCadastro, pe); }
}
