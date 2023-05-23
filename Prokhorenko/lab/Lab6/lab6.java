/* C(13)= 3 - Визначити ієрархію овочів. Зробити салат. 
Порахувати калорійність салату. Провести сортування овочів 
для салату на основі одного з параметрів. 
Знайти овоч у салаті, , що відповідає заданому діапазону калорійності.*/
import java.util.Arrays;
import java.util.Comparator;

class Vegetable {
    private String name;
    private int calories;
    private int mass;

    public Vegetable(String name, int calories, int mass) {
        this.name = name;
        this.calories = calories;
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public int getMass() {
        return mass;
    }
}

class Cucumber extends Vegetable {
    private String size;

    public Cucumber(String name, int calories, int mass, String size) {
        super(name, calories, mass);
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}

class Cabbage extends Vegetable {
    private String sort;

    public Cabbage(String name, int calories, int mass, String sort) {
        super(name, calories, mass);
        this.sort = sort;
    }

    public String getSort() {
        return sort;
    }
}

class Radish extends Vegetable {
    private String color;

    public Radish(String name, int calories, int mass, String color) {
        super(name, calories, mass);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

class Salad {
    private Vegetable[] vegetables;

    public Salad(Vegetable[] vegetables) {
        this.vegetables = vegetables;
    }

    public int calculateCalories() {
        int sumCalories = 0;
        for (Vegetable vegetable : vegetables) {
            sumCalories += vegetable.getCalories();
        }
        return sumCalories;
    }
}

public class Lab6 {
    public static void main(String[] args) {
        Cucumber cucumber1 = new Cucumber("Огiрок", 30, 180, "Великий");
        Cabbage cabbage1 = new Cabbage("Капуста", 70, 250, "Молода");
        Radish radish1 = new Radish("Редис", 40, 200, "Рожевий");

        Vegetable[] vegetables = {cucumber1, cabbage1, radish1};

        Salad salad = new Salad(vegetables);

        int caloricContent = salad.calculateCalories();
        System.out.println("Калорiйнiсть салату: " + caloricContent);

        Arrays.sort(vegetables, new Comparator<Vegetable>() {
            @Override
            public int compare(Vegetable vegetable1, Vegetable vegetable2) {
                return vegetable1.getName().compareTo(vegetable2.getName());
            }
        });

        System.out.println("Овочi з салату, якi вiдсортованi за калорiйнiстю");
        for (Vegetable vegetable : vegetables) {
            System.out.println(vegetable.getName() + " " + vegetable.getMass());
        }

        int minCalories = 35;
        int maxCalories = 65;

        for (Vegetable vegetable : vegetables) {
            if (vegetable.getCalories() >= minCalories && vegetable.getCalories() <= maxCalories) {
            	System.out.println("Овоч у салатi, що вiдповiдає заданому дiапазону калорiйностi");
                System.out.println(vegetable.getName() + " " + vegetable.getCalories());
            }
        }
    }
}