import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");
        System.out.println("The game will be available soon.");
        System.out.println("\nWelcome to Hangman! Can you guess the word and survive?");
        System.out.println("Stay tuned for the game release!");

        // Етап 4: Додана підказка
        playHintHangman();
    }

    public static void playHintHangman() {
        String[] words = {"python", "java", "javascript", "kotlin"};
        String secretWord = getRandomWord(words);
        String guessedWord = getHint(secretWord);

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nGuess the word " + guessedWord + ": > ");
        String userGuess = scanner.nextLine().toLowerCase();

        if (userGuess.equals(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost! The correct word was: " + secretWord);
        }
    }

    private static String getHint(String word) {
        StringBuilder hint = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (i < 2) {
                hint.append(word.charAt(i));
            } else {
                hint.append("-");
            }
        }
        return hint.toString();
    }

    private static String getRandomWord(String[] words) {
        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        return words[randomIndex];
    }
}
