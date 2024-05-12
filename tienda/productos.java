package tienda;
import java.util.ArrayList;

public abstract class productos {
    static ArrayList<productos> listraProd=new ArrayList<>();
    String codigo;
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    String nombre;
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    Double precio;
    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }


    public productos(String codigo){
        this.codigo=codigo;
    }

    @Override
    public String toString() {
        return "productos{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    public abstract Double descuento();
}