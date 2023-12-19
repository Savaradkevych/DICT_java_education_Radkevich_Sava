import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix by a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Transpose matrix");
            System.out.println("5. Calculate a determinant");
            System.out.println("6. Inverse matrix");
            System.out.println("0. Exit");
            System.out.print("Your choice: > ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addMatricesOperation(scanner);
                    break;
                case 2:
                    multiplyMatrixByConstantOperation(scanner);
                    break;
                case 3:
                    multiplyMatricesOperation(scanner);
                    break;
                case 4:
                    transposeMatrixOperation(scanner);
                    break;
                case 5:
                    calculateDeterminantOperation(scanner);
                    break;
                case 6:
                    inverseMatrixOperation(scanner);
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addMatricesOperation(Scanner scanner) {
        System.out.print("Enter size of first matrix: > ");
        int rowsA = scanner.nextInt();
        int colsA = scanner.nextInt();
        int[][] matrixA = readMatrix(scanner, rowsA, colsA);

        System.out.print("Enter size of second matrix: > ");
        int rowsB = scanner.nextInt();
        int colsB = scanner.nextInt();
        int[][] matrixB = readMatrix(scanner, rowsB, colsB);

        if (rowsA == rowsB && colsA == colsB) {
            int[][] result = addMatrices(matrixA, matrixB);
            System.out.println("The result is:");
            printMatrix(result);
        } else {
            System.out.println("ERROR: Matrices must have the same size for addition.");
        }
    }

    private static int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
        int rows = matrixA.length;
        int cols = matrixA[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        return result;
    }

    private static void multiplyMatrixByConstantOperation(Scanner scanner) {
        System.out.print("Enter size of matrix: > ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, rows, cols);

        System.out.print("Enter constant: > ");
        int constant = scanner.nextInt();

        int[][] result = multiplyMatrixByConstant(matrix, constant);
        System.out.println("The result is:");
        printMatrix(result);
    }

    private static int[][] multiplyMatrixByConstant(int[][] matrix, int constant) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] * constant;
            }
        }

        return result;
    }

    private static void multiplyMatricesOperation(Scanner scanner) {
        System.out.print("Enter size of first matrix: > ");
        int rowsA = scanner.nextInt();
        int colsA = scanner.nextInt();
        int[][] matrixA = readMatrix(scanner, rowsA, colsA);

        System.out.print("Enter size of second matrix: > ");
        int rowsB = scanner.nextInt();
        int colsB = scanner.nextInt();
        int[][] matrixB = readMatrix(scanner, rowsB, colsB);

        if (colsA == rowsB) {
            int[][] result = multiplyMatrices(matrixA, matrixB);
            System.out.println("The result is:");
            printMatrix(result);
        } else {
            System.out.println("ERROR: The number of columns in the first matrix must be equal to the number of rows in the second matrix.");
        }
    }

    private static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;
        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return result;
    }

    private static void transposeMatrixOperation(Scanner scanner) {
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
        System.out.print("Your choice: > ");
        int transposeType = scanner.nextInt();

        System.out.print("Enter matrix size: > ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        System.out.println("Enter matrix:");
        int[][] matrix = readMatrix(scanner, rows, cols);

        int[][] result = transposeMatrix(matrix, transposeType);

        System.out.println("The result is:");
        printMatrix(result);
    }

    private static int[][] transposeMatrix(int[][] matrix, int transposeType) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];

        switch (transposeType) {
            case 1: // Main diagonal
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        result[i][j] = matrix[j][i];
                    }
                }
                break;
            case 2: // Side diagonal
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        result[i][j] = matrix[cols - j - 1][rows - i - 1];
                    }
                }
                break;
            case 3: // Vertical line
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        result[i][j] = matrix[i][cols - j - 1];
                    }
                }
                break;
            case 4: // Horizontal line
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        result[i][j] = matrix[rows - i - 1][j];
                    }
                }
                break;
        }

        return result;
    }

    private static void calculateDeterminantOperation(Scanner scanner) {
        System.out.print("Enter matrix size: > ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        System.out.println("Enter matrix:");
        int[][] matrix = readMatrix(scanner, rows, cols);

        if (rows == cols) {
            int determinant = calculateDeterminant(matrix);
            System.out.println("The result is: " + determinant);
        } else {
            System.out.println("ERROR: Determinant can only be calculated for a square matrix.");
        }
    }

    private static int calculateDeterminant(int[][] matrix) {
        int size = matrix.length;

        if (size == 1) {
            return matrix[0][0];
        }

        if (size == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        int determinant = 0;
        for (int i = 0; i < size; i++) {
            determinant += matrix[0][i] * cofactor(matrix, 0, i);
        }

        return determinant;
    }

    private static int cofactor(int[][] matrix, int row, int col) {
        return (int) Math.pow(-1, row + col) * calculateDeterminant(minor(matrix, row, col));
    }

    private static int[][] minor(int[][] matrix, int row, int col) {
        int size = matrix.length - 1;
        int[][] minorMatrix = new int[size][size];

        int m = 0, n;
        for (int i = 0; i <= size; i++) {
            n = 0;
            for (int j = 0; j <= size; j++) {
                if (i != row && j != col) {
                    minorMatrix[m][n] = matrix[i][j];
                    n++;
                }
            }
            if (i != row) {
                m++;
            }
        }

        return minorMatrix;
    }

    private static void inverseMatrixOperation(Scanner scanner) {
        System.out.print("Enter matrix size: > ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        System.out.println("Enter matrix:");
        int[][] matrix = readMatrix(scanner, rows, cols);

        if (rows == cols) {
            double[][] inverseMatrix = inverseMatrix(matrix);
            if (inverseMatrix != null) {
                System.out.println("The result is:");
                printMatrix(inverseMatrix);
            } else {
                System.out.println("This matrix doesn't have an inverse.");
            }
        } else {
            System.out.println("ERROR: Inverse matrix can only be calculated for a square matrix.");
        }
    }

    private static double[][] inverseMatrix(int[][] matrix) {
        int size = matrix.length;

        if (calculateDeterminant(matrix) == 0) {
            return null; // Matrix doesn't have an inverse
        }

        double[][] inverseMatrix = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                inverseMatrix[i][j] = cofactor(matrix, i, j);
            }
        }

        double determinant = calculateDeterminant(matrix);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                inverseMatrix[i][j] /= determinant;
            }
        }

        return inverseMatrix;
    }

    private static int[][] readMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static void printMatrix(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}