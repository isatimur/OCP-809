package main.com.isatimur.ocp.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileTime;
import java.util.Map;

/**
 * Created by tisachenko on 17.04.16.
 */
public class ModAttributes {
    public static void main(String[] args) throws IOException {
        Path file = Paths.get("/home/tisachenko/projects/OCP-809/ReadChars.java");
        BasicFileAttributeView view = Files.getFileAttributeView(file, BasicFileAttributeView.class);
//        Files.readAttributes(file)
        long now = System.currentTimeMillis();
        FileTime creationTime = FileTime.fromMillis(now - 60000);

        FileTime lastModified = FileTime.fromMillis(now - 50000);

        FileTime lastAccess = FileTime.fromMillis(now - 30000);

        view.setTimes(lastModified, lastAccess, creationTime);

        Map<String, Object> values = Files.readAttributes(file, "*");
        for (String key : values.keySet()) {
            System.out.println(key + " : " + values.get(key));
        }

//        FileTime newTime =  FileTime.fromMillis(System.currentTimeMillis());

    }
}
