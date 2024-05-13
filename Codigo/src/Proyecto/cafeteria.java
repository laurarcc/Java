package Proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cafeteria {
    // Declaración
    private JFrame frame;
    private JPanel panel;
    private JButton regis, startSesion, sin_sesion;
    private JTextField text;  // x2
    private JLabel texto, info, eu; // x2
    private FlowLayout flowLayout;

    public cafeteria() {
        primera_ventana();
    }

    public void primera_ventana() {
        //Crear frame
        frame = new JFrame();
        frame.setTitle("Cuentamelo con un café");

        flowLayout = new FlowLayout(FlowLayout.CENTER, 120, 10); // Espacios de 20 píxeles horizontalmente y 10 píxeles verticalmente

        //Crear texto
        texto = new JLabel("Bienvenido a Chisme y Café");
        info = new JLabel("Si no está registrado es su momento para conseguir grandes descuentos en libros y comdia :)");
        eu = new JLabel("Los libros/comics/mangas hasta un 10%, culpale a la España");

        //Crear panel
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 5));
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
                //entrar a otra página con el botón
                registrar_sesion();
            }
        });

        startSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciar_sesion();
            }
        });

        //Especificaciones del panel
        frame.setVisible(true);
        frame.setBounds(200,200,700,340);

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
        //Crear frame
        JFrame frameini = new JFrame();
        frameini.setTitle("Iniciar Sesión");

        //Crear panel
        JPanel panelini = new JPanel();
        panelini.setBackground(new Color(0xF4CFC7));

        //Crear iniciar sesion y password field
        JLabel ini = new JLabel("Introduzca número de telfono o e-mail");
        JTextField ini_text = new JTextField(10);

        JLabel passw_label = new JLabel("Introduzca su contraseña");
        JPasswordField passw = new JPasswordField(10);
        passw.setEchoChar('*');

        //Botón continuar o ir para atrás
        JButton cfm = new JButton("Confirmar");
        boton_confirm(cfm);

        JButton atras = new JButton("Atrás");
        atras.setBackground(new Color(0xE79796));
        Boton_atras(atras);

        frameini.setVisible(true);
        frameini.setBounds(200,200,600,600);

        panelini.add(ini);
        panelini.add(ini_text);

        panelini.add(passw_label);
        panelini.add(passw);

        panelini.add(atras);
        panelini.add(cfm);

        frameini.add(panelini);
        frameini.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void registrar_sesion(){
        //Crear frame
        JFrame framere  = new JFrame();
        frame.setTitle("Registrarse");

        //Crear panel
        JPanel panere = new JPanel();
        panere.setBackground(new Color(0xE79796));

        //Campos para registrarse
        JLabel nombre = new JLabel("Introduzca un nombre");
        JTextField nombre_text = new JTextField(10);

        JLabel apellido = new JLabel("Introduzca el apellido");
        JTextField apellido_text = new JTextField(10);

        JRadioButton telefono = new JRadioButton("Telefono");
        JRadioButton email = new JRadioButton("Email");

        telefono.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //Botón continuar o ir para atrás
        JButton cfm = new JButton("Confirmar");
        boton_confirm(cfm);

        JButton atras = new JButton("Atrás");
        atras.setBackground(new Color(0xE79796));
        Boton_atras(atras);

        framere.setVisible(true);
        framere.setBounds(200,200,600,600);

        panere.add(atras);
        panere.add(cfm);

        framere.add(panere);
        framere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void boton_confirm(JButton cfm) {
        cfm.setBackground(new Color(0xE79796));
        cfm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Comprobar con la bbdd si es correcta la contraseña y usuario
                boolean comprobar = true;
                if (comprobar) {
                    pedir();
                } else {
                    showErrorDialog("La contraseña proporcionada es incorrecta.");
                }
            }

            private void showErrorDialog(String s) {
                JOptionPane.showMessageDialog(null, s, "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public void pedir(){
        JLabel texto  = new JLabel("WIP");
    }

    private void Boton_atras(JButton atras) {
        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameatras = new JFrame();
                JPanel panelatras = new JPanel();
                panelatras.setBackground(new Color(0xE79796));

                JLabel text  = new JLabel("¿Desea ir hacia atrás?");

                JButton si = new JButton("Si");
                si.setBackground(new Color(0xDDA38F));
                si.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        primera_ventana();
                    }
                });

                JButton no = new JButton("No");
                no.setBackground(new Color(0xDDA38F));
                no.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        iniciar_sesion();
                    }
                });

                panelatras.add(si);
                panelatras.add(no);
                panelatras.add(text);

                frameatras.add(panelatras);

                frameatras.setVisible(true);
                frameatras.setBounds(500,500,200,100);
                frameatras.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }

    public static void main(String[] args) {
        cafeteria cafeteria = new cafeteria();
    }

}