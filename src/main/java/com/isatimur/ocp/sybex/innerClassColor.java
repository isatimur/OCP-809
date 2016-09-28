package com.isatimur.ocp.sybex;

/**
 * Created by abyakimenko on 28.09.2016.
 */
public class innerClassColor {

    private int hue = 10;

    public class Shade {
        private int hue = innerClassColor.this.hue;
    }

    public static void main(String[] args) {
        //System.out.println(new Shade().hue); // неверное обращение к переменным класса в статическом контексте
        System.out.println(new innerClassColor().new Shade().hue);
    }
}
