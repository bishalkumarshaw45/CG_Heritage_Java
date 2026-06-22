public class CounterRaceDemo {
    static class Counter {
        int count = 0;
        void increment() { count++; }
        int get() { return count; }
    }

    static class SafeCounter {
        int count = 0;
        synchronized void increment() { count++; }
        int get() { return count; }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) c.increment();
            }, "T-" + i);
            threads[i].start();
        }
        for (Thread t : threads) t.join();
        System.out.println("Without synchronized, expected 5000 but got: " + c.get());

        SafeCounter sc = new SafeCounter();
        Thread[] threads2 = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads2[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) sc.increment();
            }, "S-" + i);
            threads2[i].start();
        }
        for (Thread t : threads2) t.join();
        System.out.println("With synchronized, expected 5000 and got: " + sc.get());
    }
}
