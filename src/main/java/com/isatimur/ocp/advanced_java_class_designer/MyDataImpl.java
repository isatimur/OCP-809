package com.isatimur.ocp.advanced_java_class_designer;

public class MyDataImpl implements MyData {

//    @Override
    public static boolean isNull(String str) {
        System.out.println("Проверяем на null в MyDataImpl");
        return str == null ? true : false;
    }

    public static void main(String args[]) {
        MyDataImpl obj = new MyDataImpl();
        obj.print("UUUUUUUUU");
        obj.isNull("abc");
        //MyData.isNull("abc");
    }
}