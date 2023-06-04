import java.util.ArrayList;
import java.util.List;

// Клас "Текст"
public class Text {
	private List<Sentence> sentences;

	public Text() {
		this.sentences = new ArrayList<>();
	}

	public Text(String inputText) {
		this.sentences = new ArrayList<>();
		String[] sentenceStrings = inputText.split("\\. ");
		for (String sentenceString : sentenceStrings) {
			Sentence sentence = new Sentence();
			String[] wordStrings = sentenceString.split(" ");
			for (String wordString : wordStrings) {
				if (!wordString.isEmpty()) {
					Word word = new Word(wordString);
					sentence.addWord(word);
				}
			}
			sentences.add(sentence);
		}
	}

	// додати речення
	public void addSentence(Sentence sentence) {
		sentences.add(sentence);
	}

	// замінити слова певної довжини на інші
	public void replaceWords(int wordLength, String replacement) {
		for (Sentence sentence : sentences) {
			sentence.replaceWords(wordLength, replacement);
		}
	}

	// отримати текст
	public String getText() {
		StringBuilder result = new StringBuilder();
		for (Sentence sentence : sentences) {
			result.append(sentence.getText()).append(" ");
		}
		return result.toString().trim();
	}
}
