import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CallableFutureDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService ex = Executors.newFixedThreadPool(4);
        List<Callable<Integer>> tasks = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 1; i <= 4; i++) {
            final int n = i;
            tasks.add(() -> {
                int delay = 100 + rnd.nextInt(400);
                try { Thread.sleep(delay); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                int sq = n * n;
                System.out.println("Calculated " + sq + " by " + Thread.currentThread().getName());
                return sq;
            });
        }

        List<Future<Integer>> futures = new ArrayList<>();
        for (Callable<Integer> c : tasks) futures.add(ex.submit(c));

        for (Future<Integer> f : futures) System.out.println("Result via Future.get(): " + f.get());

        ex.shutdown();
    }
}
