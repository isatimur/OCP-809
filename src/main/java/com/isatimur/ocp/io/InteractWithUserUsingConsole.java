package com.isatimur.ocp.io;

import java.io.Console;
import java.io.File;

/**
 * Created by tisachenko on 07.04.16.
 */
public class InteractWithUserUsingConsole {
    public static void main(String[] args) {
        Console console = System.console();
        if (console != null) {
            String file = console.readLine("Enter File to delete:");
            console.format("About to delete %s %n", file);
            console.printf("Sure to delete %s(Y/N)?", file);
            String delete = console.readLine();

            if ("Y".equals(delete.toUpperCase().trim())) {
                char[] pwd = console.readPassword("Enter Passwword:");
                if (pwd.length > 0) {

                    File filik = new File(file);
                    filik.deleteOnExit();
                    console.format("Deleted %s", file);
                }
                else {
                    console.format("No password. Cancelling deletion");
                }
            }
            else {
                console.format("Operatio cancelleed... %nNow exiting.");
            }
        }
        else {
            System.out.println("No console");
        }
    }
}
