import java.time.Year;

public class ChatBot {
    // Ім'я бота
    private String botName;

    // Рік створення бота
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
    }

    public static void main(String[] args) {
        // Створення екземпляру класу ChatBot з ім'ям "MyBot"
        ChatBot myBot = new ChatBot("MyBot");

        // Виведення привітання
        myBot.printGreeting();
    }
}
