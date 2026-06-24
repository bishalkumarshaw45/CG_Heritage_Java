import java.util.LinkedList;
import java.util.Queue;

public class CustomerServiceQueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.add("Alice");
        queue.add("Bob");
        queue.add("Charlie");
        queue.add("Diana");
        queue.add("Ethan");
        printQueueState(queue, "After adding 5 customers:");

        System.out.println("Serving customer: " + queue.poll());
        printQueueState(queue, "After serving 1 customer:");

        System.out.println("Serving customer: " + queue.poll());
        printQueueState(queue, "After serving 2 customers:");

        queue.add("Fiona");
        queue.add("George");
        printQueueState(queue, "After adding 2 more customers:");

        System.out.println("Remaining customers: " + queue);
    }

    private static void printQueueState(Queue<String> queue, String message) {
        System.out.println(message);
        String next = queue.peek();
        System.out.println("Next customer: " + (next == null ? "None" : next));
        System.out.println("Queue state: " + queue);
        System.out.println();
    }
}
