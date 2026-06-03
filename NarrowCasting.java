public class NarrowCasting {
    public static void main(String[] args) {

        double salary = 75000.99;
        int salaryInt = (int) salary;

        float rating = 4.8f;
        int ratingInt = (int) rating;

        System.out.println("Original Salary = " + salary);
        System.out.println("After Cast = " + salaryInt);

        System.out.println("Original Rating = " + rating);
        System.out.println("After Cast = " + ratingInt);
    }
}