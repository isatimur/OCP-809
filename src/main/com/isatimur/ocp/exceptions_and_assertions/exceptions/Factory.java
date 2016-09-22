package main.com.isatimur.ocp.exceptions_and_assertions.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

//static variable initializer error

class Factory {
    static int count;//here was a call to method initCount();

    static {
        try {
            count = initCount();
        }
        catch (FileNotFoundException e) { /* code */ }
    }

    static int initCount() throws FileNotFoundException {
        int result = 0;
        FileInputStream fin = new FileInputStream(new File("abc.txt"));

//read fin and initialize result
        return result;
    }
}