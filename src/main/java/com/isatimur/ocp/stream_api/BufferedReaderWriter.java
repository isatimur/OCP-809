package com.isatimur.ocp.stream_api;

import java.io.*;
import java.util.Arrays;
import java.util.List;

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

            List<String> vals = Arrays.asList("a", "b");
//            vals.parallelStream()

            String line = null;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

        }
    }
}
