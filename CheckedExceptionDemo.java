import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckedExceptionDemo {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\dsds4\\internship\\DAY8(17 JUNE)\\Data.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }

            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}