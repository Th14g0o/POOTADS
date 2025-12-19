public class Comissionado extends  Funcionario{
    private double vendas;

    public Comissionado(String nome, double salarioBase, double vendas){
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.vendas = vendas;
    }
    @Override
    public double calcularSalario(){
        return this.salarioBase + this.vendas * 0.10;
    }
}