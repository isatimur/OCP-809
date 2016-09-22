package main.com.isatimur.ocp.exceptions_and_assertions.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by tisachenko on 27.03.16.
 */
public class AutoClose {
    void readFileContents(String filename) throws IOException {
        File file = new File(filename);
        try (FileInputStream fis = new FileInputStream(file)) {

        }
    }

//    void copyFileContents(String inFile, String outFile) throws IOException {
//        try (FileInputStream fin;
//             FileOutputStream fout;){
//
//        }
//    }

//    void copyFileContents(String inFile, String outFile) throws IOException {
//        try (FileInputStream fin = null;
//             FileOutputStream fout = null;){
//        }
//    }

    void copyFileContents(String inFile, String outFile)
        throws IOException {
        try (FileInputStream fin = new FileInputStream(inFile);
             FileOutputStream fout = new FileOutputStream(outFile)) {
            byte[] buffer = new byte[1024];
            int i = 0;
            while ((i = fin.read(buffer)) != -1)
                fout.write(buffer, 0, i);
        }
        finally {
//            won't compile cause fileoutputstream is out of try scope!!!
//            fout = new FileOutputStream(inFile);
        }

    }

}
