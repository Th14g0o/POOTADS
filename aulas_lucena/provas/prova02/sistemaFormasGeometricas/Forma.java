public abstract class Forma  {
  public abstract double area();
  public abstract double perimetro();

  @Override
  public String toString(){
    return String.format("Forma[area=%.2f, perimetro=%.2f]", this.area(), this.perimetro());
  }

}