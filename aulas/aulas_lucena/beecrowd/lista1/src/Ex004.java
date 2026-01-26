import java.util.Scanner;
public class Ex004 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double a = entrada.nextDouble();
        double b = entrada.nextDouble();
        double c = entrada.nextDouble();
        double delta = b*b - 4*a*c;
        if (delta > 0 && a > 0){
            double r1 = (-b + Math.sqrt(delta)) / (2*a);
            double r2 = (-b - Math.sqrt(delta)) / (2*a);
            System.out.println("R1 = " + String.format("%.5f", r1) + "\nR2 = " + String.format("%.5f", r2));
        }
        else{
            System.out.println("Impossivel calcular");
        }
    }
}
