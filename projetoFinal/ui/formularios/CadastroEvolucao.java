package projetoFinal.ui.formularios;

import java.awt.*;
import javax.swing.*;
import projetoFinal.logica.modelos.Evolucao;
import projetoFinal.logica.modelos.Pokemon;
import projetoFinal.logica.servicos.ServicosPokemon;
import projetoFinal.ui.componentes.ModalErro;
import projetoFinal.ui.componentes.ModalSucesso;
import projetoFinal.ui.componentes.botoes.BotaoSalvar;
import projetoFinal.ui.componentes.campos.CampoAreaTexto;
import projetoFinal.ui.componentes.campos.CampoNumero;
import projetoFinal.ui.componentes.campos.CampoSelect;
import projetoFinal.ui.componentes.campos.CampoSelect.AoMudar;
import java.util.List;

public class CadastroEvolucao extends JPanel{
    private List<Pokemon> pokemons;
    private List<Pokemon> evolucoes;

    private void carregarListas(){
        this.pokemons = ServicosPokemon.listar();
        this.evolucoes = ServicosPokemon.listar();
    }
    public CadastroEvolucao() {
        this.carregarListas();
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
        CampoSelect campoNome = new CampoSelect("Pokemon:");
        for (Pokemon p : pokemons) campoNome.addOpcao(p.getId(), p.getNome());
        formulario.add(campoNome, gbc);

        gbc.gridy = 1;
        CampoNumero campoEstagio = new CampoNumero("Estagio:");
        formulario.add(campoEstagio, gbc);

        gbc.gridy = 2;
        CampoAreaTexto campoRequisitos = new CampoAreaTexto("Requisitos:");
        formulario.add(campoRequisitos, gbc);

        gbc.gridy = 3;
        CampoSelect campoEvolucao = new CampoSelect("Pokemon Evolução:");
        for (Pokemon e : evolucoes) campoEvolucao.addOpcao(e.getId(), e.getNome());
        formulario.add(campoEvolucao, gbc);

        campoNome.setOnChange(new AoMudar() {public void mudou(Long id) {campoEvolucao.filtrarIdDiferentes(id);}});
        campoEvolucao.setOnChange(new AoMudar() {public void mudou(Long id) {campoNome.filtrarIdDiferentes(id);}});

        gbc.gridy = 4;
        BotaoSalvar btSalvar = new BotaoSalvar();
        btSalvar.addActionListener(e ->{
            Evolucao ev = new Evolucao();
            if(campoRequisitos.temTexto() && campoEstagio.temTexto() &&  campoEvolucao.temValor() && campoNome.temValor())
            {
                ev.setEstagio(campoEstagio.getInt());
                ev.setEvolucaoId(campoEvolucao.getValorSelecionado());
                ev.setPokemonId(campoNome.getValorSelecionado());
                ev.setRequisitos(campoRequisitos.getValor());
                ServicosPokemon.adicionarEvolucao(ev);
                ModalSucesso.ExibirModal("Sucesso ao criar Evolução");
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
                ModalErro.ExibirModal("Faltou preencher " + erros + " da Evolução.");
            }
            
        });
        formulario.add(btSalvar, gbc); 
    }
}
