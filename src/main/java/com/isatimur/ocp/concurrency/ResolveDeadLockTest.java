package com.isatimur.ocp.concurrency;


// В Java deadlock – это ситуация, когда минимум две нити удерживают блок на разных ресурсах, и обе ожидают освобождения
// другого ресурса для завершения своей задачи. И ни одна не в состоянии оставить блокировку удерживаемого ресурса.

public class ResolveDeadLockTest {

    public static void main(String[] args) {
        ResolveDeadLockTest test = new ResolveDeadLockTest();

        final A a = test.new A();// вложенный класс-ресурс
        final B b = test.new B();// вложенный класс-ресурс

        // Thread-1
        Runnable block1 = () -> {
//            synchronized (a) {
            synchronized (b) {
                try {
                    // Добавляем задержку, чтобы обе нити могли начать попытки
                    // блокирования ресурсов
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Thread-1 заняла A но также нуждается в B
//                synchronized (b) {
                synchronized (a) {
                    System.out.println("In block 1");
                }
            }
        };

        // Thread-2
        Runnable block2 = () -> {
            synchronized (b) {
                // Thread-2 заняла B но также нуждается в A
                synchronized (a) {
                    System.out.println("In block 2");
                }
            }
        };

        new Thread(block1).start();
        new Thread(block2).start();
    }

    // Resource A
    private class A {
        private int i = 10;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }

    // Resource B
    private class B {
        private int i = 20;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }
}