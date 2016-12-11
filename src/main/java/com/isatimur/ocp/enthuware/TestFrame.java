package com.isatimur.ocp.enthuware;

import java.awt.*;
import java.awt.event.*;

class TestFrame extends Frame {

    static String s = "Message";

    public static void main(String args[]) {
        TestFrame t = new TestFrame();
        Button b = new Button("press me");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Message is " + s);
            }
        });
        t.add(b);
    }
}