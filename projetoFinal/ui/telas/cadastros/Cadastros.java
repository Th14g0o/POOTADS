package projetoFinal.ui.telas.cadastros;

import projetoFinal.ui.componentes.botoes.BotaoIconeTexto;
import projetoFinal.ui.interfaces.IRecarregarConteudo;
import projetoFinal.ui.util.Cores;
import projetoFinal.ui.util.Imagens;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Cadastros extends JPanel implements IRecarregarConteudo  {
    private int tamIcones = 24;
    private List<BotaoIconeTexto> btsSubmenu = new ArrayList<BotaoIconeTexto>();

    private CadastrosJogo cadastrosJogo = new CadastrosJogo();
    private CadastrosRegiao cadastrosRegiao = new CadastrosRegiao();
    private CadastrosPokemon cadastrosPokemon = new CadastrosPokemon();
    private CadastrosElemento cadastrosElemento = new CadastrosElemento();

    private void ativarBtSubmenu(BotaoIconeTexto botao){
        for (BotaoIconeTexto bt : this.btsSubmenu){
            if (botao == bt) bt.ativarBt();
            else bt.normalizarBt();
        }
    }

    public void recarregarConteudos(){
        cadastrosJogo.recarregarConteudos();
        cadastrosElemento.recarregarConteudos();
        cadastrosPokemon.recarregarConteudos();
        cadastrosRegiao.recarregarConteudos();
    }

    public Cadastros() {
        setLayout(new BorderLayout());
        setOpaque(false);

        JPanel painelButoes = new JPanel();
        painelButoes.setLayout(new FlowLayout(FlowLayout.LEFT));
        painelButoes.setBackground(Cores.AZUL);
        add(painelButoes, BorderLayout.PAGE_START);

        BotaoIconeTexto btnJogo = new BotaoIconeTexto("JOGO", Imagens.iconeCadastroJogo(tamIcones, tamIcones));
        btnJogo.setIconeSelecionado(Imagens.iconeCadastroJogoSelecionado(tamIcones, tamIcones));
        BotaoIconeTexto btnRegiao = new BotaoIconeTexto("REGIÃO", Imagens.iconeCadastroRegiao(tamIcones, tamIcones));
        btnRegiao.setIconeSelecionado(Imagens.iconeCadastroRegiaoSelecionado(tamIcones, tamIcones));
        BotaoIconeTexto btnPokemon = new BotaoIconeTexto("POKEMON", Imagens.iconeCadastroPokemon(tamIcones, tamIcones));
        btnPokemon.setIconeSelecionado(Imagens.iconeCadastroPokemonSelecionado(tamIcones, tamIcones));
        BotaoIconeTexto btnElemento = new BotaoIconeTexto("ELEMENTO", Imagens.iconeCadastroElemento(tamIcones, tamIcones));
        btnElemento.setIconeSelecionado(Imagens.iconeCadastroElementoSelecionado(tamIcones, tamIcones));

        btsSubmenu.add(btnJogo);
        btsSubmenu.add(btnRegiao);
        btsSubmenu.add(btnPokemon);
        btsSubmenu.add(btnElemento);

        painelButoes.add(btnJogo);
        painelButoes.add(btnRegiao);
        painelButoes.add(btnPokemon);
        painelButoes.add(btnElemento);

        // Adicionando area dos conteudos da tela
        CardLayout cardLayout = new CardLayout();
        JPanel painelConteudo = new JPanel(cardLayout);
        painelConteudo.setBackground(new  Color(208, 61, 108));
        painelConteudo.add(cadastrosJogo, "CADASTROS_JOGO");
        painelConteudo.add(cadastrosRegiao, "CADASTROS_REGIAO");
        painelConteudo.add(cadastrosPokemon, "CADASTROS_POKEMON");
        painelConteudo.add(cadastrosElemento, "CADASTROS_ELEMENTO");

        add(painelConteudo, BorderLayout.CENTER);

        // Inicia primeira tab
        cardLayout.show(painelConteudo, "CADASTROS_JOGO");
        btnJogo.setIcon(Imagens.iconeCadastroJogoSelecionado(tamIcones, tamIcones));
        btnJogo.setForeground(Cores.AMARELO);

         // Eventos de clique para botões
        btnJogo.addActionListener(e -> {
            cardLayout.show(painelConteudo, "CADASTROS_JOGO");
            this.ativarBtSubmenu(btnJogo);
            cadastrosJogo.recarregarConteudos();
        });
        btnRegiao.addActionListener(e -> {
            cardLayout.show(painelConteudo, "CADASTROS_REGIAO");
            this.ativarBtSubmenu(btnRegiao);
            cadastrosRegiao.recarregarConteudos();
        });
        btnPokemon.addActionListener(e -> {
            cardLayout.show(painelConteudo, "CADASTROS_POKEMON");
            this.ativarBtSubmenu(btnPokemon);
            cadastrosPokemon.recarregarConteudos();
        });
        btnElemento.addActionListener(e -> {
            cardLayout.show(painelConteudo, "CADASTROS_ELEMENTO");
            this.ativarBtSubmenu(btnElemento);
            cadastrosElemento.recarregarConteudos();
        });
    }
}
