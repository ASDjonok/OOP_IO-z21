public class Main
{
    public static void main(String[] args) {
        try {
            // текст, в якому потрібно замінити слова заданої довжини
            String text = "В заданому текстi замiнити слова заданої довжини визначеним рядком";
            System.out.println("Початковий текст: " + text);
            
            // довжина слова, яке потрібно замінити
            int wordLength = 6;
            // текст, на який потрібно замінити
            String replacement = "[заміна]";
            
            // викликаємо метод, який виконує заміну
            StringBuilder result = replaceWords(text, wordLength, replacement);
            System.out.println("Peзультат: " + result.toString());
        } catch (Exception e) {
            System.out.println("Помилка виконання: " + e.getMessage());
        }
    }

    public static StringBuilder replaceWords(String text, int wordLength, String replacement) throws IllegalArgumentException {
        if (text == null || replacement == null) {
            throw new IllegalArgumentException("Текст та рядок заміни не повинні бути пустими");
        }

        if (wordLength <= 0) {
            throw new IllegalArgumentException("Довжина слова має бути більше 0");
        }

        StringBuilder resultText = new StringBuilder();
        String[] words = text.split(" ");

        for (String word : words) {
            if (word.length() == wordLength) {
                resultText.append(replacement).append(" ");
            } else {
                resultText.append(word).append(" ");
            }
        }

        return resultText;
    }
}
