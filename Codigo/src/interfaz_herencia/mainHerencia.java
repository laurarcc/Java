package interfaz_herencia;

import herencia.alumnos;
import herencia.mainClase;
import herencia.profesores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class mainHerencia {
    public static void main(String[] args){
        Scanner teclado=new Scanner(System.in);
        ArrayList<herencia.profesores> listP=new ArrayList<>();
        ArrayList<herencia.alumnos> listA=new ArrayList<>();

        System.out.println("¿Qué desea ingresar? Profesores o alumnos");
        String var=teclado.next();

        if(var.equalsIgnoreCase("PROFESORES")){
            System.out.println("¿Cuántos profesores quiere ingresar?");

            int contProf=teclado.nextInt();
            int cont=0;

            do{
                System.out.println("Porfavor, introduzca los datos del profesor: ");
                System.out.println("Nombre, DNI, fecha de nacimiento (YYYY-MM-DD), NRP, especialidad, Centro de Destino");

                mainClase.Datos variables = getDatos(teclado);

                String NRP = teclado.next();
                String espcialidad =teclado.next();
                String CentroDestino=teclado.next();

                herencia.profesores teacher =new profesores(variables.name(), variables.DNI(), variables.fecha_nac(),NRP,espcialidad,CentroDestino);
                listP.add(teacher);

                cont++;
            }while(cont<contProf);

        } else {
            System.out.println("¿Cuántos alumnos quiere ingresar?");
            int contAlum=teclado.nextInt();
            int contador=0;

            do{
                System.out.println("Porfavor, introduzca los datos del estudiante: ");
                System.out.println("Nombre, DNI, fecha de nacimiento, CIA y ciclo");

                mainClase.Datos variables = getDatos(teclado);

                String CIAL = teclado.next();
                String ciclo =teclado.next();

                herencia.alumnos estudiante = new alumnos(variables.name(), variables.DNI(),variables.fecha_nac(),CIAL,ciclo);
                listA.add(estudiante);
                //como se calcula edad con localdate

                contador++;
            }while(contador<contAlum);
        }

        System.out.println("Si hay algún dato que desee comprobar diga si, de lo contrario diga no");
        String si=teclado.next();

        if(si.equalsIgnoreCase("SI")){
            System.out.println("Que desea comprobar, profesores, alumnos o ambos");
            String comprobar=teclado.next();

            if(comprobar.equalsIgnoreCase("PROFESORES")){
                System.out.println("Datos obtenidos de los profesores "+listP);
            } else if (comprobar.equalsIgnoreCase("ALUMNOS")) {
                System.out.println("Datos obtenidos de los estudiantes "+listA);
            } else if (comprobar.equalsIgnoreCase("AMBOS")){
                System.out.println("Datos obtenidos de los profesores "+listP);
                System.out.println("Datos obtenidos de los estudiantes "+listA);
            }
        } else {
            System.out.println("Buenos días, un placer.");
        }

    }

    private static mainClase.Datos getDatos(Scanner teclado) {
        String name= teclado.next();
        String DNI= teclado.next();
        LocalDate fecha_nac= LocalDate.parse(teclado.next());
        return new mainClase.Datos(name, DNI, fecha_nac);
    }

    public record Datos(String name, String DNI, LocalDate fecha_nac) {
    }

}
