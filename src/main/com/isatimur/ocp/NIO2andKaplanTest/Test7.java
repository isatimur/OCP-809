package com.isatimur.ocp.NIO2andKaplanTest;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.UserPrincipal;

/**
 * Created by Isachenko Timur on 15.09.2016.
 */
public class Test7 {
    public static void main(String[] args) {
        Path fPath = Paths.get("C:\\Documents\\JavaProjects\\Java8\\protected.enc");
        try {
            UserPrincipal jhester = fPath.getFileSystem().getUserPrincipalLookupService().
                    lookupPrincipalByName("developer");
            BasicFileAttributeView fView = Files.getFileAttributeView(fPath, BasicFileAttributeView.class);
//            how it should be -
            Files.setOwner(fPath, jhester);

//            how it was -
// fView.setOwner(jhester);
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }
    }
}
