public class Main
{
    // Метод обчислення значення ф-ції
    // a - нижня межа зовнішньої суми
    // n - верхня межа зовнішньої суми
    // b - нижня межа внутрішньї суми
    // m - верхня межа внутрішньї суми
    public static double calculateSum(double a, double n, double b, double m) {
        if (n < a || m < b || b == 0.)
        {
            return 0.0;
        }
        
        double sum = 0.0;
        for (double i = a; i <= n; i++) {
            for (double j = b; j <= m; j++) {
                if(j == 0.)
                {
                    System.out.println("Ділення на нуль неможливе.");
                    return 0.0;
                }
                sum += 1. / j;
            }
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        // Приклад 1 використання, задаємо діапазон значень
        double a = 1.;
        double n = 3.;
        double b = 2.;
        double m = 5.;
        
        // викликаємо метод, щоб обчислити значення ф-ції
        double result = calculateSum(a, n, b, m);
        System.out.println("Результат 1: " + result);
        
        
        // Приклад 2 використання, задаємо діапазон значень
        b = -2.;
        m = 5.;
        
        // викликаємо метод, щоб обчислити значення ф-ції
        result = calculateSum(a, n, b, m);
        System.out.println("Результат 2: " + result);
    }
}
