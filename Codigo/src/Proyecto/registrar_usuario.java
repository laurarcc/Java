package Proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;

public class registrar_usuario extends JFrame {
    private String nombre_admin = "pancracio";
    static registrar_usuario registro;
    public registrar_usuario(){
        // Espacios de 100 píxeles horizontalmente y 10 píxeles verticalmente
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 100, 10);

        //Crear panel
        JPanel panere = new JPanel();
        panere.setBackground(new Color(0xE79796));

        //Campos para registrarse
        JLabel nombre = new JLabel("Introduzca un nombre");
        JTextField nombre_text = new JTextField(10);

        JLabel apellido = new JLabel("Introduzca el apellido");
        JTextField apellido_text = new JTextField(10);

        JLabel email = new JLabel("Introduzca el email");
        JTextField email_text = new JTextField(10);

        //Radio Button
        JLabel info = new JLabel("¿Desea recibir información de las promociones?");
        JRadioButton yes = new JRadioButton("Si");
        JRadioButton no = new JRadioButton("No");
        ButtonGroup group = new ButtonGroup();

        //agrupar radios button
        group.add(yes);
        group.add(no);

        //Botón continuar o ir para atrás
        JButton cfm_regis= new JButton("Confirmar");
        confirm_regis(cfm_regis, email_text.getText());

        JButton atras = new JButton("Atrás");
        atras.setBackground(new Color(0xE79796));

        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ventana_inicio();
                registro.dispose();
            }
        });


        setVisible(true);
        setSize(300,400);

        panere.add(nombre);
        panere.add(nombre_text);

        panere.add(apellido);
        panere.add(apellido_text);

        panere.add(email);
        panere.add(email_text);

        panere.add(info);
        panere.add(yes);
        panere.add(no);

        panere.add(atras);
        panere.add(cfm_regis);

        panere.setLayout(flowLayout);
        add(panere);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        registro = this;
    }

    private void confirm_regis(JButton cfmRegis, String text) {
        cfmRegis.setBackground(new Color(0xE79796));
        cfmRegis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Comprobar si el email ya está registrado en la BBDD
                if (text.equals(nombre_admin)){
                    showErrorDialog("El email que desea registrar, ya está registrado");
                } else if(usuario_registrado(text)) {
                    System.out.println("Usuario registrado");
                } else {
                    showErrorDialog("Este email ya ha sido registrado");
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
