package main.com.isatimur.ocp.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by tisachenko on 16.04.16.
 */
public class Twist_and_Tale_8_2 {
    public static void main(String[] args) {
        Path dir = Paths.get("code");
        Path file = Paths.get("code/Java/IO.java");
        Path relative = file.resolve(file.relativize(dir));
        Path absolute = relative.toAbsolutePath();
        System.out.println(absolute);
    }
}
