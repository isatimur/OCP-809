package com.isatimur.ocp.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by tisachenko on 17.04.16.
 */
public class AccessAttributes {
    public static void main(String[] args) throws IOException {

        // D:\OCPJP\NIO2\src\SubPath.java
        Path aPath = Paths.get("D:\\OCPJP\\programs\\..programs\\..\\..\\NIO2\\src\\.\\SubPath.java");
        aPath = aPath.normalize();
        System.out.println(aPath.subpath(2, 3));


        Path path = Paths.get("./src/main/java/com/isatimur/ocp/nio/AccessAttributes.java");
        System.out.println("size:" + Files.size(path));
        System.out.println("isDirectory:" + Files.isDirectory(path));
        System.out.println("isExecutable:" + Files.isExecutable(path));
        System.out.println("isHidden:" + Files.isHidden(path));
        System.out.println("isReadable:" + Files.isReadable(path));
        System.out.println("isSameFile:" + Files.isSameFile(path, path));
        System.out.println("isSymbolycLink:" + Files.isSymbolicLink(path));
        System.out.println("isWritable:" + Files.isWritable(path));
        System.out.println("getLastModified:" + Files.getLastModifiedTime(path));
        System.out.println("getOwner:" + Files.getOwner(path));

        //Let's modify file attribute

        System.out.println(Files.getAttribute(path, "creationTime"));

        Files.setAttribute(path, "creationTime", FileTime.fromMillis(System.currentTimeMillis()));

        System.out.println(Files.getAttribute(path, "creationTime"));

        System.out.println();

        PosixFileAttributeView view = Files.getFileAttributeView(path, PosixFileAttributeView.class);
        System.out.println("view:" + view.name());

        PosixFileAttributes attr1 = view.readAttributes();
        PosixFileAttributes attr2 = Files.readAttributes(path, PosixFileAttributes.class);

        System.out.println("attribute permissions: " + attr1.permissions());
        System.out.println("attribute group: " + attr2.group());

        List<String> vowels = new ArrayList<String>();
        vowels.add("a");
        vowels.add("e");
        vowels.add("i");
        vowels.add("o");
        vowels.add("u");
        Function<List<String>, List<String>> f = list -> list.subList(2, 4);
        f.apply(vowels);
    }
}
