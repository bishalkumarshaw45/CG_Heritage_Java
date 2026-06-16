import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PhonebookApp {

    public static void main(String[] args) {

        HashMap<String, String> phonebook = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println("\n=== PHONEBOOK MENU ===");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Show All Contacts (Sorted by Name)");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            switch (choice) {

                case 1:
                    System.out.print("Enter contact name: ");
                    String addName = sc.nextLine();

                    System.out.print("Enter phone number: ");
                    String addPhone = sc.nextLine();

                    phonebook.put(addName, addPhone);
                    System.out.println("Contact added successfully.");
                    break;

                case 2:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();

                    if (phonebook.containsKey(searchName)) {
                        System.out.println("Phone Number: "
                                + phonebook.get(searchName));
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter name to update: ");
                    String updateName = sc.nextLine();

                    if (phonebook.containsKey(updateName)) {

                        System.out.print("Enter new phone number: ");
                        String newPhone = sc.nextLine();

                        phonebook.put(updateName, newPhone);
                        System.out.println("Contact updated successfully.");

                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter name to delete: ");
                    String deleteName = sc.nextLine();

                    if (phonebook.containsKey(deleteName)) {
                        phonebook.remove(deleteName);
                        System.out.println("Contact deleted successfully.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 5:
                    if (phonebook.isEmpty()) {
                        System.out.println("Phonebook is empty.");
                    } else {

                        TreeMap<String, String> sortedContacts =
                                new TreeMap<>(phonebook);

                        System.out.println("\n--- Contacts ---");

                        for (Map.Entry<String, String> entry :
                                sortedContacts.entrySet()) {

                            System.out.println(
                                    entry.getKey() + " : "
                                    + entry.getValue());
                        }
                    }
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting phonebook...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}