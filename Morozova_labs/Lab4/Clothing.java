public class Clothing {
	// бренд
	private String brand;

	// вид одягу
	private String type;

	// колір
	private String color;

	// розмір
	private int size;

	// ціна
	private double price;

	public Clothing(String brand, String type, String color, int size, double price) {
		this.brand = brand;
		this.type = type;
		this.color = color;
		this.size = size;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	// Перевизначення методу toString() для зручного виводу об'єкту на екран
	@Override
	public String toString() {
		return "Clothing { " +
				"brand = '" + brand + '\'' +
				", type = '" + type + '\'' +
				", color = '" + color + '\'' +
				", size = " + size +
				", price = " + price +
				" }";
	}
}
