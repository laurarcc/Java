package FigurasGeometricas;

public class Triangulo extends Geo implements  formula{
    Double lado;
    Double base;
    Double altura;


    public Triangulo(String name){
        //Instanciar al padre de donde hereda o podemos llamarlo como super.color;
        super(name);

    }

    @Override
    public Double Area() {
        return ((this.base*this.altura)/2);
    }

    @Override
    public Double perimetro() {
        return null;
    }

    /*@Override
    public Double Area() {
        return ((this.base*this.altura)/2 );
    }*/

}
