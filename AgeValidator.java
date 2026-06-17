import java.util.Scanner;

// Custom checked exception
class InvalidAgeException extends Exception {

    public InvalidAgeException(String message) {
        super(message);
    }
}

public class AgeValidator {

    // Method that declares the exception using throws
    public static void validateAge(int age) throws InvalidAgeException {

        if (age < 18) {
            throw new InvalidAgeException(
                "Age must be 18 or above to proceed."
            );
        }

        System.out.println("Age is valid.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            validateAge(age);

        } catch (InvalidAgeException e) {
            System.out.println("Invalid age: " + e.getMessage());

        } catch (java.util.InputMismatchException e) {
            System.out.println("Please enter a valid integer age.");

        } finally {
            sc.close();
        }
    }
}