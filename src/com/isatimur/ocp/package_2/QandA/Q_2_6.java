package com.isatimur.ocp.package_2.QandA;

/**
 * Created by tisachenko on 19.02.16.
 */
public class Q_2_6 {
    public static void main(String[] args) {
        System.out.println("Create Top-level and nested classes");
    }
}


class MyClass {
    void aVoid() {
        //enum must not be local
//        enum Test1{
//            TEST_1,TEST_2
//        }
    }

    enum Size {SMALL, MEDIUM, LARGE}

    static class StaticNested {
        enum Size {SMALL, MEDIUM, LARGE}
    }

    class Inner {
//        Inner class cannot have static declaration!!!!
//        enum Test2{
//            TEST_1,TEST_2
//        }
    }
}
