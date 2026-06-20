import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyUtility {

    public static void main(String[] args) {

        int lineCount = 0;

        // Open both files using try-with-resources
        try (BufferedReader reader = new BufferedReader(
                    new FileReader("C:\\Users\\dsds4\\internship\\DAY9(18 JUNE)\\source.txt"));
             BufferedWriter writer = new BufferedWriter(
                    new FileWriter("destination.txt"))) {

            String line;

            // Read each line from source.txt and write to destination.txt
            while ((line = reader.readLine()) != null) {

                writer.write(line);
                writer.newLine();

                lineCount++;
            }

            System.out.println("Copied " + lineCount
                    + " lines from source.txt to destination.txt");

        } catch (IOException e) {
            System.out.println("An error occurred while copying the file.");
            e.printStackTrace();
        }
    }
}