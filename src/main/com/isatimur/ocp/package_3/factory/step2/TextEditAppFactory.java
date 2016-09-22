package main.com.isatimur.ocp.package_3.factory.step2;

/**
 * Created by tisachenko on 01.03.16.
 */
public class TextEditAppFactory extends AppFactory {
    @Override
    public App getApp() {
        return new TextEditor();
    }
}
