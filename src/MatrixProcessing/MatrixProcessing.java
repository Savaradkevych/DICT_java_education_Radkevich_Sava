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
                case 4:
                    transposeMatrix(scanner);
                    break;
                case 5:
                    calculateDeterminant(scanner);
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
        System.out.println("1. Add matrices");
        System.out.println("2. Multiply matrix by a constant");
        System.out.println("3. Multiply matrices");
        System.out.println("4. Transpose matrix");
        System.out.println("5. Calculate a determinant");
        System.out.println("0. Exit");
    }

    private static int[][] readMatrix(Scanner scanner) {
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

        if (matrixA[0].length == matrixB.length) {
            int[][] resultMatrix = multiplyMatrices(matrixA, matrixB);
            System.out.println("The result is:");
            printMatrix(resultMatrix);
        } else {
            System.out.println("The operation cannot be performed.");
        }
    }

    private static void transposeMatrix(Scanner scanner) {
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
        System.out.print("Your choice: > ");
        int transposeChoice = scanner.nextInt();

        System.out.println("Enter matrix size: > ");
        int[][] matrix = readMatrix(scanner);

        System.out.println("Enter matrix:");
        printMatrix(matrix);

        int[][] resultMatrix;

        switch (transposeChoice) {
            case 1:
                resultMatrix = transposeMainDiagonal(matrix);
                break;
            case 2:
                resultMatrix = transposeSideDiagonal(matrix);
                break;
            case 3:
                resultMatrix = transposeVerticalLine(matrix);
                break;
            case 4:
                resultMatrix = transposeHorizontalLine(matrix);
                break;
            default:
                System.out.println("Invalid choice for transpose.");
                return;
        }

        System.out.println("The result is:");
        printMatrix(resultMatrix);
    }

    private static void calculateDeterminant(Scanner scanner) {
        System.out.println("Enter matrix size: > ");
        int[][] matrix = readMatrix(scanner);

        System.out.println("Enter matrix:");
        printMatrix(matrix);

        if (matrix.length == matrix[0].length) {
            int determinant = calculateDeterminant(matrix);
            System.out.println("The result is: " + determinant);
        } else {
            System.out.println("The operation cannot be performed. The matrix is not square.");
        }
    }

    private static int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
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

    private static int[][] transposeMainDiagonal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] resultMatrix = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[j][i] = matrix[i][j];
            }
        }

        return resultMatrix;
    }

    private static int[][] transposeSideDiagonal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] resultMatrix = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[cols - j - 1][rows - i - 1] = matrix[i][j];
            }
        }

        return resultMatrix;
    }

    private static int[][] transposeVerticalLine(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] resultMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][cols - j - 1] = matrix[i][j];
            }
        }

        return resultMatrix;
    }

    private static int[][] transposeHorizontalLine(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] resultMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[rows - i - 1][j] = matrix[i][j];
            }
        }

        return resultMatrix;
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
            determinant += matrix[0][i] * getCofactor(matrix, 0, i);
        }

        return determinant;
    }

    private static int getCofactor(int[][] matrix, int row, int col) {
        int size = matrix.length;
        int[][] minorMatrix = new int[size - 1][size - 1];
        int minorRow = 0;
        int minorCol = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != row && j != col) {
                    minorMatrix[minorRow][minorCol++] = matrix[i][j];

                    if (minorCol == size - 1) {
                        minorRow++;
                        minorCol = 0;
                    }
                }
            }
        }

        return (row + col) % 2 == 0 ? calculateDeterminant(minorMatrix) : -calculateDeterminant(minorMatrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
