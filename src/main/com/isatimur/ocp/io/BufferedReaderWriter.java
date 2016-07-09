package com.isatimur.ocp.io;

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
            FileReader fr = new FileReader("BufferedReaderWriter.java");
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter("CopyFromBuffRW.java");
            BufferedWriter bw = new BufferedWriter(fw);

        ) {
            String line = null;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

        }
    }
}
