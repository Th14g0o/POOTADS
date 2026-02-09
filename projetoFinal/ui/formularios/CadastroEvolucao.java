package projetoFinal.ui.formularios;

import java.awt.*;
import javax.swing.*;
import projetoFinal.logica.modelos.Evolucao;
import projetoFinal.logica.modelos.Jogo;
import projetoFinal.logica.modelos.Pokemon;
import projetoFinal.logica.servicos.ServicosJogo;
import projetoFinal.logica.servicos.ServicosPokemon;
import projetoFinal.ui.componentes.ModalErro;
import projetoFinal.ui.componentes.ModalSucesso;
import projetoFinal.ui.componentes.botoes.BotaoSalvar;
import projetoFinal.ui.componentes.campos.CampoAreaTexto;
import projetoFinal.ui.componentes.campos.CampoNumero;
import projetoFinal.ui.componentes.campos.CampoSelect;
import projetoFinal.ui.componentes.tab.Rolagem;
import projetoFinal.ui.interfaces.AoMudar;
import java.util.List;

public class CadastroEvolucao extends JPanel{
    private List<Pokemon> pokemons;
    private List<Pokemon> evolucoes;
    private List<Jogo> jogos;
    private CampoSelect campoNome;
    private CampoSelect campoEvolucao;
    private CampoSelect campoJogo;

    private void carregarListas(){
        this.pokemons = ServicosPokemon.listar();
        this.evolucoes = ServicosPokemon.listar();
        this.jogos = ServicosJogo.listar();
    }

    public void recarregarListas(){
        this.pokemons = ServicosPokemon.listar();
        this.evolucoes = ServicosPokemon.listar();
        this.jogos = ServicosJogo.listar();

        campoNome.limpar();
        campoEvolucao.limpar();
        campoJogo.limpar();

        for (Pokemon p : pokemons) campoNome.addOpcao(p.getId(), p.getNome());
        for (Pokemon e : evolucoes) campoEvolucao.addOpcao(e.getId(), e.getNome());
        for (Jogo j : jogos) campoJogo.addOpcao(j.getId(), j.getNome());
    }

    public CadastroEvolucao() {
        this.carregarListas();
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
        campoNome = new CampoSelect("Pokemon:");
        for (Pokemon p : pokemons) campoNome.addOpcao(p.getId(), p.getNome());
        formulario.add(campoNome, gbc);

        gbc.gridy = 1;
        CampoNumero campoEstagio = new CampoNumero("Estagio:");
        formulario.add(campoEstagio, gbc);

        gbc.gridy = 2;
        CampoAreaTexto campoRequisitos = new CampoAreaTexto("Requisitos:");
        formulario.add(campoRequisitos, gbc);

        gbc.gridy = 3;
        campoEvolucao = new CampoSelect("Pokemon Evolução:");
        for (Pokemon e : evolucoes) campoEvolucao.addOpcao(e.getId(), e.getNome());
        formulario.add(campoEvolucao, gbc);

        campoNome.setOnChange(new AoMudar() {public void mudou(Long id) {campoEvolucao.filtrarIdDiferentes(id);}});
        campoEvolucao.setOnChange(new AoMudar() {public void mudou(Long id) {campoNome.filtrarIdDiferentes(id);}});

        gbc.gridy = 4;
        CampoNumero campoEstagioEV = new CampoNumero("Estagio Evolução:");
        formulario.add(campoEstagioEV, gbc);

        gbc.gridy = 5;
        campoJogo = new CampoSelect("Jogo:");
        for (Jogo j : jogos) campoJogo.addOpcao(j.getId(), j.getNome());
        formulario.add(campoJogo, gbc);

        gbc.gridy = 6;
        BotaoSalvar btSalvar = new BotaoSalvar();
        formulario.add(btSalvar, gbc); 
        btSalvar.addActionListener(e ->{
            Evolucao ev = new Evolucao();
            if(campoRequisitos.temTexto() && campoEstagio.temTexto() &&  campoEvolucao.temValor() && campoNome.temValor() &&
            campoJogo.temValor() && campoEstagioEV.temTexto())
            {
                ev.setEstagio(campoEstagio.getInt());
                ev.setEvolucaoId(campoEvolucao.getValorSelecionado());
                ev.setPokemonId(campoNome.getValorSelecionado());
                ev.setRequisitos(campoRequisitos.getValor());
                ev.setIdJogo(campoJogo.getValorSelecionado());
                ev.setEstagioEvolucao(campoEstagioEV.getInt());
                ServicosPokemon.adicionarEvolucao(ev);
                ModalSucesso.ExibirModal("Sucesso ao criar Evolução!");
                campoRequisitos.limparValor();
                campoEstagio.limpar();
                campoEvolucao.limpar();
                campoNome.limpar();
            }
            else{
                String erros = "";
                if (!campoRequisitos.temTexto()) 
                    erros = erros + "o(s) requisito(s)"; 
                if (!campoEstagio.temTexto()) 
                    erros = erros + (erros.length() > 0 ? ", " : "") + "o estagio"; 
                if (!campoEvolucao.temValor()) 
                    erros = erros + (erros.length() > 0 ? ", " : "") + "o pokemon evolução"; 
                if (!campoNome.temValor()) 
                    erros = erros + (erros.length() > 0 ? ", " : "") + "o pokemon que tem evolução"; 
                if (!campoJogo.temValor()) 
                    erros = erros + (erros.length() > 0 ? ", " : "") + "o campo de jogo"; 
                if (!campoEstagioEV.temTexto()) 
                    erros = erros + (erros.length() > 0 ? ", " : "") + "o estafio da evolução"; 
                ModalErro.ExibirModal("Faltou preencher " + erros + " da Evolução.");
            }
            
        });
        add(rolagem.rolagem, BorderLayout.CENTER);
    }
}
