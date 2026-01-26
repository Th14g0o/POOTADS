public class Circulo extends Forma {
    private double raio;

    public Circulo(double raio){
        this.raio = raio;
    }

    @Override
    public double area(){
        return raio * raio * Math.PI;
    }
    @Override
    public double perimetro(){
        return 2 * Math.PI * raio;
    }
}