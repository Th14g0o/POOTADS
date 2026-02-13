package projetoFinal.ui.formularios;

import projetoFinal.logica.modelos.Jogo;
import projetoFinal.logica.servicos.ServicosJogo;
import projetoFinal.ui.componentes.ModalErro;
import projetoFinal.ui.componentes.ModalSucesso;
import projetoFinal.ui.componentes.botoes.BotaoSalvar;
import projetoFinal.ui.componentes.campos.CampoImagem;
import projetoFinal.ui.componentes.campos.CampoTexto;
import projetoFinal.ui.formularios.abstracao.FormModelo;

import java.awt.*;
import javax.swing.*;

public class CadastroJogo extends FormModelo<Jogo>{
    private CampoTexto campoNome;
    private CampoImagem campoFoto;

    public void carregarForm(boolean ehCadastro, Jogo j){
        setTipo(ehCadastro);
        setModelo(j);
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
        btSalvar = new BotaoSalvar();
        btSalvar.addActionListener(e ->{
            salvar();    
        });
        formulario.add(btSalvar, gbc); 
    }

    public boolean salvar(){
        Jogo joghuin = new Jogo();
        if(campoNome.temTexto())
        {
            joghuin.setNome(campoNome.getValor());
            joghuin.setImagem(campoFoto.getByteImagem());
            if (!this.ehCadastro && this.obj != null) {
                joghuin.setId(this.obj.getId());
                ServicosJogo.atualizar(joghuin);
            } else {
                ServicosJogo.criar(joghuin);
            }
            ModalSucesso.ExibirModal("Sucesso ao " + (this.ehCadastro ? "criar" : "atualizar") + " Jogo!");
            if (ehCadastro){
                campoNome.limparValor();
                campoFoto.limpar();
            }
            return true;
        }
        else{
            ModalErro.ExibirModal("Faltou preencher o nome do Jogo.");
            return false;
        }
    }

    public CadastroJogo() { this.carregarForm(true, null); }

    public CadastroJogo(boolean ehCadastro) { this.carregarForm(ehCadastro, null); }

    public CadastroJogo(boolean ehCadastro, Jogo j) { this.carregarForm(ehCadastro, j); }
    
}
