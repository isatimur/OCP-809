package main.com.isatimur.ocp.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by tisachenko on 07.04.16.
 */
public class ReadChars {
    public static void main(String[] args) throws IOException {
        try (
                FileReader input = new FileReader("ReadChars.java");
                FileWriter output = new FileWriter("CopyReadChars.java");
        ) {
            int data;

            while ((data = input.read()) != -1) {
                output.write(data);
            }
        }
    }
}
