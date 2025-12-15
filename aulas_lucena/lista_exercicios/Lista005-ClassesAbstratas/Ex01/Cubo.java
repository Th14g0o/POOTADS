public class Cubo extends Figura3D{
    private double lado;

    public Cubo(double lado){
        if (lado >= 0) this.lado = lado;
    }
    
    @Override
    public double GetVolume(){
        return lado * lado * lado;
    }
}