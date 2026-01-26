import java.util.Scanner;
public class Ex05 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < 1000; i++) System.out.println("N[" + i + "] = " + (i%t));
    }
}
