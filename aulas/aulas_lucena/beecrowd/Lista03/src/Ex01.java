import java.util.Scanner;
public class Ex01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String senha = sc.next();
        while (!senha.equals("2002")){
            System.out.println("Senha Invalida");
            System.out.println(senha);
            senha = sc.next();
        }
        System.out.println("Acesso Permitido");
    }
}
