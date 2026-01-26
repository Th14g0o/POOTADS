class ex1{
    public record Produto(String nome, double preco) {}
    public static void main(String[] args) {
        Produto jogo = new Produto("Black Myth", 1.5);
        System.out.println(jogo);
        final double a = 0;
    }
}