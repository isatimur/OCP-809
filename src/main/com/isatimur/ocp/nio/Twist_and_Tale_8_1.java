package main.com.isatimur.ocp.nio;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringJoiner;

/**
 * Created by tisachenko on 16.04.16.
 */
public class Twist_and_Tale_8_1 {
    public static void main(String[] args) {
        Path path = Paths.get("/home/tisachenko/ROSTRUD/../projects/./8-1.txt");

        ///home/tisachenko/ROSTRUD/../projects/./8-1.txt
        System.out.println(path.toString());
        //tisachenko
        System.out.println(path.getName(1));
        ///home/tisachenko/ROSTRUD/../projects/.
        System.out.println(path.getParent());
        //ROSTRUD/..
        System.out.println(path.subpath(2, 4));

        //7
        System.out.println(path.getNameCount());

        StringJoiner joiner = new StringJoiner(",");

//        path =path.normalize();
        for (int i = 0; i < path.getNameCount(); i++) {
            joiner.add(path.getName(i).toString());
        }
        System.out.println(joiner.toString());

        joiner = new StringJoiner(",");
        path = path.normalize();
        for (int i = 0; i < path.getNameCount(); i++) {
            joiner.add(path.getName(i).toString());
        }
        System.out.println(joiner.toString());
    }
}
