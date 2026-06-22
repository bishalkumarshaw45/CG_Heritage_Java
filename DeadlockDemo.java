public class DeadlockDemo {
    static final Object lockA = new Object();
    static final Object lockB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("T1 acquired lockA");
                try { Thread.sleep(100); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                System.out.println("T1 attempting lockB");
                synchronized (lockB) {
                    System.out.println("T1 acquired lockB");
                }
            }
        }, "T1");

        Thread t2 = new Thread(() -> {
            synchronized (lockB) {
                System.out.println("T2 acquired lockB");
                try { Thread.sleep(100); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                System.out.println("T2 attempting lockA");
                synchronized (lockA) {
                    System.out.println("T2 acquired lockA");
                }
            }
        }, "T2");

        t1.start();
        t2.start();
        Thread.sleep(500);
        System.out.println("After 500ms: t1.isAlive()=" + t1.isAlive() + " t2.isAlive()=" + t2.isAlive() + " (if both true, likely deadlocked)");

        // Fix: consistent lock ordering (always lockA then lockB)
        Thread t3 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("T3 acquired lockA");
                synchronized (lockB) {
                    System.out.println("T3 acquired lockB");
                }
            }
        }, "T3");

        Thread t4 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("T4 acquired lockA");
                synchronized (lockB) {
                    System.out.println("T4 acquired lockB");
                }
            }
        }, "T4");

        t3.start();
        t4.start();
        t3.join();
        t4.join();
        System.out.println("Fixed-order threads completed normally");
    }
}
