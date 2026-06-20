import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadNotes {

    public static void main(String[] args) {

        int lineCount = 0;

        try (BufferedReader reader = new BufferedReader(
                new FileReader("myNotes.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {
                lineCount++;
                System.out.println("Line " + lineCount + ": " + line);
            }

            System.out.println("Total lines: " + lineCount);

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}