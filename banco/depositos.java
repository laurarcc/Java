package banco;

public class depositos extends productos{
    String fecha_vencimiento;
    String cuenta_asociada;
    Double comision_admin=0.001;

    public Double getComision_admin() {
        return comision_admin;
    }

    public void setComision_admin(Double comision_admin) {
        this.comision_admin = comision_admin;
    }

    public depositos(String num_produc, String fecha_apertura, String fecha_vencimiento, String cuenta_asociada, String DNI, Double saldo) {
        super(num_produc, fecha_apertura, DNI, saldo);
        this.fecha_vencimiento=fecha_vencimiento;
        this.cuenta_asociada=cuenta_asociada;
    }

    @Override
    public double Calcula_comision() {
        return getComision_admin()*saldo;
    }
}
