package main.com.isatimur.ocp.package_3.singelton;

/**
 * Created by tisachenko on 01.03.16.
 */
public class Singelton {
    private static Singelton INSTANCE = null;

    private Singelton() {
        System.out.println("Private constructor");
    }

    public static Singelton getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Singelton();
        return INSTANCE;
    }

}
