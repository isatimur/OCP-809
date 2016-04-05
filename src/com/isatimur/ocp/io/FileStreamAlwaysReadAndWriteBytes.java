package com.isatimur.ocp.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by tisachenko on 05.04.16.
 */
public class FileStreamAlwaysReadAndWriteBytes {
    public static void main(String[] args) throws IOException {
        try (FileInputStream in = new FileInputStream("text.txt");
             FileOutputStream out = new FileOutputStream("text.txt");
        ) {
            //so writes only 1 byte from int last 8 lower bits
            int i999 = 0b00000000_00000000_00000011_11100111;
            int i20 = 0b00000000_00000000_00000000_11111111;

            out.write(i999);
            out.write(i20);

            System.out.println(i999 + ":" + in.read());
            System.out.println(i20 + ":" + in.read());

        }
    }

}
