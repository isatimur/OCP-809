package com.isatimur.ocp.io;

import java.io.*;

/**
 * Created by tisachenko on 07.04.16.
 */
public class ReadWriteObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (FileOutputStream fos = new FileOutputStream("object.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             FileInputStream fis = new FileInputStream("object.txt");
             ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            Car car = new Car("Lambordgini", 5);

            oos.writeObject(car);

            oos.flush();

            Car car2 = (Car) ois.readObject();
            System.out.println(car2.getName() + " " + car2.getAge());


        }
    }
}

class Car implements Serializable {
    private String name;
    private int age;

    public Car(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}