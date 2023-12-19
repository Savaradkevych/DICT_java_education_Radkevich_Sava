package TicTacToe;

public class TicTacToe {
    public static void main(String[] args) {
        // Ігрове поле
        char[][] board = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'X', 'O'}
        };

        // Друк ігрового поля
        printBoard(board);
    }

    // Метод для друку ігрового поля
    private static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
