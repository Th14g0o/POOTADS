import java.util.Scanner;
public class Ex04 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] ns = new int[20];
        for (int i = 0; i < 20; i++) ns[i] = Integer.parseInt(sc.nextLine());
        int j = 19;
        for (int i = 0; i < 10; i++) {
            int esquerda = ns[i];
            int direita  = ns[j];
            ns[i] = direita;
            ns[j] = esquerda;
            j--;
        }
        for(int i = 0; i < 20; i++) System.out.println("N[" + i + "] = " + ns[i]);
    }
}
