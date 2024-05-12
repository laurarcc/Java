package taller;

import java.time.LocalDate;

public class turismos extends vehiculos{
    Double numero_puertas;
    String remolque; //que coño?
    Double numero_plazas;

    turismos(String matricula, String chasis, String marca, String potencia, String DNI_pro, LocalDate fecha_matric,String remolque,
             Double numero_puertas, Double numero_plazas) {
        super(matricula, chasis, marca, potencia, DNI_pro, fecha_matric);
        this.numero_plazas = numero_plazas;
        this.remolque = remolque;
        this.numero_puertas = numero_puertas;
    }

    @Override
    public String itv() {
        return "La ITV se redefine a los 5 años";
    }
}
