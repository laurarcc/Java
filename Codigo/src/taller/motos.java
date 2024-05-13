package taller;

import java.time.LocalDate;

public class motos extends vehiculos{

    motos(String matricula, String chasis, String marca, String potencia, String DNI_pro, LocalDate fecha_matric) {
        super(matricula, chasis, marca, potencia, DNI_pro, fecha_matric);
    }

    @Override
    public String itv(){
        return ("La ITV es cada 5 años");
    }
}
