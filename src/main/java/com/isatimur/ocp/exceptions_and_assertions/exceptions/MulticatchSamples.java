package com.isatimur.ocp.exceptions_and_assertions.exceptions;

import java.io.IOException;

/**
 * Created by Isa Timur on 8/21/16.
 */
public class MulticatchSamples {

    public static void throwsIO() throws IOException {
        throw new IOException();
    }

    public static void main(String[] args) {
        try {
//            Path path = Paths.get("dolphinBorn.txt");
//            String text = new String(Files.readAllBytes(path));
//            LocalDate date = LocalDate.parse(text);
//            System.out.println(date);
//            throwsIO();
            throw new IOException("ex");
        }
//        catch (DateTimeParseException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        catch (DateTimeParseException | IOException e) {
//        catch (FileNotFoundException | RuntimeException ex) {
        catch (IOException | RuntimeException ex) {
            ex.printStackTrace();
//            throw new RuntimeException(ex);
        }

    }
}
