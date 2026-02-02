package projetoFinal.ui.formularios;

import projetoFinal.logica.modelos.Regiao;
import projetoFinal.logica.servicos.ServicosRegiao;
import projetoFinal.ui.componentes.ModalErro;
import projetoFinal.ui.componentes.ModalSucesso;
import projetoFinal.ui.componentes.botoes.BotaoSalvar;
import projetoFinal.ui.componentes.campos.CampoTexto;

import java.awt.*;
import javax.swing.*;

public class CadastroRegiao extends JPanel{
    public CadastroRegiao() {
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
        CampoTexto campoNome = new CampoTexto("Nome:");
        formulario.add(campoNome, gbc);

        gbc.gridy = 1;
        BotaoSalvar btSalvar = new BotaoSalvar();
        btSalvar.addActionListener(e ->{
            Regiao r = new Regiao();
            if(campoNome.temTexto())
            {
                r.setNome(campoNome.getValor());
                ServicosRegiao.criar(r);
                ModalSucesso.ExibirModal("Sucesso ao criar Região!");
                campoNome.limparValor();
            }
            else{
                ModalErro.ExibirModal("Faltou preencher o nome da Região.");
            }
            
        });
        formulario.add(btSalvar, gbc); 
    }
    
}
