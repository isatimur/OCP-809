package com.isatimur.ocp.package_3.factory.step2;

/**
 * Created by tisachenko on 01.03.16.
 */
public abstract class AppFactory {

    public App getAppInstance() {
        App app = getApp();
        return app;


    }

    public abstract App getApp();
}
