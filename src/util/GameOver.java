package util;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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
                                + "(Вы не смогли поймать три вещи :))</html>"),
                BorderLayout.CENTER);
        Sound("/home/taty/git/-GetFoodGame-/GameOver908 (online-audio-converter.com).wav");



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

    static void Sound(String filename){
        AudioPlayer MAP = AudioPlayer.player;
        AudioStream MAS;

        ContinuousAudioDataStream loop = null;
        try {
            InputStream test = new FileInputStream(filename);
            MAS = new AudioStream(test);
            AudioPlayer.player.start(MAS);


        } catch (IOException error) {
            System.out.println("error");
        }
        MAP.start(loop);

    }
}
