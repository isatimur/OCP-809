package main.com.isatimur.ocp.mock_tests.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by tisachenko on 14.03.16.
 */
public class SynchronizedCollections {
    public static void main(String[] args) {
        List<Integer> source = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> fish = new CopyOnWriteArrayList<>(source);
        List<Integer> mammals = Collections.synchronizedList(source);
        Set<Integer> birds = new ConcurrentSkipListSet<>(source);
        birds.addAll(source);

        synchronized (mammals) {
            for (Integer f : fish)
                fish.add(4);
            for (Integer d : mammals)
                mammals.add(4);
//            Iterator<Integer> iterator = mammals.iterator();
//            while (iterator.hasNext()){
//                iterator.next();
//            mammals.add(4);
//            mammals.add(4);
//            mammals.add(4);
//            mammals.add(4);
//            }
        }

        for (Integer b : birds)
            birds.add(5);
        System.out.println(fish.size() + " " + mammals.size() + " " + birds.size());
    }

}