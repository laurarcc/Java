package ficheros;

import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

public class ejercicio_ficheros {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Actividad 1 : Listado de ficheros en el directorio actual");
        File dirActual = new File(".");
        String[] directorioActual = dirActual.list();
        assert directorioActual != null;
        for(String fichero : directorioActual){
            System.out.println(fichero);
        }

        System.out.println("Actividad 2 : Listar ficheros de directorio proporcionado");
        String retudir = teclado.nextLine();
        File dirProporcionado = new File(retudir);
        String[] directorioProporcionado = dirProporcionado.list();
        assert directorioProporcionado != null;
        for(String fichero : directorioProporcionado){
            System.out.println(fichero);
        }

        System.out.println("Actividad 3 : Mostrar propiedades del directorio proporcionado");
        String ruta = teclado.nextLine();
        File directorio = new File(ruta);
        File[] ficheros = directorio.listFiles();

        if(ficheros != null){
            for(File fichero : ficheros){
                System.out.println("Nombre: "+fichero.getName());
                System.out.println("Ruta relativa: "+fichero.getPath());
                System.out.println("Ruta absoluta: "+fichero.getAbsolutePath());
                System.out.println("Atributo lectura: "+fichero.canRead());
                System.out.println("Atributo escritura: "+fichero.canWrite());
                System.out.println("Tamaño: "+fichero.length());
                System.out.println("Si es un directorio: "+fichero.isDirectory());
                System.out.println("Si es un fichero: "+fichero.isFile());
            }
        }

        System.out.println("Lectura y escritura de desde/hacia un archivo de texto: ");
        File fichi = new File("texto.txt");

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("texto.txt"));
            BufferedReader br = new BufferedReader(new FileReader(fichi));

            String contenido = "Dam" + "\n";

            for(int i=1;i<=10;i++){
                String linea="Fila "+i+" "+contenido+"\n";
                bw.write(linea);
            }
            bw.flush();

            String linea;
            while((linea = br.readLine()) != null){
                System.out.println(linea);
            }

            System.out.println("Archivo de texto escrito y leido correctamente.");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de texto.");


        }
    }
}
