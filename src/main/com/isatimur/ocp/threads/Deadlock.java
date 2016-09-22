package main.com.isatimur.ocp.threads;

/**
 * Created by tisachenko on 25.05.16.
 */
public class Deadlock {
    public static void main(String[] args) {
        CTester pavel = new CTester();
        CDeveloper ivan = new CDeveloper();

        AndroidApp androidApp = new AndroidApp(ivan, pavel);
        iPhoneApp iPhoneApp = new iPhoneApp(ivan, pavel);

        androidApp.start();
        iPhoneApp.start();
    }
}

class CDeveloper {

    synchronized void fixBugs() {
        System.out.println("fixing..");
    }

    synchronized void code() {
        System.out.println("coding..");
    }

}

class CTester {
    synchronized void testAppln() {
        System.out.println("testing..");
    }
}

class AndroidApp extends Thread {
    CDeveloper dev;
    CTester tester;

    public AndroidApp(CDeveloper dev, CTester tester) {
        this.dev = dev;
        this.tester = tester;
    }

    @Override
    public void run() {
//        CDeveloper devLock= dev;
//        CTester testerLock= tester;
        synchronized (dev) {

            synchronized (tester) {
                tester.testAppln();
                dev.fixBugs();
            }
        }
    }
}

class iPhoneApp extends Thread {
    CDeveloper dev;
    CTester tester;

    public iPhoneApp(CDeveloper dev, CTester tester) {
        this.dev = dev;
        this.tester = tester;
    }

    @Override
    public void run() {
//        CTester testerLock= tester;
//        CDeveloper devLock= dev;
        synchronized (tester) {
            synchronized (dev) {
                tester.testAppln();
                dev.fixBugs();
            }
        }
    }
}