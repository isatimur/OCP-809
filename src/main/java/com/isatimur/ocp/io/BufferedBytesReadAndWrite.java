package com.isatimur.ocp.io;

import java.io.*;

/**
 * Created by tisachenko on 05.04.16.
 */
public class BufferedBytesReadAndWrite {
    public static void main(String[] args) throws IOException {

        String line;
        Console c = System.console();
        Writer w = c.writer();
        if ((line = c.readLine()) != null)
            w.append(line);
        w.flush();

//        Console c = System.console();
//        c.re

//        BufferedReader
//        BufferedWriter
//                FileReader
//                FileWrite
//        PrintReader !!!!!!!!!!!!
//                PrintWriter

        PrintWriter out1 = new PrintWriter("zoo.log");
        out1.print(5); // PrintWriter method
        out1.write(String.valueOf(5)); // Writer method
        out1.print(2.0); // PrintWriter method
        out1.write(String.valueOf(2.0)); // Writer method
        out1.flush();
        try (
            FileInputStream in = new FileInputStream("Кнут Д. - Искусство программирования для ЭВМ том 3 (1-е издание) - 1978.pdf");
            FileOutputStream out = new FileOutputStream("/home/tisachenko/projects/OCP-809/Knut_copy.pdf");
            BufferedInputStream bis = new BufferedInputStream(in);
            BufferedOutputStream bos = new BufferedOutputStream(out);

        ) {
            long start = System.currentTimeMillis();
            int data;
            while ((data = bis.read()) != -1) {
                bos.write(data);
            }
            long end = System.currentTimeMillis();
            System.out.println("Millis elapsed: " + (end - start));
        }
    }
}
