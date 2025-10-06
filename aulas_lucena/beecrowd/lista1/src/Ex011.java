import java.util.Scanner;
public class Ex011 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double a = entrada.nextDouble();
        double b = entrada.nextDouble();
        double c = entrada.nextDouble();
        double pi = 3.14159;
        System.out.printf("TRIANGULO: %.3f\n" +
                "CIRCULO: %.3f\n" +
                "TRAPEZIO: %.3f\n" +
                "QUADRADO: %.3f\n" +
                "RETANGULO: %.3f\n",
                a*c/2, c * c * pi, (a+b) * c / 2, b * b, a * b);
    }
}
