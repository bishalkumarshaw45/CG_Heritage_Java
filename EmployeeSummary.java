public class EmployeeSummary {

    public static void main(String[] args) {

        String emp1 = "bishal kumar shaw";
        String emp2 = "suraj mondal";
        String emp3 = "manish kumar";
        String emp4 = "aayush twiary";
        String emp5 = "smit kuamr";

        double salary1 = 75000.99;
        double salary2 = 68000.50;
        double salary3 = 82000.75;
        double salary4 = 59000.20;
        double salary5 = 91000.90;

        // Casting
        int salary1Int = (int) salary1;
        int salary5Int = (int) salary5;

        // String Methods
        System.out.println("=== EMPLOYEE REPORT ===");

        System.out.println(emp1.toUpperCase());
        System.out.println(emp2.toLowerCase());
        System.out.println(emp3.trim());
        System.out.println("Length of Emp4 Name: " + emp4.length());

        // Ternary Operator
        String performance1 = salary1 > 70000 ? "Excellent" : "Good";
        String performance2 = salary2 > 70000 ? "Excellent" : "Good";
        String performance3 = salary3 > 70000 ? "Excellent" : "Good";
        String performance4 = salary4 > 70000 ? "Excellent" : "Good";
        String performance5 = salary5 > 70000 ? "Excellent" : "Good";

        System.out.println("\n--- Employee Details ---");

        System.out.println(emp1 + " | Salary: " + salary1Int +
                " | " + performance1);

        System.out.println(emp2 + " | Salary: " + salary2 +
                " | " + performance2);

        System.out.println(emp3 + " | Salary: " + salary3 +
                " | " + performance3);

        System.out.println(emp4 + " | Salary: " + salary4 +
                " | " + performance4);

        System.out.println(emp5 + " | Salary: " + salary5Int +
                " | " + performance5);
    }
}