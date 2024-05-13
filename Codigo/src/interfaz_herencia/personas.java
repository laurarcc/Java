package interfaz_herencia;

import java.time.LocalDate;
import java.time.Period;

public class personas {
    String nombre;
    String DNI;
    LocalDate fecha_nacimiento;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int CalcularEdad(){
        LocalDate fecha_hoy= LocalDate.now();
        Period periodo = Period.between(fecha_hoy, fecha_nacimiento);
        return periodo.getYears();
    }

    public personas(String nombre,String DNI, LocalDate fecha_nacimiento) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public String toString() {
        return "personas{" +
                "nombre='" + nombre + '\'' +
                ", DNI='" + DNI + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                '}';
    }
}
