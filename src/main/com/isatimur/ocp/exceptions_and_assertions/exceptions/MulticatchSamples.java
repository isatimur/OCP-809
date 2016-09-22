package main.com.isatimur.ocp.exceptions_and_assertions.exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Created by Isa Timur on 8/21/16.
 */
public class MulticatchSamples {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("dolphinBorn.txt");
            String text = new String(Files.readAllBytes(path));
            LocalDate date = LocalDate.parse(text);
            System.out.println(date);
        }
//        catch (DateTimeParseException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
        catch (DateTimeParseException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
