package main.com.isatimur.ocp.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by tisachenko on 03.04.16.
 */
public class Read_nd_Write {

    public static void main(String[] args) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream("/home/tisachenko/Desktop/test.txt");
             FileOutputStream fileOutputStream = new FileOutputStream("/home/tisachenko/Desktop/Sample2.txt");) {
// THIS IS THE SIMPLESCT MBUT NOT SUFFICIANT EXAMPLE OF READING AND WRITING FILE EXAMPLE
            int data;
//            while ((data = fileInputStream.read()) != -1) {
//                fileOutputStream.write(data);
//            }
//            fileOutputStream.flush();

//            byte[] buff = new byte[2028];
//            while ((data = fileInputStream.read(buff)) != -1) {

            // this method will fit all left space with zeros "00"
//                fileOutputStream.write(buff);
//            }

            byte[] buff = new byte[1024];
            while ((data = fileInputStream.read(buff)) != -1) {
                fileOutputStream.write(buff, 0, data);
            }

        }
    }

}
