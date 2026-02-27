package projetoFinal.ui.telas;

import javax.swing.*;

import projetoFinal.ui.componentes.LayoutVertical;
import projetoFinal.ui.componentes.botoes.BotaoIconeTexto;
import projetoFinal.ui.componentes.botoes.BotaoVermelho;
import projetoFinal.ui.componentes.campos.CampoSelect;
import projetoFinal.ui.util.Cores;
import projetoFinal.ui.util.Imagens;

import java.awt.*;

public class Time extends LayoutVertical  {
    public Time() {
        setOpaque(false);
        
        JPanel painelAcoesTime = new JPanel(new FlowLayout(FlowLayout.LEFT, 20,20));
        painelAcoesTime.setOpaque(false);
        painelAcoesTime.setAlignmentY(Component.TOP_ALIGNMENT);
        addPainel(painelAcoesTime);

        CampoSelect time = new CampoSelect("");
        painelAcoesTime.add(time);

        BotaoVermelho btCriar = new BotaoVermelho("Criar", Cores.VERMELHO, Color.WHITE);
        btCriar.altura(time.campo.getPreferredSize().height + 1);
        painelAcoesTime.add(btCriar);

        BotaoVermelho btEditar = new BotaoVermelho("Editar", Cores.AZUL, Color.WHITE);
        btEditar.altura(time.campo.getPreferredSize().height + 1);
        painelAcoesTime.add(btEditar);

        JPanel painelEspacosTime = new JPanel(new FlowLayout(FlowLayout.LEFT, 20,20));
        painelEspacosTime.setBackground(Cores.AZUL);
        painelEspacosTime.setAlignmentY(Component.TOP_ALIGNMENT);
        addPainel(painelEspacosTime);

        BotaoIconeTexto btAdd1 = new BotaoIconeTexto("", Imagens.iconeAdicionarMaisBranco(50, 50));
        btAdd1.padding(20, 20, 20, 20);
        btAdd1.adicionarFundo(Cores.VERMELHO);
        painelEspacosTime.add(btAdd1);

        BotaoIconeTexto btAdd2 = new BotaoIconeTexto("", Imagens.iconeAdicionarMaisBranco(50, 50));
        btAdd2.padding(20, 20, 20, 20);
        btAdd2.adicionarFundo(Cores.VERMELHO);
        painelEspacosTime.add(btAdd2);

        BotaoIconeTexto btAdd3 = new BotaoIconeTexto("", Imagens.iconeAdicionarMaisBranco(50, 50));
        btAdd3.padding(20, 20, 20, 20);
        btAdd3.adicionarFundo(Cores.VERMELHO);
        painelEspacosTime.add(btAdd3);

        BotaoIconeTexto btAdd4 = new BotaoIconeTexto("", Imagens.iconeAdicionarMaisBranco(50, 50));
        btAdd4.padding(20, 20, 20, 20);
        btAdd4.adicionarFundo(Cores.VERMELHO);
        painelEspacosTime.add(btAdd4);

        BotaoIconeTexto btAdd5 = new BotaoIconeTexto("", Imagens.iconeAdicionarMaisBranco(50, 50));
        btAdd5.padding(20, 20, 20, 20);
        btAdd5.adicionarFundo(Cores.VERMELHO);
        painelEspacosTime.add(btAdd5);

        BotaoIconeTexto btAdd6 = new BotaoIconeTexto("", Imagens.iconeAdicionarMaisBranco(50, 50));
        btAdd6.padding(20, 20, 20, 20);
        btAdd6.adicionarFundo(Cores.VERMELHO);
        painelEspacosTime.add(btAdd6);

    }
}
