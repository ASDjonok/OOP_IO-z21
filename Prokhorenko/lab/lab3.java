//C(3)= 0 - StringBuilder 
//C(17)= 1 -  Вивести всі речення заданого тексту в порядку зростання кількості слів у них. 
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Lab3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введiть текст:");
        String text = scanner.nextLine();

        String[] sentences = text.split("[.!?]\\s*");
        Arrays.sort(sentences, Comparator.comparingInt(sentence -> sentence.split("\\s+").length));

        StringBuilder sortedSentences = new StringBuilder();
        for (String sentence : sentences) {
            sortedSentences.append(sentence).append(". ");
        }

        System.out.println("Вiдсортованi речення:");
        System.out.println(sortedSentences.toString());
    }
}
