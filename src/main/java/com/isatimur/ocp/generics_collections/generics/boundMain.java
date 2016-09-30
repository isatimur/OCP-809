package com.isatimur.ocp.generics_collections.generics;

import com.isatimur.ocp.generics_collections.generics.habr.CarHabr;
import com.isatimur.ocp.generics_collections.generics.habr.VehicleHabr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abyakimenko on 29.09.2016.
 */
public class boundMain {
    @Override
    public String toString() {
        return super.toString();
    }

    public static void printList(List<? extends Number> list) {
        list.forEach(System.out::println);
    }

    public static void printListVehicles(List<? extends VehicleHabr> list) {
        list.forEach(System.out::println);
    }

    public static long total(List<? extends Number> list) {
        long count = 0;
        for (Number number : list)
            count += number.longValue();
        return count;
    }

    public static void main(String[] args) {

        // "предикат от V или любого супертипа V (вплоть до Object)"
        List<VehicleHabr> cars = new ArrayList<>();
        cars.add(new VehicleHabr());
        cars.add(new CarHabr());

        printListVehicles(cars);

        List<Number> keywords = new ArrayList<>();

        keywords.add(1);
        keywords.add(12.0);
        keywords.add(13);
        keywords.add(41L);
        keywords.add(45);

        printList(keywords);


        List<? extends Number> list = new ArrayList<Integer>();
//        list.add(1);
    }
}
//    Если метод имеет аргументы с параметризованным типом (например, Collection или Predicate), то в случае, если аргумент - производитель (producer),
//    нужно использовать ? extends T, а если аргумент - потребитель (consumer), нужно использовать ? super T.

//    Производитель и потребитель, кто это такие? Очень просто: если метод читает данные из аргумента, то этот аргумент -
//    производитель, а если метод передаёт данные в аргумент, то аргумент является потребителем. Важно заметить, что определяя производителя или потребителя, мы рассматриваем только данные типа T.
//
//    В нашем примере Predicate - это потребитель (метод getAll(Predicate) передаёт в этот аргумент данные типа T),
//    а Map<K, V> - производитель (метод putAll(Map<K, V>) читает данные типа T - в данном случае под T подразумевается K и V - из этого аргумента).
//
//    В случае, если аргумент является и потребителем, и производителем одновременно - например, если метод одновременно
//    и читает из коллекции, и пишет в неё (плохой стиль, но всякое бывает) - тогда его нужно оставить как есть.
//
//    С возвращаемыми значениями тоже ничего делать не нужно - никакого удобства использование wildcard-ов в этом случае
//    пользователю не принесёт, а лишь вынудит его использовать wildcard-ы в собственном коде.
//
//    Вооружившись PECS-принципом, мы можем теперь пройтись по всем методам нашего MyObjectStore интерфейса и сделать
//    улучшения там, где это требуется. Методы put(K, V) и get(K) улучшений не требуют (т.к. они не имеют аргументов с параметризованным типом); методы putAll(Map<? extends K, ? extends V>) и getAll(Predicate<? super V>) мы уже и так улучшили, дальше некуда; а вот метод