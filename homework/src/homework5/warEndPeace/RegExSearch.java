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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс, в котором используются Pattern и Matcher
 * с регулярными выражениями для поиска слова в тексте
 * с использованием кириллицы, латиниы и цифр.
 *
 * @version 1.0 10.10.2020
 * @author Сергей Шпаковский
 */
public class RegExSearch implements ISearchEngine{
    private final boolean caseInsensitive;
    private StringBuffer stringBuffer = new StringBuffer();

    public RegExSearch(boolean caseInsensitive) {
        this.caseInsensitive = caseInsensitive;
    }

    /**
     * Поиск количества использования слова в тексте
     * с/без учета регистра с использованием регулярных выражений.
     * @param text текст в котором ищется слово.
     * @param word слово содержащее цифры, кириллицу,
     *             символ "-" и латиницу.
     * @return количество употреблений слова в тексте.
     */
    @Override
    public long search(String text, String word) {
        long counter = 0;
        String patternString = regExStringMaker(word);
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            counter++;
        }
        return counter;
    }

    /**
     * Делает регулярное выражение по заданному слову
     * для поиска в тексте.
     * @param word строка со словом для поиска.
     * @return строка-регулярное выражение для поиска слова в тексте
     *          с учетом или без учета регистра слова.
     */
    private String regExStringMaker(String word) {
        StringBuffer strBuf = this.stringBuffer;
        strBuf.setLength(0);
        String preString = "(\\s|\\.|\\n|\\t|\\f|\"|\\s\\-|\\(|\\*|'|\\,)";
        String postString =
            "(\\s|\\.|\\n|\\t|\\f|\"|\\s\\-|\\)|\\*|'|\\,|\\:|;|\\!|\\?)";
        strBuf.append(preString);
        strBuf.append('(');
        int length = word.length();
        for (int i = 0; i < word.length(); i++) {
            strBuf.append("[");
            if (Character.isLetter((word.charAt(i))) && this.caseInsensitive) {
                if (i < length - 1) {
                    strBuf.append(word.substring(i, i + 1).toUpperCase());
                    strBuf.append(word.substring(i, i + 1).toLowerCase());
                } else {
                    strBuf.append(word.substring(i).toUpperCase());
                    strBuf.append(word.substring(i).toLowerCase());
                }
            } else {
                strBuf.append(word.charAt(i));
            }
            strBuf.append("]");
        }
        strBuf.append(')');
        strBuf.append(postString);
        return strBuf.toString();
    }
}
