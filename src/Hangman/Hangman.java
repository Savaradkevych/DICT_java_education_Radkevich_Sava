import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");
        System.out.println("The game will be available soon.");
        System.out.println("\nWelcome to Hangman! Can you guess the word and survive?");
        System.out.println("Stay tuned for the game release!");

        // Етап 6: Гра з вгадуванням літер та обмеженням кількості помилок
        playHangmanWithLimitedMistakes();
    }

    public static void playHangmanWithLimitedMistakes() {
        String[] words = {"python", "java", "javascript", "kotlin"};
        String secretWord = getRandomWord(words);
        char[] guessedWordArray = new char[secretWord.length()];
        for (int i = 0; i < guessedWordArray.length; i++) {
            guessedWordArray[i] = '-';
        }

        int remainingAttempts = 8;
        Scanner scanner = new Scanner(System.in);

        while (remainingAttempts > 0) {
            printGuessedWord(guessedWordArray);
            System.out.print("Input a letter: > ");
            char userGuess = scanner.next().toLowerCase().charAt(0);

            if (!containsLetter(secretWord, userGuess)) {
                remainingAttempts--;
                System.out.println("That letter doesn't appear in the word");
            } else if (containsLetter(guessedWordArray, userGuess)) {
                remainingAttempts--;
                System.out.println("No improvements");
            } else {
                updateGuessedWord(secretWord, guessedWordArray, userGuess);
                printGuessedWord(guessedWordArray);
                if (!containsDash(guessedWordArray)) {
                    System.out.println("Congratulations! You guessed the word!");
                    System.out.println("You survived!");
                    return;
                }
            }

            System.out.println("Attempts left: " + remainingAttempts);
        }

        System.out.println("Thanks for playing!");
        System.out.println("You lost! The correct word was: " + secretWord);
    }

    private static String getRandomWord(String[] words) {
        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        return words[randomIndex];
    }

    private static boolean containsLetter(String word, char letter) {
        return word.indexOf(letter) != -1;
    }

    private static boolean containsLetter(char[] guessedWordArray, char letter) {
        for (char c : guessedWordArray) {
            if (c == letter) {
                return true;
            }
        }
        return false;
    }

    private static void updateGuessedWord(String word, char[] guessedWordArray, char letter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                guessedWordArray[i] = letter;
            }
        }
    }

    private static void printGuessedWord(char[] guessedWordArray) {
        for (char c : guessedWordArray) {
            System.out.print(c);
        }
        System.out.println();
    }

    private static boolean containsDash(char[] guessedWordArray) {
        for (char c : guessedWordArray) {
            if (c == '-') {
                return true;
            }
        }
        return false;
    }
}
