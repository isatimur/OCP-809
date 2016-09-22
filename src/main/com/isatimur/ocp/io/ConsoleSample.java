package main.com.isatimur.ocp.io;

import java.io.Console;

/**
 * Created by Isa Timur on 9/6/16.
 */
public class ConsoleSample {
    public static void main(String[] args) {
        Console console = System.console();
        if (console != null) {
            String userInput = console.readLine();
            console.writer().println("You entered the following: " + userInput);
        }
    }
}
