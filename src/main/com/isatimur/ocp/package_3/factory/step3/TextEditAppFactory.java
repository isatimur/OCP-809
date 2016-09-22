package main.com.isatimur.ocp.package_3.factory.step3;

/**
 * Created by tisachenko on 01.03.16.
 */
public class TextEditAppFactory extends AppFactory {
    @Override
    public App getApp() {
        return new TextEditor();
    }

    @Override
    public Font getFont() {
        return new RegularFont();
    }
}
