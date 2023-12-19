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

        // Виведення порожнього ігрового поля
        printBoard(board);

        // Гравчик 1 використовує хрестики "X", а гравчик 2 - нулики "O"
        char currentPlayer = 'X';

        // Головний ігровий цикл
        while (true) {
            // Введення та обробка ходу гравця
            makeMove(board, currentPlayer);

            // Виведення ігрового поля після ходу гравця
            printBoard(board);

            // Перевірка стану гри
            if (isGameFinished(board)) {
                break;
            }

            // Зміна поточного гравця
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    // Метод для введення та обробки ходу гравця
    private static void makeMove(char[][] board, char currentPlayer) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the coordinates: ");
            String[] coordinates = scanner.nextLine().split(" ");

            try {
                int x = Integer.parseInt(coordinates[0]) - 1;
                int y = Integer.parseInt(coordinates[1]) - 1;

                if (isValidMove(board, x, y)) {
                    board[x][y] = currentPlayer;
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
    }

    // Метод для виведення ігрового поля
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

    // Метод для перевірки чи хід гравця є допустимим
    private static boolean isValidMove(char[][] board, int x, int y) {
        return x >= 0 && x < 3 && y >= 0 && y < 3 && board[x][y] == ' ';
    }

    // Метод для перевірки чи гра завершилась
    private static boolean isGameFinished(char[][] board) {
        if (checkWins(board, 'X')) {
            System.out.println("X wins");
            return true;
        } else if (checkWins(board, 'O')) {
            System.out.println("O wins");
            return true;
        } else if (isBoardFull(board)) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }

    // Метод для перевірки чи хтось виграв
    private static boolean checkWins(char[][] board, char symbol) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                    (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
                return true;
            }
        }
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    // Метод для перевірки чи ігрове поле повне
    private static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
