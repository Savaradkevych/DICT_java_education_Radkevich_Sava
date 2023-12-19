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

    public static void main(String[] args) {
        // Створення екземпляру класу ChatBot з ім'ям "MyBot"
        ChatBot myBot = new ChatBot("MyBot");

        // Виведення привітання
        myBot.printGreeting();
    }
}
