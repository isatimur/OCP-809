package com.isatimur.ocp.lambda.streams.prologistic;

import com.isatimur.ocp.lambda.functional_interfaces.Supplier;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.isatimur.ocp.lambda.streams.prologistic.PersonStore.persons;

/**
 * Created by abyakimenko on 13.10.2016.
 */
public class Reduce {

    /**
     * Тип женерик - <T> и возвращает T => <T> T
     *
     * @param object
     * @param <T>
     * @return
     */
    public static <T> T genericMethod(T object) {

        return object;
    }

    public static void main(String[] args) {

        // одна из идей - работает как аккумулятор

        // T reduce(T identity, BinaryOperator<T> accumulator);
        // Первый Reduce метод
        // определяем самого старшего человека
        // Reduce метод принимает функцию аккумулятора BinaryOperator. Это на самом деле BiFunction, когда оба операнда
        // имеют один и тот же тип, в этом случае Person. BiFunctions похожи на Function, но принимает два аргумента.
        // Пример функции сравнивает людей по возрасту и возвращает самого старшего.
        persons.stream()
                .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
                .ifPresent(System.out::println);

        // Optional<T> reduce(BinaryOperator<T> accumulator);
        // Второй Reduce метод принимает идентифицирующее значение и BinaryOperator. Этот метод может быть использован
        // для «создания» нового человека с агрегированным имен и возрастом других человек в потоке:
        BinaryOperator<Person> binaryOperator = (p1, p2) -> {
            p1.age += p2.age;
            p1.name += p2.name;
            return p1;
        };

        Person result = persons
                .stream()
                .reduce(new Person("", 0), binaryOperator);

        // Третий Reduce
        // <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner);
        // Третий Reduce  метод принимает три параметра: значение идентификатора,BiFunction аккумулятор и объединитель
        // функции типа BinaryOperator. Поскольку идентифицирующее значение не ограничивает тип Person, мы можем
        // использовать это сокращение для определения суммы возрасте от всех лиц:
        Integer ageSumm = persons
                .stream()
                .reduce(0,
                        (sum, p) -> sum += p.age,   // accumulator
                        (sum1, sum2) -> sum1 + sum2 // combiner
                );
        System.out.println(ageSumm);

        Integer ageSum1 = persons
                .parallelStream()
                .reduce(0,
                        (sum, p) -> {
                            System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
                            return sum += p.age;
                        },
                        (sum1, sum2) -> {
                            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
                            return sum1 + sum2;
                        });

        persons
                .parallelStream()
                .reduce(0,
                        (sum, p) -> {
                            System.out.format("accumulator: sum=%s; person=%s [%s]\n", sum, p, Thread.currentThread().getName());
                            return sum += p.age;
                        },
                        (sum1, sum2) -> {
                            System.out.format("combiner: sum1=%s; sum2=%s [%s]\n", sum1, sum2, Thread.currentThread().getName());
                            return sum1 + sum2;
                        });

        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println(commonPool.getParallelism());

        List<String> stringList = Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
                .filter(s -> {
                    System.out.println("Фильтр: " + s);
                    return s.startsWith("bb");
                })
                .collect(Collectors.toList());

        Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });

        // о-первых, операция сортировки выполняется на всей совокупности входных данных. Другими словами, sorted
        // выполнен в горизонтальном направлении. Таким образом, sorted вызывается 8 раз
        // для нескольких комбинаций на каждом элементе во входной коллекции.
        Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

        // после оптимизации
        Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

        // filter:  dd2
        // filter:  aa2
        // filter:  bb1
        // filter:  bb3
        // filter:  cc4
        // map:     aa2
        // forEach: AA2

        Supplier<Stream<String>> streamSupplier = () -> Stream.of("dd2", "aa2", "bb1", "bb3", "cc")
                .filter(s -> s.startsWith("a"));

        streamSupplier.get().anyMatch(s -> true);   // операция пройдет успешно
        streamSupplier.get().noneMatch(s -> true);  // здесь также все будет ok
    }
}
