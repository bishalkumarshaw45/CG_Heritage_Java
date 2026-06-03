public class EmployeeValidation {

    public static void validate(String code) {

        boolean valid =
                code.startsWith("EMP") &&
                code.contains("FIN") &&
                code.endsWith("20224");

        System.out.println("Code : " + code);
        System.out.println("Valid : " + valid);
    }

    public static void main(String[] args) {
        validate("EMP-FIN-20224");
    }
}