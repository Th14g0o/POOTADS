public class Disciplina {
    public String nome;
    public double notaBim1;
    public double notaBim2;
    public double notaFinal;

    public double mediaParcial() {
        return (notaBim1 * 2 + notaBim2 * 3) / 5;
    }
    public double mediaFinal(){
        return (mediaParcial() + notaFinal) / 2;
    }
}
