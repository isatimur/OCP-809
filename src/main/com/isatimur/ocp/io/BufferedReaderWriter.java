package main.com.isatimur.ocp.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by tisachenko on 07.04.16.
 */
public class BufferedReaderWriter {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new FileReader("BufferedReaderWriter.java"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("CopyFromBuffRW.java"));

        ) {
            String line = null;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

        }
    }
}
