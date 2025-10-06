import java.util.Scanner;
public class Ex005 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int dias = entrada.nextInt();
        int a = dias / 365;
        int m = (dias % 365) / 30;
        int d = (dias % 365) % 30;
        System.out.println(a + " ano(s)\n" + m + " mes(es)\n" + d + " dia(s)");
    }
}
