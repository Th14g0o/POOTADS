public class Racional{
    private int num;
    private int den;

    public Racional(int num, int den){
        this.num = num;
        this.den = den;
    }
    public Racional(int num){
        this(num, 1) // chama o constrututor
    }

    public Racional multiplicar(Racional b){
        var a = this; // this -> recupera o proprio objeto
        var num = a.num * b.num; // var -> indica que vai ser inferido pelo compilador
        var den = a.den * b.den;
        Racional c = new Racional(num, den);
        return c;
    }
}