//C(3)= 0 - StringBuilder 
//C(17)= 1 -  Вивести всі речення заданого тексту в порядку зростання кількості слів у них. 
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Lab5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введiть текст:");
        String inputText = scanner.nextLine();

        Text text = new Text(inputText);
        text.sortSentencesByWordCount();

        System.out.println("Вiдсортованi речення:");
        System.out.println(text.toString());
    }
}

class Text {
    private Sentence[] sentences;

    public Text(String inputText) {
        String normalizedText = normalizeText(inputText);
        String[] sentenceStrings = normalizedText.split("[.!?]\\s*");
        sentences = new Sentence[sentenceStrings.length];
        for (int i = 0; i < sentenceStrings.length; i++) {
            sentences[i] = new Sentence(sentenceStrings[i]);
        }
    }

    public void sortSentencesByWordCount() {
        Arrays.sort(sentences, Comparator.comparingInt(Sentence::getWordCount));
    }

    @Override
    public String toString() {
        StringBuilder sortedSentences = new StringBuilder();
        for (Sentence sentence : sentences) {
            sortedSentences.append(sentence.toString()).append(". ");
        }
        return sortedSentences.toString();
    }

    private String normalizeText(String inputText) {
        return inputText.replaceAll("[\\s\\t]+", " ");
    }
}

class Sentence {
    private Word[] words;
    private PunctuationMark[] punctuationMarks;

    public Sentence(String sentenceString) {
        String[] wordStrings = sentenceString.split("\\s+");
        words = new Word[wordStrings.length];
        punctuationMarks = new PunctuationMark[wordStrings.length - 1];
        int wordIndex = 0;
        int punctuationMarkIndex = 0;

        for (String wordString : wordStrings) {
            if (isWord(wordString)) {
                words[wordIndex] = new Word(wordString);
                wordIndex++;
            } else {
                punctuationMarks[punctuationMarkIndex] = new PunctuationMark(wordString);
                punctuationMarkIndex++;
            }
        }
    }

    public int getWordCount() {
        return words.length;
    }

    @Override
    public String toString() {
        StringBuilder sentenceBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i] != null) {
                sentenceBuilder.append(words[i].toString());
            }
            if (i < punctuationMarks.length) {
                if (punctuationMarks[i] != null) {
                    sentenceBuilder.append(punctuationMarks[i].toString());
                }
            }
            sentenceBuilder.append(" ");
        }
        return sentenceBuilder.toString().trim();
    }

    private boolean isWord(String wordString) {
        return wordString.matches("[a-zA-Z]+");
    }
}

class Word {
    private char[] letters;

    public Word(String wordString) {
        letters = wordString.toCharArray();
    }

    @Override
    public String toString() {
        return new String(letters);
    }
}

class PunctuationMark {
    private String mark;

    public PunctuationMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return mark;
    }
}
