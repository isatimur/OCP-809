package com.isatimur.ocp.package_2.ocp.enums;

/**
 * Created by tisachenko on 26.02.16.
 */
public enum Season3 {
    WINTER {
        public void printHours() {
            System.out.println("short hours");
        }
    },
    SUMMER {
        public void printHours() {
            System.out.println("long hours");
        }
    }, SPRING, FALL;

    public static void main(String[] args) {
        Season3.WINTER.printHours();
    }

    public void printHours() {
        System.out.println("default hours");
    }
}

enum SimpleShape {
    SQUARE, CIRCLE, TRIANGLE
}