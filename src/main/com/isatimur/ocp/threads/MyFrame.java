package com.isatimur.ocp.threads;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tisachenko on 20.05.16.
 */
public class MyFrame {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(400, 300);
        jFrame.setVisible(true);
        MovingBall ball = new MovingBall(60, jFrame);
        ball.run();
    }
}

class MovingBall extends Thread {
    int radius;
    Graphics graphics;
    int xPos, yPos;
    JFrame frame;


    public MovingBall(int i, JFrame jFrame) {
        this.radius = i;
        this.graphics = jFrame.getGraphics();
        this.frame = jFrame;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, frame.getWidth(), frame.getHeight());
            ++xPos;
            ++yPos;
            graphics.setColor(Color.RED);
            graphics.fillOval(xPos, yPos, radius, radius);

        }

    }
}