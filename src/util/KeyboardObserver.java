package util;


import items.Stand;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardObserver extends KeyAdapter { // Отслеживает нажатия клавиш
    private Stand stand;
    private Rectangle rectangle;
    public KeyboardObserver(Stand stand,Rectangle rectangle) {
        this.stand = stand;
        this.rectangle = rectangle;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            stand.setDirection(StandDirection.LEFT);
            stand.setLocation(stand.getX()-25, stand.getY());
            rectangle.setLocation(stand.getX()-25, stand.getY());
            stand.setStandX(stand.getX()-25);
            if(stand.getX() < 0){
                stand.setLocation(stand.getX()+25, stand.getY());
                rectangle.setLocation(stand.getX()+25, stand.getY());
                stand.setStandX(stand.getX()+25);
            }
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            stand.setDirection(StandDirection.RIGHT);
            stand.setLocation(stand.getX()+25, stand.getY());
            rectangle.setLocation(stand.getX()+25, stand.getY());
            stand.setStandX(stand.getX()+25);
            if(stand.getX() > 610){
                stand.setLocation(stand.getX()-25, stand.getY());
                rectangle.setLocation(stand.getX()-25, stand.getY());
                stand.setStandX(stand.getX()-25);
            }
        }
    }




}