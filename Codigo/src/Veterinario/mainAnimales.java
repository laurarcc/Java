package Veterinario;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class mainAnimales {
    public static void main(String[] args){

        ArrayList<loros> listaL=new ArrayList<>();
        ArrayList<perros> listaP=new ArrayList<>();
        ArrayList<gatos> listaG=new ArrayList<>();

        /*gatos cat=new gatos("gato1",0.0,"miau");
        if(animales.get(0) instanceof gatos){
            System.out.println((gatos) animales.get(0).getName());
        }  (mirar bien) */

        int contVacG=0;
        int contVacP=0;
        int contVacL=0;

        System.out.println("Bienvenido al veterinario especializados en loros, perros y gatos :) ");
        System.out.println("Indiquenos porfavor su nombre y apellidos");

        Scanner teclado=new Scanner(System.in);

        //Solamente está para decorar un poco
        String nombreD= teclado.next();
        teclado.nextLine();
        String apellidoD= teclado.next();

        System.out.println("Holita "+nombreD+" "+apellidoD);

        //Método para controlar que entran solo números
        int cont = controlInt(teclado);

        int cuantos=0;

        //Método para controlar que entran solo letras
        String word = controlString(teclado);

        while(cont>cuantos){
            switch (word) {
                case "LOROS" -> {
                    System.out.println("Ingrese el nombre del loro y su tamaño: ");

                    String name = teclado.next();
                    Double size = teclado.nextDouble();

                    loros loro = new loros(name, size);
                    listaL.add(loro);

                    System.out.println("¿Está vacunado? S/N");
                    String vac = teclado.next().toUpperCase();
                    loro.vacuna();
                    contVacL = getContVacL(vac, contVacL);
                }

                case "PERROS" -> {
                    System.out.println("Ingrese el nombre del perro, tamaño y raza: ");
                    System.out.println("En caso de ser mezcla ponga mix o no saber");

                    String name = teclado.next();
                    Double size = teclado.nextDouble();

                    teclado.nextLine();

                    String raza = teclado.next();
                    perros perro = new perros(name, size, raza);
                    listaP.add(perro);

                    System.out.println("¿Está vacunado? S/N");
                    String vac = teclado.next().toUpperCase();
                    perro.setVacuna(vac);
                    perro.vacuna();
                    contVacP = getVacP(vac, contVacP);

                }

                case "GATOS" -> {
                    System.out.println("Ingrese el nombre del gato, tamaño y raza: ");
                    System.out.println("En caso de ser mezcla ponga mix o no saber");

                    String name = teclado.next();
                    Double size = teclado.nextDouble();

                    teclado.nextLine();

                    String raza = teclado.next();
                    gatos gato = new gatos(name, size, raza);
                    listaG.add(gato);

                    System.out.println("¿Está vacunado? S/N");
                    String vac = teclado.next().toUpperCase();
                    gato.vacuna();
                    //System.out.println(gato.vacuna());
                    contVacG = getContVacG(vac, contVacG);

                }
                default -> System.out.println("No disponemos de personal para ese animal todavía");
            }
            cuantos++;
        }
        imprimir(listaL,listaG,listaP);
    }

    private static String controlString(Scanner teclado) {
        String word="";
        boolean valido=false;
        while (!valido) {
            System.out.println("¿Qué animal desea ingresar?");
            if (teclado.hasNext()) {
                word= teclado.next().toUpperCase();
                valido = true;
            } else {
                System.out.print("Porfavor introduzca lo que se pide");
                teclado.next();
            }
        }
        return word;
    }

    private static int controlInt(Scanner teclado) {
        int cont=0;
        boolean siesnumero=false;

        while (!siesnumero) {
            System.out.print("Introduce cuantos animales deseas introducir: ");
            if (teclado.hasNextInt()) {
                cont = teclado.nextInt();
                siesnumero = true;
            } else {
                System.out.print("Porfavor introduzca un numero entero ");
                teclado.next();
            }
        }
        return cont;
    }

    private static int getContVacL(String vac, int contVacL) {
        if (Objects.equals(vac, "SI")) {
            System.out.println("¡Muy bien!");
            contVacL++;
        } else {
            System.out.println("Vacunalo porfavor");
        }
        return contVacL;
    }

    private static int getVacP(String vac, int contVacP) {
        if(Objects.equals(vac, "SI")){
            System.out.println("¡Muy bien!");
            contVacP++;
        } else {
            System.out.println("Vacunalo porfavor");
        }
        return contVacP;
    }

    private static int getContVacG(String vac, int contVacG) {
        if(Objects.equals(vac, "SI")){
            System.out.println("¡Muy bien!");
            contVacG++;
        } else {
            System.out.println("Vacunalo porfavor");
        }
        return contVacG;
    }

    private static void imprimir(ArrayList<loros> listaL, ArrayList<gatos> listaG, ArrayList<perros> listaP) {
        System.out.println("Los animales que se han registrado son los siguientes: ");
        for (Veterinario.loros animales : listaL) {
            System.out.println(animales);
        }

        for (Veterinario.perros animales : listaP) {
            System.out.println(animales);
        }

        for (Veterinario.gatos animales : listaG) {
            System.out.println(animales);
        }
    }
}
