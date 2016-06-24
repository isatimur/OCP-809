package com.isatimur.ocp.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by tisachenko on 05.04.16.
 */
public class NonBufferedAndBufferedBytesReadAndWrite {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream in = new FileInputStream("Кнут Д. - Искусство программирования для ЭВМ том 3 (1-е издание) - 1978.pdf");
                FileOutputStream out = new FileOutputStream("/home/tisachenko/projects/OCP-809/Knut_copy.pdf")
        ) {
            long start = System.currentTimeMillis();
            int data;
            while ((data = in.read()) != -1) {
                out.write(data);
            }
            long end = System.currentTimeMillis();
            System.out.println("Millis elapsed: " + (end - start));
        }
    }
}
