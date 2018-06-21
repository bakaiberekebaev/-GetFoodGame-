package items;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Andrey on 26.06.2017.
 */
public class Banana extends JPanel {
    private BufferedImage image;

    private int bX = (int)(Math.random() * 486);
    private int bY = 50;

    public int getbX() {
        return bX;
    }

    public int getbY() {
        return bY;
    }

    public void setbY(int bY) {
        this.bY = bY;
    }

    public Banana(){
        try {
            image = ImageIO.read(this.getClass().getResourceAsStream("/images/"+"banana"+".png"));
            this.setOpaque(false);
        } catch (IOException e) {
            System.out.println("Неверный путь к изображению.");
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
}
