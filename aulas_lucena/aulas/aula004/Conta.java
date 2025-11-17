public class Conta{
    private String conta;
    private double saldo;
    public Conta(String conta, double saldo){
        setConta(conta);
        setSaldo(saldo);
    }

    public void setConta(String conta){
        this.conta = conta;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public double getConta(){
        return this.conta;
    }
    public double getSaldo(){
        return this.saldo;
    }

    public double depositar(double valor){
        if (valor > 0) this.saldo += valor;
    }
    public double sacar(double valor){
        if (valor > 0 && valor <= this.saldo) this.saldo -= valor;
        return this.saldo;
    }
    
    public transferirPara(Conta c, double valor){
        double saldoAtual = this.saldo
        double valor = this.sacar(valor)
        if (saldoAtual != valor) c.depositar(valor)
    }
}