package com.isatimur.ocp.generics_collections.generics;

/**
 * Created by abyakimenko on 29.09.2016.
 */
public class mainGenerics {

    public static void main(String[] args) {

        Elephant elephant = new Elephant();
        Crate<Elephant> crateForElephant = new Crate<>();

        crateForElephant.packCrate(elephant);
        Elephant inNewHome = crateForElephant.emptyCrate();

//        Now we couldn’t have simply hard-coded Elephantin the Crateclass, since a Zebrais
//        not an Elephant. However, we could have created an Animalsuperclass or interface and
//                used that in Crate.
//        Generic classes become useful when the classes used as the type parameter can have absolutely
//        nothing to do with each other. For example, we need to ship our 120-pound robot to another city:
        Crate<Zebra> crateForZebra = new Crate<>();

        Robot joeBot = new Robot();
        Crate<Robot> robotCrate = new Crate<>();
        robotCrate.packCrate(joeBot);

        Integer numPounds = 15_000;
        SizeLimitedCrate<Elephant, Integer> c1 = new SizeLimitedCrate<>(elephant, numPounds);
    }
}
