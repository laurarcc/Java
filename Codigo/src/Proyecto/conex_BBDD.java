package Proyecto;
import java.io.*;
import java.sql.*;

public class conex_BBDD {
    public static void main(String[] args) throws IOException {
        try{
            Class.forName("com.mysql.jdbc.Driver"); //el error tiene que ver con esto
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafeteria", "root", "");
            Statement sentence = conn.createStatement();
            ResultSet resultado;

            //Verificar si la conexión es válida
            if(conn != null && !conn.isClosed()){
                System.out.println("Conexión a la base de datos establecida con éxito.");
            } else {
                System.out.println("No se pudo establecer la conexión con la base de datos.");
            }

            //Fichero que almacena las sentencias
            File fichout = new File("./src/almacen.txt");

            //Si el fichero no existe se crea
            if(!fichout.exists()){
                fichout.createNewFile();
            }

        }catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver JDBC.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos.");
            e.printStackTrace();
        }
    }
}
