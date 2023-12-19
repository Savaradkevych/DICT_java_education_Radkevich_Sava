import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");
        System.out.println("The game will be available soon.");
        System.out.println("\nWelcome to Hangman! Can you guess the word and survive?");
        System.out.println("Stay tuned for the game release!");

        // Етап 3: Ускладнена версія гри - вибір випадкового слова зі списку
        playAdvancedHangman();
    }

    public static void playAdvancedHangman() {
        String[] words = {"python", "java", "javascript", "kotlin"};
        String secretWord = getRandomWord(words);

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nGuess the word: > ");
        String userGuess = scanner.nextLine().toLowerCase();

        if (userGuess.equals(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost! The correct word was: " + secretWord);
        }
    }

    private static String getRandomWord(String[] words) {
        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        return words[randomIndex];
    }
}
