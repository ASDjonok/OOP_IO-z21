//С(11)= 8 -  Визначити клас меблі, який складається як мінімум з 5-и полів. \
import java.util.Arrays;
import java.util.Comparator;


class Furniture {
    private String name;
    private int height;
    private int width;
    private int length;
    private double price;

    public Furniture(String name, int height, int width, int length, double price) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.length = length;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Меблi{" +
                "назва='" + name + '\'' +
                ", висота=" + height +
                ", ширина=" + width +
                ", довжина=" + length +
                ", цiна=" + price +
                '}';
    }
}

public class Lab4 {

    public static void main(String[] args) {

        Furniture[] furnitureArray = createFurnitureArray();

        sortArrayByWidth(furnitureArray);

        System.out.println("Масив меблiв, вiдсортований за зростанням ширини:");
        printArray(furnitureArray);

        sortArrayByPrice(furnitureArray);

        System.out.println("Масив меблiв, вiдсортований за спаданням цiни:");
        printArray(furnitureArray);
    }

    private static Furniture[] createFurnitureArray() {
        Furniture[] furnitureArray = new Furniture[5];
        furnitureArray[0] = new Furniture("Стiлець", 60, 50, 50, 700);
        furnitureArray[1] = new Furniture("Стiл", 100, 160, 80, 2000);
        furnitureArray[2] = new Furniture("Лiжко", 100, 200, 220, 5000);
        furnitureArray[3] = new Furniture("Шафа", 200, 100, 75, 3000);
        furnitureArray[4] = new Furniture("Диван", 90, 180, 140, 9000);
        return furnitureArray;
    }

    private static void sortArrayByWidth(Furniture[] furnitureArray) {
        Arrays.sort(furnitureArray, Comparator.comparingInt(Furniture::getWidth));
    }

    private static void sortArrayByPrice(Furniture[] furnitureArray) {
        Arrays.sort(furnitureArray, Comparator.comparingDouble(Furniture::getPrice).reversed());
    }

    private static void printArray(Furniture[] furnitureArray) {
        for (Furniture furniture : furnitureArray) {
            System.out.println(furniture);
        }
    }
}
