package homework5;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class WarAndPeace {
    public static void main(String[] args) {
        //1. Скачать книгу "Война и мир" на компьютер.
        // Используя метод readAllBytesJava7 считать сохранённый файл
        //и сохранить результат считывания
        // в переменную типа типа String.
        String filePath = "h:/book.txt";
        String book = readAllBytesJava7(filePath);

        System.out.println(book);       //fixme

        //2. В книге "Война и мир" найти все уникальные слова
        // и поместить их в коллекцию используя Set.
        // Знаки препинания, пробелы и переводы строк - это не слова.
        Set<String> words = new TreeSet<>();
        //[А-Яа-яЁё]+-{0,2}[А-Яа-яЁё]*
        String patternString = "([А-Яа-яЁё]+-{0,2}[А-Яа-яЁё]*)";
        List<String> arrWords = new ArrayList<>();
        Map<String, Long> mapWords = new Hashtable<>();
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(book);
        String tmp;
        while (matcher.find()) {
            tmp = matcher.group(1);
            arrWords.add(tmp);
            long keyValue = mapWords.get(tmp);
            if (keyValue > 0) {
                mapWords.replace(tmp, ++keyValue);
            } else {
                mapWords.put(tmp, 1L);
            }
        }
        words.addAll(arrWords);

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
