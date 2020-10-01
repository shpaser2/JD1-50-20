package homework5;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Класс для работы с файлом и текстом,
 * поиском по тексту через регулярные выражения и indexOf.
 *
 * @version 0.2 01.10.2020
 * @author Сергей Шпаковский
 */
public class WarAndPeace {
    public static void main(String[] args) {
        //1. Скачать книгу "Война и мир" на компьютер.
        // Используя метод readAllBytesJava7 считать сохранённый файл
        //и сохранить результат считывания
        // в переменную типа типа String.
        //String filePath = "h:/book.txt";
        String filePath = "c:/book.txt";
        String book = readAllBytesJava7(filePath);
//        System.out.println(book);

        //2. В книге "Война и мир" найти все уникальные слова
        // и поместить их в коллекцию используя Set.
        // Знаки препинания, пробелы и переводы строк - это не слова.
        //2.0 и 4.2*
        Set<String> words = new TreeSet<>();
        String patternString = "([А-Яа-яЁё]+-{0,2}[А-Яа-яЁё]*)";
        List<String> arrWords = new ArrayList<>();
        Map<String, Long> mapWords = new Hashtable<>();
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(book);
        String tmp;
        while (matcher.find()) {
            tmp = matcher.group(1);
            arrWords.add(tmp);
        }
        //2.1
        words.addAll(arrWords);
//        System.out.println(arrWords);
//        System.out.println(words);
        
        //2.2 Найти в строке топ 10 слов и вывести количество
        // этих слов используя Map. Отсортировать по количеству.
        // Распечатать в консоль. Пример: Война - 200 раз,
        // Мир - 100 раз и так далее. Знаки препинания,
        // пробелы и переводы строк - это не слова.
        Map<String, Integer> wordsCount = new HashMap<>();
        Integer wordCounter;
        for (String word : arrWords) {
            if (wordsCount.containsKey(word)) {
                wordCounter = wordsCount.get(word);
                wordCounter++;
                wordsCount.replace(word, wordCounter);
            } else {
                wordsCount.put(word, 1);
            }
        }
        Map<String, Integer> topWordsCount = new LinkedHashMap<>();
        wordsCount.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(e -> topWordsCount.put(e.getKey(), e.getValue()));
        int capacity = topWordsCount.size();
        List<String> keysWords = new ArrayList<>(capacity);
        for (Map.Entry<String, Integer> entry : topWordsCount.entrySet()) {
            keysWords.add(entry.getKey());
        }
        for (int i = keysWords.size() - 1; i >= keysWords.size() - 11; i--) {
            System.out.println(keysWords.get(i)
                    + "\t" + topWordsCount.get(keysWords.get(i)).toString()
                    + " раз");
        }
    }

    private static String readAllBytesJava7(String filePath) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
