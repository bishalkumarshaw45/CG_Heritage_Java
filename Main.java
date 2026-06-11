class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void speak() {
        System.out.println("Animal sound");
    }

    final void breathe() {
        System.out.println("Breathing...");
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Dog extends Animal {
    String breed;

    Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    void speak() {
        System.out.println("Woof!");
    }

    void fetch() {
        System.out.println("Dog is fetching.");
    }
}

class Cat extends Animal {
    String color;

    Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    void speak() {
        System.out.println("Meow!");
    }

    void purr() {
        System.out.println("Cat is purring.");
    }
}

class Bird extends Animal {
    double wingspan;

    Bird(String name, int age, double wingspan) {
        super(name, age);
        this.wingspan = wingspan;
    }

    void speak() {
        System.out.println("Tweet!");
    }

    void fly() {
        System.out.println("Bird is flying.");
    }
}

public class Main {
    public static void main(String[] args) {

        Dog d = new Dog("Tommy", 3, "Labrador");
        Cat c = new Cat("Kitty", 2, "White");
        Bird b = new Bird("Tweety", 1, 1.5);

        d.display();
        d.speak();
        d.breathe();
        d.fetch();

        c.display();
        c.speak();
        c.breathe();
        c.purr();

        b.display();
        b.speak();
        b.breathe();
        b.fly();
    }
}