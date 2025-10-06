import java.util.Scanner;
public class Ex010 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int x = entrada.nextInt();
        double y = entrada.nextDouble();
        System.out.printf("%.3f km/l\n", x / y);
    }
}
