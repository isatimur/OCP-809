package com.isatimur.ocp.package_3.factory.step1;

/**
 * Created by tisachenko on 01.03.16.
 */
public class Client {
    public static void main(String[] args) {
        String filename = "1.txt";
        AppFactory.getApplication(filename).open(filename);
        String filename2 = "2.doc";
        AppFactory.getApplication(filename2).open(filename2);

    }
}
