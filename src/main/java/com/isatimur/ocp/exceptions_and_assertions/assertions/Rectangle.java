package com.isatimur.ocp.exceptions_and_assertions.assertions;

/**
 * Created by Isa Timur on 8/22/16.
 */
public class Rectangle {
    private int width, height;

    public Rectangle(int width, int height) {
//        recomendation to use a runtime exception like this one
//        if (width < 0 || height < 0) {
//            throw new IllegalArgumentException();
//        }
        this.width = width;
        this.height = height;
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10, 15);

        Rectangle rectangle1 = new Rectangle(10, -15);
        rectangle1.getArea();
        System.out.println("Rectangle 1: " + rectangle.getArea());
        System.out.println("Rectangle 2: " + rectangle1.getArea());

    }

    public int getArea() {
        assert isValid() : "Not a valid Rectangle";
        return width * height;
    }

    private boolean isValid() {
        return (width >= 0 && height >= 0);
    }
}
