import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");
        System.out.println("The game will be available soon.");
        System.out.println("\nWelcome to Hangman! Can you guess the word and survive?");
        System.out.println("Stay tuned for the game release!");

        // Етап 2: Спрощена версія гри
        playSimplifiedHangman();
    }

    public static void playSimplifiedHangman() {
        String secretWord = "java"; // Задане слово для вгадування
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nGuess the word: > ");
        String userGuess = scanner.nextLine().toLowerCase();

        if (userGuess.equals(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}
