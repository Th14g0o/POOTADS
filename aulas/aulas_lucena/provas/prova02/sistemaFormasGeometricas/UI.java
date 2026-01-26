
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI{
    public static List<Forma> formas = new ArrayList<Forma>();
    public static void main(String[] args){   
        Scanner sc = new Scanner(System.in);
        double areaTot = 0;
        double perimetroTot = 0;
        for (int i = 0; i < 3; i++){
            System.out.println("Digite a Forma(C para círculo e R para retângulo): ");
            String forma = sc.next();
            if (forma.equals("C")){
                System.out.println("Digite o raio: ");
                formas.add(new Circulo(sc.nextDouble()));
                areaTot += formas.get(i).area();
                perimetroTot += formas.get(i).perimetro();
            }
            else{
                System.out.println("Digite a largura e em seguida altura: ");
                formas.add(new Retangulo(sc.nextDouble(), sc.nextDouble()));
                areaTot += formas.get(i).area();
                perimetroTot += formas.get(i).perimetro();
            }
        } 

        System.out.printf("\nÁrea total = %.2f\nPerímetro Total =  %.2f\n\nLista de formas:\n", areaTot, perimetroTot);

        for (Forma f : formas) 
            System.out.println(f);
        
    }
}