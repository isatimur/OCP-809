package com.isatimur.ocp.advanced_java_class_designer;

public interface MyData {
 
    default void print(String str) {
        if (!isNull(str))
            System.out.println("Класс MyData. Печатаем строку: " + str);
    }

    static boolean isNull(String str) {
        System.out.println("метод проверки на null в MyData");
 
        return str == null ? true : "".equals(str) ? true : false;
    }

//    static boolean isNull(String str) {
//        System.out.println("Статический метод проверки на null");
//
//        return str == null ? true : "".equals(str) ? true : false;
//    }
}