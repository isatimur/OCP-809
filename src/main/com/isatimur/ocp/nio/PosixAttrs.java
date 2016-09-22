package main.com.isatimur.ocp.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermissions;

/**
 * Created by tisachenko on 18.04.16.
 */
public class PosixAttrs {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/home/tisachenko/projects/OCP-809/myData.data");
        PosixFileAttributeView view = Files.getFileAttributeView(path, PosixFileAttributeView.class);

        PosixFileAttributes attributes = view.readAttributes();
        if (attributes.owner().getName().equals("tisachenko")) {
            view.setPermissions(PosixFilePermissions.fromString("rwxrwxrwx"));

        }
        else {
            view.setPermissions(PosixFilePermissions.fromString("rwxr-x---"));
        }
    }
}
