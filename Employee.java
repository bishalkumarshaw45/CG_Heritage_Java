import java.io.Serializable;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private int empId;
    private String name;
    private double salary;
    private String department;

    public Employee(int empId, String name, double salary, String department) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee ID: " + empId +
               "\nName: " + name +
               "\nSalary: " + salary +
               "\nDepartment: " + department;
    }
}