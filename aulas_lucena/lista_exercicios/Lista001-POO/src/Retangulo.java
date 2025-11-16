public class Retangulo {
    private double b;
    private double h;

    public Retangulo(double b, double h){
        SetBase(b);
        SetAltura(h);
    }

    public void SetBase(double b){
        if (b > 0) this.b = b;
    }
    public void SetAltura(double h){
        if (h > 0) this.h = h;
    }
    public double GetBase(){
        return b;
    }
    public double GetAltura(){
        return h;
    }

    public double CalcArea(){
        return b * h;
    }
    public double CalcDiagonal(){
        return Math.sqrt(b * b + h * h);
    }

    @Override
    public String toString() {
        return String.format("Retangulo\nBase: %.2f\nAltura: %.2f\nArea = %.2f\nDiagonal = %.2f", b, h, CalcArea(), CalcDiagonal());
    }
}
