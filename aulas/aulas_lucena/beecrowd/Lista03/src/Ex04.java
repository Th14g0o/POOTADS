import java.util.Scanner;
public class Ex04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nc = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < nc; i++) {
            int p = 0;
            int cq = Integer.parseInt(sc.nextLine());
            String[] cs = new String[cq];
            for (int j = 0; j < cq; j++) {
                String c = sc.nextLine();
                cs[j] = c;
                if      (c.equalsIgnoreCase("LEFT"))  p -= 1;
                else if (c.equalsIgnoreCase("RIGHT")) p += 1;
                else {
                    String cf = c;
                    while (!cf.equalsIgnoreCase("LEFT") && !cf.equalsIgnoreCase("RIGHT"))
                        cf = cs[Integer.parseInt((cf.substring(8))) - 1];
                    if      (cf.equals("LEFT"))  p -= 1;
                    else if (cf.equals("RIGHT")) p += 1;
                }
            }
            System.out.println(p);
        }
    }
}
