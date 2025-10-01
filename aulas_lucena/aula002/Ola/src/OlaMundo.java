import java.util.Scanner;
import java.time.LocalDate;
// Quando formos criar os pacotes tentaremos ser especificos tambem
public class OlaMundo {
    public static void main(String[] args) {
        // args pega valores que vem no comando para rodar
        // java .\arq.java args
        Scanner sc = new Scanner(System.in);
        System.out.println("Ola, Mundo!");
        System.out.print("Qual é seu nome? ");
        String nome = sc.nextLine();
        System.out.println("Ola " + nome + "!");

        // System.out.println("Args:" + args[0]);

        System.out.print("Qual o ano de nascimento? ");
        int ano = sc.nextInt();
        System.out.println("Sua idade é " + (LocalDate.now().getYear() - ano) + ", ou " + (LocalDate.now().getYear() - ano - 1) + ", dependendo do mês em que nasceu.");
    }
}
