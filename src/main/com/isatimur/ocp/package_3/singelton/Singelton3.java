package main.com.isatimur.ocp.package_3.singelton;

/**
 * Created by tisachenko on 01.03.16.
 */
public class Singelton3 {
    private static Singelton3 anInstance;
//            = new Singelton3();

    private Singelton3() {
        System.out.println("private singelton 3");
    }

    synchronized public static Singelton3 getInstance() {
        if (anInstance == null)
            anInstance = new Singelton3();
        return anInstance;
    }
}
