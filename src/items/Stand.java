package items;

import util.StandDirection;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Stand extends JPanel { // Подставка
    private StandDirection direction;

    private BufferedImage image;

    private int standX = 250;
    private int standY = 350;

    public int getStandX() {
        return standX;
    }



    public void setStandX(int standX) {
        this.standX = standX;
    }

    public int getStandY() {
        return standY;
    }

    public void setStandY(int standY) {
        this.standY = standY;
    }

    public Stand(){
        try {
            image = ImageIO.read(this.getClass().getResourceAsStream("/images/"+"stand"+".png"));
            this.setOpaque(false);
        } catch (IOException e) {
            System.out.println("Неверный путь к изображению.");
        }
    }

    public void setDirection(StandDirection direction) {
        this.direction = direction;
    }

    public StandDirection getDirection() {
        return direction;
    }



    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
}