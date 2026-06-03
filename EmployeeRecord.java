public class EmployeeRecord {
    public static void main(String[] args) {

        String name = "bishal";
        double salary = 85000;
        String department = "IT";
        boolean active = true;

        String performance =
                salary > 80000 ? "Excellent" : "Good";

        System.out.println(
                "Name: " + name +
                ", Salary: " + salary +
                ", Department: " + department +
                ", Active: " + active +
                ", Performance: " + performance
        );
    }
}