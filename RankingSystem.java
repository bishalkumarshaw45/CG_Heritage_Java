import java.util.*;

class Employee {
    int id;
    String name;
    int score;

    Employee(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
}

public class RankingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of N: ");
        int N = sc.nextInt();

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < N; i++) {

            System.out.print("Enter Employee"+i+" Id: ");
            int id = sc.nextInt();
            System.out.print("Enter Employee"+i+" name: ");
            String name = sc.next();
            System.out.print("Enter Employee"+i+" score: ");
            int score = sc.nextInt();

            employees.add(new Employee(id, name, score));
            System.out.println();
        }

        double total = 0;
        for (Employee e : employees) {
            total += e.score;
        }
        double average = total / N;

        Employee highest = employees.get(0);
        Employee lowest = employees.get(0);

        for (Employee e : employees) {
            if (e.score > highest.score) {
                highest = e;
            }
            if (e.score < lowest.score) {
                lowest = e;
            }
        }

        System.out.printf("Average Score: %.2f\n", average);
        System.out.println("Highest Scorer: " + highest.name + " " + highest.score);
        System.out.println("Lowest Scorer: " + lowest.name + " " + lowest.score);

        List<Employee> qualified = new ArrayList<>();

        for (Employee e : employees) {
            if (e.score >= average) {
                qualified.add(e);
            }
        }

        Collections.sort(qualified, (e1, e2) -> {

            if (e2.score != e1.score) {
                return e2.score - e1.score;
            } else {
                return e1.name.compareTo(e2.name);
            }
        });

        System.out.println("Qualified Employees:");
        for (Employee e : qualified) {
            System.out.println(e.name + " " + e.score);
        }
    }
}
