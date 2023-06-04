public class Main {
	public static void main(String[] args) {
		try {
			// Приклад вхідного тексту
			Text text = new Text("В заданому текстi замiнити\t\t   слова заданої    довжини визначеним рядком");

			// Вивести результат
			System.out.println("Початковий вигляд: " + text.getText());

			// Виконати заміну
			int wordLength = 5;
			String replacement = "[заміна]";
			text.replaceWords(wordLength, replacement);

			// Вивести результат
			System.out.println("Результат: " + text.getText());
		} catch (Exception e) {
			System.out.println("Помилка виконання: " + e.getMessage());
		}
	}
}