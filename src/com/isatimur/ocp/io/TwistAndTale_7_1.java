package com.isatimur.ocp.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by tisachenko on 05.04.16.
 */
public class TwistAndTale_7_1 {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream in = new FileInputStream("/home/tisachenko/projects/OCP-809/src/com/isatimur/ocp/io/TwistAndTale_7_1.java");
                FileOutputStream out = new FileOutputStream("/home/tisachenko/projects/OCP-809/src/com/isatimur/ocp/io/Copy.java");
        ) {
            int data;
            byte[] byteArr = new byte[2048];
            while ((data = in.read(byteArr)) != -1) {
                out.write(byteArr);
            }
        }
    }
}
