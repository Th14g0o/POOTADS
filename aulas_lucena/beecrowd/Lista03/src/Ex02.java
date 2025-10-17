import java.util.Scanner;
public class Ex02 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        if (t.length() > 140) System.out.println("MUTE");
        else System.out.println("TWEET");
    }
}
