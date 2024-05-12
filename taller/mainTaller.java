package taller;
import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class mainTaller {
    public static void main(String[] arg){
        //Con formato para la fecha
        DateTimeFormatter formato= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha="11-11-2020";
        LocalDate date=LocalDate.parse(fecha,formato);

        //Sin formato para la fecha
        LocalDate fecha2=LocalDate.parse(fecha);

        //Clases ya cargadas
        motos moto = new motos("2222T","chasis","marca","potencia","DNI_pro",date);
        turismos coche = new turismos("matricula","chasis","marca","potencia","DNI",date,"remolque",5.0,5.0);
        wawa bus = new wawa("matricula","chasis","marca","potencia","DNI",date,30.0,"publico");

        Scanner teclado=new Scanner(System.in);
        String variable=teclado.next();

        if(variable.equalsIgnoreCase("motos")){
            System.out.println(moto.itv());
        } else if (variable.equalsIgnoreCase("coche")) {
            System.out.println(coche.itv());
        } else if (variable.equalsIgnoreCase("bus")) {
            System.out.print(bus.itv());
        }
    }

}
