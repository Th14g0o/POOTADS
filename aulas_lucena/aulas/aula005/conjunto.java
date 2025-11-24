import java.util.HashSet;
import java.util.Set;

public class conjunto{
    public static void main(String[] args) {
        Set<String> palavras = new HashSet<>();
        palavras.add("Flamengo");
        palavras.add("Fluminense");
        palavras.add("Botafogo");
        palavras.add("Botafogo");
        System.out.println(palavras.size());
        for (String palavra : palavras) {
            System.out.println(palavra);
        }
        
    }
}