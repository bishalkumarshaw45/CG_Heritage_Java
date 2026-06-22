// Named class implementing Runnable
class MyRunnableTask implements Runnable {
    private String name;

    public MyRunnableTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Named Class - Iteration " + i + ": My name is " + name + 
                             ", Current thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class Task2_RunnableDemo {
    public static void main(String[] args) {
        System.out.println("=== Using Named Class implementing Runnable ===");
        Thread thread1 = new Thread(new MyRunnableTask("Bob"), "NamedClassThread");
        thread1.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("\n=== Using Lambda Expression ===");
        String lambdaName = "Charlie";
        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Lambda - Iteration " + i + ": My name is " + lambdaName + 
                                 ", Current thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted: " + e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
        }, "LambdaThread");
        thread2.start();

        try {
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("\n=== Comparison ===");
        System.out.println("Named Class: More verbose, but explicit and reusable");
        System.out.println("Lambda: More concise, cleaner syntax, ideal for simple tasks");
    }
}
