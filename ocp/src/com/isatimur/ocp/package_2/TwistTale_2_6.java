package com.isatimur.ocp.package_2;

/**
 * Created by tisachenko on 18.02.16.
 */
public class TwistTale_2_6 {
    {
        class Test {
        }
        Test test = new Test();

    }

}

class Flower {
    String color = "red";
    Petal[] petals;

    Flower() {
        petals = new Petal[2];
// line 3
    }

    public static void main(String args[]) {
        new Flower();
    }

    private class Petal {
        // line 1
        static final int count = 3;
        String color = "purple";

        public Petal() {
            System.out.println(color);
        }
// line 2
    }
}