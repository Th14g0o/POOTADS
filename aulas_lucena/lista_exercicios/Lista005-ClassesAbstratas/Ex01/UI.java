import java.util.Scanner;

class UI {
     private static void exibirOpcoes(){
        System.out.println("\nEscolha uma das opçoes opções abaixo.");
        System.out.println(" 1 : Testar Esfera");
        System.out.println(" 2 : Testar Cubo");
        System.out.println("-1 : Sair do Sistema");
        System.out.print("Digite o numero da opção aqui: ");
    }

    private static void testarEsfera(Scanner entrada){
        System.out.println("Digite o raio da Esfera: ");
        Esfera e = new Esfera(entrada.nextDouble());
        String texto = "Esfera Volume: %.2f\n";
        System.out.printf(texto, e.GetVolume());
    }

    private static void testarCubo(Scanner entrada){
        System.out.println("Digite o lado do Cubo: ");
        Cubo c = new Cubo(entrada.nextDouble());
        String texto = "Cubo Volume: %.2f\n";
        System.out.printf(texto, c.GetVolume());
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int op = 0;
        while (op != -1){
            switch (op){
                case -2: System.out.print("Digite o numero da opção aqui(0 para ver as opcções novamente): "); op = sc.nextInt(); break;
                case 1: testarEsfera(sc); op = -2; break;
                case 2: testarCubo(sc); op = -2; break;
                default: exibirOpcoes(); op = sc.nextInt();
            }
        }
        System.out.println("Cabou...");
    }
}