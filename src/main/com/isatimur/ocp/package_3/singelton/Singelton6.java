package main.com.isatimur.ocp.package_3.singelton;

/**
 * Created by tisachenko on 01.03.16.
 */
public class Singelton6 {

    private Singelton6() {
        System.out.println("private singelton 6");
    }

    public static Singelton6 getInstance() {
        return SingeltonHolder.anInstance;
    }

    //            = new Singelton3();
    private static class SingeltonHolder {
        private static Singelton6 anInstance = new Singelton6();
    }
}
