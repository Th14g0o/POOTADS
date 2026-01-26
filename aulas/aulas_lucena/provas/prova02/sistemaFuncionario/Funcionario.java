public abstract class Funcionario{
    protected String nome;
    protected double salarioBase;

    public abstract double calcularSalario();

    @Override
    public String toString() {
        return String.format("Funcionario[nome=%s, salarioFinal=%.2f]", this.nome, this.calcularSalario());
    }
}