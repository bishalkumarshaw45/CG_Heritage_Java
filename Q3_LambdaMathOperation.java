public class Q3_LambdaMathOperation {
    // Functional interface with one abstract method
    @FunctionalInterface
    interface MathOperation {
        int operate(int a, int b);
    }

    public static void main(String[] args) {
        // Lambda expressions implementing the interface
        MathOperation addition = (a, b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (a, b) -> a * b;

        int a = 10;
        int b = 5;

        System.out.println("Addition: " + addition.operate(a, b));
        System.out.println("Subtraction: " + subtraction.operate(a, b));
        System.out.println("Multiplication: " + multiplication.operate(a, b));
    }
}
