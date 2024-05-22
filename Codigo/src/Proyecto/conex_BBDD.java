package Proyecto;
import java.io.*;
import java.sql.*;

public class conex_BBDD {
    public static void main(String[] args) throws IOException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafeteria", "root", "");
            Statement sentence = conn.createStatement();
            ResultSet libros, bebidas;

            //Verificar si la conexión es válida
            if(conn != null && !conn.isClosed()){
                System.out.println("Conexión a la base de datos establecida con éxito.");
            } else {
                System.out.println("No se pudo establecer la conexión con la base de datos.");
            }

            //Fichero que almacena las sentencias
            File fichout = new File("./Codigo/src/Proyecto/almacen.txt");
            FileWriter fw = new FileWriter(fichout);
            BufferedWriter bw = new BufferedWriter(fw);

            //Si el fichero no existe se crea
            if(!fichout.exists()){
                fichout.createNewFile();
            }

            //Escribir en el fichero las bebidas y si se vende uno restar (preguntar)
            bebidas = sentence.executeQuery("SELECT * FROM bebidas");
            while(bebidas.next()){
                bw.write(bebidas.getString(1)+"\n"+bebidas.getString(2)+"\n"
                +bebidas.getString(3)+"\n"+bebidas.getString(4));
                bw.newLine();
                bw.flush();
            }

            //Escribir en el fichero los libros  y si se vende uno restar (preguntar)
            libros = sentence.executeQuery("SELECT * FROM libros");
            while(libros.next()){
                bw.write(libros.getString(1)+"\n"+libros.getString(2)+"\n"+
                        libros.getString(3)+"\n"+libros.getString(4));
                bw.newLine();
                bw.flush();
            }

            bw.close();
            conn.close();

        }catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver JDBC.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos.");
            e.printStackTrace();
        }
    }


    }
