package com.isatimur.ocp.advanced_java_class_designer;

public interface Interface1 {
 
    void method1(String str);
     
    default void log(String str){
        System.out.println("Метод по умолчанию. Логгируем: " + str);
        System.out.print(str);
    }

    static boolean isNull(String str) {
        System.out.println("Статический метод проверки на null");

        return str == null ? true : "".equals(str) ? true : false;
    }
}