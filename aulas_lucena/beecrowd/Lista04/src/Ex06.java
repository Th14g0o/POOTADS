import java.util.Scanner;
public class Ex06 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] X = new int[N];
        for (int i = 0; i < N; i++) X[i] = sc.nextInt();
        int menor = X[0];
        int indice = 0;
        for (int i = 0; i < N; i++) if (X[i] < menor) {menor = X[i]; indice = i;}
        System.out.println("Menor valor: " + menor);
        System.out.println("Posicao: " + indice);
    }
}
