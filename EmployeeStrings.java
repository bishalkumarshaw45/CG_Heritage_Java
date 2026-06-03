public class EmployeeStrings {
    public static void main(String[] args) {

        String employeeName = "BISHAL";
        String department = "Finance";
        String email = "BISHAL@company.com";

        String s1 = new String("BISHAL");
        String s2 = new String("BISHAL");

        System.out.println("Using == : " + (s1 == s2));
        System.out.println("Using .equals() : " + s1.equals(s2));
    }
}