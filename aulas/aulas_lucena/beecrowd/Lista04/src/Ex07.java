import java.util.Scanner;
public class Ex07 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] ls = new int[4][4];

        int qtd = sc.nextInt();
        for (int i = 0; i < qtd; i++){
            for (int j = 0; j < 4; j++)
                for(int t = 0; t < 4;  t++)
                    ls[j][t] = sc.nextInt();

            boolean podeDireita = false;
            boolean podeEsquerda = false;
            boolean podeSubir= false;
            boolean podeDescer = false;
            boolean tem2048 = false;

            for (int j = 0; j < 4; j++) {
                for (int t = 0; t < 4; t++) {
                    int v = ls[j][t];
                    if (v != 0) {
                        if (t > 0 && (ls[j][t - 1] == 0 || ls[j][t - 1] == v)) podeEsquerda = true;
                        if (t < 3 && (ls[j][t + 1] == 0 || ls[j][t + 1] == v)) podeDireita  = true;
                        if (j > 0 && (ls[j - 1][t] == 0 || ls[j - 1][t] == v)) podeSubir    = true;
                        if (j < 3 && (ls[j + 1][t] == 0 || ls[j + 1][t] == v)) podeDescer   = true;
                        if (v >= 2048) tem2048 = true;
                    }
                    if (tem2048) break;
                }
                if (tem2048) break;
            }


            String comandos = "";
            if (!tem2048) {
                if (podeDescer) comandos += "DOWN ";
                if (podeEsquerda) comandos += "LEFT ";
                if (podeDireita) comandos += "RIGHT ";
                if (podeSubir) comandos += "UP ";
            }

            if (comandos.equals("")) System.out.println("NONE");
            else System.out.println(comandos.substring(0, comandos.length() - 1));
        }
    }
}
