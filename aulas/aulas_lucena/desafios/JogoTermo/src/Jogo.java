import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Jogo {
    private static ArrayList<String> palavras = new ArrayList<>();
    private static void populaPalavras(){
        Scanner sc;
        try {
            sc = new Scanner(new File("palavras.txt"));
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                palavras.add(linha);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void exibeOpcoes(){
        System.out.println("Opções:");
        System.out.println(" 1 : começar jogo");
        System.out.println("-1 : sair do jogo");
        System.out.println("digite a opções: ");
    }
    public static void letrasCertas(String palavraCerta, String palavra){
        String[] acertos = new String[palavraCerta.length()];
        for (int i = 0; i < palavraCerta.length(); i++){
            String letraCerta = palavraCerta.charAt(i) + "";
            String letra = palavra.charAt(i) + "";
            if (letraCerta.equals(letra)) acertos[i] = "🟩";
            else acertos[i] = "⬛";
        }
        for (int i = 0; i < palavraCerta.length(); i++){
            String letraCerta = palavraCerta.charAt(i) + "";
            String letra = palavra.charAt(i) + "";
            if (!letraCerta.equals(letra) && palavraCerta.contains(letra)){
                int qtd = 0;
                for (int j = 0; j < palavraCerta.length(); j++){
                    if (palavra.charAt(i) == palavraCerta.charAt(j) && acertos[i].equals("⬛"))
                        qtd++;
                }
                for (int j = 0; j < palavraCerta.length(); j++){
                    if (palavra.charAt(i) == palavra.charAt(j) && !acertos[j].equals("⬛"))
                        qtd--;
                }
                for (int j = 0; j < palavraCerta.length(); j++){
                    if (palavra.charAt(i) == palavraCerta.charAt(j) && acertos[i].equals("⬛") && qtd > 0) {
                        acertos[i] = "🟨";
                        qtd--;
                    }
                }
            }
        }
        for (int i = 0; i < acertos.length; i++) System.out.print(acertos[i]);
        System.out.print("\n");
    }
    public static void comecar(Scanner entrada){
        String palavraCerta = palavras.get((int)(Math.random() * palavras.size()));
        palavraCerta = palavraCerta.toLowerCase();
        String palavra = "";
        System.out.println("Acerte a palavra com " + palavraCerta.length() + " letras:");
        entrada.nextLine();
        while (!palavra.equalsIgnoreCase(palavraCerta)){
            System.out.print("Digite: ");
            palavra = entrada.nextLine().trim().toLowerCase();
            if (palavra.length() == palavraCerta.length()) letrasCertas(palavraCerta, palavra);
            else System.out.println("Palavra invalida");
        }
        System.out.println("Acertou, parabens!");
    }
    public static void main(String[] args){
        populaPalavras();
        Scanner sc = new Scanner(System.in);
        int op = 0;
        while (op != -1){
            switch (op){
                case 0: exibeOpcoes(); op = sc.nextInt(); break;
                case 1: comecar(sc); op = -2; break;
                default:
                    System.out.println("digite a opção(0 para ver as opções: ");
                    op = sc.nextInt();
                    break;
            }
        }

    }
}
