package interfaz_herencia;

import herencia.person;

import java.time.LocalDate;

public class alumnos extends personas implements acceso{
    String CIAL;
    String ciclo;

    public String getCIAL() {
        return CIAL;
    }

    public void setCIAL(String CIAL) {
        this.CIAL = CIAL;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public alumnos(String nombre, String DNI, LocalDate fecha_nc, String CIAL, String ciclo){
        super(nombre,DNI,fecha_nc);
        this.CIAL=CIAL;
        this.ciclo=ciclo;
    }

    @Override
    public String toString() {
        return "alumnos{" +
                "nombre='" + nombre + '\'' +
                ", DNI='" + DNI + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", CIAL='" + CIAL + '\'' +
                ", ciclo='" + ciclo + '\'' +
                "} ";
    }

    @Override
    public String getIdef() {
        return this.CIAL;
    }

    @Override
    public void setIdef(String CIAL) {
        this.CIAL = CIAL;
    }
}
