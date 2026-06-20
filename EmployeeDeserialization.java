import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class EmployeeDeserialization {

    public static void main(String[] args) {

        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream("emp.ser"))) {

            while (true) {
                Employee employee = (Employee) in.readObject();

                System.out.println(employee);
                System.out.println("---------------------");
            }

        } catch (EOFException e) {
            System.out.println("All employee records loaded successfully.");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}