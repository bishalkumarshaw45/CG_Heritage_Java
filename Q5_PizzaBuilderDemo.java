import java.util.ArrayList;
import java.util.List;

public class Q5_PizzaBuilderDemo {
    static class Pizza {
        private final String size;
        private final String crust;
        private final List<String> toppings;
        private final boolean extraCheese;

        private Pizza(Builder builder) {
            this.size = builder.size;
            this.crust = builder.crust;
            this.toppings = builder.toppings;
            this.extraCheese = builder.extraCheese;
        }

        static class Builder {
            private String size;
            private String crust;
            private List<String> toppings = new ArrayList<>();
            private boolean extraCheese;

            Builder size(String size) {
                this.size = size;
                return this;
            }

            Builder crust(String crust) {
                this.crust = crust;
                return this;
            }

            Builder topping(String topping) {
                this.toppings.add(topping);
                return this;
            }

            Builder extraCheese(boolean extraCheese) {
                this.extraCheese = extraCheese;
                return this;
            }

            Pizza build() {
                return new Pizza(this);
            }
        }

        @Override
        public String toString() {
            return "Pizza{size='" + size + "', crust='" + crust + "', toppings=" + toppings + ", extraCheese=" + extraCheese + "}";
        }
    }

    public static void main(String[] args) {
        Pizza pizza1 = new Pizza.Builder()
                .size("Large")
                .crust("Thin")
                .topping("Cheese")
                .topping("Olives")
                .extraCheese(true)
                .build();

        Pizza pizza2 = new Pizza.Builder()
                .size("Medium")
                .crust("Thick")
                .topping("Pepperoni")
                .topping("Mushrooms")
                .extraCheese(false)
                .build();

        System.out.println("Pizza 1: " + pizza1);
        System.out.println("Pizza 2: " + pizza2);
    }
}
