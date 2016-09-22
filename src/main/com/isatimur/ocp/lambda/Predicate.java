package main.com.isatimur.ocp.lambda;

/**
 * Created by Isachenko Timur on 08.07.2016.
 */
@FunctionalInterface
public interface Predicate<T> {
    public static void main(String[] args) {
        Predicate<String> p1 = s -> s.length() < 20;
        Predicate<String> p2 = s -> s.length() > 5;

        boolean b = p1.test("Hello world!");
        System.out.println("Hello is shorter than 20 characters: " + b);

        Predicate<String> p3 = p1.and(p2);
        System.out.println("P3 for Yes: " + p3.test("Yes"));
        System.out.println("P3 for Good morning: " + p3.test("Good morning"));
        System.out.println("P3 for Good morning gentelmen: " + p3.test("Good morning gentelmen"));

        Predicate<String> p4 = p1.or(p2);

        System.out.println("P4 for Yes: " + p4.test("Yes"));
        System.out.println("P4 for Good morning: " + p4.test("Good morning"));
        System.out.println("P4 for Good morning gentelmen: " + p4.test("Good morning gentelmen"));

        Predicate<String> p5 = Predicate.isEqualsTo("Yes");
        System.out.println("P5 for Yes: " + p5.test("Yes"));
        System.out.println("P5 for Yes: " + p5.test("Yes"));

        Predicate<Integer> p6 = Predicate.isEqualsTo(1);
        System.out.println(p6.test(1));

    }

    static <U> Predicate<U> isEqualsTo(U text) {
        return s -> s.equals(text);
    }

    boolean test(T t);

    default Predicate<T> or(Predicate<T> other) {
        return t -> test(t) || other.test(t);
    }

    default Predicate<T> and(Predicate<T> other) {
        return t -> test(t) && other.test(t);
    }

}
