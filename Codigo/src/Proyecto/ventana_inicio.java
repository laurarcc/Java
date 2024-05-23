package Proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//hacer métodos de las interfaces a lo mejor es mas llevadero
public class ventana_inicio extends JFrame  {
    // Declaración
    private JPanel panel;
    private JButton regis, startSesion, sin_sesion;
    private JLabel texto, info, eu; // x2
    private FlowLayout flowLayout;

    static ventana_inicio ventana_inicio;

    public ventana_inicio() {
        //Panel
        panel = new JPanel();

        //Crear frame
        setLocationRelativeTo(null);
        setBounds(new Rectangle(700,500));
        setTitle("Cuéntamelo con un café");

        //Espacios de 120 píxeles horizontalmente y 10 píxeles verticalmente
        flowLayout = new FlowLayout(FlowLayout.CENTER, 50, 10);

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
        //panel = new ImagenPanel("./src/Proyecto/cafeteria.jpg");
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
                new registrar_usuario();
                ventana_inicio.dispose();
            }
        });

        startSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new iniciar_sesion();
                ventana_inicio.dispose();
            }
        });

        sin_sesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new pedir();
                ventana_inicio.dispose();
            }
        });

        //Especificaciones del panel
        setVisible(true);
        panel.setVisible(true);

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
        add(panel);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana_inicio = this;
    }

}
