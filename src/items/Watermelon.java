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
public class Watermelon extends JPanel{
    private BufferedImage image;

    private int wX = (int)(Math.random() * 486);
    private int wY = 50;

    public int getwX() {
        return wX;
    }

    public int getwY() {
        return wY;
    }

    public void setwY(int wY) {
        this.wY = wY;
    }

    public Watermelon(){
        try {
            image = ImageIO.read(this.getClass().getResourceAsStream("/images/"+"watermelon"+".png"));
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
