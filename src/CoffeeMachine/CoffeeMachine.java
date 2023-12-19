import java.util.Scanner;

public class CoffeeMachine {
    private static final int WATER_PER_CUP_ESPRESSO = 250;
    private static final int COFFEE_BEANS_PER_CUP_ESPRESSO = 16;
    private static final int COST_ESPRESSO = 4;

    private static final int WATER_PER_CUP_LATTE = 350;
    private static final int MILK_PER_CUP_LATTE = 75;
    private static final int COFFEE_BEANS_PER_CUP_LATTE = 20;
    private static final int COST_LATTE = 7;

    private static final int WATER_PER_CUP_CAPPUCINO = 200;
    private static final int MILK_PER_CUP_CAPPUCINO = 100;
    private static final int COFFEE_BEANS_PER_CUP_CAPPUCINO = 12;
    private static final int COST_CAPPUCINO = 6;

    private static final int WATER_LIMIT = 400;
    private static final int MILK_LIMIT = 540;
    private static final int COFFEE_BEANS_LIMIT = 120;
    private static final int CUPS_LIMIT = 9;

    private static int water = 400;
    private static int milk = 540;
    private static int coffeeBeans = 120;
    private static int disposableCups = 9;
    private static int money = 550;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runCoffeeMachine();
        scanner.close();
    }

    public static void runCoffeeMachine() {
        while (true) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            String action = scanner.next();

            switch (action) {
                case "buy":
                    buyCoffee();
                    break;
                case "fill":
                    fillMachine();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    printStatus();
                    break;
                case "exit":
                    System.out.println("Exiting coffee machine. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid action. Please choose buy, fill, take, remaining, or exit.");
                    break;
            }
        }
    }

    public static void printStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public static void buyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back – to main menu:");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                makeCoffee(WATER_PER_CUP_ESPRESSO, 0, COFFEE_BEANS_PER_CUP_ESPRESSO, COST_ESPRESSO);
                break;
            case 2:
                makeCoffee(WATER_PER_CUP_LATTE, MILK_PER_CUP_LATTE, COFFEE_BEANS_PER_CUP_LATTE, COST_LATTE);
                break;
            case 3:
                makeCoffee(WATER_PER_CUP_CAPPUCINO, MILK_PER_CUP_CAPPUCINO, COFFEE_BEANS_PER_CUP_CAPPUCINO, COST_CAPPUCINO);
                break;
            case 4:
                // back to main menu
                break;
            default:
                System.out.println("Invalid choice. Please choose 1, 2, 3, or 4.");
                break;
        }
    }

    public static void makeCoffee(int waterNeeded, int milkNeeded, int coffeeBeansNeeded, int cost) {
        if (water >= waterNeeded && milk >= milkNeeded && coffeeBeans >= coffeeBeansNeeded && disposableCups >= 1) {
            System.out.println("I have enough resources to make coffee. Here's your coffee!");
            water -= waterNeeded;
            milk -= milkNeeded;
            coffeeBeans -= coffeeBeansNeeded;
            disposableCups--;
            money += cost;
        } else {
            System.out.println("Sorry, not enough resources to make coffee.");
        }

        printStatus();
    }

    public static void fillMachine() {
        System.out.println("Write how many ml of water you want to add:");
        int addedWater = scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        int addedMilk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        int addedCoffeeBeans = scanner.nextInt();

        System.out.println("Write how many disposable cups of coffee you want to add:");
        int addedCups = scanner.nextInt();

        water += addedWater;
        milk += addedMilk;
        coffeeBeans += addedCoffeeBeans;
        disposableCups += addedCups;

        printStatus();
    }

    public static void takeMoney() {
        System.out.println("I gave you " + money);
        money = 0;

        printStatus();
    }
}
