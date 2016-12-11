package com.isatimur.ocp.package_4;

import java.io.*;

public class TestClass {


    public static void main(String[] args) throws Exception {

        Boo boo = new Boo();
        boo.si++;
        System.out.println(boo.ti + " " + boo.si);
        FileOutputStream fos = new FileOutputStream("d:\\temp\\boo.ser");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(boo);
        os.close();

        FileInputStream fis = new FileInputStream("d:\\temp\\boo.ser");
        ObjectInputStream is = new ObjectInputStream(fis);
        Boo boo22 = (Boo) is.readObject();
        boo = (Boo) is.readObject();
        is.close();
        System.out.println(boo.ti + " " + boo.si);
    }
}