package com.isatimur.ocp.package_3.factory.step3;

/**
 * Created by tisachenko on 01.03.16.
 */
public abstract class AppFactory {

    public App getAppInstance() {
        App app = getApp();
        return app;


    }

    public Font getFontInstance() {
        Font font = getFont();
        return font;
    }

    public abstract App getApp();

    public abstract Font getFont();

}
