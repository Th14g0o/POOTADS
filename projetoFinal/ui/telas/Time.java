package projetoFinal.ui.telas;

import javax.swing.*;

import projetoFinal.ui.componentes.botoes.BotaoIconeTexto;
import projetoFinal.ui.componentes.botoes.BotaoVermelho;
import projetoFinal.ui.componentes.campos.CampoSelect;
import projetoFinal.ui.util.Cores;
import projetoFinal.ui.util.Imagens;

import java.awt.*;

public class Time extends JPanel  {
    public Time() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setOpaque(false);
        
        JPanel painelAcoesTime = new JPanel(new FlowLayout(FlowLayout.LEFT, 20,20));
        painelAcoesTime.setOpaque(false);
        painelAcoesTime.setAlignmentY(Component.TOP_ALIGNMENT);
        painelAcoesTime.setMaximumSize(new Dimension(Integer.MAX_VALUE, painelAcoesTime.getPreferredSize().height));
        add(painelAcoesTime);

        CampoSelect time = new CampoSelect("");
        painelAcoesTime.add(time);

        BotaoVermelho btCriar = new BotaoVermelho("Criar", Cores.VERDE, Color.WHITE);
        btCriar.altura(time.campo.getPreferredSize().height + 1);
        painelAcoesTime.add(btCriar);

        BotaoVermelho btEditar = new BotaoVermelho("Editar", Cores.AZUL, Color.WHITE);
        btEditar.altura(time.campo.getPreferredSize().height + 1);
        painelAcoesTime.add(btEditar);

        JPanel painelEspacosTime = new JPanel(new FlowLayout(FlowLayout.LEFT, 20,20));
        painelEspacosTime.setBackground(Cores.AZUL);
        painelEspacosTime.setAlignmentY(Component.TOP_ALIGNMENT);
        painelEspacosTime.setMaximumSize(new Dimension(Integer.MAX_VALUE, painelEspacosTime.getPreferredSize().height));
        add(painelEspacosTime);

        BotaoIconeTexto btAdd1 = new BotaoIconeTexto("", Imagens.iconeAdicionarMaisBranco(50, 50));
        btAdd1.padding(10, 10, 10, 10);
        btAdd1.adicionarFundo(Cores.VERDE);
        painelEspacosTime.add(btAdd1);

        BotaoIconeTexto btAdd2 = new BotaoIconeTexto("", Imagens.iconeAdicionarMaisBranco(50, 50));
        btAdd2.padding(10, 10, 10, 10);
        btAdd2.adicionarFundo(Cores.VERDE);
        painelEspacosTime.add(btAdd2);

        BotaoIconeTexto btAdd3 = new BotaoIconeTexto("", Imagens.iconeAdicionarMaisBranco(50, 50));
        btAdd3.padding(10, 10, 10, 10);
        btAdd3.adicionarFundo(Cores.VERDE);
        painelEspacosTime.add(btAdd3);

        BotaoIconeTexto btAdd4 = new BotaoIconeTexto("", Imagens.iconeAdicionarMaisBranco(50, 50));
        btAdd4.padding(10, 10, 10, 10);
        btAdd4.adicionarFundo(Cores.VERDE);
        painelEspacosTime.add(btAdd4);

        BotaoIconeTexto btAdd5 = new BotaoIconeTexto("", Imagens.iconeAdicionarMaisBranco(50, 50));
        btAdd5.padding(10, 10, 10, 10);
        btAdd5.adicionarFundo(Cores.VERDE);
        painelEspacosTime.add(btAdd5);

        BotaoIconeTexto btAdd6 = new BotaoIconeTexto("", Imagens.iconeAdicionarMaisBranco(50, 50));
        btAdd6.padding(10, 10, 10, 10);
        btAdd6.adicionarFundo(Cores.VERDE);
        painelEspacosTime.add(btAdd6);

        // em conjunto com setMaximumSize ajusta as alturas
        add(Box.createVerticalGlue());
    }
}
