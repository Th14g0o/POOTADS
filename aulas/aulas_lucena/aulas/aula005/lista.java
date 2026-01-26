import java.util.ArrayList;
import java.util.List;

public class lista {
    public static void main(String[] args) {
        List<String> palavras = new ArrayList<>();
        palavras.add("Texto");
        palavras.add("muito");
        palavras.add("Louco");
        for (int i = palavras.size() -1; i >= 0; i--){
            System.out.print(palavras.get(i));
            if (i > 0) System.out.print(" ");
        }
    }
}
