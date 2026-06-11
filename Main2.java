class Constants {
    // final variable: value cannot be changed
    final int MAX_SPEED = 120;

    void showSpeed() {
        System.out.println("Max Speed = " + MAX_SPEED);

        // Compile Error: Cannot assign a value to final variable
        // MAX_SPEED = 150;
    }

    // final method: cannot be overridden
    final void getSpeed() {
        System.out.println("Speed is " + MAX_SPEED);
    }
}

class Car extends Constants {

    /*
    Compile Error: Cannot override the final method

    void getSpeed() {
        System.out.println("New Speed");
    }
    */
}

// final class: cannot be inherited
final class SecurityManager {
    void secure() {
        System.out.println("System Secured");
    }
}

/*
Compile Error: Cannot inherit from final class SecurityManager

class MySecurity extends SecurityManager {
}
*/

public class Main2 {
    public static void main(String[] args) {

        Constants c = new Constants();
        c.showSpeed();
        c.getSpeed();

        SecurityManager s = new SecurityManager();
        s.secure();
    }
}