package projetoFinal.ui.util;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Imagens {
    public static ImageIcon getImagemIcone(String caminho, int larg, int altu){
        ImageIcon icone = new ImageIcon(
            Imagens.class.getResource(caminho)
        );
        Image img = icone.getImage().getScaledInstance(larg, altu, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
    public static Image getImagem(String caminho, int larg, int altu){
        ImageIcon icone = new ImageIcon(
            Imagens.class.getResource(caminho)
        );
        return icone.getImage().getScaledInstance(larg, altu, Image.SCALE_SMOOTH);
    }

    public static Image escalaImagem(byte[] conteudoImg, int larg, int altu){
        ImageIcon icone = new ImageIcon(conteudoImg);
        return icone.getImage().getScaledInstance(larg, altu, Image.SCALE_SMOOTH);

    }
    public static ImageIcon escalaIcone(byte[] conteudoImg, int larg, int altu){
        ImageIcon icone = new ImageIcon(conteudoImg);
        return new ImageIcon(icone.getImage().getScaledInstance(larg, altu, Image.SCALE_SMOOTH));

    }


    public static ImageIcon logo(int larg, int altu) {
        return getImagemIcone(
            "/projetoFinal/conteudos/imgs/comuns/iconePokebolaBorda.png",
            larg, altu
        );
    }
    public static Image iconeJanela(int larg, int altu) {
        return getImagem(
            "/projetoFinal/conteudos/imgs/comuns/iconePokebolaBorda.png",
            larg, altu
        );
    }
    public static ImageIcon iconeBarraJanelaFechar(int larg, int altu) {
        return getImagemIcone(
            "/projetoFinal/conteudos/imgs/comuns/barraJanelaFechar.png",
            larg, altu
        );
    }
    public static ImageIcon iconeBarraJanelaMaximizar(int larg, int altu) {
        return getImagemIcone(
            "/projetoFinal/conteudos/imgs/comuns/barraJanelaMaximizar.png",
            larg, altu
        );
    }
    public static ImageIcon iconeBarraJanelaMinimizar(int larg, int altu) {
        return getImagemIcone(
            "/projetoFinal/conteudos/imgs/comuns/barraJanelaMinimizar.png",
            larg, altu
        );
    }

    public static ImageIcon iconeCadastroPokemon(int larg, int altu) {
        return getImagemIcone(
            "/projetoFinal/conteudos/imgs/comuns/iconePikachu.png",
            larg, altu
        );
    }
    public static ImageIcon iconeCadastroPokemonSelecionado(int larg, int altu) {
        return getImagemIcone(
            "/projetoFinal/conteudos/imgs/comuns/iconePikachuSelecionado.png",
            larg, altu
        );
    }

    public static ImageIcon iconeCadastroJogo(int larg, int altu) {
        return getImagemIcone(
            "/projetoFinal/conteudos/imgs/comuns/iconeJogos.png",
            larg, altu
        );
    }
    public static ImageIcon iconeCadastroJogoSelecionado(int larg, int altu) {
        return getImagemIcone(
            "/projetoFinal/conteudos/imgs/comuns/iconeJogosSelecionada.png",
            larg, altu
        );
    }

    public static ImageIcon iconeCadastroRegiao(int larg, int altu) {
        return getImagemIcone(
            "/projetoFinal/conteudos/imgs/comuns/iconeMapa.png",
            larg, altu
        );
    }
    public static ImageIcon iconeCadastroRegiaoSelecionado(int larg, int altu) {
        return getImagemIcone(
            "/projetoFinal/conteudos/imgs/comuns/iconeMapaSelecioando.png",
            larg, altu
        );
    }

    public static ImageIcon iconeCadastroElemento(int larg, int altu) {
        return getImagemIcone(
            "/projetoFinal/conteudos/imgs/comuns/iconeElemento.png",
            larg, altu
        );
    }
    public static ImageIcon iconeCadastroElementoSelecionado(int larg, int altu) {
        return getImagemIcone(
            "/projetoFinal/conteudos/imgs/comuns/iconeElementoSelecionado.png",
            larg, altu
        );
    }

    public static ImageIcon iconeCheckBox(int larg, int altu) {
        return getImagemIcone(
            "/projetoFinal/conteudos/imgs/comuns/CheckBox.png",
            larg, altu
        );
    }
    public static ImageIcon iconeCheckBoxSelecionado(int larg, int altu) {
        return getImagemIcone(
            "/projetoFinal/conteudos/imgs/comuns/CheckBoxSelecionado.png",
            larg, altu
        );
    }

    public static ImageIcon iconeBtSalvar(int larg, int altu) {
        return getImagemIcone(
            "/projetoFinal/conteudos/imgs/comuns/iconeSalvar.png",
            larg, altu
        );
    }

    public static ImageIcon iconeAnexarImagem(int larg, int altu) {
        return getImagemIcone(
            "/projetoFinal/conteudos/imgs/comuns/anexarImagem.png",
            larg, altu
        );
    }

    public static ImageIcon iconeLapisVerde(int larg, int altu) {
        return getImagemIcone(
            "/projetoFinal/conteudos/imgs/comuns/iconeLapisVerde.png",
            larg, altu
        );
    }

    public static ImageIcon iconeLixeiraVermelha(int larg, int altu) {
        return getImagemIcone(
            "/projetoFinal/conteudos/imgs/comuns/iconeLixeiraVermelha.png",
            larg, altu
        );
    }

    public static ImageIcon iconeAdicionarMaisBranco(int larg, int altu) {
        return getImagemIcone(
            "/projetoFinal/conteudos/imgs/comuns/iconeAdicionarMaisBranco.png",
            larg, altu
        );
    }
}
