package com.isatimur.ocp.package_3.singelton;

/**
 * Created by tisachenko on 01.03.16.
 */
public class Singelton4 {
    private static Singelton4 anInstance;
//            = new Singelton3();

    private Singelton4() {
        System.out.println("private singelton 4");
    }

    public static Singelton4 getInstance() {
        if (anInstance == null)
            synchronized (Singelton4.class) {
                if (anInstance == null)
                    anInstance = new Singelton4();
            }
        return anInstance;
    }
}
