import java.util.Scanner;

// Custom checked exception
class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String message) {
        super(message);
    }
}

// BankAccount class
class BankAccount {

    private double balance;

    // Constructor
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Method to withdraw money
    public void withdraw(double amount)
            throws InsufficientFundsException {

        if (amount > balance) {
            throw new InsufficientFundsException(
                "Insufficient balance. Available balance: ₹" + balance
            );
        }

        balance -= amount;
        System.out.println("Withdrawal successful.");
        System.out.println("Remaining balance: ₹" + balance);
    }

    // Getter method
    public double getBalance() {
        return balance;
    }
}

public class BankDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create account with initial balance
        BankAccount account = new BankAccount(5000);

        try {
            System.out.println("Current balance: ₹" + account.getBalance());

            System.out.print("Enter withdrawal amount: ₹");
            double amount = sc.nextDouble();

            account.withdraw(amount);

        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());

        } catch (java.util.InputMismatchException e) {
            System.out.println("Please enter a valid amount.");

        } finally {
            sc.close();
        }
    }
}