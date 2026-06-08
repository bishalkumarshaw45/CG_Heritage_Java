class Student {
    int rollNumber;
    String name;
    double marks;

    
    static int studentCount = 0;

    Student() {
        rollNumber = 0;
        name = "Unknown";
        marks = 0.0;
        studentCount++;
    }

    Student(int rollNumber, String name, double marks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.marks = marks;
        studentCount++;
    }

    String getGrade() {
        if (marks >= 80)
            return "A";
        else if (marks >= 60)
            return "B";
        else if (marks >= 40)
            return "C";
        else
            return "F";
    }

    // Display Method
    void display() {
        System.out.println("Roll No: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + getGrade());
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();
        Student s2 = new Student(101, "Bishal", 92.5);
        Student s3 = new Student(102, "suraj", 68.0);

        s1.display();
        s2.display();
        s3.display();

        System.out.println("Total Students: " + Student.studentCount);
    }
}