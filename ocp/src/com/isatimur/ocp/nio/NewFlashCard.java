package com.isatimur.ocp.nio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by tisachenko on 16.04.16.
 */
public class NewFlashCard implements ActionListener {
    JFrame frame = new JFrame("OCP JAVA SE - New Flash Card");
    JTextField mainObj = null;
    JTextField subObj = null;
    JTextField note = null;
    JButton save = null;
    JButton clear = null;
    JButton exit = null;

    public static void main(String[] args) {
        NewFlashCard flashCard = new NewFlashCard();
        flashCard.buildUI();
    }

    private void buildUI() {
        mainObj = new JTextField();
        subObj = new JTextField();
        note = new JTextField();
        save = new JButton("Save");
        save.addActionListener(this);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(6, 2));
        topPanel.add(new JLabel(""));
        topPanel.add(new JLabel(""));

        topPanel.add(new JLabel("Main objective number"));
        topPanel.add(mainObj);
        topPanel.add(new JLabel(""));
        topPanel.add(new JLabel(""));
        topPanel.add(new JLabel("Sub objective number"));
        topPanel.add(subObj);
        topPanel.add(new JLabel(""));
        topPanel.add(new JLabel(""));
        topPanel.add(new JLabel("Flashcard text"));
        topPanel.add(new JLabel(""));

        JPanel middle = new JPanel();
        middle.setLayout(new BorderLayout());
        middle.add(note);

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
    }

    public void actionPerformed(ActionEvent e) {
        String caseDir = "/home/tisachenko/ROSTRUD/";
        String subdir = mainObj.getText();
        String fileName = subObj.getText() + ".txt";
        Path path = Paths.get(caseDir, subdir, fileName);
        JOptionPane.showMessageDialog(frame, path.toString());
        try {
            if (Files.notExists(path.getParent())) {
                Files.createDirectories(path.getParent());
            }
            if(!Files.exists(path))
            Files.createFile(path);
            PrintWriter pw = new PrintWriter(new FileWriter(path.toFile()));
            pw.println(note.getText());
            pw.flush();

//            Files.write(Files.createFile(path), note.getText().getBytes());
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(frame, e1.toString());
        }


    }
}
