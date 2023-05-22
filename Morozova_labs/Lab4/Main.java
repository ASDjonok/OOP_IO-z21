import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Clothing[] clothingArray = {
                new Clothing("Brand A", "Shirt", "Blue", 42, 29.99),
                new Clothing("Brand B", "Jeans", "Black", 34, 59.99),
                new Clothing("Brand C", "Dress", "Red", 38, 79.99),
                new Clothing("Brand A", "Shirt", "White", 40, 39.99),
                new Clothing("Brand B", "Jeans", "Blue", 32, 49.99)
        };


        Arrays.sort(clothingArray, Comparator.comparing(Clothing::getBrand));

        System.out.println(" \"brand\":");
        for (Clothing clothing : clothingArray) {
            System.out.println(clothing);
        }


        Arrays.sort(clothingArray, Comparator.comparingDouble(Clothing::getPrice).reversed());

        System.out.println(" \"price\":");
        for (Clothing clothing : clothingArray) {
            System.out.println(clothing);
        }
    }
}