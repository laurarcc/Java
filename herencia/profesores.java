package herencia;

import java.time.LocalDate;

public class profesores extends person{
    String NRP;
    String especialidad;
    String CentroDestino;

    public String getNRP(){
        return NRP;
    }

    public void setNRP(String NRP){
        this.NRP=NRP;
    }

    public String getEspecialidad(){
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCentroDestino(){
        return CentroDestino;
    }

    public void setCentroDestino(String CentroDestino){
        this.CentroDestino=CentroDestino;
    }

    public profesores(String nombre, String DNI, LocalDate fecha_nc, String NRP, String especialidad, String centroDestino){
        super(nombre,DNI,fecha_nc);
        this.CentroDestino=centroDestino;
        this.NRP=NRP;
        this.especialidad=especialidad;
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
                "} ";
    }
}
