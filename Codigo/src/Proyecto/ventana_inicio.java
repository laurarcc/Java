package Proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventana_inicio {
    // Declaración
    private JFrame frame;
    private JPanel panel;
    private JButton regis, startSesion, sin_sesion;
    private JLabel texto, info, eu; // x2
    private FlowLayout flowLayout;

    public void ventana_inicio(JFrame frame) {
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
                registrar_usuario reg = new registrar_usuario();
                new registrar_usuario();
                panel.setVisible(false);
            }
        });

        startSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciar_sesion ini = new iniciar_sesion();
                new iniciar_sesion();
                panel.setVisible(false);
            }
        });

        sin_sesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pedir pedir = new pedir();
                new pedir();
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
}
