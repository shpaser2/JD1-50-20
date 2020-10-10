/*
 * Сергей Шпаковский
 *
 * Это программное обеспечение является публичной и открытой
 * информацией.
 *
 * АВТОР НЕ ДАЁТ НИКАКИХ ГАРАНТИЙ, ЯВНЫХ ИЛИ КОСВЕННЫХ (ВКЛЮЧАЯ - НО
 * НЕ ОГРАНИЧИВАЯСЬ ИМИ - ГАРАНТИИ РЕАЛИЗУЕМОСТИ), СООТВЕТСТВИЯ
 * ОПРЕДЕЛЁННОМУ НАЗНАЧЕНИЮ ИЛИ НЕНАРУШЕНИЯ УСЛОВИЙ, ЧТО СОДЕРЖИМОЕ
 * ДАННОГО ФАЙЛА ПОДХОДИТ ДЛЯ КАКИХ-ЛИБО ЦЕЛЕЙ ИЛИ ЧТО ЛЮБОЕ
 * ИСПОЛЬЗОВАНИЕ ИЛИ РЕАЛИЗАЦИЯ ТАКОГО СОДЕРЖИМОГО НЕ БУДЕТ НАРУШАТЬ
 * КАКИХ-ЛИБО ПАТЕНТОВ ТРЕТЬЕЙ СТОРОНЫ, АВТОРСКИХ ПРАВ, КОММЕРЧЕСКОЙ
 * ТАЙНЫ ИЛИ ИНЫХ ПРАВ.
 */
package homework5.warEndPeace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс для работы с файлом и текстом,
 * поиском по тексту через регулярные выражения и indexOf.
 *
 * @version 1.0 10.10.2020
 * @author Сергей Шпаковский
 */
public class WarAndPeace {

    /**
     * Точка входа и примеры использования {@link EasySearch}
     * и {@link RegExSearch} на тексте из файла, хранимого на пк.
     * @param args аргументы при запуске.
     */
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
        String patternString = "([А-Яа-яЁёA-Za-z\\d]+-{0,2}[А-Яа-яЁёA-Za-z]*)";
        List<String> arrWords = new ArrayList<>();
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(book);
        String tmp;
        while (matcher.find()) {
            tmp = matcher.group(1);
            arrWords.add(tmp);
        }

        //2.1 Найдены в строке все уникальные слова
        // и помещены в коллекцию используя Set.
        Set<String> words = new TreeSet<>(arrWords);
        System.out.println("Всего " + arrWords.size() + " слов.");
        System.out.println("Уникальных - " + words.size() + " слов.");
        
        //2.2 Найти в строке топ 10 слов и вывести количество
        // этих слов используя Map. Отсортировать по количеству.
        // Распечатать в консоль. Пример: Война - 200 раз,
        // Мир - 100 раз и так далее. Знаки препинания,
        // пробелы и переводы строк - это не слова.
        System.out.println("Топ 10 слов:");
        showTopTenWords(arrWords);

        //4.1 поиск слова используя метод indexOf из класса String.
        // В данной реализации не используются регулярные
        // выражения в любом виде, для любых задач.
        //4.2* RegExSearch реализующий интерфейс ISearchEngine.
        // Реализован поиск при помощи класса Matcher.
        //5. Используя реализации интерфейса ISearchEngine
        // вывести информацию как часто встречаются слова "война",
        // "и" (как союз), "мир" вне зависимости от регистра.
        EasySearch easySearch = new EasySearch(true);
        System.out.println("Слово \"война\" " + "с помощью EasySearch "
            + easySearch.search(book, "война") + " раз.");
        System.out.println("Союз \"и\" " + "с помощью EasySearch "
            + easySearch.search(book, "и") + " раз.");
        System.out.println("Слово \"мир\" " + "с помощью EasySearch "
            + easySearch.search(book, "мир") + " раз.");

        RegExSearch regExSearch = new RegExSearch(true);
        System.out.println("Слово \"война\" " + "с поомщью RegExSearch "
            + regExSearch.search(book, "война") + " раз.");
        System.out.println("Союз \"и\" " + "с поомщью RegExSearch "
            + regExSearch.search(book, "и") + " раз.");
        System.out.println("Слово \"мир\" " + "с поомщью RegExSearch "
            + regExSearch.search(book, "мир") + " раз.");
    }

    /**
     * Находит топ-10 слов и отображает число их употребления.
     * @param arrWords текст преобразованный в массив слов.
     */
    public static void showTopTenWords(List<String> arrWords) {
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

    /**
     * Вычитывает содержимое файла в строку.
     * @param filePath путь к файлу.
     * @return строка с содержимым файла.
     */
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
