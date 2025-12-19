public class Assalariado extends  Funcionario{

    public Assalariado(String nome, double salarioBase){
        this.salarioBase = salarioBase;
        this.nome = nome;
    }

    @Override
    public double calcularSalario(){
        return this.salarioBase;
    }
}