import java.util.Scanner;
public class UI {
    public static void exibirOpcoes(){
        System.out.println("\nEscolha uma das opçoes opções abaixo.");
        System.out.println(" 1 : Testar Circulo");
        System.out.println(" 2 : Testar Disciplina");
        System.out.println(" 3 : Testar Retangulo");
        System.out.println(" 4 : Testar Equação Segundo Grau");
        System.out.println("-1 : Sair do Sistema");
        System.out.print("Digite o numero da opção aqui: ");
    }

    public static void testarCirculo(Scanner entrada){
        Circulo c = new Circulo();
        System.out.println("Digite o raio do circulo:");
        c.raio = entrada.nextDouble();
        String texto = "Circulo:\nraio: %.2f\narea: %.2f\nCircunferência: %2f";
        System.out.printf(texto, c.raio, c.calArea(), c.calCirc());
    }
    public static void testarDisciplina(Scanner entrada){
        Disciplina d = new Disciplina();
        System.out.println("Digite o nome da disciplina:");
        d.nome = entrada.next();
        System.out.println("Digite a nota do 1° bimestre:");
        d.notaBim1 = entrada.nextDouble();
        System.out.println("Digite a nota do 2° bimestre:");
        d.notaBim2 = entrada.nextDouble();
        System.out.println("Digite a nota da prova final:");
        d.notaFinal = entrada.nextDouble();
        double media = d.mediaParcial();
        String texto = "Disciplina: %s\nNota Bimestre: %.2f e %.2f\nMedia = %.2f\n";
        System.out.printf(texto, d.nome, d.notaBim1, d.notaBim2, media);
        if (media >= 60) System.out.println("Aprovado no bimestre!!");
        else{
            media = d.mediaFinal();
            texto = "Nota Final: %.2f\nMedia Final = %.2f\n";
            System.out.printf(texto, d.notaFinal, media);
            if (media >= 60) System.out.println("Aprovado na final!!");
            else System.out.println("Reprovado...");
        }
    }
    public static void testarRetangulo(Scanner entrada){
        System.out.println("Digite a base, em seguida, a altura:");
        Retangulo r = new Retangulo(entrada.nextDouble(), entrada.nextDouble());
        System.out.println(r);
    }
    public static void testarEquacaoII(Scanner entrada){
        System.out.println("Digite a A, em seguida, a B, por fim, C:");
        EquacaoII e = new EquacaoII(entrada.nextDouble(), entrada.nextDouble(), entrada.nextDouble());
        System.out.println(e);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int op = 0;
        while (op != -1){
            switch (op){
                case -2: System.out.print("Digite o numero da opção aqui(0 para ver as opcções novamente): "); op = sc.nextInt(); break;
                case 1: testarCirculo(sc); op = -2; break;
                case 2: testarDisciplina(sc); op = -2; break;
                case 3: testarRetangulo(sc); op = -2; break;
                case 4: testarEquacaoII(sc); op = -2; break;
                default: exibirOpcoes(); op = sc.nextInt();
            }
        }
        System.out.println("Cabou...");
    }
}
