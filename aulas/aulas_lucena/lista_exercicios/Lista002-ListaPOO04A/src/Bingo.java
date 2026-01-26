import java.util.Random;

public class Bingo {
    private int    numBolas;
    private int[]  bolas;
    private int    indice;
    private Random gerador;

    private boolean verifica_valor(int valor){
        for (int i = 0; i < this.numBolas; i++)
            if (this.bolas[i] == valor) return true;
        return false;
    }

    public Bingo(){
        this.gerador = new Random();
    }

    public void iniciar(int numBolas){
        this.numBolas = numBolas;
        this.bolas    = new int[numBolas];
        this.indice   = 0;
    }
    public int proximo(){
        if (this.indice == this.numBolas) return -1;
        int n = this.gerador.nextInt(1, this.numBolas);
        while (this.verifica_valor(n))
            n = this.gerador.nextInt(1, this.numBolas);
        this.bolas[indice] = n;
        this.indice++;
        return n;
    }
    public int[] sorteados(){
        int[] bolasSorteadas = new int[this.indice];
        for (int i = 0; i < this.indice; i ++)
            bolasSorteadas[i] = this.bolas[i];
        return bolasSorteadas;
    }

}
