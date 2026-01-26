import java.util.Scanner;
public class Ex007 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int maiorAB = (a + b + Math.abs(a - b)) / 2;
        int maiorABC = (c + maiorAB + Math.abs(c - maiorAB)) / 2;
        System.out.println(maiorABC + " eh o maior");
    }
}
