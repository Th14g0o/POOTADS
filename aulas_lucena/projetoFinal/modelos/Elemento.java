package aulas_lucena.projetoFinal.modelos;
// import java.util.ArrayList;
import java.util.List;

public class Elemento{
    private String nome;
    private List<Elemento> fraquezas;
    private List<Elemento> vantagens;
    private String cor;

    public Elemento(String nome, String cor){
        this.nome = nome;
        this.cor = cor;
    }

    public void setFraquezas(List<Elemento> fraquezas){
        for (Elemento elemento : fraquezas)  
            this.setFraqueza(elemento);
    }
    public void setFraqueza(Elemento fraqueza){
        this.fraquezas.add(fraqueza);
    }
    public void setVantagens(List<Elemento> vantagens){
        for (Elemento elemento : vantagens)  
            this.setVantagem(elemento);
    }
    public void setVantagem(Elemento vantagens){
        this.vantagens.add(vantagens);
    }
}