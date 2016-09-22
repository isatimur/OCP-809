package com.isatimur.ocp.exceptions_and_assertions.exceptions;

import java.io.FileNotFoundException;

/**
 * Created by tisachenko on 25.03.16.
 */
//I have added throws Exception to line 29 here to make code compilable because we should handle methods which throws checked exceptions
//a) comment 18 line
//b) add throws Exception to line 29 like it is right now
public class TwistThrowsException {
    public static void main(String[] args)
        throws FileNotFoundException {
        new TwistThrowsException().useReadFile("a");
    }

    public void readFile() throws FileNotFoundException {
        System.out.println("readFile");
        throw new FileNotFoundException();
    }

    void useReadFile(String name)
        throws FileNotFoundException {
        System.out.println("useReadFile");
        try {
            readFile();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();

        }
    }

}
