package main.com.isatimur.ocp.nio;

/**
 * Created by tisachenko on 25.04.16.
 */

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirStream {
    public static void main(String args[]) throws IOException {
//        Path dir = Paths.get("/home/tisachenko/ROSTRUD/8");
//        try (DirectoryStream<Path> stream=Files.newDirectoryStream(dir,"*.{txt~}")) {
////            for (Path value : stream) {
////                System.out.println(value + ":" + Files.isDirectory(value));
//                Iterator iterator =  stream.iterator();
//                while (iterator.hasNext()){
//
//                    Files.delete((Path)iterator.next());
////                    System.out.println(iterator.next());
//
//                }
////            }
//        }
        Path path1 = Paths.get("MyDir/hello.java");
        Path path2 = Paths.get("FriendDir/code");
        Path path4 = Paths.get("FriendDir/code");
        Path path3 = path1.relativize(path2);
        for (Path path : path3)
            System.out.println(path);
    }
}