package Proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;

public class iniciar_sesion extends ventana_inicio {
    private String nombre_admin = "pancracio";
    JFrame frame = new JFrame();
    public iniciar_sesion(){
        // Espacios de 100 píxeles horizontalmente y 10 píxeles verticalmente
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 100, 10);

        //Crear panel
        JPanel panelini = new JPanel();
        panelini.setBackground(new Color(0xF4CFC7));

        //Crear iniciar sesion
        JLabel ini = new JLabel("Introduzca número de e-mail");
        JTextField ini_text = new JTextField(10);

        //Botón continuar o ir para atrás
        JButton cfm = new JButton("Confirmar");
        boton_confirm(cfm, ini_text.getText().strip());

        JButton atras = new JButton("Atrás");
        atras.setBackground(new Color(0xE79796));

        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_inicio ventana_inicio = new ventana_inicio();
                new ventana_inicio();
            }
        });

        frame.setVisible(true);
        frame.setSize(300,300);

        panelini.add(ini);
        panelini.add(ini_text);

        panelini.add(atras);
        panelini.add(cfm);

        panelini.setLayout(flowLayout);
        frame.add(panelini);
    }

    private void boton_confirm(JButton cfm , String text) {
        cfm.setBackground(new Color(0xE79796));
        cfm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Comprobar con la bbdd si es correcto el email
                if (text.equals("pancracio")) {
                    administrador admin = new administrador(nombre_admin);
                    new administrador(admin);
                    //usuario
                } else if (usuario_registrado(text)) {
                    pedir ir = new pedir();
                    new pedir();
                } else {
                    showErrorDialog("El email proporcionado es incorrecto.");
                }
            }
        });
    }

    /**
     * Comprobamos que el usuario esté registrado en la base de datos
     * @param text es el email que se le pasa para comprobar a dicho usuario
     * @return false o true según se requiera
     */
    private boolean usuario_registrado(String text) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafeteria", "root", "");
            Statement sentence = conn.createStatement();
            ResultSet usuario;

            File fichin = new File("./Codigo/src/Proyecto/consultas.txt");
            BufferedReader br = new BufferedReader(new FileReader(fichin));

            //consulta
            String linea = br.readLine(); //porque es la primera linea, si es la segunda es un while
            usuario = sentence.executeQuery(linea);
            while (usuario.next()) {
                String reg = usuario.getString("EMAIL");
                if(reg.equals(text)){
                    return true;
                }
            }

            br.close();
            conn.close();

        }catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver JDBC.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos.");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    private void showErrorDialog(String s) {
        JOptionPane.showMessageDialog(null, s, "Error", JOptionPane.ERROR_MESSAGE);
    }

}
