package com.isatimur.ocp.enthuware.concurrency;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

class JerkyThread extends Thread {
    private int data = 0;
    private boolean done = false;

    public JerkyThread(int x) {
        super();
        this.data = x;
    }

    public synchronized int getData() {
        return data;
    }

    public synchronized boolean isDone() {
        return done;
    }

    public synchronized void run() {
        data += data;
        done = true;
    }

    public static void main(String[] args) throws Exception {
//        java.nio.file.FileVisitResult


        AtomicInteger ai = new AtomicInteger();
        Stream<Integer> stream = Stream.of(11, 11, 22, 33).parallel();
        stream.filter(e -> {
            ai.incrementAndGet();
            return e % 2 == 0;
        });
        System.out.println(ai);

        Deque<Integer> d = new ArrayDeque<>();
        d.add(1);
        d.addFirst(2);
        d.pop();
        d.offerFirst(3);


        BinaryOperator<String> bo = (s1, s2) -> s1.concat(s2);
        List<String> names = new ArrayList<>();
        names.add("Bill");
        names.add("George");
        names.add("Obama");
        String finalvalue = names.stream().reduce("Hello : ", bo);
        System.out.println(finalvalue);

        List<Student> ls = Arrays.asList(new Student("S1", Student.Grade.A), new Student("S2", Student.Grade.A), new Student("S3", Student.Grade.C));

//        Map<Integer, List<Student>> grouping = ls.stream().groupBy( Collectors.mapping(Student::getGrade,new ArrayList())));


        JerkyThread[] jta = new JerkyThread[3];
        for (int i = 0; i < 3; i++) {
            jta[i] = new JerkyThread(i);
            jta[i].start();
        }
        for (JerkyThread jt : jta) {
            if (jt.isDone()) System.out.println(jt.getData());
        }
    }
}