import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");
        System.out.println("The game will be available soon.");
        System.out.println("\nWelcome to Hangman! Can you guess the word and survive?");
        System.out.println("Stay tuned for the game release!");

        // Етап 7: Гра з вгадуванням літер, обмеженням кількості помилок і валідацією вводу
        playHangmanWithValidation();
    }

    public static void playHangmanWithValidation() {
        String[] words = {"python", "java", "javascript", "kotlin"};
        String secretWord = getRandomWord(words);
        char[] guessedWordArray = new char[secretWord.length()];
        for (int i = 0; i < guessedWordArray.length; i++) {
            guessedWordArray[i] = '-';
        }

        int remainingAttempts = 8;
        Set<Character> guessedLetters = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        while (remainingAttempts > 0) {
            printGuessedWord(guessedWordArray);
            System.out.print("Input a letter: > ");
            String userInput = scanner.next().toLowerCase();

            if (userInput.length() != 1) {
                System.out.println("You should input a single letter");
                continue;
            }

            char userGuess = userInput.charAt(0);

            if (!Character.isLowerCase(userGuess)) {
                System.out.println("Please enter a lowercase English letter");
                continue;
            }

            if (guessedLetters.contains(userGuess)) {
                System.out.println("You've already guessed this letter");
                continue;
            }

            guessedLetters.add(userGuess);

            if (!containsLetter(secretWord, userGuess)) {
                remainingAttempts--;
                System.out.println("That letter doesn't appear in the word");
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
