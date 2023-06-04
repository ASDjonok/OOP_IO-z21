public class Main
{
    public static void main(String[] args) {
        try {
            // Вхідна матриця B
            float[][] matrixB = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };
            System.out.println("Початкова матриця B:");
            printMatrix(matrixB);

            // Транспонуємо матрицю B
            float[][] matrixC = transposeMatrix(matrixB);
            
            // Виводимо результат транспонування
            System.out.println("Результат транспонування матриці B:");
            printMatrix(matrixC);

            // Виводимо результати обчислень
            System.out.println("Сума найбільших елементів у рядках з непарними номерами та найменших елементів у рядках з парними номерами: " + sumMaxAndMinElements(matrixC));
        } catch (Exception e) {
            System.out.println("Сталася помилка: " + e.getMessage());
        }
        
    }
    
    // Метод для транспонування матриці
    private static float[][] transposeMatrix(float[][] matrixB) {
        if (matrixB == null)
        {
            return new float[0][0];
        }
        
        int rows = matrixB.length;
        int cols = matrixB[0].length;
        
        float[][] matrixC = new float[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixC[j][i] = matrixB[i][j];
            }
        }

        return matrixC;
    }
    
    // Метод для обчислення суми найбільших елементів у рядках з непарними номерами
    // та найменших елементів в рядках матриці з парними номерами
    private static float sumMaxAndMinElements(float[][] matrixС) {
        if (matrixС == null)
        {
            return 0f;
        }
        
        float sum = 0;
        int rows = matrixС.length;

        for (int i = 0; i < rows; i++) {
            // мінімальне або максимальне значення
            float checkValue = matrixС[i][0];
            // ознака парності рядка
            boolean isEvenRow = i % 2 == 1; 
            for (int j = 1; j < matrixС[i].length; j++) {
                // якщо рядок непарний шукаємо максимальний елемент
                // якщо рядок парний, то шукаємо найменший елемент
                if ((!isEvenRow && matrixС[i][j] > checkValue) || (isEvenRow && matrixС[i][j] < checkValue)) {
                    checkValue = matrixС[i][j];
                }
            }
            
            sum += checkValue;
        }

        return sum;
    }
    
    // Метод для виведення матриці на екран
    private static void printMatrix(float[][] matrix) {
        if (matrix == null)
        {
            return;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
