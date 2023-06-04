// Клас "Тюльпан"
public class Tulip extends Flower {

	public Tulip(String name, double price, int freshnessLevel, int length, String color) {
		super(name, price, freshnessLevel, length, color);
		setType("Tulip");
	}
}
