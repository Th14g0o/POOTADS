public class EquacaoII {
    private double a;
    private double b;
    private double c;

    public EquacaoII(double a, double b, double c){
        SetA(a);
        SetB(b);
        SetC(c);
    }

    public void SetA(double a){
        this.a = a;
    }
    public void SetB(double b){
        this.b = b;
    }
    public void SetC(double c){
        this.c = c;
    }
    public double GetA(){
        return a;
    }
    public double GetB(){
        return b;
    }
    public double GetC(){
        return c;
    }

    public double CalcDelta(){
        return b*b - 4*a*c;
    }
    public double[] CalcRaizes(){
        double[] raizes = new double[0];
        double delta = CalcDelta();
        if (delta >= 0){
            raizes = new double[2];
            raizes[0] = (-b + Math.sqrt(delta)) / 2 * a;
            raizes[1] = (-b - Math.sqrt(delta)) / 2 * a;
        }
        return raizes;
    }

    @Override
    public String toString(){
        double[] raizes = CalcRaizes();
        if (raizes.length > 0)
            return String.format("Equações\nDelta = %.2f\n%.2fx² + %.2fx + %.2f = %.2f\n%.2fx² + %.2fx + %.2f = %.2f", CalcDelta(), a,b,c,raizes[0], a,b,c, raizes[1]);
        else return String.format("Raizes Desconhecidas\nDelta = %.2f\n%.2fx² + %.2fx +  %.2f = Desconhecido", CalcDelta(), a, b, c);
    }
}
