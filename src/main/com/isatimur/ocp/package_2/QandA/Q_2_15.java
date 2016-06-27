package com.isatimur.ocp.package_2.QandA;

/**
 * Created by tisachenko on 19.02.16.
 */
public class Q_2_15 {
    public static void main(String[] args) {
        new MyClass_C();
    }
}

class Base_C {
    static {
        System.out.println("STATIC");
    }

    {
        System.out.println("INIT");
    }
//    Base_C(){
//        System.out.println("CONSTRUCTOR");
//    }
}

class MyClass_C extends Base_C {
    static {
        System.out.println(":static");
    }

    {
        System.out.println(":init");
    }
//    MyClass_C(){
//        System.out.println("constructor");
//    }
}