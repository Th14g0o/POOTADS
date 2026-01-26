public class Esfera extends Figura3D {
    private double raio;
    public Esfera(double raio){
        if (raio >= 0) this.raio = raio;
    }
    public double GetVolume(){
        return 4 * Math.PI * (this.raio*this.raio*this.raio) / 3;
    }
}