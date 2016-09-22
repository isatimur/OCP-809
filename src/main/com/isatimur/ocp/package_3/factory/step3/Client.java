package main.com.isatimur.ocp.package_3.factory.step3;

import java.util.Calendar;

/**
 * Created by tisachenko on 01.03.16.
 */
public class Client {
    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();

        AppFactory factory = new TextEditAppFactory();
        String filename = "1.txt";
        App app = factory.getApp();
        app.open(filename);
        Font font = factory.getFont();
        font.settled();

        factory = new WordAppFactory();

        filename = "2.doc";
        app = factory.getApp();
        app.open(filename);
        font = factory.getFont();
        font.settled();

    }
}
