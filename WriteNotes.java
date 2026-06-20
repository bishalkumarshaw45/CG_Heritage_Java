import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteNotes {

    public static void main(String[] args) {

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("myNotes.txt"))) {

            writer.write("Learning Java file handling.");
            writer.newLine();

            writer.write("BufferedWriter improves writing performance.");
            writer.newLine();

            writer.write("Try-with-resources closes files automatically.");
            writer.newLine();

            writer.write("Exception handling makes programs reliable.");
            writer.newLine();

            writer.write("Practice coding every day to improve skills.");
            writer.newLine();

            System.out.println("File created successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}