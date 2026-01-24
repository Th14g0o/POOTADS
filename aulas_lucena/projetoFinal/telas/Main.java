package aulas_lucena.projetoFinal.telas;

import javax.swing.*;
import java.awt.*;

import aulas_lucena.projetoFinal.componentes.BarraJanela;
import aulas_lucena.projetoFinal.componentes.BotaoVermelho;
import aulas_lucena.projetoFinal.util.Cores;
import aulas_lucena.projetoFinal.util.Imagens;


public class Main extends JFrame {
    private CardLayout cardLayout;
    private JPanel painelConteudo;

    public Main() {
        
        // Criando tela
        setTitle("PokeTime");
        setUndecorated(true); // tira janela padrão
        
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
        BarraJanela barraJanela = new BarraJanela(this);
        painelTopo.add(barraJanela);
        painelTopo.add(cabecalho);
        add(painelTopo, BorderLayout.NORTH);

        // criando div para botoes
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // criando "div"
        painelBotoes.setOpaque(false); // bg transparente
        JButton btnHome = new BotaoVermelho("Home");
        btnHome.setFocusPainted(false);
        JButton btnListaPokemon = new BotaoVermelho("Pokedex");
        btnListaPokemon.setFocusPainted(false);
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));

        painelBotoes.add(btnHome);
        painelBotoes.add(btnListaPokemon);

        cabecalho.add(painelLogo, BorderLayout.WEST);
        cabecalho.add(painelBotoes, BorderLayout.EAST);
        

        // Adicionando area dos conteudos da tela
        cardLayout = new CardLayout();
        painelConteudo = new JPanel(cardLayout);
        painelConteudo.setBackground(new  Color(208, 61, 108));
        painelConteudo.add(new Home(), "HOME");
        painelConteudo.add(new ListaPokemon(), "POKEDEX");
        
        add(painelConteudo, BorderLayout.CENTER);

        // Eventos de clique para botões
        btnHome.addActionListener(e ->
            cardLayout.show(painelConteudo, "HOME")
        );
        btnListaPokemon.addActionListener(e ->
            cardLayout.show(painelConteudo, "POKEDEX")
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}
