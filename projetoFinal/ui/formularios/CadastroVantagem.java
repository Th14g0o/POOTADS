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
import projetoFinal.ui.formularios.abstracao.FormModelo;
import projetoFinal.ui.interfaces.AoMudar;
import projetoFinal.ui.util.Enuns.TipoNumero;

public class CadastroVantagem extends FormModelo<FraquezaVantagem>{
    private List<Jogo> jogos;
    private List<Elemento> elementos;
    private List<Elemento> fvs;

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

    private projetoFinal.logica.dto.ElementoFraquezaVantagemDTO fvModel;
    private CampoSelect campoElemento;
    private CampoSelect campoVD;
    private CampoSelect campoJogo;

    public void carregarForm(boolean ehCadastro, projetoFinal.logica.dto.ElementoFraquezaVantagemDTO fv){
        this.fvModel = fv;
        setTipo(ehCadastro);
        setModelo(fv);

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
    if (!this.ehCadastro && this.fvModel != null) campoElemento.selecionar(this.fvModel.getIdElementoAlvo());
        formulario.add(campoElemento, gbc);

        gbc.gridy = 1;
        campoVD = new CampoSelect("Elemento que tem vantagem/desvantagem:");
        for (Elemento e : fvs) campoVD.addOpcao(e.getId(), e.getNome());
    if (!this.ehCadastro && this.fvModel != null) campoVD.selecionar(this.fvModel.getIdElementoFraquezaVantagem());
        formulario.add(campoVD, gbc);

        campoElemento.setOnChange(new AoMudar() {public void mudou(Long id) {campoVD.filtrarIdDiferentes(id);}});
        campoVD.setOnChange(new AoMudar() {public void mudou(Long id) {campoElemento.filtrarIdDiferentes(id);}});

        gbc.gridy = 2;
        CampoGrupoRadio radioVantagem = new CampoGrupoRadio(List.of("Vantagem", "Desvantagem"));
    if (!this.ehCadastro && this.fvModel != null) radioVantagem.setValor(this.fvModel.getEhFraqueza() ? "Desvantagem" : "Vantagem");
        formulario.add(radioVantagem, gbc);

        gbc.gridy = 3;
        CampoNumero campoMultiplicador = new CampoNumero("Multiplicador:", 7, TipoNumero.DOUBLE);
    if (!this.ehCadastro && this.fvModel != null) campoMultiplicador.setValor(this.fvModel.getMultiplicador());
        formulario.add(campoMultiplicador, gbc);

        gbc.gridy = 4;
        campoJogo  = new CampoSelect("Jogo:");
        for (Jogo j : jogos) campoJogo.addOpcao(j.getId(), j.getNome());
    if (!this.ehCadastro && this.fvModel != null) campoJogo.selecionar(this.fvModel.getIdJogo());
        formulario.add(campoJogo, gbc);

        gbc.gridy = 5;
        BotaoSalvar btSalvar = new BotaoSalvar();
        btSalvar.addActionListener(e ->{
            FraquezaVantagem fvNew = new FraquezaVantagem();
            if(campoMultiplicador.temTexto() && radioVantagem.temValor() && campoElemento.temValor() &&  campoVD.temValor() && campoJogo.temValor())
            {
                fvNew.setIdElementoAlvo(campoElemento.getValorSelecionado());
                fvNew.setIdElementoFraquezaVantagem(campoVD.getValorSelecionado());
                fvNew.setEhFraqueza(radioVantagem.getValor() == 0 ? false : true);
                fvNew.setMultiplicador(campoMultiplicador.getDouble());
                fvNew.setIdJogo(campoJogo.getValorSelecionado());
                if (!this.ehCadastro && this.fvModel != null){
                    fvNew.setId(this.fvModel.getId());
                    ServicosElemento.atualizarFraquezaVantagem(fvNew);
                } else {
                    ServicosElemento.criarFraquezaVantagem(fvNew);
                }
                ModalSucesso.ExibirModal("Sucesso ao " + (this.ehCadastro ? "criar" : "atualizar") + " " + (fvNew.getEhFraqueza() ? "Desvantagem!" : "Vantagem!"));
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

    public CadastroVantagem(){ this.carregarForm(true, null); }
    public CadastroVantagem(boolean ehCadastro){ this.carregarForm(ehCadastro, null); }
    public CadastroVantagem(boolean ehCadastro, FraquezaVantagem fv){ this.carregarForm(ehCadastro, fv); }
}
