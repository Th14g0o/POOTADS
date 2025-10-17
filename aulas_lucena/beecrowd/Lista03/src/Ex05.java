import java.util.Scanner;
public class Ex05 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++){
            String p1 = sc.nextLine();
            String p2 = sc.nextLine();
            String nome = "";
            for (int j = 0; j < p1.length(); j+=2)
                nome += p1.substring(j, j+2) + p2.substring(j,  j + (j == p1.length() - 2 && p2.length() % 2 != 0 ? 1 : 2));
            System.out.println(nome);
        }
    }
}
