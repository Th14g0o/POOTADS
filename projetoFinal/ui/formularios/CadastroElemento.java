package projetoFinal.ui.formularios;

import java.awt.*;
import javax.swing.*;

import projetoFinal.logica.modelos.Elemento;
import projetoFinal.logica.servicos.ServicosElemento;
import projetoFinal.ui.componentes.ModalErro;
import projetoFinal.ui.componentes.ModalSucesso;
import projetoFinal.ui.componentes.botoes.BotaoSalvar;
import projetoFinal.ui.componentes.campos.CampoImagem;
import projetoFinal.ui.componentes.campos.CampoSelecionaCor;
import projetoFinal.ui.componentes.campos.CampoTexto;
import projetoFinal.ui.formularios.abstracao.FormModelo;

public class CadastroElemento extends FormModelo<Elemento>{
    private boolean ehCadastro = true;

    public void setTipo(boolean ehCadastro){
        this.ehCadastro = ehCadastro;
    }

    private CampoTexto campoNome;
    private CampoImagem campoFoto;
    private CampoSelecionaCor campoCor;

    public void carregarForm(boolean ehCadastro, Elemento el){
        setModelo(el);
        setTipo(ehCadastro);
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
        campoFoto = new CampoImagem("Imagem do Jogo:");
        if (!this.ehCadastro && this.obj != null) campoFoto.setImagem(this.obj.getImagem());
        formulario.add(campoFoto, gbc);

        gbc.gridy = 2;
        campoCor = new CampoSelecionaCor("Selecione a cor representante:");
        if (!this.ehCadastro && this.obj != null) campoCor.setCorHex(this.obj.getCor());
        formulario.add(campoCor, gbc);

        gbc.gridy = 3;
        btSalvar = new BotaoSalvar();
        btSalvar.addActionListener(e ->{
            salvar();
        });
        formulario.add(btSalvar, gbc); 
    }

    public CadastroElemento() {
        this(true);
    }

    public boolean salvar(){
        Elemento elemento = new Elemento();
        if(campoNome.temTexto())
        {
            elemento.setNome(campoNome.getValor());
            elemento.setImagem(campoFoto.getByteImagem());
            elemento.setCor(campoCor.getCorSelecionadaHex());
            if (!this.ehCadastro){ 
                elemento.setId(this.obj.getId());
                ServicosElemento.atualizar(elemento);
            }
            else ServicosElemento.criar(elemento);
            ModalSucesso.ExibirModal("Sucesso ao " + (this.ehCadastro ? "criar" : "atualizar") + " Elemento!");
            if (ehCadastro){
                campoNome.limparValor();
                campoFoto.limpar();
                campoCor.limpar();
            }
            return true;
        }
        else{
            ModalErro.ExibirModal("Faltou preencher o nome do Elemento.");
            return false;
        }
    }

    public CadastroElemento(boolean ehCadastro) {
        this(ehCadastro, null);
    }
    
    public CadastroElemento(boolean ehCadastro, Elemento el) {
        carregarForm(ehCadastro, el);
    }
}
