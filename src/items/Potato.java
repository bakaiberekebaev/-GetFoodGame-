package items;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Potato extends JPanel { // Картошка
    private BufferedImage image;

    private int potatoX = (int) (Math.random() * 486); // ãåíåðèðóåì ñëó÷àéíûé x
    private int potatoY = 50;


    public int getPotatoX() {
        return potatoX;
    }


    public int getPotatoY() {
        return potatoY;
    }

    public void setPotatoY(int potatoY) {
        this.potatoY = potatoY;
    }

    public Potato() {
        try {
            image = ImageIO.read(this.getClass().getResourceAsStream("/images/"+"potato"+".png"));
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
