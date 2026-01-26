import java.util.Scanner;
public class Ex03 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int ns = sc.nextInt();
        for (int i = 0; i < ns; i++) {
            String n = sc.next();
            int leds = 0;
            for (int j = 0; j < n.length(); j++) {
                switch (n.charAt(j)) {
                    case '1' : leds += 2; break;
                    case '7' : leds += 3; break;
                    case '4' : leds += 4; break;
                    case '2' :
                    case '3' :
                    case '5' : leds += 5; break;
                    case '6' :
                    case '9' :
                    case '0' : leds += 6; break;
                    case '8' : leds += 7; break;
                    default : leds += 0; break;
                }
            }
            System.out.println(leds + " leds");
        }
    }
}
