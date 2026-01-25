package aulas_lucena.projetoFinal.ui.telas;

import aulas_lucena.projetoFinal.ui.componentes.BotaoIconeTexto;
import aulas_lucena.projetoFinal.ui.util.Cores;
import aulas_lucena.projetoFinal.ui.util.Imagens;

import javax.swing.*;
import java.awt.*;

public class Cadastros extends JPanel  {;
    private int tamIcones = 24;

    public Cadastros() {
        setLayout(new BorderLayout());
        setOpaque(false);

        JPanel painelButoes = new JPanel();
        painelButoes.setLayout(new FlowLayout(FlowLayout.LEFT));
        painelButoes.setBackground(Cores.AZUL);
        add(painelButoes, BorderLayout.PAGE_START);

        JButton btnJogo = new BotaoIconeTexto("Jogo", Imagens.iconeCadastroJogo(tamIcones, tamIcones));
        JButton btnRegiao = new BotaoIconeTexto("Região", Imagens.iconeCadastroRegiao(tamIcones, tamIcones));
        JButton btnPokemon = new BotaoIconeTexto("Pokemon", Imagens.iconeCadastroPokemon(tamIcones, tamIcones));
        JButton btnElemento = new BotaoIconeTexto("Elemento", Imagens.iconeCadastroElemento(tamIcones, tamIcones));

        painelButoes.add(btnJogo);
        painelButoes.add(btnRegiao);
        painelButoes.add(btnPokemon);
        painelButoes.add(btnElemento);

        // Adicionando area dos conteudos da tela
        CardLayout cardLayout = new CardLayout();
        JPanel painelConteudo = new JPanel(cardLayout);
        painelConteudo.setBackground(new  Color(208, 61, 108));
        painelConteudo.add(new CadastrosJogo(), "CADASTROS_JOGO");
        painelConteudo.add(new CadastrosRegiao(), "CADASTROS_REGIAO");
        painelConteudo.add(new CadastrosPokemon(), "CADASTROS_POKEMON");
        painelConteudo.add(new CadastrosElemento(), "CADASTROS_ELEMENTO");

        add(painelConteudo, BorderLayout.CENTER);

        // Inicia primeira tab
        cardLayout.show(painelConteudo, "CADASTROS_JOGO");
        btnJogo.setIcon(Imagens.iconeCadastroJogoSelecionado(tamIcones, tamIcones));
        btnJogo.setForeground(Cores.AMARELO);

         // Eventos de clique para botões
        btnJogo.addActionListener(e -> {
            cardLayout.show(painelConteudo, "CADASTROS_JOGO");

            btnJogo.setIcon(Imagens.iconeCadastroJogoSelecionado(tamIcones, tamIcones));
            btnRegiao.setIcon(Imagens.iconeCadastroRegiao(tamIcones, tamIcones));
            btnPokemon.setIcon(Imagens.iconeCadastroPokemon(tamIcones, tamIcones));
            btnElemento.setIcon(Imagens.iconeCadastroElemento(tamIcones, tamIcones));
            
            btnJogo.setForeground(Cores.AMARELO);
            btnRegiao.setForeground(Color.WHITE);
            btnPokemon.setForeground(Color.WHITE);
            btnElemento.setForeground(Color.WHITE);
        });
        btnRegiao.addActionListener(e -> {
            cardLayout.show(painelConteudo, "CADASTROS_REGIAO");

            btnJogo.setIcon(Imagens.iconeCadastroJogo(tamIcones, tamIcones));
            btnRegiao.setIcon(Imagens.iconeCadastroRegiaoSelecionado(tamIcones, tamIcones));
            btnPokemon.setIcon(Imagens.iconeCadastroPokemon(tamIcones, tamIcones));
            btnElemento.setIcon(Imagens.iconeCadastroElemento(tamIcones, tamIcones));

            btnJogo.setForeground(Color.WHITE);
            btnRegiao.setForeground(Cores.AMARELO);
            btnPokemon.setForeground(Color.WHITE);
            btnElemento.setForeground(Color.WHITE);
        });
        btnPokemon.addActionListener(e -> {
            cardLayout.show(painelConteudo, "CADASTROS_POKEMON");

            btnJogo.setIcon(Imagens.iconeCadastroJogo(tamIcones, tamIcones));
            btnRegiao.setIcon(Imagens.iconeCadastroRegiao(tamIcones, tamIcones));
            btnPokemon.setIcon(Imagens.iconeCadastroPokemonSelecionado(tamIcones, tamIcones));
            btnElemento.setIcon(Imagens.iconeCadastroElemento(tamIcones, tamIcones));

            btnJogo.setForeground(Color.WHITE);
            btnRegiao.setForeground(Color.WHITE);
            btnPokemon.setForeground(Cores.AMARELO);
            btnElemento.setForeground(Color.WHITE);
        });
        btnElemento.addActionListener(e -> {
            cardLayout.show(painelConteudo, "CADASTROS_ELEMENTO");

            btnJogo.setIcon(Imagens.iconeCadastroJogo(tamIcones, tamIcones));
            btnRegiao.setIcon(Imagens.iconeCadastroRegiao(tamIcones, tamIcones));
            btnPokemon.setIcon(Imagens.iconeCadastroPokemon(tamIcones, tamIcones));
            btnElemento.setIcon(Imagens.iconeCadastroElementoSelecionado(tamIcones, tamIcones));

            btnJogo.setForeground(Color.WHITE);
            btnRegiao.setForeground(Color.WHITE);
            btnPokemon.setForeground(Color.WHITE);
            btnElemento.setForeground(Cores.AMARELO);
        });
    }
}
