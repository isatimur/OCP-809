package com.isatimur.ocp.advanced_java_class_designer;

public interface Interface2 {
 
    void method2();
     
    default void log1(String str){
        System.out.println("Метод по умолчанию. Логгируем: " + str);
    }
 
}