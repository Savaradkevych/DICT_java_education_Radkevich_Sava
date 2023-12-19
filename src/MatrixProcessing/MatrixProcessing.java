import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть матрицю:");
        int[][] matrix = readMatrix(scanner);

        System.out.println("Введіть константу:");
        int constant = scanner.nextInt();

        int[][] resultMatrix = multiplyMatrixByConstant(matrix, constant);

        System.out.println("Результат множення матриці на константу:");
        printMatrix(resultMatrix);
    }

    private static int[][] readMatrix(Scanner scanner) {
        // Функція для зчитування матриці
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static int[][] multiplyMatrixByConstant(int[][] matrix, int constant) {
        // Функція для множення матриці на константу
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] resultMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = matrix[i][j] * constant;
            }
        }

        return resultMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        // Функція для виведення матриці
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
