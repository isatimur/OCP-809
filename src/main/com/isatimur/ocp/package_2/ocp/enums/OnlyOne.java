package main.com.isatimur.ocp.package_2.ocp.enums;

/**
 * Created by tisachenko on 26.02.16.
 */
public enum OnlyOne {
    ONCE(true);

    private OnlyOne(boolean b) {
        System.out.println("constructing");
    }

    public static void main(String[] args) {
        OnlyOne firstCall = OnlyOne.ONCE; // prints constructing
        OnlyOne secondCall = OnlyOne.ONCE; // doen't rint constructing
    }
}
