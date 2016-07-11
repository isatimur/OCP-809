package com.isatimur.ocp.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by tisachenko on 07.04.16.
 */
public class UsingPrintWriter {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("file.txt", true);
            PrintWriter pw = new PrintWriter(fw);

            pw.write(97);
            pw.write("String");
            pw.write("PartialString", 0, 4);
            pw.write(new char[] {'c', 'h', 'a', 'r'});
            pw.write(new char[] {'c', 'h', 'a', 'r'}, 1, 1);

            pw.println(true);
            pw.println('a');
            pw.println(12.45f);
            pw.println(41.87);
            pw.println(3986L);
            pw.println(pw);
            pw.println(new Integer(10));

            pw.close();

        }
        catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
