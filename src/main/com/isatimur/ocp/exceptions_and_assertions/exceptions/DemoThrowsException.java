package com.isatimur.ocp.exceptions_and_assertions.exceptions;

import java.io.FileNotFoundException;

/**
 * Created by tisachenko on 24.03.16.
 */
public class DemoThrowsException {
    public void readFile(String file) throws FileNotFoundException {
        boolean found = findFile(file);
        if (!found) {
            throw new FileNotFoundException("MIssing file");

        }
        else {
            System.out.println("File has been found");
        }
    }

    private boolean findFile(String file) {
        return false;
    }

    void useReadFile(String name) throws FileNotFoundException {
        try {
            readFile(name);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
