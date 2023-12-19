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

        // Зчитування та відображення ігрового поля
        readAndPrintBoard(board);

        // Введення та обробка ходу користувача
        makeUserMove(board);

        // Аналіз стану гри після ходу користувача
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

    // Метод для введення та обробки ходу користувача
    private static void makeUserMove(char[][] board) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the coordinates: ");
            String[] coordinates = scanner.nextLine().split(" ");

            try {
                int x = Integer.parseInt(coordinates[0]) - 1;
                int y = Integer.parseInt(coordinates[1]) - 1;

                if (isValidMove(board, x, y)) {
                    board[x][y] = 'X';
                    break;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("You should enter numbers!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Оновлення ігрового поля після ходу користувача
        printBoard(board);
    }

    // Метод для перевірки чи хід користувача є допустимим
    private static boolean isValidMove(char[][] board, int x, int y) {
        return x >= 0 && x < 3 && y >= 0 && y < 3 && board[x][y] == ' ';
    }

    // Метод для аналізу стану гри та виведення результатів
    private static void analyzeGameState(char[][] board) {
        // Реалізуйте аналіз стану гри та виведення результатів, як на попередніх етапах
    }
}
