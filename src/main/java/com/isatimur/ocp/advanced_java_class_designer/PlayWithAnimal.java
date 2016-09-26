package com.isatimur.ocp.advanced_java_class_designer;

/**
 * Created by Isachenko Timur on 21.07.2016.
 */
public class PlayWithAnimal {
    public static void main(String[] args) {
        Animal animal = new Lion();
        animal.printName();

        // Tiger tigr = (Tiger)animal; rt exception
    }

}

abstract class Animal {
    String name = "???";

    public void printName() {
        System.out.println(name);
    }
}

class Tiger extends Animal {
    String name = "Tiger";
    public void printName() {
        System.out.println(name);
    }

}

class Lion extends Animal {
    String name = "Leo";
//    public void printName() {
//        System.out.println(name);
//    }
}