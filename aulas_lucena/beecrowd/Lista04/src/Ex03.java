import java.util.Scanner;
public class Ex03 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] ns = new int[10];
        ns[0] = n;
        for(int i = 1; i < 10; i++) ns[i] = ns[i-1] * 2;
        for(int i = 0; i < 10; i++) System.out.println("N[" + i + "] = " + ns[i]);
    }
}
