class LivingBeing {
    void grow() {
        System.out.println("Growing...");
    }

    void reproduce() {
        System.out.println("Reproducing...");
    }
}

class Animal extends LivingBeing {
    void breathe() {
        System.out.println("Breathing...");
    }

    void eat() {
        System.out.println("Animal is eating...");
    }
}

class Dog extends Animal {
    @Override
    void eat() {
        super.eat(); // Call Animal's eat()
        System.out.println("Dog is eating a bone...");
    }

    void bark() {
        System.out.println("Woof! Woof!");
    }
}

public class Main1 {
    public static void main(String[] args) {
        Dog d = new Dog();

        d.grow();
        d.reproduce();
        d.breathe();
        d.eat();
        d.bark();
    }
}