package projetoFinal.ui.formularios;

import projetoFinal.logica.modelos.Regiao;
import projetoFinal.logica.servicos.ServicosRegiao;
import projetoFinal.ui.componentes.ModalErro;
import projetoFinal.ui.componentes.ModalSucesso;
import projetoFinal.ui.componentes.botoes.BotaoSalvar;
import projetoFinal.ui.componentes.campos.CampoTexto;
import projetoFinal.ui.formularios.abstracao.FormModelo;

import java.awt.*;
import javax.swing.*;

public class CadastroRegiao extends FormModelo<Regiao>{
    private Regiao regiao;
    private CampoTexto campoNome;

    public void carregarForm(boolean ehCadastro, Regiao r){
        this.regiao = r;
        setTipo(ehCadastro);
        setModelo(r);
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
        if (!this.ehCadastro && this.regiao != null) campoNome.setValor(this.regiao.getNome());
        formulario.add(campoNome, gbc);

        gbc.gridy = 1;
        BotaoSalvar btSalvar = new BotaoSalvar();
        btSalvar.addActionListener(e ->{
            Regiao rNovo = new Regiao();
            if(campoNome.temTexto())
            {
                rNovo.setNome(campoNome.getValor());
                if (!this.ehCadastro && this.regiao != null){
                    rNovo.setId(this.regiao.getId());
                    ServicosRegiao.atualizar(rNovo);
                } else {
                    ServicosRegiao.criar(rNovo);
                }
                ModalSucesso.ExibirModal("Sucesso ao " + (this.ehCadastro ? "criar" : "atualizar") + " Região!");
                campoNome.limparValor();
            }
            else{
                ModalErro.ExibirModal("Faltou preencher o nome da Região.");
            }
            
        });
        formulario.add(btSalvar, gbc); 
    }

    public CadastroRegiao(){ this.carregarForm(true, null); }
    public CadastroRegiao(boolean ehCadastro){ this.carregarForm(ehCadastro, null); }
    public CadastroRegiao(boolean ehCadastro, Regiao r){ this.carregarForm(ehCadastro, r); }
    
}
