import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Simple BankAccount with synchronized methods
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.printf("[DEPOSIT] ₹%.2f | Balance: ₹%.2f%n", amount, balance);
    }

    public synchronized boolean withdraw(double amount) {
        if (balance < amount) {
            System.out.printf("[FAILED] Withdraw ₹%.2f (Only ₹%.2f available)%n", amount, balance);
            return false;
        }
        balance -= amount;
        System.out.printf("[WITHDRAW] ₹%.2f | Balance: ₹%.2f%n", amount, balance);
        return true;
    }

    public synchronized double getBalance() {
        return balance;
    }
}

// Simple Deposit Task
class DepositTask implements Runnable {
    private BankAccount account;
    private double amount;

    public DepositTask(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    public void run() {
        account.deposit(amount);
    }
}

// Simple Withdrawal Task
class WithdrawalTask implements Runnable {
    private BankAccount account;
    private double amount;

    public WithdrawalTask(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    public void run() {
        account.withdraw(amount);
    }
}

// Main class to run the Bank Transaction Simulator
public class BankTransactionSimulator {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("===== BANK TRANSACTION SIMULATOR (Indian Currency) =====\n");

        // Start with ₹50,000
        BankAccount account = new BankAccount(50000);
        System.out.printf("Initial Balance: ₹%.2f\n\n", account.getBalance());

        // Create thread pool with 4 threads
        ExecutorService executor = Executors.newFixedThreadPool(4);

        System.out.println("Starting 10 Deposits and 10 Withdrawals...\n");

        // Submit 10 deposits (₹1000, ₹2000, ..., ₹10000)
        for (int i = 1; i <= 10; i++) {
            executor.submit(new DepositTask(account, i * 1000));
        }

        // Submit 10 withdrawals (₹500, ₹1000, ..., ₹5000)
        for (int i = 1; i <= 10; i++) {
            executor.submit(new WithdrawalTask(account, i * 500));
        }

        // Wait for all tasks to complete
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        // Show results
        System.out.println("\n===== TRANSACTION SUMMARY =====");
        System.out.printf("Final Balance: ₹%.2f\n", account.getBalance());

        // Expected: 50000 + (1000+2000+...+10000) - (500+1000+1500+...+5000)
        // Deposits = 1000*(1+2+...+10) = 1000*55 = 55000
        // Withdrawals = 500*(1+2+...+10) = 500*55 = 27500
        double expected = 50000 + 55000 - 27500;
        System.out.printf("Expected: ₹%.2f\n\n", expected);

        if (Math.abs(account.getBalance() - expected) < 0.01) {
            System.out.println("✓ BALANCE CORRECT! All transactions completed safely.");
        } else {
            System.out.println("✗ BALANCE MISMATCH!");
        }
    }
}
