package util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Bakai
 */
public class GameOver extends JDialog
{
    public GameOver(JFrame owner)
    {
        super(owner, "Игра окончена!", true);


        add(new JLabel(
                        "<html><h1><i>Игра проиграна:(</i></h1><hr>"
                                + "(Вы не смогли поймать одну вещь!)</html>"),
                BorderLayout.CENTER);



        JButton ok = new JButton("Ок");
        ok.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });


        JPanel panel = new JPanel();
        panel.add(ok);
        add(panel, BorderLayout.SOUTH);
        setSize(400, 400);
        setLocationRelativeTo(null);
    }
}
