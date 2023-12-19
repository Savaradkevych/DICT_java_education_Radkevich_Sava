import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;

    public CoffeeMachine(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
        this.money = money;
    }

    public void processUserInput(String action) {
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
                System.exit(0);
            default:
                System.out.println("Invalid action. Please try again.");
        }
    }

    private void buyCoffee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String coffeeType = scanner.next();
        switch (coffeeType) {
            case "1":
                makeCoffee(250, 0, 16, 4);
                break;
            case "2":
                makeCoffee(350, 75, 20, 7);
                break;
            case "3":
                makeCoffee(200, 100, 12, 6);
                break;
            case "back":
                break;
            default:
                System.out.println("Invalid coffee type. Please try again.");
        }
    }

    private void makeCoffee(int waterNeeded, int milkNeeded, int coffeeBeansNeeded, int cost) {
        if (water >= waterNeeded && milk >= milkNeeded && coffeeBeans >= coffeeBeansNeeded && disposableCups > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= waterNeeded;
            milk -= milkNeeded;
            coffeeBeans -= coffeeBeansNeeded;
            disposableCups--;
            money += cost;
        } else {
            System.out.println("Sorry, not enough resources to make coffee!");
        }
    }

    private void fillMachine() {
        Scanner scanner = new Scanner(System.in);
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
    }

    private void takeMoney() {
        System.out.println("I gave you " + money);
        money = 0;
    }

    private void printStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            coffeeMachine.processUserInput(action);
        }
    }
}
