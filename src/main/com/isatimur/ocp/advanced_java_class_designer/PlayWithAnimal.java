package main.main.com.isatimur.ocp.advanced_java_class_designer;

/**
 * Created by Isachenko Timur on 21.07.2016.
 */
public class PlayWithAnimal {
    public static void main(String[] args) {
        Animal animal = new Lion();
        animal.printName();
    }

}

abstract class Animal {
    String name = "???";

    public void printName() {
        System.out.println(name);
    }
}

class Lion extends Animal {
    String name = "Leo";
}