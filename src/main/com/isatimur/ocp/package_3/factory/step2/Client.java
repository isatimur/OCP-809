package main.com.isatimur.ocp.package_3.factory.step2;

/**
 * Created by tisachenko on 01.03.16.
 */
public class Client {
    public static void main(String[] args) {

        AppFactory factory = new TextEditAppFactory();
        String filename = "1.txt";
        App app = factory.getApp();
        app.open(filename);
        factory = new WordAppFactory();

        filename = "2.doc";
        app = factory.getApp();
        app.open(filename);

    }
}
