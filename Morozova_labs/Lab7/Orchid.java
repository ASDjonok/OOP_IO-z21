// Клас "Орхідея"
public class Orchid  extends  Flower {
	// ознака додавання тільки бутону у букети (в спеціальній ємності)
	private boolean onlyBud;

	public Orchid(String name, double price, int freshnessLevel, int length, String color, boolean onlyBud) {
		super(name, price, freshnessLevel, length, color);
		this.onlyBud = onlyBud;
		setType("Orchid");
	}

	public boolean isOnlyBud() {
		return onlyBud;
	}

	public void setOnlyBud(boolean onlyBud) {
		this.onlyBud = onlyBud;
	}
}
