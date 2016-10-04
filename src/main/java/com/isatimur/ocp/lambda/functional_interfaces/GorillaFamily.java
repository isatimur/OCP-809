package com.isatimur.ocp.lambda.functional_interfaces;

@FunctionalInterface
interface Gorrila {
    String move();
}

/**
 * Created by Isa Timur on 8/9/16.
 * <p>
 * Functional Interfaces # Parameters   Return Type Single Abstract Method
 *
 *
 * Supplier<T>             0            T           get  -- Returns a String without taking any parameters
 * Consumer<T>             1 (T)        void        accept
 * BiConsumer<T, U>        2 (T, U)     void        accept
 * Predicate<T>            1 (T)        boolean     test
 * BiPredicate<T, U>       2 (T, U)     boolean     test
 * Function<T, R>          1 (T)        R           apply -- Returns a Booleanand takes a String
 * BiFunction<T, U, R>     2 (T, U)     R           apply -- Returns an Integer and takes two Integers
 * UnaryOperator<T>        1 (T)        T           apply
 * BinaryOperator<T>       2 (T, T)     T           apply -- Returns an Integer and takes two Integers
 *
 *
 */
public class GorillaFamily {

    String walk = "walk";

    public static void main(String[] args) {
        new GorillaFamily().everyonePlay(true);
    }

    void everyonePlay(boolean baby) {

        String approach = "amble";
//      approach = "reassemble";

        play(() -> walk);
        play(() -> baby ? "hitch a ride" : "run");
        play(() -> approach);
    }

    void play(Gorrila g) {
        System.out.println(g.move());
    }
}
