package com.isatimur.ocp.package_2;

/**
 * Created by tisachenko on 18.02.16.
 */
public class Outer {
    static int outerStatic = 10;
    int outerInstance = 10;

    void foo() {
        class LocalInner {
        }
    }

    Object fooAnonymus() {
        return new Object() {
            @Override
            public String toString() {
                return "anonymus";
            }
        };
    }

    static class StaticNested {
        static int innerStatic = outerStatic;
        int innerInstance = outerStatic;
    }

}

class Outer1 {
    public static void main(String[] args) {
        System.out.println(Outer.StaticNested.innerStatic);
        System.out.println(new Outer.StaticNested().innerInstance);

    }
}



