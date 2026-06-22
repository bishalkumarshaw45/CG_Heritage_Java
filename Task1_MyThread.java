public class Task1_MyThread extends Thread {
    private String name;

    public Task1_MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration " + i + ": My name is " + name + 
                             ", Current thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        Task1_MyThread thread = new Task1_MyThread("Alice");
        thread.start();
    }
}
