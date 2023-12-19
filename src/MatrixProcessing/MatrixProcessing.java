import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            printMenu();
            System.out.print("Your choice: > ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addMatrices(scanner);
                    break;
                case 2:
                    multiplyMatrixByConstant(scanner);
                    break;
                case 3:
                    multiplyMatrices(scanner);
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);
    }

    private static void printMenu() {
        // Функція для виведення меню
        System.out.println("1. Add matrices");
        System.out.println("2. Multiply matrix by a constant");
        System.out.println("3. Multiply matrices");
        System.out.println("0. Exit");
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

    private static void addMatrices(Scanner scanner) {
        System.out.println("Enter size of first matrix: > ");
        int[][] matrixA = readMatrix(scanner);

        System.out.println("Enter first matrix:");
        printMatrix(matrixA);

        System.out.println("Enter size of second matrix: > ");
        int[][] matrixB = readMatrix(scanner);

        System.out.println("Enter second matrix:");
        printMatrix(matrixB);

        // Перевірка можливості додавання матриць
        if (matrixA.length == matrixB.length && matrixA[0].length == matrixB[0].length) {
            int[][] resultMatrix = addMatrices(matrixA, matrixB);
            System.out.println("The result is:");
            printMatrix(resultMatrix);
        } else {
            System.out.println("The operation cannot be performed.");
        }
    }

    private static void multiplyMatrixByConstant(Scanner scanner) {
        System.out.println("Enter size of matrix: > ");
        int[][] matrix = readMatrix(scanner);

        System.out.println("Enter matrix:");
        printMatrix(matrix);

        System.out.println("Enter constant: > ");
        int constant = scanner.nextInt();

        int[][] resultMatrix = multiplyMatrixByConstant(matrix, constant);

        System.out.println("The result is:");
        printMatrix(resultMatrix);
    }

    private static void multiplyMatrices(Scanner scanner) {
        System.out.println("Enter size of first matrix: > ");
        int[][] matrixA = readMatrix(scanner);

        System.out.println("Enter first matrix:");
        printMatrix(matrixA);

        System.out.println("Enter size of second matrix: > ");
        int[][] matrixB = readMatrix(scanner);

        System.out.println("Enter second matrix:");
        printMatrix(matrixB);

        // Перевірка можливості множення матриць
        if (matrixA[0].length == matrixB.length) {
            int[][] resultMatrix = multiplyMatrices(matrixA, matrixB);
            System.out.println("The result is:");
            printMatrix(resultMatrix);
        } else {
            System.out.println("The operation cannot be performed.");
        }
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

    private static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        // Функція для множення двох матриць
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;
        int[][] resultMatrix = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    resultMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                }
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
