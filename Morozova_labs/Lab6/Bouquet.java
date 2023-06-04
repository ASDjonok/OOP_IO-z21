import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Клас "Букет"
public class Bouquet {
	private List<Flower> flowers;

	// букет зі святковим пакуванням
	private boolean festivePackaging;

	public Bouquet() {
		flowers = new ArrayList<>();
	}

	public List<Flower> getFlowers() {
		return flowers;
	}

	public boolean isFestivePackaging() {
		return festivePackaging;
	}

	public void setFestivePackaging(boolean festivePackaging) {
		this.festivePackaging = festivePackaging;
	}

	public void addFlower(Flower flower) {
		flowers.add(flower);
	}

	public void removeFlower(Flower flower) {
		flowers.remove(flower);
	}

	public double calculateTotalPrice() {
		double totalPrice = 0;
		for (Flower flower : flowers) {
			totalPrice += flower.getPrice();
		}
		// кщо святкове пакування, то додати 10 до загальної суми
		return festivePackaging ? totalPrice + 10 : totalPrice;
	}

	// сортувати квіти букету за рівнем свіжості від найменш свіжих
	public void sortByFreshnessLevel() {
		Collections.sort(flowers, (flower1, flower2) -> flower1.getFreshnessLevel() - flower2.getFreshnessLevel());
	}

	// Квіти, довжина яких від [minLength] до [maxLength]
	public List<Flower> findFlowersByLengthRange(int minLength, int maxLength) {
		List<Flower> foundFlowers = new ArrayList<>();
		for (Flower flower : flowers) {
			int flowerLength = flower.getLength();
			if (flowerLength >= minLength && flowerLength <= maxLength) {
				foundFlowers.add(flower);
			}
		}
		return foundFlowers;
	}

	public void printBouquet() {
		for (Flower flower : flowers) {
			System.out.println(flower.toString());
		}
	}
}