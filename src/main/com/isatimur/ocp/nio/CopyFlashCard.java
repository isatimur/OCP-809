package com.isatimur.ocp.nio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created by tisachenko on 16.04.16.
 */
public class CopyFlashCard implements ActionListener {
    JFrame frame = new JFrame("OCP JAVA SE - Copy Flash Card");
    JTextField copyFrom = null;
    JTextField copyTo = null;
    JTextArea fileContents = null;
    JButton save = null;
    JButton clear = null;
    JButton exit = null;

    public static void main(String[] args) throws IOException {
//        CopyFlashCard flashCard = new CopyFlashCard();
//        flashCard.buildUI();
        try (InputStream in = System.in) {
            Path target = Paths.get("myNotesFromConsole.txt");
            Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
        }

    }

    private void buildUI() {
        copyFrom = new JTextField();
        copyTo = new JTextField();
        fileContents = new JTextArea("Click 'Copy file' to " + "view contents");
        fileContents.disable();

        save = new JButton("Copy file");
        save.addActionListener(this);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(6, 2));
        topPanel.add(new JLabel(""));
        topPanel.add(new JLabel(""));

        topPanel.add(new JLabel("File source"));
        topPanel.add(copyFrom);
        topPanel.add(new JLabel(""));
        topPanel.add(new JLabel(""));
        topPanel.add(new JLabel("File destination"));
        topPanel.add(copyTo);
        topPanel.add(new JLabel(""));
        topPanel.add(new JLabel(""));
        topPanel.add(new JLabel("Destination File Contents"));
        topPanel.add(new JLabel(""));

        JPanel middle = new JPanel();
        middle.setLayout(new BorderLayout());
        middle.add(fileContents);

        JPanel bottom = new JPanel();
        bottom.add(save);

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        main.add(BorderLayout.NORTH, topPanel);
        main.add(BorderLayout.CENTER, middle);
        main.add(BorderLayout.SOUTH, bottom);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.setSize(500, 250);
        frame.getContentPane().add(main);
        frame.setVisible(true);

        copyFrom.setText("/home/tisachenko/ROSTRUD/8/8-1.txt");
        copyTo.setText("/home/tisachenko/ROSTRUD/8/8-1.txt");

    }

    public void actionPerformed(ActionEvent e) {
        try {
            Path source = Paths.get(copyFrom.getText());
            Path target = Paths.get(copyTo.getText());

            OutputStream stream = new FileOutputStream(target.toFile(),true);
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

            byte[] bytes = Files.readAllBytes(target);

            fileContents.setText(new String(bytes, Charset.defaultCharset()));


        } catch (IOException e1) {
            JOptionPane.showMessageDialog(frame, e1.toString());

        }

    }
}
