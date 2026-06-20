import java.io.*;
import java.util.*;

public class StudentRecordSaver {

    private static final String FILE_NAME = "students.txt";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== Student Record Menu =====");
            System.out.println("1. Add");
            System.out.println("2. View All");
            System.out.println("3. Search");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    viewAllStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addStudent() {

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(FILE_NAME, true))) {

            System.out.print("Enter Roll Number: ");
            int rollNumber = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Marks: ");
            double marks = scanner.nextDouble();
            scanner.nextLine();

            writer.write(rollNumber + "," + name + "," + marks);
            writer.newLine();

            System.out.println("Student record added successfully.");

        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }

    private static void viewAllStudents() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No records found.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(
                new FileReader(FILE_NAME))) {

            String line;

            System.out.println("\n--- Student Records ---");

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                System.out.println("Roll No: " + data[0]
                        + " | Name: " + data[1]
                        + " | Marks: " + data[2]);
            }

        } catch (IOException e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }
    }

    private static void searchStudent() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No records found.");
            return;
        }

        System.out.print("Enter student name to search: ");
        String searchName = scanner.nextLine();

        boolean found = false;

        try (BufferedReader reader = new BufferedReader(
                new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data[1].equalsIgnoreCase(searchName)) {

                    System.out.println("\nStudent Found:");
                    System.out.println("Roll No: " + data[0]);
                    System.out.println("Name: " + data[1]);
                    System.out.println("Marks: " + data[2]);

                    found = true;
                }
            }

            if (!found) {
                System.out.println("Student not found.");
            }

        } catch (IOException e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }
    }

    private static void deleteStudent() {

        File inputFile = new File(FILE_NAME);

        if (!inputFile.exists()) {
            System.out.println("No records found.");
            return;
        }

        System.out.print("Enter roll number to delete: ");
        String rollToDelete = scanner.nextLine();

        File tempFile = new File("temp.txt");

        boolean deleted = false;

        try (BufferedReader reader = new BufferedReader(
                     new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(
                     new FileWriter(tempFile))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data[0].equals(rollToDelete)) {
                    deleted = true;
                    continue;
                }

                writer.write(line);
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error processing file.");
            e.printStackTrace();
            return;
        }

        if (inputFile.delete() && tempFile.renameTo(inputFile)) {

            if (deleted) {
                System.out.println("Student record deleted successfully.");
            } else {
                System.out.println("Roll number not found.");
            }

        } else {
            System.out.println("Unable to update the file.");
        }
    }
}