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
}
