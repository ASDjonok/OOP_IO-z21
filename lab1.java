public class Lab1 {
    public static void main(String[] args) {
        int i, j;
        double S=0;
        int a=2, n=8, b=0, m=4, C=0;
        if ((a<=n)&&(b<=m)){
            for (i=a;i<=n; i++)
            if (i==C){
                System.out.println("Отримуємо дiлення на нуль");
                return;
            }
            else{
                for(j=b; j<=m; j++)
                S += (i-j)/(i-C);
            }
            System.out.println("Результат S = " + S);  
        }
        else System.out.println("Помилка");
    }
}
