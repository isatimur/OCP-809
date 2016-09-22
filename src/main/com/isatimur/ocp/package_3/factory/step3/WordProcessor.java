package main.com.isatimur.ocp.package_3.factory.step3;

/**
 * Created by tisachenko on 01.03.16.
 */
public class WordProcessor implements App {
    @Override
    public void open(String filename) {
        System.out.println("Launch WordProcessor using " + filename);
    }
}
