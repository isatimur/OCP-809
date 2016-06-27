package com.isatimur.ocp.localization;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by developer on 6/25/16.
 */
public class IndianArt {
    JFrame f = new JFrame("BookNow");
    JLabel lTotalBookings = new JLabel();
    JLabel lWhen = new JLabel();
    JLabel lPrice = new JLabel();
    JLabel lImage;
    JButton btnBook = new JButton();

    public static void main(String[] args) {
        IndianArt ia = new IndianArt();
        ia.setLocaleSpecificData(new Locale("hi", "IN"));
        ia.buildShowUI();
    }

    private void buildShowUI() {
        f.getContentPane().setLayout(new FlowLayout());
        f.setSize(300, 400);
        f.getContentPane().add(lTotalBookings);
        f.getContentPane().add(lImage);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(4, 1));
        panel1.add(lWhen);
        panel1.add(lPrice);
        panel1.add(new JLabel(""));
        panel1.add(btnBook);
        f.getContentPane().add(panel1);
        f.setVisible(true);
    }

    private void setLocaleSpecificData(Locale locale) {
        ResourceBundle labels =
                ResourceBundle.getBundle("com.isatimur.ocp.localization.IndianArtLabelsBundle", locale);
        String text = null;
        text = labels.getString("total_bookings");
        lTotalBookings.setText(text);
        text = labels.getString("when");
        lWhen.setText(text);
        text = labels.getString("price");
        lPrice.setText(text);

        text = labels.getString("book_now");
        btnBook.setText(text);
        ImageIcon artImage = new ImageIcon
                (labels.getString("sample_art"));
        lImage = new JLabel(artImage);
    }
}
