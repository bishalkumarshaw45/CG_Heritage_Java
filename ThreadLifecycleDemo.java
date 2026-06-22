public class ThreadLifecycleDemo {
    static final Object lock = new Object();

    static class Worker extends Thread {
        public Worker(String name) { super(name); }

        @Override
        public void run() {
            System.out.println(getName() + " run() start");
            synchronized (lock) {
                System.out.println(getName() + " acquired lock and will sleep");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(getName() + " run() end");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Worker("Worker-1");
        System.out.println("State (NEW): " + t.getState());

        t.start();
        Thread.sleep(50);
        System.out.println("State (after start, likely RUNNABLE/TIMED_WAITING): " + t.getState());

        // Demonstrate BLOCKED: have a holder thread keep the lock while another tries to acquire it
        Thread holder = new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Holder");

        Thread blocked = new Thread(() -> {
            System.out.println("Blocked thread attempting to acquire lock");
            synchronized (lock) {
                System.out.println("Blocked thread acquired lock");
            }
        }, "BlockedThread");

        System.out.println("Blocked state before start: " + blocked.getState());
        holder.start();
        Thread.sleep(50);
        blocked.start();
        Thread.sleep(50);
        System.out.println("Blocked state after start (expect BLOCKED): " + blocked.getState());

        holder.join();
        blocked.join();

        t.join();
        System.out.println("Worker state after termination: " + t.getState());
    }
}
