package com.isatimur.ocp.package_3.factory.step2;

/**
 * Created by tisachenko on 01.03.16.
 */
public class TextEditor implements App {
    @Override
    public void open(String filename) {
        System.out.println("Launch TextEditor using " + filename);
    }
}
