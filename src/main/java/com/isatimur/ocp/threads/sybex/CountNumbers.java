package com.isatimur.ocp.threads.sybex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountNumbers extends RecursiveAction {
    private int start;
    private int end;

    public CountNumbers(int start, int end) {
        this.start = start;
        this.end = end;
    }

    protected void compute() {
        if (start < 0) return;
        else {
            int middle = start + ((end - start) / 2);
            invokeAll(new CountNumbers(start, middle),
                    new CountNumbers(middle, end)); // m1
        }
    }

    public void addAndPrintItems(BlockingDeque<Integer> deque) throws InterruptedException {
        deque.offer(103);
        deque.offerFirst(20, 1, TimeUnit.SECONDS);
        deque.offerLast(85, 7, TimeUnit.HOURS);
        System.out.print(deque.pollFirst(200, TimeUnit.NANOSECONDS));
        System.out.print(" " + deque.pollLast(1, TimeUnit.MINUTES));
    }

    public static void main(String[] args) {

        Map<String, List<String>> stateCitiesMap = new HashMap<>();
//        Map<String, List<String>> stateCitiesMap = new HashMap<String, ArrayList<String>>();
        Map<String, ArrayList<String>> stateCitiesMap1 = new HashMap<>();

        Stream<String> cats = Stream.of("leopard", "lynx", "ocelot", "puma").parallel();
        Stream<String> bears = Stream.of("panda", "grizzly", "polar").parallel();
        ConcurrentMap<Boolean, List<String>> data = Stream.of(cats, bears)
                .flatMap(s -> s)
                .collect(Collectors.groupingByConcurrent(s -> !s.startsWith("p")));
        System.out.println(data.get(false).size() + " " + data.get(true).size());


        ForkJoinTask<?> task = new CountNumbers(0, 4); // m2
        ForkJoinPool pool = new ForkJoinPool();
        Object result = pool.invoke(task); // m3
    }
}