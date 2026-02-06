package projetoFinal.ui.componentes;

import javax.swing.*;
import projetoFinal.ui.componentes.botoes.BotaoIconeTexto;
import projetoFinal.ui.util.Cores;
import java.awt.*;
import java.util.List;

public class CardComum extends JPanel {
    private PainelArredondado cabecalho = new PainelArredondado();
    private PainelArredondado corpo = new PainelArredondado();
    private JPanel painelBotoes = new JPanel();

    public CardComum(){
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setOpaque(false);

        add(cabecalho);
        cabecalho.setLayout(new FlowLayout(FlowLayout.RIGHT, 0,0));
        cabecalho.setBackground(Color.WHITE);
        cabecalho.setRoundTopRight(5);
        cabecalho.setRoundTopLeft(5);
        cabecalho.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        add(corpo);
        corpo.setBackground(Cores.AZUL);
        corpo.setRoundBottomRight(5);
        corpo.setRoundBottomLeft(5);
    }

    public void setMargin(int cima, int esquerda, int baixo, int direita){
        this.setBorder(BorderFactory.createEmptyBorder(cima, esquerda, baixo, direita));
    }

    public void setRadiusCard(int radius){
        cabecalho.setRoundTopRight(radius);
        cabecalho.setRoundTopLeft(radius);
        corpo.setRoundBottomRight(radius);
        corpo.setRoundBottomLeft(radius);
    }

    public void addConteudo(JPanel conteudo){
        corpo.add(conteudo);
    }

    public void addBotaoAcao(BotaoIconeTexto bt){
        this.cabecalho.add(bt);
    }

    public void addBotaoAcao(List<BotaoIconeTexto> bts){
        for (BotaoIconeTexto bt : bts){
            this.addBotaoAcao(bt);
        }
    }    
}
