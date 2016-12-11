package com.isatimur.ocp.nio.abyakimenko;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Created by abyakimenko on 24.11.2016.
 */
public class psvm {

    public static void main(String[] args) throws IOException {


//        System.out.println(Arrays.asList("duck","chicken","flamingo","pelican")
//                .parallelStream().parallel() // q1
//                .reduce(0,
//                        (c1, c2) -> c1.length() + c2.length(), // q2
//                        (s1, s2) -> s1 + s2)); // q3


        Path p0 = Paths.get("c:\\temp");
        Path p01 = Paths.get(".").normalize();

       final String testUUID = "3d197b9c-f8dc-2725-4daa-fd6b6a57847c";
//                             "e8bff97e-227b-46ff-957c-75768bb13924"

        System.out.println(UUID.randomUUID().toString());

        UUID.fromString(testUUID);

//        if (Files.isSameFile(p0, Paths.get("c:\\temp\\111"))) {
//
//
//            System.out.println("isSame");
//        }

        Path p1 = Paths.get("c:\\temp\\..\\.\\..\\test.txt");


        Path p2 = Paths.get("c:\\temp\\report.pdf");
        System.out.println(p1.resolve(p2));

        psvm d = new psvm();
        psvm.D dd = d.new D();


        Path p3 = Paths.get("c:\\temp\\report.pdf");
        Path p4 = p3.getParent();
        Path norm = p4.normalize();

        System.out.println(norm.toAbsolutePath());

        Path path3 = Paths.get("E:\\data");
        Path path4 = Paths.get("E:\\user\\home");

        Path relativePath = path3.relativize(path4);
        System.out.println(path3.resolve(relativePath));
        System.out.println(path3.resolve(relativePath).normalize());
    }

    class A {
    }

    class B extends A {
    }

    class C extends B {
    }

    class D extends C {
    }


}
