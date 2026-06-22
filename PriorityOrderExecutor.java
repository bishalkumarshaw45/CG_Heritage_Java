import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class PriorityOrderExecutor {
    enum Priority {HIGH, MEDIUM, LOW}

    static class Order implements Comparable<Order> {
        final int id;
        final Priority priority;

        Order(int id, Priority priority) { this.id = id; this.priority = priority; }

        @Override
        public int compareTo(Order o) {
            return this.priority.ordinal() - o.priority.ordinal();
        }

        @Override public String toString() { return "Order{" + id + "," + priority + '}'; }
    }

    public static void main(String[] args) throws Exception {
        PriorityBlockingQueue<Order> queue = new PriorityBlockingQueue<>();
        // produce orders with mixed priorities
        queue.add(new Order(1, Priority.LOW));
        queue.add(new Order(2, Priority.HIGH));
        queue.add(new Order(3, Priority.MEDIUM));
        queue.add(new Order(4, Priority.HIGH));
        queue.add(new Order(5, Priority.LOW));

        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<String>> futures = new ArrayList<>();
        Random rnd = new Random();

        while (!queue.isEmpty()) {
            final Order o = queue.poll();
            if (o == null) break;
            Callable<String> task = () -> {
                int delay = 100 + rnd.nextInt(400);
                try { Thread.sleep(delay); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                String res = "Processed " + o + " by " + Thread.currentThread().getName();
                System.out.println(res);
                return res;
            };
            futures.add(executor.submit(task));
        }

        for (Future<String> f : futures) {
            System.out.println("Result: " + f.get());
        }

        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.SECONDS);
    }
}
