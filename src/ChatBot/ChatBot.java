import java.time.Year;
import java.util.Scanner;

public class ChatBot {
    private String botName;
    private int birthYear;

    // Конструктор класу
    public ChatBot(String name) {
        botName = name;
        birthYear = Year.now().getValue();
    }

    // Метод для виведення привітання
    public void printGreeting() {
        System.out.println("Hello! My name is " + botName + ".");
        System.out.println("I was created in " + birthYear + ".");
        askForName();
        guessAge();
    }

    // Метод для запитання імені користувача
    private void askForName() {
        System.out.println("Please, remind me your name.");

        // Створення об'єкту Scanner для зчитування введення користувача
        Scanner scanner = new Scanner(System.in);

        // Зчитування імені користувача зі стандартного введення
        String userName = scanner.nextLine();

        // Виведення вітання з ім'ям користувача
        System.out.println("What a great name you have, " + userName + "!");
    }

    // Метод для вгадування віку
    private void guessAge() {
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5, and 7.");

        // Створення об'єкту Scanner для зчитування введення користувача
        Scanner scanner = new Scanner(System.in);

        // Зчитування залишків від ділення на 3, 5 і 7
        int remainder3 = scanner.nextInt();
        int remainder5 = scanner.nextInt();
        int remainder7 = scanner.nextInt();

        // Визначення віку за формулою
        int userAge = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;

        // Виведення віку користувача
        System.out.println("Your age is " + userAge + "; that's a good time to start programming!");
    }

    public static void main(String[] args) {
        // Створення екземпляру класу ChatBot з ім'ям "MyBot"
        ChatBot myBot = new ChatBot("MyBot");

        // Виведення привітання та вгадування віку
        myBot.printGreeting();
    }
}
