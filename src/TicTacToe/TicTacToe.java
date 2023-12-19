package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        // Ігрове поле
        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        // Зчитування рядка від користувача та відображення ігрового поля
        readAndPrintBoard(board);

        // Аналіз стану гри
        analyzeGameState(board);
    }

    // Метод для зчитування та відображення ігрового поля
    private static void readAndPrintBoard(char[][] board) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String input = scanner.nextLine();

        // Перетворення введеного рядка у гру "Хрестики-нулики"
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = input.charAt(index++);
            }
        }

        // Виведення ігрового поля
        printBoard(board);
    }

    // Метод для друку ігрового поля
    private static void printBoard(char[][] board) {
        System.out.println("---------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }

        System.out.println("---------");
    }

    // Метод для аналізу стану гри та виведення результатів
    private static void analyzeGameState(char[][] board) {
        // Аналіз стану гри
        boolean xWins = checkWins(board, 'X');
        boolean oWins = checkWins(board, 'O');
        boolean impossible = isImpossible(board);
        boolean gameNotFinished = isGameNotFinished(board);
        boolean draw = !xWins && !oWins && !gameNotFinished && !impossible;

        // Виведення результатів
        if (impossible) {
            System.out.println("Impossible");
        } else if (xWins) {
            System.out.println("X wins");
        } else if (oWins) {
            System.out.println("O wins");
        } else if (draw) {
            System.out.println("Draw");
        } else if (gameNotFinished) {
            System.out.println("Game not finished");
        }
    }

    // Метод для перевірки перемоги гравця
    private static boolean checkWins(char[][] board, char symbol) {
        // Перевірка для рядків, стовпців та діагоналей
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                    (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
                return true;
            }
        }
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    // Метод для перевірки неможливої ситуації
    private static boolean isImpossible(char[][] board) {
        int countX = countSymbol(board, 'X');
        int countO = countSymbol(board, 'O');
        int countEmpty = countSymbol(board, ' ');

        return Math.abs(countX - countO) >= 2 || (countX > countO && checkWins(board, 'O')) || (countO > countX && checkWins(board, 'X'));
    }

    // Метод для перевірки незакінченої гри
    private static boolean isGameNotFinished(char[][] board) {
        return !checkWins(board, 'X') && !checkWins(board, 'O') && countSymbol(board, ' ') > 0;
    }

    // Метод для підрахунку кількості символів на ігровому полі
    private static int countSymbol(char[][] board, char symbol) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == symbol) {
                    count++;
                }
            }
        }
        return count;
    }
}
