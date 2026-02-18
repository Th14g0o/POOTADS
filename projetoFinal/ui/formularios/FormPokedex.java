package projetoFinal.ui.formularios;

import java.awt.*;
import javax.swing.*;
import projetoFinal.logica.modelos.Jogo;
import projetoFinal.logica.modelos.Pokedex;
import projetoFinal.logica.modelos.Pokemon;
import projetoFinal.logica.modelos.Regiao;
import projetoFinal.logica.servicos.ServicosJogo;
import projetoFinal.logica.servicos.ServicosPokedex;
import projetoFinal.logica.servicos.ServicosPokemon;
import projetoFinal.logica.servicos.ServicosRegiao;
import projetoFinal.ui.componentes.ModalErro;
import projetoFinal.ui.componentes.ModalSucesso;
import projetoFinal.ui.componentes.botoes.BotaoSalvar;
import projetoFinal.ui.componentes.campos.CampoAreaTexto;
import projetoFinal.ui.componentes.campos.CampoNumero;
import projetoFinal.ui.componentes.campos.CampoSelecionaCor;
import projetoFinal.ui.componentes.campos.CampoSelect;
import projetoFinal.ui.interfaces.AoMudar;
import projetoFinal.ui.componentes.tab.Rolagem;
import projetoFinal.ui.formularios.abstracao.FormModelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormPokedex extends FormModelo<Pokedex>{
    private CampoSelect campoPokemon;
    private CampoSelect campoAnterior;
    private CampoSelect campoProximo;
    private CampoSelect campoJogo;
    private CampoSelect campoRegiao;
    private CampoNumero campoNumero;
    private CampoAreaTexto campoDescricao;
    private CampoSelecionaCor campoCor;
    
    private List<Pokemon> pokemons;
    private List<Pokemon> pokemonsAnte;
    private List<Pokemon> pokemonsProx;
    private List<Jogo> jogos;
    private List<Regiao> regioes;

    public void carregarListas(){
        this.jogos = ServicosJogo.listar();
        this.pokemons = ServicosPokemon.listar();
        this.pokemonsAnte = ServicosPokemon.listar();
        this.pokemonsProx = ServicosPokemon.listar();
        this.regioes = ServicosRegiao.listar();
    }

    public void recarregarConteudos(){
        recarregarListas();
    };



    public void recarregarListas(){
        this.jogos = ServicosJogo.listar();
        this.pokemons = ServicosPokemon.listar();
        this.pokemonsAnte = ServicosPokemon.listar();
        this.pokemonsProx = ServicosPokemon.listar();
        this.regioes = ServicosRegiao.listar();

        this.campoPokemon.limpar();
        this.campoAnterior.limpar();
        this.campoProximo.limpar();
        this.campoJogo.limpar();
        this.campoRegiao.limpar();

        for (Jogo j : jogos) campoJogo.addOpcao(j.getId(), j.getNome());
        for (Regiao r : regioes) campoRegiao.addOpcao(r.getId(), r.getNome());
        for (Pokemon p : pokemons) campoPokemon.addOpcao(p.getId(), p.getNome());
        for (Pokemon p : pokemonsAnte) campoAnterior.addOpcao(p.getId(), p.getNome());
        for (Pokemon p : pokemonsProx) campoProximo.addOpcao(p.getId(), p.getNome());
    }
    private void mudancaOrdemPokedex(){
        Long idPoke = campoPokemon.getValorSelecionado();
        Long idAnte = campoAnterior.getValorSelecionado();
        Long idProx = campoProximo.getValorSelecionado();

        campoProximo.filtrarIdDiferentes(new ArrayList<>(Arrays.asList(idPoke, idAnte)));
        campoAnterior.filtrarIdDiferentes(new ArrayList<>(Arrays.asList(idPoke, idProx)));
    }
    
    public void carregarForm(boolean ehCadastro, Pokedex dto){
        this.carregarListas();
        setTipo(ehCadastro);
        setModelo(dto);

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
        campoJogo = new CampoSelect("Jogo:");
        for (Jogo j : jogos) campoJogo.addOpcao(j.getId(), j.getNome());
        if (!this.ehCadastro && this.obj != null && this.obj != null) campoJogo.selecionar(this.obj.getIdJogo());
        formulario.add(campoJogo, gbc);

        gbc.gridy = 1;
        campoRegiao = new CampoSelect("Região:");
        for (Regiao r : regioes) campoRegiao.addOpcao(r.getId(), r.getNome());
        if (!this.ehCadastro && this.obj != null && this.obj != null) campoRegiao.selecionar(this.obj.getIdRegiao());
        formulario.add(campoRegiao, gbc);

        gbc.gridy = 2;
        campoPokemon = new CampoSelect("Pokemon:");
        for (Pokemon p : pokemons) campoPokemon.addOpcao(p.getId(), p.getNome());
        if (!this.ehCadastro && this.obj != null && this.obj != null) campoPokemon.selecionar(this.obj.getIdPokemon());
        formulario.add(campoPokemon, gbc);

        gbc.gridy = 3;
        campoNumero = new CampoNumero("Número:");
        if (!this.ehCadastro && this.obj != null && this.obj != null) campoNumero.setValor(this.obj.getNumeroPokemon());
        formulario.add(campoNumero, gbc);

        gbc.gridy = 4;
        campoDescricao = new CampoAreaTexto("Descrição:");
        if (!this.ehCadastro && this.obj != null && this.obj != null) campoDescricao.setValor(this.obj.getDescricaoPokemon());
        formulario.add(campoDescricao, gbc);

        gbc.gridy = 5;
        campoCor = new CampoSelecionaCor("Selecione a cor representante:");
        if (!this.ehCadastro && this.obj != null && this.obj != null) campoCor.setCorHex(this.obj.getCor());
        formulario.add(campoCor, gbc);

        gbc.gridy = 6;
        campoAnterior = new CampoSelect("Pokemon Anterior:");
        for (Pokemon p : pokemonsAnte) campoAnterior.addOpcao(p.getId(), p.getNome());
        if (!this.ehCadastro && this.obj != null && this.obj != null) campoAnterior.selecionar(this.obj.getIdAnterior());
        formulario.add(campoAnterior, gbc);

        gbc.gridy = 7;
        campoProximo = new CampoSelect("Proximo Pokemon:");
        for (Pokemon p : pokemonsProx) campoProximo.addOpcao(p.getId(), p.getNome());
        if (!this.ehCadastro && this.obj != null && this.obj != null) campoProximo.selecionar(this.obj.getIdProximo());
        formulario.add(campoProximo, gbc);
        
        campoAnterior.setOnChange(new AoMudar() {public void mudou(Long id) {mudancaOrdemPokedex();}});
        campoProximo.setOnChange(new AoMudar() {public void mudou(Long id) {mudancaOrdemPokedex();}});
        campoPokemon.setOnChange(new AoMudar() {public void mudou(Long id) {mudancaOrdemPokedex();}});

        gbc.gridy = 8;
        btSalvar = new BotaoSalvar();
        formulario.add(btSalvar, gbc); 
        btSalvar.addActionListener(e ->{
            salvar();
        });
        add(rolagem.rolagem, BorderLayout.CENTER);
    }

    public boolean salvar(){
        Pokedex novo = new Pokedex();
        if(campoJogo.temValor() && campoRegiao.temValor() && campoPokemon.temValor() &&  campoNumero.temTexto() && campoDescricao.temTexto() &&
            campoCor.temCorSelecionada())
        {
            novo.setIdJogo(campoJogo.getValorSelecionado());
            novo.setIdPokemon(campoPokemon.getValorSelecionado());
            novo.setIdRegiao(campoRegiao.getValorSelecionado());
            novo.setDescricaoPokemon(campoDescricao.getValor());
            novo.setNumeroPokemon(campoNumero.getInt());
            novo.setCor(campoCor.getCorSelecionadaHex());
            novo.setIdProximo(campoAnterior.getValorSelecionado());
            novo.setIdAnterior(campoProximo.getValorSelecionado());
            if (!this.ehCadastro && this.obj != null && this.obj != null){
                novo.setId(this.obj.getId());
                ServicosPokedex.atualizar(novo);
            } else {
                ServicosPokedex.criar(novo);
            }
            ModalSucesso.ExibirModal("Sucesso ao " + (this.ehCadastro ? "criar" : "atualizar") + " Pokedex!");
            if (ehCadastro){
                campoJogo.limpar();
                campoRegiao.limpar();
                campoPokemon.limpar();
                campoNumero.limpar();
                campoDescricao.limparValor();
                campoCor.limpar();
                campoAnterior.limpar();
                campoProximo.limpar();
            }
            return true;
        }
        else{
            String erros = "";
            if (!campoJogo.temValor()) 
                erros = erros + "o Jogo"; 
            if (!campoRegiao.temValor()) 
                erros = erros + (erros.length() > 0 ? ", " : "") + "a Região"; 
            if (!campoPokemon.temValor()) 
                erros = erros + (erros.length() > 0 ? ", " : "") + "o Pokemon "; 
            if (!campoNumero.temTexto()) 
                erros = erros + (erros.length() > 0 ? ", " : "") + "o Numero na Pokedex"; 
            if (!campoDescricao.temTexto()) 
                erros = erros + (erros.length() > 0 ? ", " : "") + "a Descrição";
            if (!campoCor.temCorSelecionada()) 
                erros = erros + (erros.length() > 0 ? ", " : "") + "a Cor";
            ModalErro.ExibirModal("Faltou preencher " + erros + " da Pokedex.");
            return false;
        }
    }

    public FormPokedex(){ carregarForm(true, null); }
    public FormPokedex(boolean ehCadastro){ carregarForm(ehCadastro, null); }
    public FormPokedex(boolean ehCadastro, Pokedex px){ carregarForm(ehCadastro, px); }
}
