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

/**
 * Класс без регулярных выражений для поиска слова в тексте
 * с использованием кириллицы, латиниы и цифр.
 *
 * @version 1.0 10.10.2020
 * @author Сергей Шпаковский
 */
public class EasySearch implements ISearchEngine {
    private final boolean caseInsensitive;

    public EasySearch(boolean isCaseInsensitive) {
        this.caseInsensitive = isCaseInsensitive;
    }

    /**
     * Поиск количества использования слова в тексте
     * с/без учета регистра без использования регулярных выражений.
     * @param text текст в котором ищется слово.
     * @param word слово содержащее цифры, кириллицу,
     *             символ "-" и латиницу.
     * @return количество употреблений слова в тексте.
     */
    @Override
    public long search(String text, String word) {
        long counter = 0;
        int index;
        String[] strArr = createWordsForSearch(word);
        for (int i = 0; i < strArr.length; i++) {
            index = 0;
            do {
                index++;
                index = text.indexOf(strArr[i], index);
                if (index != -1) {
                    counter++;
                }
            } while (index != -1);
        }
        return counter;
    }

    /**
     * Создает массив строк из данного слова для поиска в разных
     * формах записи (с Заглавной, ПРОПИСНЫМИ, строчными) и с
     * разными позможными символами перед и после слова.
     * Учитывает включен ли поиск без учета регистра или нет.
     * @param keyWord слово для поиска.
     * @return  массив строк с вариантами слова в тексте.
     */
    private String[] createWordsForSearch(String keyWord) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = createWordCaseVariants(keyWord);
        String[] postStrings = {",", ".", " ", ":", ";", "\"", "!", "?", "\n"
            , ")", "\t", "\f", "*", "\'"};
        String[] preStrings = {" ", "\n", " -", "\"", "(", "\t", "\f", "*"
            , "\'", ",", "."};
        int length = preStrings.length * postStrings.length * words.length;
        String[] strArr = new String[length];
        int index = 0;
        for (String word : words) {
            for (String preString : preStrings) {
                for (String postString : postStrings) {
                    strArr[index] = createWordForSearch(preString, word,
                        postString, stringBuilder);
                    index++;
                }
            }
        }
        return strArr;
    }

    /**
     * Из слова делает слова с Заглавной, всеми ПРОПИСНЫМИ
     * и всеми строчными буквами.
     * Если слово начинается с цифры и содержит буквы, то варианта
     * два - ПРОПИСНЫМИ и строчными буквами.
     * Если только цифры - оставляет как есть.
     * @param word
     * @return
     */
    private String[] createWordCaseVariants(String word) {
        int length;
        length = this.caseInsensitive ? checkWordForLetters(word) : 1;
        String[] words = new String[length];
        if (length == 1) {
            words[0] = word;
        } else {
            words[0] = word.toUpperCase();
            words[1] = word.toLowerCase();
            if (length == 3) {
                words[2] = word.substring(0, 1).toUpperCase()
                    .concat(word.substring(1).toLowerCase());
            }
        }
        return words;
    }

    /**
     * Определяет количество форм прописи переданного слова.
     * Примеры: 13-го - 2 формы. 13-ГО и 13-го.
     * мир - 3 формы. Мир, МИР, мир.
     * 13 - 1 форма. 13
     * @param word слово или число в виде строки
     * @return количество вариантов записи слова в плане размера букв.
     */
    private int checkWordForLetters(String word) {
        int type = 1;
        if (Character.isLetter((word.charAt(0)))) {
            if (word.length() > 1) {
                type = 3;
            } else {
                type = 2;
            }
        } else {
            char[] chars = word.toCharArray();
            for (char c : chars) {
                if (Character.isLetter(c)) {
                    type = 2;
                    break;
                }
            }
        }
        return type;
    }

    /**
     * Склеивает три строки.
     * @param preStr строка начала
     * @param word строка в середине
     * @param postStr строка в конце
     * @param strBuilder "инструмент" склейки
     * @return строка "началосерединаконец"
     */
    private String createWordForSearch(String preStr, String word,
                                       String postStr,
                                       StringBuilder strBuilder) {
        String result =
                strBuilder.append(preStr).append(word)
                        .append(postStr).toString();
        strBuilder.setLength(0);
        return result;
    }
}
