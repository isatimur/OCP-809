package com.isatimur.ocp.package_3.factory.step1;

/**
 * Created by tisachenko on 01.03.16.
 */
public class AppFactory {

    public static App getApplication(String filename) {
        App app = null;

        if (filename.endsWith(".txt")) {
            app = new TextEditor();
        } else if (filename.endsWith(".doc")) {
            app = new WordProcessor();
        } else {
            app = new OtherEditor();
        }
        return app;


    }
}
