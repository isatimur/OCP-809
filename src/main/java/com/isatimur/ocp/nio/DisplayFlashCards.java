package com.isatimur.ocp.nio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by tisachenko on 24.04.16.
 */
public class DisplayFlashCards implements ActionListener {
    JFrame frame = new JFrame("Display flash cards");
    JLabel lblObjectiveNo = null;
    JLabel lblFlashcard = null;
    JButton btnNext = null;
    JButton btnPrevious = null;

    private void buildUI() {
        lblObjectiveNo = new JLabel();
        lblFlashcard = new JLabel();
        lblObjectiveNo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblFlashcard.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btnNext = new JButton(" > ");
        btnNext.addActionListener(this);
        btnPrevious = new JButton(" < ");
        btnPrevious.addActionListener(this);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(6, 1));
        topPanel.add(new JLabel(""));
        topPanel.add(new JLabel(" Exam Objective"));
        topPanel.add(lblObjectiveNo);
        topPanel.add(new JLabel(""));
        topPanel.add(new JLabel(""));
        topPanel.add(new JLabel(" Exam Tip"));

        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BorderLayout());
        middlePanel.add(lblFlashcard);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(btnPrevious);
        bottomPanel.add(btnNext);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(BorderLayout.NORTH, topPanel);
        mainPanel.add(BorderLayout.CENTER, middlePanel);
        mainPanel.add(BorderLayout.SOUTH, bottomPanel);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.setSize(500, 550);
        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);


    }

    private void accessAllExamTips() throws IOException {
        Files.walkFileTree(Paths.get("/home/tisachenko/ROSTRUD/"), fileVisitor);
        flashcards = HierarchyFiles.flashCardsMap;
    }

    FileVisitor fileVisitor = HierarchyFiles.getLocalFileVisitor();

    LinkedHashMap<String, LinkedList<String>> flashcards = null;
    ListIterator<String> examObjIterator = null;
    LinkedList<String> keyNames = new LinkedList<>();
    ListIterator<String> tipsIterator = null;

    public void initExamTips() {
        for (String key : flashcards.keySet()) {
            keyNames.add(key);
        }
        examObjIterator = keyNames.listIterator();
        showNextTip();
    }

    private void showNextTip() {
        if (tipsIterator != null && tipsIterator.hasNext()) {
            lblFlashcard.setText("<html>" + tipsIterator.next() + "</html>");
        } else {
            if (examObjIterator.hasNext()) {
                String currentObj = examObjIterator.next();
                lblObjectiveNo.setText(currentObj);
                tipsIterator = flashcards.get(currentObj).listIterator();
                if (tipsIterator != null && tipsIterator.hasNext()) {
                    lblFlashcard.setText("<html>" + tipsIterator.next() + "</html>");
                }
            }
        }


    }


    private void showPrevTip() {
        if (tipsIterator != null && tipsIterator.hasPrevious()) {
            lblFlashcard.setText("<html>" + tipsIterator.previous() + "</html>");
        } else {
            if (examObjIterator.hasPrevious()) {
                String currentObj = examObjIterator.previous();
                lblObjectiveNo.setText(currentObj);
                tipsIterator = flashcards.get(currentObj).listIterator();
                if (tipsIterator != null && tipsIterator.hasNext()) {
                    lblFlashcard.setText("<html>" + tipsIterator.next() + "</html>");
                }
            }
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getActionCommand().equals(" < ")) {
                showPrevTip();
            } else {
                showNextTip();
            }
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(frame, e1.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        DisplayFlashCards displayFlashCards = new DisplayFlashCards();
        displayFlashCards.buildUI();
        displayFlashCards.accessAllExamTips();
        displayFlashCards.initExamTips();

    }
}
