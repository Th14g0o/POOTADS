import java.util.Scanner;
public class Ex06 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        float nota1 = -1;
        float nota2 = -1;
        while (nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10){
            if (nota1 < 0 || nota1 > 10){
                nota1 = sc.nextFloat();
                if (nota1 < 0 || nota1 > 10) System.out.println("nota invalida");
            }
            else{
                nota2 = sc.nextFloat();
                if (nota2 < 0 || nota2 > 10) System.out.println("nota invalida");
            }
        }
        System.out.printf("media = %.2f\n", (nota1 + nota2) / 2);
    }
}
