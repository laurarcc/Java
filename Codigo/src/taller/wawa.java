package taller;

import java.time.LocalDate;

public class wawa extends vehiculos{
    Double numero_plazas;
    String servicio;
    wawa(String matricula, String chasis, String marca, String potencia, String DNI_pro,
         LocalDate fecha_matric, Double numero_plazas, String servicio) {
        super(matricula, chasis, marca, potencia, DNI_pro, fecha_matric);
        this.numero_plazas = numero_plazas;
        this.servicio = servicio;
    }

    @Override
    public String itv() {
        return "La ITV se redefine a 2 años";
    }
}
