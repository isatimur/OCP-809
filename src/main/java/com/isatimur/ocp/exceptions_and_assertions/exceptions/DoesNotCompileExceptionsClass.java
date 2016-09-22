package com.isatimur.ocp.exceptions_and_assertions.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.MissingResourceException;

/**
 * Created by Isa Timur on 8/21/16.
 */
public class DoesNotCompileExceptionsClass {
    public static void main(String[] args) {

    }

    public void doesnotcompile() {
        try {
            migrtThrow();
        }
        catch (FileNotFoundException | IllegalStateException e) {

        }
        catch (InputMismatchException | MissingResourceException e) {

        }
        catch (ArrayIndexOutOfBoundsException e) {

        }
        catch (IllegalArgumentException e) {

        }
        catch (IOException e) {

        }
        catch (Exception e) {

        }
    }

    void migrtThrow() throws DateTimeParseException, IOException {

    }
}
