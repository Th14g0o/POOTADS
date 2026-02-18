package projetoFinal.ui.telas;

import javax.swing.*;

import projetoFinal.ui.componentes.BarraJanela;
import projetoFinal.ui.componentes.botoes.BotaoVermelho;
import projetoFinal.ui.telas.cadastros.Cadastros;
import projetoFinal.ui.telas.listagem.Listas;
import projetoFinal.ui.util.Cores;
import projetoFinal.ui.util.Imagens;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Main extends JFrame {
    private CardLayout cardLayout;
    private JPanel painelConteudo;
    private List<JButton> botoesHeader = new ArrayList<JButton>();

    private void destacarBotaoAtual(JButton botao){
        for (JButton bt : botoesHeader){
            if (botao != bt)  bt.setForeground(Color.WHITE);
            else bt.setForeground(Cores.AMARELO);
        }
    }
    private Home telaHome = new Home();
    private Cadastros telaCadastros = new Cadastros();
    private Listas telaListas = new Listas();
    private Time telaTime = new Time();
    private Pokedex telaPokedex = new Pokedex();

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
        JButton btnListas = new BotaoVermelho("Listagem");
        JButton btnTime = new BotaoVermelho("Time");
        JButton btnPokedex = new BotaoVermelho("Pokedex");
        botoesHeader.add(btnHome);
        botoesHeader.add(btnCadastros);
        botoesHeader.add(btnListas);
        botoesHeader.add(btnTime);
        botoesHeader.add(btnPokedex);

        painelBotoes.add(btnHome);
        painelBotoes.add(btnCadastros);
        painelBotoes.add(btnListas);
        painelBotoes.add(btnTime);
        painelBotoes.add(btnPokedex);
        
        cabecalho.add(painelLogo, BorderLayout.WEST);
        cabecalho.add(painelBotoes, BorderLayout.EAST);
        
        // Adicionando area dos conteudos da tela
        cardLayout = new CardLayout();
        painelConteudo = new JPanel(cardLayout);
        painelConteudo.setBackground(new  Color(208, 61, 108));


        painelConteudo.add(telaHome, "HOME");
        painelConteudo.add(telaCadastros, "CADASTROS");
        painelConteudo.add(telaListas, "LISTAGEM");
        painelConteudo.add(telaTime, "TIME");
        painelConteudo.add(telaPokedex, "POKEDEX");
        
        add(painelConteudo, BorderLayout.CENTER);        

        cardLayout.show(painelConteudo, "HOME");
        btnHome.setForeground(Cores.AMARELO);

        // Eventos de clique para botões
        btnHome.addActionListener(e -> {
            cardLayout.show(painelConteudo, "HOME");
            this.destacarBotaoAtual(btnHome);
        });
        btnCadastros.addActionListener(e -> {
            cardLayout.show(painelConteudo, "CADASTROS");
            this.destacarBotaoAtual(btnCadastros);
            telaCadastros.recarregarConteudos();
        });
        btnTime.addActionListener(e -> {
            cardLayout.show(painelConteudo, "TIME");
            this.destacarBotaoAtual(btnTime);
        });
        btnPokedex.addActionListener(e -> {
            cardLayout.show(painelConteudo, "POKEDEX");
            this.destacarBotaoAtual(btnPokedex);
        });
        btnListas.addActionListener(e ->{
            cardLayout.show(painelConteudo, "LISTAGEM");
            this.destacarBotaoAtual(btnListas);
            telaListas.recarregarConteudos();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}
