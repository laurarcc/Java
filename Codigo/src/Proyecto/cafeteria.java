package Proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.*;
import java.sql.*;

//usar un unico frame , remove de ventanas
public class cafeteria {
    // Declaración
    private JFrame frame;
    private JPanel panel;
    private JButton regis, startSesion, sin_sesion;
    private JLabel texto, info, eu; // x2
    private FlowLayout flowLayout;
    private String nombre_admin = "pancracio";

    public cafeteria() {
        primera_ventana();
    }

    public void primera_ventana() {
        //Crear frame
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setTitle("Cuentamelo con un café");

        // Espacios de 120 píxeles horizontalmente y 10 píxeles verticalmente
        flowLayout = new FlowLayout(FlowLayout.CENTER, 120, 10);

        //Crear texto
        texto = new JLabel("Bienvenido a Chisme y Café");
        info = new JLabel("¡Aprovecha esta oportunidad para registrarte y conseguir grandes descuentos!");
        eu = new JLabel("Los libros/comics/mangas hasta un 10%, culpale a la España");

        texto.setFont(new Font("Serif", Font.PLAIN, 20));
        info.setFont(new Font("Serif", Font.PLAIN, 20));
        eu.setFont(new Font("Serif", Font.PLAIN, 20));

        texto.setHorizontalAlignment(SwingConstants.CENTER);
        info.setHorizontalAlignment(SwingConstants.CENTER);
        eu.setHorizontalAlignment(SwingConstants.CENTER);

        texto.setForeground(Color.WHITE);
        info.setForeground(Color.WHITE);
        eu.setForeground(Color.WHITE);

        //Crear paneln con imagen fondo
        panel = new ImagenPanel("./src/Proyecto/cafeteria.jpg");
        panel.setBackground(new Color(0xF4CFC7));

        //Botones de registrarse e iniciar sesion
        regis = new JButton("Registrarse");
        regis.setPreferredSize(new Dimension(150, 70)); //tamaño para los botonones
        startSesion = new JButton("Iniciar Sesión");
        startSesion.setPreferredSize(new Dimension(150, 70)); //tamaño para los botonones
        sin_sesion = new JButton("Continuar sin sesión");
        sin_sesion.setPreferredSize(new Dimension(150, 70)); //tamaño para los botonones

        regis.setBackground(new Color(0xE79796));
        startSesion.setBackground(new Color(0xE79796));
        sin_sesion.setBackground(new Color(0xE79796));

        //Action listener
        regis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrar_sesion();
                panel.setVisible(false);
            }
        });

        startSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciar_sesion();
                panel.setVisible(false);
            }
        });

        sin_sesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pedir();
                panel.setVisible(false);
            }
        });

        //Especificaciones del panel
        frame.setVisible(true);
        frame.setSize(730,340);

        //Imagen

        //Texto
        panel.add(texto);
        panel.add(info);
        panel.add(eu);

        //Botones al panel
        panel.add(regis);
        panel.add(startSesion);
        panel.add(sin_sesion);

        panel.setLayout(flowLayout);
        frame.add(panel);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void iniciar_sesion(){
        // Espacios de 100 píxeles horizontalmente y 10 píxeles verticalmente
        flowLayout = new FlowLayout(FlowLayout.CENTER, 100, 10);

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
        Boton_atras(atras);

        frame.setVisible(true);
        frame.setSize(300,300);

        panelini.add(ini);
        panelini.add(ini_text);

        panelini.add(atras);
        panelini.add(cfm);

        panelini.setLayout(flowLayout);
        frame.add(panelini);
    }

    public void registrar_sesion(){
        // Espacios de 100 píxeles horizontalmente y 10 píxeles verticalmente
        flowLayout = new FlowLayout(FlowLayout.CENTER, 100, 10);

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
        Boton_atras(atras);

        frame.setVisible(true);
        frame.setSize(300,400);

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
        frame.add(panere);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
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

    private void boton_confirm(JButton cfm , String text) {
        cfm.setBackground(new Color(0xE79796));
        cfm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Comprobar con la bbdd si es correcto el email
                if (text.equals(nombre_admin)) {
                    administrador admin = new administrador(nombre_admin);
                    new administrador(admin);
                    //usuario
                } else if (usuario_registrado(text)) {
                    System.out.println("Ta bueno");
                } else {
                    showErrorDialog("El email proporcionado es incorrecta.");
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

    public void pedir(){
        JPanel pedir_panel = new JPanel();
        pedir_panel.setSize(730,340);
        JLabel texto  = new JLabel("WIP");

        /*Combo box que muestre las diferentes bebidas y se elige una
        * tiene que seleccionar una si o si, si no le echa, después de
        * elegir algo que tomar puede elegir si quiere libro o no, se le
        * suma al precio final y paga en caja.*/


        //Añadir cosas a panel
        pedir_panel.add(texto);

        //Añadir cosas al frame
        frame.add(pedir_panel);
    }

    private void Boton_atras(JButton atras) {
        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panelatras = new JPanel();
                panelatras.setBackground(new Color(0xE79796));

                JLabel text  = new JLabel("¿Desea ir hacia atrás?");

                JButton si = new JButton("Si");
                si.setBackground(new Color(0xDDA38F));
                si.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        primera_ventana();
                        panelatras.setVisible(false);
                    }
                });

                JButton no = new JButton("No");
                no.setBackground(new Color(0xDDA38F));
                no.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        iniciar_sesion();
                        panelatras.setVisible(false);
                    }
                });

                panelatras.add(si);
                panelatras.add(no);
                panelatras.add(text);

                frame.add(panelatras);

                frame.setVisible(true);
                frame.setSize(200,100);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }

    public static void main(String[] args) {
        cafeteria cafeteria = new cafeteria();
    }

}