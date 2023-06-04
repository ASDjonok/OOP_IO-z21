import java.util.List;
import java.util.ArrayList;

// Клас "Слово"
public class Word {
	private List<Letter> letters;

	public Word(List<Letter> letters) {
		this.letters = letters;
	}

	public Word(String word) {
		word = replaceTabsAndSpaces(word);
		this.letters = new ArrayList<>();
		for (char c : word.toCharArray()) {
			letters.add(new Letter(c));
		}
	}

	public String getText() {
		StringBuilder result = new StringBuilder();
		for (Letter letter : letters) {
			result.append(letter.getCharacter());
		}
		return result.toString();
	}

	public void replaceIfLengthMatches(int length, String replacement) {
		if (letters.size() == length) {
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < letters.size(); i++) {
				result.append(letters.get(i).getCharacter());
			}
			result.replace(0, result.length(), replacement);
			letters.clear();
			for (char c : result.toString().toCharArray()) {
				letters.add(new Letter(c));
			}
		}
	}

	private String replaceTabsAndSpaces(String input) {
		input = input.replaceAll("[\\t]", " ");
		StringBuilder result = new StringBuilder();
		boolean previousWhitespace = false;
		for (char c : input.toCharArray()) {
			if (Character.isWhitespace(c)) {
				if (!previousWhitespace) {
					previousWhitespace = true;
				}
			} else {
				result.append(c);
				previousWhitespace = false;
			}
		}
		return result.toString();
	}
}
