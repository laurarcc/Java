package interfaz_herencia;

import java.time.LocalDate;

public class tutores extends profesores implements acceso, sueldo{
    String grupo;

    public tutores(String nombre, String DNI, LocalDate fecha_nc, String NRP, Integer especialidad,
                   String centroDestino, Double salario, String grupo) {
        super(nombre, DNI, fecha_nc,NRP,especialidad,centroDestino,salario);
        this.grupo = grupo;
    }

    @Override
    public String getIdef() {
        return this.NRP;
    }

    @Override
    public void setIdef(String NRP) {
        this.NRP = NRP;
    }

    @Override
    public double getSueldo() {
        return (this.salario*aumento);
    }
}
