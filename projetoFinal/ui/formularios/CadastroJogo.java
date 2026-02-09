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
    private Jogo jogo;
    private CampoTexto campoNome;
    private CampoImagem campoFoto;

    public void carregarForm(boolean ehCadastro, Jogo j){
        this.jogo = j;
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
        if (!this.ehCadastro && this.jogo != null) campoNome.setValor(this.jogo.getNome());
        formulario.add(campoNome, gbc);

        gbc.gridy = 1;
        campoFoto = new CampoImagem("Imagem do Jogo:");
        if (!this.ehCadastro && this.jogo != null) campoFoto.setImagem(this.jogo.getImagem());
        formulario.add(campoFoto, gbc);

        gbc.gridy = 2;
        BotaoSalvar btSalvar = new BotaoSalvar();
        btSalvar.addActionListener(e ->{
            Jogo joghuin = new Jogo();
            if(campoNome.temTexto())
            {
                joghuin.setNome(campoNome.getValor());
                joghuin.setImagem(campoFoto.getByteImagem());
                if (!this.ehCadastro && this.jogo != null) {
                    joghuin.setId(this.jogo.getId());
                    ServicosJogo.atualizar(joghuin);
                } else {
                    ServicosJogo.criar(joghuin);
                }
                ModalSucesso.ExibirModal("Sucesso ao " + (this.ehCadastro ? "criar" : "atualizar") + " Jogo!");
                campoNome.limparValor();
                campoFoto.limpar();
            }
            else{
                ModalErro.ExibirModal("Faltou preencher o nome do Jogo.");
            }
            
        });
        formulario.add(btSalvar, gbc); 
    }

    public CadastroJogo() { this.carregarForm(true, null); }

    public CadastroJogo(boolean ehCadastro) { this.carregarForm(ehCadastro, null); }

    public CadastroJogo(boolean ehCadastro, Jogo j) { this.carregarForm(ehCadastro, j); }
    
}
