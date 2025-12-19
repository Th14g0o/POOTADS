
import java.util.ArrayList;
import java.util.List;

public class UI{
    public static List<Funcionario> funcionarios = new ArrayList<Funcionario>();
    public static void main(String[] args){   
        funcionarios.add(new Assalariado("Ana", 3000.0));
        funcionarios.add(new Assalariado("Bruno", 4200.0));
        funcionarios.add(new Comissionado("Carla",4000.0, 10000.0));
        Funcionario maior = funcionarios.get(0);
        for (Funcionario f : funcionarios) {
            System.out.println(f);
            if (f.calcularSalario() > maior.calcularSalario()) maior = f;
        }
        System.out.println("Maior Salário: " + maior);

    }
}