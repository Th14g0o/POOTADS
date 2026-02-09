package projetoFinal.ui.formularios;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import projetoFinal.logica.modelos.Elemento;
import projetoFinal.logica.modelos.FraquezaVantagem;
import projetoFinal.logica.modelos.Jogo;
import projetoFinal.logica.servicos.ServicosElemento;
import projetoFinal.logica.servicos.ServicosJogo;
import projetoFinal.ui.componentes.ModalErro;
import projetoFinal.ui.componentes.ModalSucesso;
import projetoFinal.ui.componentes.botoes.BotaoSalvar;
import projetoFinal.ui.componentes.campos.CampoGrupoRadio;
import projetoFinal.ui.componentes.campos.CampoNumero;
import projetoFinal.ui.componentes.campos.CampoSelect;
import projetoFinal.ui.interfaces.AoMudar;
import projetoFinal.ui.util.Enuns.TipoNumero;

public class CadastroVantagem extends JPanel{
    private List<Jogo> jogos;
    private List<Elemento> elementos;
    private List<Elemento> fvs;

    private CampoSelect campoElemento;
    private CampoSelect campoVD;
    private CampoSelect campoJogo;

    private void carregarListas(){
        jogos = ServicosJogo.listar();
        elementos = ServicosElemento.listar();
        fvs = ServicosElemento.listar();
    }

    public void recarregarListas(){
        jogos = ServicosJogo.listar();
        elementos = ServicosElemento.listar();
        fvs = ServicosElemento.listar();

        campoElemento.limpar();
        campoVD.limpar();
        campoJogo.limpar();

        for (Elemento e : elementos) campoElemento.addOpcao(e.getId(), e.getNome()); 
        for (Elemento e : fvs) campoVD.addOpcao(e.getId(), e.getNome());
        for (Jogo j : jogos) campoJogo.addOpcao(j.getId(), j.getNome());
    }

    public CadastroVantagem() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        setOpaque(false);

        carregarListas();

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
        campoElemento = new CampoSelect("Elemento:");
        for (Elemento e : elementos) campoElemento.addOpcao(e.getId(), e.getNome()); 
        formulario.add(campoElemento, gbc);

        gbc.gridy = 1;
        campoVD = new CampoSelect("Elemento que tem vantagem/desvantagem:");
        for (Elemento e : fvs) campoVD.addOpcao(e.getId(), e.getNome());
        formulario.add(campoVD, gbc);

        campoElemento.setOnChange(new AoMudar() {public void mudou(Long id) {campoVD.filtrarIdDiferentes(id);}});
        campoVD.setOnChange(new AoMudar() {public void mudou(Long id) {campoElemento.filtrarIdDiferentes(id);}});

        gbc.gridy = 2;
        CampoGrupoRadio radioVantagem = new CampoGrupoRadio(List.of("Vantagem", "Desvantagem"));
        formulario.add(radioVantagem, gbc);

        gbc.gridy = 3;
        CampoNumero campoMultiplicador = new CampoNumero("Multiplicador:", 7, TipoNumero.DOUBLE);
        formulario.add(campoMultiplicador, gbc);

        gbc.gridy = 4;
        campoJogo  = new CampoSelect("Jogo:");
        for (Jogo j : jogos) campoJogo.addOpcao(j.getId(), j.getNome());
        formulario.add(campoJogo, gbc);

        gbc.gridy = 5;
        BotaoSalvar btSalvar = new BotaoSalvar();
        btSalvar.addActionListener(e ->{
            FraquezaVantagem fv = new FraquezaVantagem();
            if(campoMultiplicador.temTexto() && radioVantagem.temValor() && campoElemento.temValor() &&  campoVD.temValor() && campoJogo.temValor())
            {
                fv.setIdElementoAlvo(campoElemento.getValorSelecionado());
                fv.setIdElementoFraquezaVantagem(campoVD.getValorSelecionado());
                fv.setEhFraqueza(radioVantagem.getValor() == 0 ? false : true);
                fv.setMultiplicador(campoMultiplicador.getDouble());
                fv.setIdJogo(campoJogo.getValorSelecionado());
                ServicosElemento.criarFraquezaVantagem(fv);
                ModalSucesso.ExibirModal("Sucesso ao criar " + (fv.getEhFraqueza() ? "Desvantagem!" : "Vantagem!"));
                campoElemento.limpar();
                campoVD.limpar();
                radioVantagem.limpar();
                campoJogo.limpar();
                campoMultiplicador.limpar();
            }
            else{
                String erros = "";
                if (!campoElemento.temValor()) 
                    erros = erros + "o elemento"; 
                if (!campoVD.temValor()) 
                    erros = erros + (erros.length() > 0 ? ", " : "") + "o elemento alvo"; 
                if (!radioVantagem.temValor()) 
                    erros = erros + (erros.length() > 0 ? ", " : "") + "a seleção da vantagem ou desvantagem"; 
                if (!campoMultiplicador.temTexto()) 
                    erros = erros + (erros.length() > 0 ? ", " : "") + "o multiplicador"; 
                if (!campoJogo.temValor()) 
                    erros = erros + (erros.length() > 0 ? ", " : "") + "o jogo";
                ModalErro.ExibirModal("Faltou preencher " + erros + " da Vantagem/Desvantagem.");
            }
            
        });
        formulario.add(btSalvar, gbc);
    }
}
