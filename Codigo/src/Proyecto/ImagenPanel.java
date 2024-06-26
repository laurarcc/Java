package Proyecto;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ImagenPanel extends JPanel {
    private Image image;

    public ImagenPanel() {
        this.image = new ImageIcon(Objects.requireNonNull(getClass().getResource("cafeteria.jpg"))).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(image != null) {
            int w = getWidth();
            int h = getHeight();
            g.drawImage(image, 0, 0, w, h, this);
        }
    }
}
