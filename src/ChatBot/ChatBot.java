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
        countToNumber();
        runProgrammingTest();
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

    // Метод для підрахунку до введеного користувачем числа
    private void countToNumber() {
        System.out.println("Now I will prove to you that I can count to any number you want!");

        // Створення об'єкту Scanner для зчитування введення користувача
        Scanner scanner = new Scanner(System.in);

        // Зчитування числа від користувача
        int userNumber = scanner.nextInt();

        // Виведення чисел від 1 до введеного користувачем числа зі знаками оклику
        for (int i = 1; i <= userNumber; i++) {
            System.out.println(i + "!");
        }
    }

    // Метод для проведення тесту з програмування
    private void runProgrammingTest() {
        System.out.println("Let's test your programming knowledge.");
        System.out.println("Why do we use methods in programming?");
        System.out.println("1. To repeat a statement multiple times.");
        System.out.println("2. To decompose a program into several small subroutines.");
        System.out.println("3. To determine the execution time of a program.");
        System.out.println("4. To interrupt the execution of a program.");

        // Створення об'єкту Scanner для зчитування введення користувача
        Scanner scanner = new Scanner(System.in);

        // Правильна відповідь
        int correctAnswer = 2;

        // Цикл для перевірки відповідей користувача
        while (true) {
            // Зчитування відповіді користувача
            int userAnswer = scanner.nextInt();

            // Перевірка відповіді
            if (userAnswer == correctAnswer) {
                System.out.println("Congratulations! That's correct.");
                break;  // Завершення циклу, якщо відповідь правильна
            } else {
                System.out.println("Sorry, that's incorrect. Please try again.");
            }
        }

        // Виведення повідомлення про завершення програми
        System.out.println("Goodbye, have a nice day!");
    }

    public static void main(String[] args) {
        // Створення екземпляру класу ChatBot з ім'ям "MyBot"
        ChatBot myBot = new ChatBot("MyBot");

        // Виведення привітання та вгадування віку та підрахунок до числа та проведення тесту
        myBot.printGreeting();
    }
}
