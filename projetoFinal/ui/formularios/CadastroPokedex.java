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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CadastroPokedex extends JPanel{
    private List<Pokemon> pokemons;
    private List<Pokemon> pokemonsAnte;
    private List<Pokemon> pokemonsProx;
    private List<Jogo> jogos;
    private List<Regiao> regioes;

    private CampoSelect campoPokemon;
    private CampoSelect campoAnterior;
    private CampoSelect campoProximo;
    private CampoSelect campoJogo;
    private CampoSelect campoRegiao;

    public void carregarListas(){
        this.jogos = ServicosJogo.listar();
        this.pokemons = ServicosPokemon.listar();
        this.pokemonsAnte = ServicosPokemon.listar();
        this.pokemonsProx = ServicosPokemon.listar();
        this.regioes = ServicosRegiao.listar();
    }

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

    public CadastroPokedex() {
        carregarListas();
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
        formulario.add(campoJogo, gbc);

        gbc.gridy = 1;
        campoRegiao = new CampoSelect("Região:");
        for (Regiao r : regioes) campoRegiao.addOpcao(r.getId(), r.getNome());
        formulario.add(campoRegiao, gbc);

        gbc.gridy = 2;
        campoPokemon = new CampoSelect("Pokemon:");
        for (Pokemon p : pokemons) campoPokemon.addOpcao(p.getId(), p.getNome());
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
        campoAnterior = new CampoSelect("Pokemon Anterior:");
        for (Pokemon p : pokemonsAnte) campoAnterior.addOpcao(p.getId(), p.getNome());
        formulario.add(campoAnterior, gbc);

        gbc.gridy = 7;
        campoProximo = new CampoSelect("Proximo Pokemon:");
        for (Pokemon p : pokemonsProx) campoProximo.addOpcao(p.getId(), p.getNome());
        formulario.add(campoProximo, gbc);
        
        campoAnterior.setOnChange(new AoMudar() {public void mudou(Long id) {mudancaOrdemPokedex();}});
        campoProximo.setOnChange(new AoMudar() {public void mudou(Long id) {mudancaOrdemPokedex();}});
        campoPokemon.setOnChange(new AoMudar() {public void mudou(Long id) {mudancaOrdemPokedex();}});

        gbc.gridy = 8;
        BotaoSalvar btSalvar = new BotaoSalvar();
        formulario.add(btSalvar, gbc); 
        btSalvar.addActionListener(e ->{
            Pokedex px = new Pokedex();
            if(campoJogo.temValor() && campoRegiao.temValor() && campoPokemon.temValor() &&  campoNumero.temTexto() && campoDescricao.temTexto() &&
               campoCor.temCorSelecionada())
            {
                px.setIdJogo(campoJogo.getValorSelecionado());
                px.setIdPokemon(campoPokemon.getValorSelecionado());
                px.setIdRegiao(campoRegiao.getValorSelecionado());
                px.setDescricaoPokemon(campoDescricao.getValor());
                px.setNumeroPokemon(campoNumero.getInt());
                px.setCor(campoCor.getCorSelecionadaHex());
                px.setIdProximo(campoAnterior.getValorSelecionado());
                px.setIdAnterior(campoProximo.getValorSelecionado());
                ServicosPokedex.criar(px);
                ModalSucesso.ExibirModal("Sucesso ao criar Pokedex!");
                campoJogo.limpar();
                campoRegiao.limpar();
                campoPokemon.limpar();
                campoNumero.limpar();
                campoDescricao.limparValor();
                campoCor.limpar();
                campoAnterior.limpar();
                campoProximo.limpar();
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
            }
            
        });
        add(rolagem.rolagem, BorderLayout.CENTER);
    }
}
