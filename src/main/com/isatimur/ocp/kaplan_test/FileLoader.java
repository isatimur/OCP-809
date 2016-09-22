package main.com.isatimur.ocp.kaplan_test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by Isa Timur on 9/10/16.
 */
public class FileLoader {

    public static void main(String[] args) {
        try (FileInputStream fs = new FileInputStream("people.txt")) {
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
            System.out.print(fs.read());
        }
        catch (Exception ex) {
            System.err.print("Error reading file");
        }
    }
}
