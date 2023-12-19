import java.util.Scanner;

public class CoffeeMachine {
    private static final int WATER_PER_CUP = 200;
    private static final int MILK_PER_CUP = 50;
    private static final int COFFEE_BEANS_PER_CUP = 15;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        makeCoffee();
        calculateIngredients();
        checkIngredients();
        scanner.close();
    }

    public static void makeCoffee() {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }

    public static void calculateIngredients() {
        System.out.println("\nWrite how many cups of coffee you will need:");
        int cups = scanner.nextInt();

        int water = cups * WATER_PER_CUP;
        int milk = cups * MILK_PER_CUP;
        int coffeeBeans = cups * COFFEE_BEANS_PER_CUP;

        System.out.println("For " + cups + " cups of coffee you will need:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
    }

    public static void checkIngredients() {
        System.out.println("\nWrite how many ml of water the coffee machine has:");
        int availableWater = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int availableMilk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int availableCoffeeBeans = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int cupsNeeded = scanner.nextInt();

        int maxCupsWater = availableWater / WATER_PER_CUP;
        int maxCupsMilk = availableMilk / MILK_PER_CUP;
        int maxCupsCoffeeBeans = availableCoffeeBeans / COFFEE_BEANS_PER_CUP;

        int maxCupsPossible = Math.min(maxCupsWater, Math.min(maxCupsMilk, maxCupsCoffeeBeans));

        if (maxCupsPossible >= cupsNeeded) {
            if (maxCupsPossible > cupsNeeded) {
                System.out.println("Yes, I can make that amount of coffee (and even " + (maxCupsPossible - cupsNeeded) + " more than that)");
            } else {
                System.out.println("Yes, I can make that amount of coffee");
            }
        } else {
            System.out.println("No, I can make only " + maxCupsPossible + " cups of coffee");
        }
    }
}

