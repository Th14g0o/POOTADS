package aulas_lucena.projetoFinal.util;

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

    public static ImageIcon logo(int larg, int altu) {
        return getImagemIcone(
            "/aulas_lucena/projetoFinal/conteudos/imgs/comuns/iconePokebolaBorda.png",
            larg, altu
        );
    }
    public static Image iconeJanela(int larg, int altu) {
        return getImagem(
            "/aulas_lucena/projetoFinal/conteudos/imgs/comuns/iconePokebolaBorda.png",
            larg, altu
        );
    }
    public static ImageIcon iconeBarraJanelaFechar(int larg, int altu) {
        return getImagemIcone(
            "/aulas_lucena/projetoFinal/conteudos/imgs/comuns/barraJanelaFechar.png",
            larg, altu
        );
    }
    public static ImageIcon iconeBarraJanelaMaximizar(int larg, int altu) {
        return getImagemIcone(
            "/aulas_lucena/projetoFinal/conteudos/imgs/comuns/barraJanelaMaximizar.png",
            larg, altu
        );
    }
    public static ImageIcon iconeBarraJanelaMinimizar(int larg, int altu) {
        return getImagemIcone(
            "/aulas_lucena/projetoFinal/conteudos/imgs/comuns/barraJanelaMinimizar.png",
            larg, altu
        );
    }
}
