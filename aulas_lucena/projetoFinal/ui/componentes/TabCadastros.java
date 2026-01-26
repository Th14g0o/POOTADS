package aulas_lucena.projetoFinal.ui.componentes;

import javax.swing.*;

import aulas_lucena.projetoFinal.ui.util.Cores;

import java.awt.*;
import java.util.List;

public class TabCadastros extends JPanel {
    private JPanel painelTabs;
    private CardLayout cardLayout;
    private JPanel fundoTab;
     private JPanel painelConteudo;
    private List<BotaoTab> botoes;

    private void selecionarTab(BotaoTab ativa, CardLayout layout, JPanel conteudo, String card, List<BotaoTab> todas) {
        for (BotaoTab tab : todas) {
            tab.setSelecionado(false);
        }
        ativa.setSelecionado(true);
        layout.show(conteudo, card);
    }

    public void adicionarConteudo(JPanel conteudo, String idTela){
        painelConteudo.add(conteudo, idTela);
    }

    public void iniciarTab(){
        if (this.botoes.size() > 0)  {
            BotaoTab bt = this.botoes.get(0);
            selecionarTab(bt, cardLayout, painelConteudo, bt.idTab, this.botoes);
        }
    }

    public TabCadastros(List<BotaoTab> botoes) {
        setLayout(new BorderLayout());
        setOpaque(false);
        this.botoes = botoes;

        // tab
        painelTabs = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        painelTabs.setOpaque(false);
        add(painelTabs, BorderLayout.NORTH);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        for (BotaoTab btTab : botoes) {
            painelTabs.add(btTab);
            btTab.addActionListener(e ->
                selecionarTab(btTab, cardLayout, painelConteudo, btTab.idTab, botoes)
            );
        }
        
        fundoTab = new JPanel();
        fundoTab.setLayout(new BoxLayout(fundoTab, BoxLayout.Y_AXIS));
        fundoTab.setBackground(Cores.AZUL);
        fundoTab.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(fundoTab, BorderLayout.CENTER);

        // Fundo
        cardLayout = new CardLayout();
        painelConteudo = new JPanel(cardLayout);
        painelConteudo.setBackground(Cores.VERMELHO);
        painelConteudo.setAlignmentX(Component.LEFT_ALIGNMENT);
        fundoTab.add(painelConteudo);
        
    }
}
