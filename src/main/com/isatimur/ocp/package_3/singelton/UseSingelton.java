package main.com.isatimur.ocp.package_3.singelton;

/**
 * Created by tisachenko on 01.03.16.
 */
public class UseSingelton {
    public static void main(String[] args) {

        System.out.println("Following code implements a simple Singelton pattern which does not intend to handle concurrency");
        Singelton singelton1 = Singelton.getInstance();
        Singelton singelton2 = Singelton.getInstance();
        System.out.println(singelton1 == singelton2);
        System.out.println("=================================");
        System.out.println("Following code implements Singelton(2) and intends to handle concurrency ");
        Singelton2 singelton21 = Singelton2.getINSTANCE();
        Singelton2 singelton22 = Singelton2.getINSTANCE();
        System.out.println(singelton21 == singelton22);
        System.out.println("=================================");
        System.out.println("Following code implements Singelton(3) in synchronized method manner");
        Singelton3 singelton31 = Singelton3.getInstance();
        Singelton3 singelton32 = Singelton3.getInstance();
        System.out.println(singelton31 == singelton32);
        System.out.println("=================================");
        System.out.println("Following code implements Singelton(4) in synchronized block manner");
        Singelton4 singelton41 = Singelton4.getInstance();
        Singelton4 singelton42 = Singelton4.getInstance();
        System.out.println(singelton41 == singelton42);

        System.out.println("Following code implements Singelton(6) with inner static holder");
//
        Singelton6 singelton61 = Singelton6.getInstance();
        Singelton6 singelton62 = Singelton6.getInstance();
        System.out.println(singelton61 == singelton62);

    }
}
