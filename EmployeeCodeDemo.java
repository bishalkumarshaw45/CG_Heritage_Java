public class EmployeeCodeDemo {
    public static void main(String[] args) {

        String empCode = "EMP-FIN-20224";

        String department = empCode.substring(4, 7);
        String employeeNumber = empCode.substring(8);
        char firstChar = empCode.charAt(0);

        System.out.println("Department = " + department);
        System.out.println("Employee Number = " + employeeNumber);
        System.out.println("First Character = " + firstChar);
    }
}