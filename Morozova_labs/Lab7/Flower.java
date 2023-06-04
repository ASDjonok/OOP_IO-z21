
// Клас "Квітка"
public class Flower {
	private String name;
	private double price;

	// рівень свіжості квітки (чим менше значення тим свіжіша)
	private int freshnessLevel;
	private int length;
	private String color;
	private String type;

	public Flower(String name, double price, int freshnessLevel, int length, String color) {
		this.name = name;
		this.price = price;
		this.freshnessLevel = freshnessLevel;
		this.length = length;
		this.color = color;
		type = "Flower";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getFreshnessLevel() {
		return freshnessLevel;
	}

	public void setFreshnessLevel(int freshnessLevel) {
		this.freshnessLevel = freshnessLevel;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	protected void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type + " { name = " + name + ", price = " + price + ", freshnessLevel = " + freshnessLevel + ", length = " + length + ", color = " + color + " }";
	}
}
