package projetoFinal.ui.telas;

import javax.swing.*;

import projetoFinal.ui.componentes.BarraJanela;
import projetoFinal.ui.componentes.BotaoVermelho;
import projetoFinal.ui.util.Cores;
import projetoFinal.ui.util.Imagens;

import java.awt.*;


public class Main extends JFrame {
    private CardLayout cardLayout;
    private JPanel painelConteudo;

    public Main() {
        // Criando tela
        setTitle("PokeTime");
        setIconImage(Imagens.iconeJanela(32, 32));;
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setBackground(Cores.VERMELHO);

        // div para header e barra
        JPanel painelTopo = new JPanel();
        painelTopo.setLayout(new BoxLayout(painelTopo, BoxLayout.Y_AXIS));

        // Criando "componente" header com os botões
        JPanel cabecalho = new JPanel(new BorderLayout());
        cabecalho.setBackground(Color.WHITE);

        // criando "div" para logo
        JPanel painelLogo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelLogo.setOpaque(false); // bg transparente
        JLabel imagem = new JLabel(Imagens.logo(32, 32));
        JLabel labelTitulo = new JLabel("PokeTime", SwingConstants.LEFT);
        painelLogo.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));// padding
        
        painelLogo.add(imagem);
        painelLogo.add(labelTitulo);

        // adicionando header e barra personalizada na janela
        setUndecorated(true); // tira janela padrão
        BarraJanela barraJanela = new BarraJanela(this);
        painelTopo.add(barraJanela);
        painelTopo.add(cabecalho);
        add(painelTopo, BorderLayout.NORTH);

        // criando div para botoes
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // criando "div"
        painelBotoes.setOpaque(false); // bg transparente
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));

        JButton btnHome = new BotaoVermelho("Home");
        JButton btnCadastros = new BotaoVermelho("Cadastros");
        JButton btnTime = new BotaoVermelho("Time");
        JButton btnPokedex = new BotaoVermelho("Pokedex");

        painelBotoes.add(btnHome);
        painelBotoes.add(btnCadastros);
        painelBotoes.add(btnTime);
        painelBotoes.add(btnPokedex);

        cabecalho.add(painelLogo, BorderLayout.WEST);
        cabecalho.add(painelBotoes, BorderLayout.EAST);
        
        // Adicionando area dos conteudos da tela
        cardLayout = new CardLayout();
        painelConteudo = new JPanel(cardLayout);
        painelConteudo.setBackground(new  Color(208, 61, 108));
        painelConteudo.add(new Home(), "HOME");
        painelConteudo.add(new Cadastros(), "CADASTROS");
        painelConteudo.add(new Time(), "TIME");
        painelConteudo.add(new Pokedex(), "POKEDEX");
        
        add(painelConteudo, BorderLayout.CENTER);        

        cardLayout.show(painelConteudo, "HOME");
        btnHome.setForeground(Cores.AMARELO);

        // Eventos de clique para botões
        btnHome.addActionListener(e -> {
            cardLayout.show(painelConteudo, "HOME");
            btnHome.setForeground(Cores.AMARELO);
            btnCadastros.setForeground(Color.WHITE);
            btnTime.setForeground(Color.WHITE);
            btnPokedex.setForeground(Color.WHITE);
        });
        btnCadastros.addActionListener(e -> {
            cardLayout.show(painelConteudo, "CADASTROS");
            btnHome.setForeground(Color.WHITE);
            btnCadastros.setForeground(Cores.AMARELO);
            btnTime.setForeground(Color.WHITE);
            btnPokedex.setForeground(Color.WHITE);
        });
        btnTime.addActionListener(e -> {
            cardLayout.show(painelConteudo, "TIME");
            btnHome.setForeground(Color.WHITE);
            btnCadastros.setForeground(Color.WHITE);
            btnTime.setForeground(Cores.AMARELO);
            btnPokedex.setForeground(Color.WHITE);
        });
        btnPokedex.addActionListener(e -> {
            cardLayout.show(painelConteudo, "POKEDEX");
            btnHome.setForeground(Color.WHITE);
            btnCadastros.setForeground(Color.WHITE);
            btnTime.setForeground(Color.WHITE);
            btnPokedex.setForeground(Cores.AMARELO);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}
