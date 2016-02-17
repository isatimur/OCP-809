package com.isatimur.package_2;

/**
 * Created by tisachenko on 15.02.16.
 */
public class Finalinitialization {

    {
        System.out.println(new MyDerivedClass().finalVar);
    }

    public static void main(String[] args) {
        new Finalinitialization();
    }

}

class MyClass {
    public final int finalVar;

    //without this initializer block code would not compile!!!
    {
        finalVar = 999990;
    }
}

class MyDerivedClass extends MyClass {
    MyDerivedClass() {
        super();
//        finalVar = 1000;
    }
}
