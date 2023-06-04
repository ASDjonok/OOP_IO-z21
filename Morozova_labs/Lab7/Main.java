import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		// Створення об'єкту FlowerCollection
		FlowerCollection flowerCollection = new FlowerCollection();
		// Створення тюльпанів
		Tulip tulip1 = new Tulip("Червоний тюльпан", 2.5, 4, 30, "Червоний");
		Tulip tulip2 = new Tulip("Білий тюльпан", 2.0, 3, 28, "Білий");
		Tulip tulip3 = new Tulip("Рожевий тюльпан", 2.2, 4, 29, "Рожевий");

		// Створення троянд
		Rose rose1 = new Rose("Бордова троянда", 3.5, 5, 35, "Бордовий", true);
		Rose rose2 = new Rose("Синя троянда", 3.2, 4, 33, "Синій", false);
		Rose rose3 = new Rose("Жовта троянда", 3.0, 3, 32, "Жовтий", true);

		// Створення орхідей
		Orchid orchid1 = new Orchid("Фіолетова орхідея", 4.0, 4, 3, "Фіолетовий", true);
		Orchid orchid2 = new Orchid("Біла орхідея", 3.8, 4, 38, "Білий", false);
		Orchid orchid3 = new Orchid("Жовта орхідея", 3.7, 3, 2, "Жовтий", true);

		// Додавання квітів до колекції
		flowerCollection.add(tulip1);
		flowerCollection.add(tulip2);
		flowerCollection.add(tulip3);
		flowerCollection.add(rose1);
		flowerCollection.add(rose2);
		flowerCollection.add(rose3);
		flowerCollection.add(orchid1);
		flowerCollection.add(orchid2);
		flowerCollection.add(orchid3);

		// Виведення кількості квітів у колекції
		System.out.println("Кількість квітів: " + flowerCollection.size());

		// Виведення всіх квітів у колекції
		System.out.println("Квіти у колекції:");
		for (Flower flower : flowerCollection) {
			System.out.println(flower.toString());
		}

		// Видалення квіту з колекції

		// Перевірка наявності квіту у колекції
		boolean containsFlower = flowerCollection.contains(rose2);
		System.out.println("\nНаявність квітки: " + containsFlower);
		// Сортування за довжиною
		flowerCollection.sortByLength();

		// Виведення відсортованих квітів
		System.out.println("\nВідсортовані квіти:");
		for (Flower flower : flowerCollection) {
			System.out.println(flower.getName() + " - " + flower.getLength());
		}
	}
}
