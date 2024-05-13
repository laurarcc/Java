package taller;

import java.time.LocalDate;

public abstract class vehiculos {
    String matricula;
    String chasis; //numero de chasis
    String marca;
    String potencia;
    String DNI_pro; //DNI de propietario del vehículo
    LocalDate fecha_matric; //fecha de matriculación

    public abstract String itv();

    vehiculos(String matricula,String chasis,String marca, String potencia,String DNI_pro,LocalDate fecha_matric){
        this.chasis = chasis;
        this.matricula = matricula;
        this.marca = marca;
        this.potencia = potencia;
        this.DNI_pro = DNI_pro;
        this.fecha_matric = fecha_matric;
    }

    @Override
    public String toString() {
        return "vehiculos{" +
                "matricula='" + matricula + '\'' +
                ", chasis='" + chasis + '\'' +
                ", marca='" + marca + '\'' +
                ", potencia='" + potencia + '\'' +
                ", DNI_pro='" + DNI_pro + '\'' +
                ", fecha_matric=" + fecha_matric +
                '}';
    }
}
