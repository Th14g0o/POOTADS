import java.util.Scanner;
public class Ex02 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] ns = new int[10];
        for (int i = 0; i < 10; i++) ns[i] = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < 10; i++) {
            if (ns[i] <= 0) System.out.println("X[" + i + "] = " + 1);
            else System.out.println("X[" + i + "] = " + ns[i]);
        }
    }
}
