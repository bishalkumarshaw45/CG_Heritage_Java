import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteDemo {

    public static void main(String[] args) {

        // Try-with-resources automatically closes the writer
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("output.txt"))) {

            writer.write("Hello, World!");
            writer.newLine();

            writer.write("Welcome to Java Exception Handling.");
            writer.newLine();

            writer.write("This file was created using try-with-resources.");

            System.out.println("Data written successfully.");

        } catch (IOException | RuntimeException e) {

            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}