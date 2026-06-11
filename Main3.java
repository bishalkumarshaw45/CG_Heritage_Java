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
}

class Dog extends Animal {
    String breed;

    Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    void speak() {
        System.out.println(name + ": Woof!");
    }
}

class Cat extends Animal {
    String color;

    Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    @Override
    void speak() {
        System.out.println(name + ": Meow!");
    }
}

class Bird extends Animal {
    double wingspan;

    Bird(String name, int age, double wingspan) {
        super(name, age);
        this.wingspan = wingspan;
    }

    @Override
    void speak() {
        System.out.println(name + ": Tweet!");
    }
}

public class Main3 {
    public static void main(String[] args) {

        Animal[] animals = new Animal[5];

        animals[0] = new Dog("Bruno", 3, "Labrador");
        animals[1] = new Cat("Whiskers", 2, "White");
        animals[2] = new Bird("Tweety", 1, 30.5);
        animals[3] = new Dog("Rocky", 4, "German Shepherd");
        animals[4] = new Cat("Kitty", 1, "Black");

        for (Animal a : animals) {
            a.speak();
        }
    }
}