import java.util.Scanner;

public class Q3 {
    public static int achar(String[] lista, String palavra){
        for (int i = 0; i < lista.length; i ++){
            if (lista[i].equals(palavra)) return i;
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String msg = sc.nextLine();
        int N = sc.nextInt();
        if (N == 0) System.out.println(msg);
        else{
            String nova_msg = "";
            for (int i = 0; i < msg.length(); i++){
                String l = (msg.charAt(i) + "").toUpperCase();
                int indice = achar(letras, l);
                if (indice == -1) nova_msg += l;
                else{
                    if (indice + 1 + N > letras.length) nova_msg += letras[((indice + 1 + N) % 26) - 1];
                    else nova_msg += letras[indice + N];
                }
            }
            System.out.println(nova_msg);
        }
    }
}
