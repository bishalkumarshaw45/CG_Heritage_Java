class Employee {

    // Private fields
    private String employeeId;
    private String name;
    private String department;
    private double baseSalary;
    private int experienceYears;

    // Static variables
    private static int employeeCount = 0;

    // Constructor
    public Employee(String name, String department, double baseSalary, int experienceYears) {

        employeeCount++;
        this.employeeId = String.format("EMP%03d", employeeCount);

        setName(name);
        this.department = department;
        setBaseSalary(baseSalary);
        setExperienceYears(experienceYears);
    }

    // Static method
    public static int getTotalEmployees() {
        return employeeCount;
    }

    // Getters
    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    // Setters with validation
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name!");
        }
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 15000) {
            this.baseSalary = baseSalary;
        } else {
            System.out.println("Salary must be at least Rs.15000");
        }
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears >= 0) {
            this.experienceYears = experienceYears;
        } else {
            System.out.println("Experience cannot be negative");
        }
    }

    // Overloaded calculateBonus methods
    public double calculateBonus() {
        return baseSalary * 0.10;
    }

    public double calculateBonus(double percentage) {
        return baseSalary * percentage / 100;
    }

    public double calculateBonus(double percentage, boolean includeExperienceBonus) {

        double bonus = baseSalary * percentage / 100;

        if (includeExperienceBonus) {
            bonus += experienceYears * 1000;
        }

        return bonus;
    }

    // toString()
    @Override
    public String toString() {
        return "Employee{id='" + employeeId +
                "', name='" + name +
                "', dept='" + department +
                "', salary=" + baseSalary +
                ", exp=" + experienceYears + " yrs}";
    }
}

public class employeeManagementSystem {
    public static void main(String[] args) {

        Employee emp1 = new Employee("Aayush Tiwary", "IT", 50000, 3);
        Employee emp2 = new Employee("Rahul Sharma", "HR", 40000, 5);

        // Display employee details
        System.out.println(emp1);
        System.out.println(emp2);

        // Bonus calculations
        System.out.println("\nBonuses:");

        System.out.println(emp1.getName() +
                " Default Bonus = Rs." +
                emp1.calculateBonus());

        System.out.println(emp1.getName() +
                " 15% Bonus = Rs." +
                emp1.calculateBonus(15));

        System.out.println(emp1.getName() +
                " 15% Bonus + Experience Bonus = Rs." +
                emp1.calculateBonus(15, true));

        // Total employees
        System.out.println("\nTotal Employees = "
                + Employee.getTotalEmployees());
    }
}
