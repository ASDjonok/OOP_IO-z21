public class Main {
	public static void main(String[] args) {
		Bouquet bouquet = new Bouquet();

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
		// Додавання квіток до букету
		bouquet.addFlower(tulip1);
		bouquet.addFlower(tulip2);
		bouquet.addFlower(tulip3);
		bouquet.addFlower(rose1);
		bouquet.addFlower(rose2);
		bouquet.addFlower(rose3);
		bouquet.addFlower(orchid1);
		bouquet.addFlower(orchid2);
		bouquet.addFlower(orchid3);
		System.out.println("Букет складається з наступних квіток:");
		bouquet.printBouquet();

		bouquet.sortByFreshnessLevel();
		System.out.println("\nБукет після сортування за рівнем свіжості:");
		bouquet.printBouquet();

		System.out.println("\nКвіти, довжина яких від 20 до 35:");
		for (Flower flower : bouquet.findFlowersByLengthRange(20, 35)) {
			System.out.println(flower.toString());
		}

		System.out.println("\nЗагальна вартість букета: " + bouquet.calculateTotalPrice());
		bouquet.setFestivePackaging(true);
		System.out.println("Загальна вартість букета зі світковим пакуванням: " + bouquet.calculateTotalPrice());
	}
}