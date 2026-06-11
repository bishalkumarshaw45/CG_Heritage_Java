interface Drawable {

    void draw();

    default void printInfo() {
        System.out.println("This shape is drawable.");
    }

    static void version() {
        System.out.println("Drawable Interface Version 1.0");
    }
}

interface Resizable {
    void resize(double factor);
}

abstract class Shape {
    String color;

    Shape(String color) {
        this.color = color;
    }

    abstract double area();

    abstract double perimeter();

    void displayInfo() {
        System.out.println("Color: " + color);
    }
}

class Circle extends Shape implements Drawable, Resizable {
    double radius;

    Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public double area() {
        return 3.14 * radius * radius;
    }

    public double perimeter() {
        return 2 * 3.14 * radius;
    }

    public void draw() {
        System.out.println("Drawing Circle");
    }

    public void resize(double factor) {
        radius = radius * factor;
    }
}

class Rectangle extends Shape implements Drawable, Resizable {
    double length, width;

    Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    public double area() {
        return length * width;
    }

    public double perimeter() {
        return 2 * (length + width);
    }

    public void draw() {
        System.out.println("Drawing Rectangle");
    }

    public void resize(double factor) {
        length = length * factor;
        width = width * factor;
    }
}

class Triangle extends Shape implements Drawable {
    double base, height;

    Triangle(String color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    public double area() {
        return 0.5 * base * height;
    }

    public double perimeter() {
        return base + height + Math.sqrt(base * base + height * height);
    }

    public void draw() {
        System.out.println("Drawing Triangle");
    }
}

public class ShapeHierarchy {
    public static void main(String[] args) {

        Circle c = new Circle("Red", 5);
        Rectangle r = new Rectangle("Blue", 4, 6);
        Triangle t = new Triangle("Green", 3, 4);

        // Static Interface Method
        Drawable.version();

        System.out.println("\n--- Circle ---");
        c.displayInfo();
        c.draw();
        c.printInfo();
        System.out.println("Area = " + c.area());
        System.out.println("Perimeter = " + c.perimeter());
        c.resize(2);

        System.out.println("\n--- Rectangle ---");
        r.displayInfo();
        r.draw();
        r.printInfo();
        System.out.println("Area = " + r.area());
        System.out.println("Perimeter = " + r.perimeter());
        r.resize(1.5);

        System.out.println("\n--- Triangle ---");
        t.displayInfo();
        t.draw();
        t.printInfo();
        System.out.println("Area = " + t.area());
        System.out.println("Perimeter = " + t.perimeter());

        // Polymorphic Array
        System.out.println("\n--- Polymorphism ---");
        Shape[] shapes = { c, r, t };

        for (Shape s : shapes) {
            System.out.println("Area = " + s.area());
            System.out.println("Perimeter = " + s.perimeter());
        }

        // Upcasting
        System.out.println("\n--- Upcasting ---");
        Shape s1 = new Circle("Yellow", 7);
        System.out.println("Area = " + s1.area());

        // Downcasting
        System.out.println("\n--- Downcasting ---");
        if (s1 instanceof Circle) {
            Circle c2 = (Circle) s1;
            c2.draw();
        }

        // instanceof checks
        System.out.println("\n--- instanceof ---");
        System.out.println(c instanceof Circle);
        System.out.println(r instanceof Rectangle);
        System.out.println(t instanceof Triangle);
        System.out.println(c instanceof Shape);
    }
}