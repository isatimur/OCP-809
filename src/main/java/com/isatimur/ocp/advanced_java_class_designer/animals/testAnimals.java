package com.isatimur.ocp.advanced_java_class_designer.animals;

/**
 * Created by abyakimenko on 10.12.2016.
 */
public class testAnimals {

    public void feedAnimal(Animal animal) {
        if (animal instanceof Cow) {
            ((Cow) animal).addHay();
        } else if (animal instanceof Bird) {
            ((Bird) animal).addSeed();
        } else if (animal instanceof Cat) {

            animal.feed();
//            ((Lion) animal).addMeat();// Cat cannot be cast to com.isatimur.ocp.advanced_java_class_designer.animals.Lion
            // тип объекта - Cat - приведение невозможно!!!

        } else if (animal instanceof Lion) {
            ((Lion) animal).addMeat();
        } else {
            throw new RuntimeException("Unsupported animal");
        }
    }

    public static void main(String[] args) {

        Cat cat = new Cat();
        Cat ca1 = new Lion();


        Animal lion = new Lion();
        Animal cow = new Cow();
        Animal bird = new Bird();

        testAnimals animals = new testAnimals();

        animals.feedAnimal(lion);
        animals.feedAnimal(cat);
        animals.feedAnimal(cow);
        animals.feedAnimal(bird);
    }
}
