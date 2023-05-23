import java.util.Random;
public class Lab2 {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;

        short[][] A = new short[m][n];
        short[][] B = new short[m][n];

        for (int k = 0; k < A.length; k++){
            for (int d = 0; d < A[k].length; d++){
                A[k][d] = (short) randomNumbers();
            }
        }

        for (int k = 0; k < B.length; k++){
            for (int d = 0; d < B[k].length; d++){
                B[k][d] = (short) randomNumbers();
            }
        }

        System.out.println("Матриця A:");
        printMatrix(A);

        System.out.println("Матриця B:");
        printMatrix(B);

        short[][] C = multiplyMatrices(A, B);
        System.out.println("Результат множення матриць C = A x B:");
        printMatrix(C);

        double[] rowAverages = calculationRowAverages(C);
        System.out.println("Середнє значення елементiв кожного рядка матрицi C:");
        printRowAverages(rowAverages);
    }

    public static int randomNumbers() {
        Random p = new Random();
        return p.nextInt(25);}
    public static short[][] multiplyMatrices(short[][] A, short[][] B){
        int rowsA = A.length;
        int columnA = A[0].length;
        int columnB = B[0].length;

        short[][] C = new short[rowsA][columnB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < columnB; j++) {
                int sum = 0;
                for (int k = 0; k < columnA; k++) {
                    sum += A[i][k] * B[k][j];
                }
                C[i][j] = (short) sum;
            }
        }

        return C;
    }
    public static void printMatrix(short[][] matrix) {
        for (short[] row : matrix) {
            for (short element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    public static double[] calculationRowAverages(short[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        double[] rowAverages = new double[rows];

        for (int i = 0; i < rows; i++) {
            int sum = 0;
            for (int j = 0; j < cols; j++) {
                sum += matrix[i][j];
            }
            rowAverages[i] = (double) sum / cols;
        }

        return rowAverages;
    }

    public static void printRowAverages(double[] rowAverages) {
        for (double average : rowAverages) {
            System.out.println(average);
        }
    }
}
