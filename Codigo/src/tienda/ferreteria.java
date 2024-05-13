package tienda;

public class ferreteria extends productos{
    String tipo;
    public ferreteria(String codigo){
        super(codigo);
        listraProd.add(this);
    }

    @Override
    public String toString() {
        return "ferreteria{" +
                "tipo='" + tipo + '\'' +
                "} " + super.toString();
    }

    @Override
    public Double descuento() {
        return 0.1;
    }
}
