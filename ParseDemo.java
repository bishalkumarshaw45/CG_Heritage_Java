public class ParseDemo {
    public static void main(String[] args) {

        String ageStr = "25";
        String salaryStr = "50000.50";

        int age = Integer.parseInt(ageStr);
        double salary = Double.parseDouble(salaryStr);

        System.out.println("Age + 5 = " + (age + 5));
        System.out.println("Salary + Bonus = " + (salary + 5000));
    }
}