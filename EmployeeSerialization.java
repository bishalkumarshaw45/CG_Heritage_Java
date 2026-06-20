import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EmployeeSerialization {

    public static void main(String[] args) {

        Employee emp1 = new Employee(101, "Alice", 65000.0, "HR");
        Employee emp2 = new Employee(102, "Bob", 72000.0, "IT");
        Employee emp3 = new Employee(103, "Charlie", 80000.0, "Finance");

        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream("emp.ser"))) {

            out.writeObject(emp1);
            out.writeObject(emp2);
            out.writeObject(emp3);

            System.out.println("Employee objects saved successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}