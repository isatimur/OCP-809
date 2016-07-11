package com.isatimur.ocp.package_4.generics;

/**
 * Created by tisachenko on 07.03.16.
 */
public class BoxPrinterTest {
    public static void main(String[] args) {
        BoxPrinter<Integer> boxPrinter = new BoxPrinter<>(new Integer(10));
        System.out.println(boxPrinter);

        BoxPrinter<String> boxPrinterText = new BoxPrinter<>("Hello world");
        System.out.println(boxPrinterText);

    }
}

class BoxPrinter<T> {
    T value;

    public BoxPrinter(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[" + value + "]";
    }
}