package Proyecto;

import javax.swing.*;

public class pedir extends JFrame {
    JFrame frame;
    public pedir(){
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
}
