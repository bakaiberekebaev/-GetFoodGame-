package game;
import items.Banana;
import items.Potato;
import items.Stand;
import items.Watermelon;
import util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;





/**
 * Created by Bakai
 */
public class Game { // главный класс
    static int score = 0;
    static int ditems = 0; // вещи,которые не смогли поймать
    public static void main(String[] args) throws IOException, InterruptedException {

        JFrame frame = new JFrame("GetFoodGame"){
            @Override
            public void paint(Graphics g){
                super.paint(g);
                g.setColor(Color.BLACK);
                g.drawString("score: "+ score,20,40);
            }
        };
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.white);
        Stand stand = new Stand();
        stand.setBackground(Color.WHITE);
        stand.setBounds(stand.getStandX(),stand.getStandY(),100,100);
        Rectangle standRec = new Rectangle(stand.getStandX(),stand.getStandY(),50,60);

        KeyboardObserver observer = new KeyboardObserver(stand,standRec);
        frame.addKeyListener(observer);

        frame.add(stand).setVisible(true);
        frame.setSize(700,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        while(true) {

            int number = (int)(Math.random() * 3);
            if(number == 0) {
                Potato potato = new Potato();
                potato.setBackground(Color.WHITE);
                Thread.sleep(1000);
                potato.setBounds(potato.getPotatoX(),potato.getPotatoY(),100,100);
                frame.add(potato).setVisible(true);
                Rectangle fruit = new Rectangle(potato.getPotatoX(),potato.getPotatoY(),100,60);
                Timer timer = new Timer(50, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        potato.setPotatoY(potato.getPotatoY() + 10);
                        potato.setLocation(potato.getPotatoX(), potato.getPotatoY());
                        fruit.setLocation(potato.getPotatoX(), potato.getPotatoY());
                        if (standRec.intersects(fruit)) {
                            frame.remove(potato);
                            score += 100;
                            frame.repaint();
                            Thread.currentThread().stop();
                        }else if(!standRec.intersects(fruit) &&  potato.getPotatoY() > 450 ){
                            ditems++;
                            System.out.println(ditems);
                            frame.remove(potato);
                            Thread.currentThread().stop();
                        }
                    }
                });
                timer.start();
            }else if(number == 1){
                Watermelon watermelon = new Watermelon();
                watermelon.setBackground(Color.WHITE);
                Thread.sleep(1000);
                watermelon.setBounds(watermelon.getwX(),watermelon.getwY(),100,100);
                frame.add(watermelon).setVisible(true);
                Rectangle fruit = new Rectangle(watermelon.getwX(),watermelon.getwY(),100,60);
                Timer timer = new Timer(50, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        watermelon.setwY(watermelon.getwY() + 10);
                        watermelon.setLocation(watermelon.getwX(), watermelon.getwY());
                        fruit.setLocation(watermelon.getwX(), watermelon.getwY());
                        if (standRec.intersects(fruit)) {
                            frame.remove(watermelon);
                            score += 100;
                            frame.repaint();
                            Thread.currentThread().stop();
                        }else if(!standRec.intersects(fruit) &&  watermelon.getwY() > 450){
                            ditems++;
                            System.out.println(ditems);
                            frame.remove(watermelon);
                            Thread.currentThread().stop();
                        }
                    }
                });
                timer.start();
            }else if(number == 2){
                Banana banana = new Banana();
                banana.setBackground(Color.WHITE);
                Thread.sleep(1000);
                banana.setBounds(banana.getbX(),banana.getbY(),100,100);
                frame.add(banana).setVisible(true);
                Rectangle fruit = new Rectangle(banana.getbX(),banana.getbY(),100,60);
                Timer timer = new Timer(50, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        banana.setbY(banana.getbY() + 10);
                        banana.setLocation(banana.getbX(), banana.getbY());
                        fruit.setLocation(banana.getbX(), banana.getbY());
                        if (standRec.intersects(fruit)) {
                            frame.remove(banana);
                            score += 100;
                            frame.repaint();
                            Thread.currentThread().stop();
                        }else if(!standRec.intersects(fruit) &&  banana.getbY() > 450 ){
                            ditems++;
                            System.out.println(ditems);
                            frame.remove(banana);
                            Thread.currentThread().stop();
                        }
                    }
                });
                timer.start();
            }
            if(ditems == 2){
                new GameOver(frame).setVisible(true);
            }
        }

    }


}
