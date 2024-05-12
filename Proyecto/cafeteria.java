import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cafeteria {
    // Declaration
    private JFrame frame;
    private JPanel panel;
    private JButton regis, startSesion;

    public cafeteria() {
        primera_ventana();
    }

    public void primera_ventana() {
        //Crear frame
        frame = new JFrame();
        frame.setTitle("Chisme y Café o Cuentamelo con un café");

        //Crear panel
        panel = new JPanel();
        panel.setBackground(new Color(0xF4CFC7));

        //Botones de registrarse e iniciar sesion
        regis = new JButton("Registrarse");
        startSesion = new JButton("Iniciar Sesión");

        regis.setBackground(new Color(0xE79796));
        startSesion.setBackground(new Color(0xE79796));

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
        frame.setBounds(200,200,600,600);

        //Botones al panel
        panel.add(regis);
        panel.add(startSesion);

        frame.add(panel);
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
                    //Option pane de error
                }
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