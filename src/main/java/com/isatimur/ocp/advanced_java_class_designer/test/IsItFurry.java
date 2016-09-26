package com.isatimur.ocp.advanced_java_class_designer.test;

public class IsItFurry {
    interface Mammal {
    }

    static class Furry implements Mammal {
    }

    static class Chipmunk extends Furry {
    }

    public static void main(String[] args) {
        Chipmunk c = new Chipmunk();
        Mammal m = c;
        Furry f = c;
        int result = 0;
        if (c instanceof Mammal)
            result += 1;
        if (c instanceof Furry)
            result += 2;
        if (null instanceof Chipmunk)
            result += 4;
        System.out.println(result);
    }
}