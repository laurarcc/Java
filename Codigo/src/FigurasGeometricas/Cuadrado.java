package FigurasGeometricas;

public class Cuadrado extends Geo implements formula {
    Double lado;
    public Cuadrado(String name){
        super(name);
    }

    @Override
    public Double Area() {
        return (this.lado*this.lado);
    }

    @Override
    public Double perimetro() {
        return (lado*lado);
    }

    //@Override
    /*public Double Area() {
        return (this.lado*this.lado);
    }*/
}
