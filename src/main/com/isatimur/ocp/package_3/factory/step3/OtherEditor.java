package com.isatimur.ocp.package_3.factory.step3;

/**
 * Created by tisachenko on 01.03.16.
 */
public class OtherEditor implements App {

    @Override
    public void open(String filename) {
        System.out.println("Launch OtherEditor using " + filename);
    }
}
