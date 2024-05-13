package interfaz_herencia;

import java.time.LocalDate;

public class profesores extends personas implements acceso, sueldo{
    String NRP;
    Integer especialidad;
    String CentroDestino;
    Double salario;

    public Integer getEspecialidad(){
        return especialidad;
    }

    public void setEspecialidad(Integer especialidad) {
        this.especialidad = especialidad;
    }

    public String getCentroDestino(){
        return CentroDestino;
    }

    public void setCentroDestino(String CentroDestino){
        this.CentroDestino=CentroDestino;
    }

    public profesores(String nombre, String DNI, LocalDate fecha_nc, String NRP, Integer especialidad,
                      String centroDestino, Double salario){
        super(nombre,DNI,fecha_nc);
        this.CentroDestino = centroDestino;
        this.NRP = NRP;
        this.especialidad = especialidad;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "profesores{" +
                "nombre='" + nombre + '\'' +
                ", DNI='" + DNI + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", NRP='" + NRP + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", CentroDestino='" + CentroDestino + '\'' +
                ", Salario='" + salario + '\'' +
                "} ";
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
        return this.salario;
    }
}
