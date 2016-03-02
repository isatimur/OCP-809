package com.isatimur.ocp.package_2.ocp.enums;

/**
 * Created by tisachenko on 26.02.16.
 */
public class A {
    private int x = 10;

    public static void main(String[] args) {
        new A().new B().new C().allTheX();
        System.out.println("++++++++++++++++++++++++++++++++++++Another way of getting to method allTheX");
        A a = new A();
        A.B b = a.new B();
        A.B.C c = b.new C();
        c.allTheX();
    }

    class B {
        private int x = 20;

        class C {
            private int x = 30;

            public void allTheX() {
                System.out.println(x);
                System.out.println(this.x);
                System.out.println(B.this.x);
                System.out.println(A.this.x);
            }
        }
    }

}
