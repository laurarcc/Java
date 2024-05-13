package banco;

public class cuentas extends productos{

    String nombre;
    String apellidos;
    Double comision=5.0; //5euros por mes

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    public cuentas(String num_produc, String fecha_apertura, String DNI, String nombre, String apellidos, Double saldo) {
        super(num_produc, fecha_apertura, DNI, saldo);
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    @Override
    public double Calcula_comision() {
        return getComision();
    }
}
