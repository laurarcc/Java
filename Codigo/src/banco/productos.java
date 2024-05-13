package banco;

public abstract class productos {
    String num_produc;
    String fecha_apertura; //localdate?
    String DNI;
    Double saldo;

    public productos(String num_produc, String fecha_apertura, String DNI, Double saldo) {
        this.num_produc = num_produc;
        this.DNI = DNI;
        this.fecha_apertura = fecha_apertura;
        this.saldo = saldo;
    }

    public abstract double Calcula_comision();

}
