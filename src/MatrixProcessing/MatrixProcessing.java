import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть матрицю A:");
        int[][] matrixA = readMatrix(scanner);

        System.out.println("Введіть матрицю B:");
        int[][] matrixB = readMatrix(scanner);

        // Перевірка можливості додавання матриць
        if (canAddMatrices(matrixA, matrixB)) {
            int[][] resultMatrix = addMatrices(matrixA, matrixB);
            System.out.println("Результат додавання матриць:");
            printMatrix(resultMatrix);
        } else {
            System.out.println("ERROR: Неможливо додати матриці, оскільки вони мають різні розміри.");
        }
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

    private static boolean canAddMatrices(int[][] matrixA, int[][] matrixB) {
        // Перевірка можливості додавання матриць
        return matrixA.length == matrixB.length && matrixA[0].length == matrixB[0].length;
    }

    private static int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
        // Функція для додавання двох матриць
        int rows = matrixA.length;
        int cols = matrixA[0].length;
        int[][] resultMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
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
