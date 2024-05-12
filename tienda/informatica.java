package tienda;

public class informatica extends productos{

    String marca;
    public informatica(String codigo) {
        super(codigo);
        listraProd.add(this);
    }

    @Override
    public String toString() {
        return "informatica{" +
                "marca='" + marca + '\'' +
                "} " + super.toString();
    }

    @Override
    public Double descuento() {
        return 0.01;
    }
}
