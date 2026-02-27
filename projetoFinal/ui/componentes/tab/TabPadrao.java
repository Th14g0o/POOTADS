package projetoFinal.ui.componentes.tab;

import javax.swing.*;

import projetoFinal.ui.util.Cores;
import java.awt.*;
import java.util.List;

public class TabPadrao extends JPanel {
    private JPanel painelTabs;
    private CardLayout cardLayout;
    private JPanel fundoTab;
    private JPanel painelConteudo;
    private List<BotaoTab> botoes;

    private void selecionarTab(BotaoTab ativa, String idConteudo) {
        for (BotaoTab tab : this.botoes) {
            tab.setSelecionado(false);
        }
        ativa.setSelecionado(true);
        this.cardLayout.show(this.painelConteudo, idConteudo);
    }

    public void adicionarConteudo(JPanel conteudo, String idTela){
        painelConteudo.add(conteudo, idTela);
    }
    

    public void iniciarTab(){
        if (this.botoes.size() > 0)  {
            BotaoTab bt = this.botoes.get(0);
            selecionarTab(bt, bt.idTab);
        }
    }

    public void setBotoes(List<BotaoTab> botoes){
        this.botoes = botoes;
        for (BotaoTab btTab : botoes) {
            painelTabs.add(btTab);
            btTab.addActionListener(e ->
                selecionarTab(btTab, btTab.idTab)
            );
        }
    }

    public TabPadrao() {
        setLayout(new BorderLayout());
        setOpaque(false);
        // tab
        painelTabs = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        painelTabs.setOpaque(false);
        add(painelTabs, BorderLayout.NORTH);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        
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
