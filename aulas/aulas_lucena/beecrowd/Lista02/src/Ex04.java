import java.util.Scanner;
public class Ex04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maior = n;
        int posi = 1;
        for  (int i = 2; i <= 100; i++){
            n = sc.nextInt();
            if (n > maior){
                maior = n;
                posi = i;
            }
        }
        System.out.println(maior + "\n" + posi);
    }
}
