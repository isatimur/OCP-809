package com.isatimur.ocp.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by tisachenko on 05.04.16.
 */
public class ReadWritePrimitiveData1 {
    public static void main(String[] args) throws IOException {
        try (FileOutputStream fos = new FileOutputStream("myData.data");
             DataOutputStream dos = new DataOutputStream(fos);
             FileInputStream fis = new FileInputStream("myData.data");
             DataInputStream dis = new DataInputStream(fis);

        ) {

            dos.writeChars("OS");
            dos.writeInt(999);
            dos.writeDouble(45.8);
            dos.writeBoolean(true);
            dos.writeUTF("Will score 100%");

            System.out.println(dis.readChar());
            System.out.println(dis.readChar());
            System.out.println(dis.readInt());
            System.out.println(dis.readDouble());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readUTF());

//            System.out.println(dis.readBoolean());

        }
    }
}
