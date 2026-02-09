package projetoFinal.ui.util;

import java.awt.Color;

public class Cores {
    public static final Color VERMELHO = new Color(208, 61, 108);
    public static final Color AMARELO = new Color(255, 202, 2);
    public static final Color AZUL = new Color(54, 90, 153);
    public static final Color VERDE = new Color(54, 153, 59);
    public static final Color TRANSPARENTE = new Color(0, 0, 0, 0);
    public static final Color PRETO_TRANSPARENTE = new Color(0, 0, 0, 5);


    public static final String RGBParaHex(int R, int G, int B){
        String hex = String.format("#%02X%02X%02X", R,G, B);
        return hex;
    }
    public static final String ColorParaHex(Color cor){
        if (cor != null) return RGBParaHex(cor.getRed(), cor.getGreen(), cor.getBlue());
        else return null;
    }
    public static final Color HexParaColor(String hex){
        try {
            Color cor = Color.decode(hex);
            return cor;
        } catch (Exception e) {
            return null;
        }
    }
    public static Color CorDeContraste(Color bg) {
        if (bg == null) return Color.BLACK;
        double luminancia = (0.299 * bg.getRed() + 0.587 * bg.getGreen() + 0.114 * bg.getBlue()) / 255.0;
        return luminancia > 0.5 ? Color.BLACK : Color.WHITE;
    }
}
