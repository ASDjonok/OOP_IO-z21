// Клас "Троянда"
public class Rose extends Flower{

	// ознака троянди з шипами
	private  boolean withThorns;
	public Rose(String name, double price, int freshnessLevel, int length, String color, boolean withThorns) {
		super(name, price, freshnessLevel, length, color);
		this.withThorns = withThorns;
		setType("Rose");
	}

	public boolean isWithThorns() {
		return withThorns;
	}

	public void setWithThorns(boolean withThorns) {
		this.withThorns = withThorns;
	}
}
