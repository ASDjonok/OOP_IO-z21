import java.util.ArrayList;
import java.util.List;

// Клас "Речення"
public class Sentence {
	private List<Word> words;

	public Sentence() {
		this.words = new ArrayList<>();
	}

	public void addWord(Word word) {
		words.add(word);
	}

	public void replaceWords(int wordLength, String replacement) {
		for (Word word : words) {
			word.replaceIfLengthMatches(wordLength, replacement);
		}
	}

	public String getText() {
		StringBuilder result = new StringBuilder();
		for (Word word : words) {
			result.append(word.getText()).append(" ");
		}
		return result.toString().trim();
	}
}
