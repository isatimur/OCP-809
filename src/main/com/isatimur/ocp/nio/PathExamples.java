package main.com.isatimur.ocp.nio;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by tisachenko on 16.04.16.
 */
public class PathExamples {
    public static void main(String[] args) {
        Path file1 = Paths.get("ocp/java/file.txt");
        Path dir1 = FileSystems.getDefault().getPath("java/");
        Path relative = file1.relativize(dir1);
        System.out.println(relative);
        System.out.println(relative.toAbsolutePath());

        Path relativeDir = dir1.relativize(file1);
        System.out.println(relativeDir);
        System.out.println(relativeDir.toAbsolutePath());

        Path file2 = Paths.get("java/file.txt");
        Path dir2 = FileSystems.getDefault().getPath("java/");

        System.out.println((dir2).resolve(file2));
        System.out.println(file2.relativize(dir2));
        System.out.println(dir2.relativize(file2));

        Path file3 = Paths.get("/java/file.txt");
        Path dir3 = FileSystems.getDefault().getPath("/java/");
        System.out.println();
        System.out.println((dir3).resolve(file3));
        System.out.println((file3).resolve(dir3));
        System.out.println(file3.relativize(dir3));
        System.out.println(dir3.relativize(file3));

//        Path dirr = Paths.get("code");
//        Path dirC = Paths.get("")
    }
}
