package com.isatimur.ocp.advanced_java_class_designer;

public class MyClass implements Interface1, Interface2 {
 
    @Override
    public void method2() {
    }
 
    @Override
    public void method1(String str) {
    }
 


    @Override
    public void log(String str){
        System.out.println("Класс MyClass. Логгируем: " + str);
        //Interface1.log("печать в консоль");
        Interface1.isNull("ss");
    }
}