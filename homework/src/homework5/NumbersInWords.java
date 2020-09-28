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
package homework5;

/**
 * Класс преобразования чисел из цифр в пропись.
 *
 * @version 2.00 28.09.2020
 * @author Сергей Шпаковский
 */
public class NumbersInWords {

    /**
     * Точка входа и проверка работы методов.
     * @param args аргументы передаваемые при запуске.
     */
    public static void main(String[] args) {
        // 1.1 В данном методе произвести конвертацию переданного
        // числа в число прописью. Числа от - 999 999 999
        // до 999 999 999.
        // 1.2 Пример передали: 223. Получили "Двести двадцать три"
        System.out.println(toString(32768));
        System.out.println(toString(600014010));
        System.out.println(toString(223));
        System.out.println(toString(-15));
        System.out.println(toString(0));
    
        // 2.1 В данном методе произвести конвертацию переданного
        // числа в число прописью. Выводить до сотых, без округления.
        // 2.2 Пример передали: 223.1599999.
        // Получили "Двести двадцать три целых пятнадцать сотых".
        System.out.println(toString(223.1599999));
        System.out.println(toString(-0.11));
    
        // 3.1 В данном методе посчитать количество прошедших
        // недель по переданному числу дней.
        // 3.2 Пример передали: 5. Получили "0 недель"
        // 3.3 Пример передали: 14. Получили "2 недели"
        // 3.4 Пример передали: 177. Получили "25 недель"
        System.out.println(toWeek(5));
        System.out.println(toWeek(14));
        System.out.println(toWeek(177));
    
        //4.1 В данном методе конвертируют переданные миллисекунды в
        // количество часов, минут, секунд и миллисекунд.
        //4.2 В зависимости от параметра shortFormat возвращать
        // либо короткое
        // написание в формате HH:mm:ss.SSS, где HH - это часы,
        // mm - это минуты, ss - это секунды, SSS - это миллисекунды.
        // Либо полное написание
        //4.3 Пример передали: 7789001, true.
        // Получили 02:09:49.001.
        //4.4 Пример передали: 7789001, false.
        // Получили 2 часа 9 минут 49 секунд 1 миллисекунда
        System.out.println(toHoursMinuteSecondMillisecond(7789001,true));
        System.out.println(toHoursMinuteSecondMillisecond(7789001,false));
    }
    
    /**
     * Преобразует любое целое число в диапазоне от - 999 999 999
     * до 999 999 999 в число прописью.
     * @param number целое число для преобразования.
     * @return строка с прописью числа с заглавной буквой.
     */
    public static String toString(int number) {
        StringBuilder stringBuilder = new StringBuilder();

        if (number < 0) {
            stringBuilder.append("минус ");
            number = -number;
        }

        int[] array = new int[9];
        for (int i = 0; i < array.length; i++) {
            array[i] = number % 10;
            number /= 10;
        }

        boolean allowUnitsWrite = true;
        for (int i = array.length - 1; i >= 0; i--) {
            //set to default value
            if (i == 8 || i == 5 || i == 2) {
                allowUnitsWrite = true;
            }
            if (!allowUnitsWrite) {
                continue;
            }
            //миллионы
            if (i == 5) {
                if (array[6] != 0 && array[7] != 1) {
                    switch (array[6]) {
                        case 1:
                            stringBuilder.append("миллион ");
                            break;
                        case 2:
                        case 3:
                        case 4:
                            stringBuilder.append("миллиона ");
                            break;
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                            stringBuilder.append("миллионов ");
                            break;
                        default:
                            stringBuilder.append("error with millions ");
                            break;
                    }
                } else if (array[8] != 0 || array[7] != 0) {
                    stringBuilder.append("миллионов ");
                }
            }
            //тысячи
            if (i == 2) {
                if (array[3] != 0 && array[4] != 1) {
                    switch (array[3]) {
                        case 1:
                            stringBuilder.append("тысяча ");
                            break;
                        case 2:
                        case 3:
                        case 4:
                            stringBuilder.append("тысячи ");
                            break;
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                            stringBuilder.append("тысяч ");
                            break;
                        default:
                            stringBuilder.append("error with thousands ");
                            break;
                    }
                } else if (array[5] != 0 || array[4] != 0) {
                    stringBuilder.append("тысяч ");
                }
            }
            //сотни десятки единицы
            switch (array[i]) {
                case 0: continue;
                case 1: if (i == 8 || i == 5 || i == 2) {
                            stringBuilder.append("сто");
                        } else if (i == 7 || i == 4 || i == 1) {
                            stringBuilder.append(
                                returnTensString(array[i - 1]));
                            allowUnitsWrite = false;
                        } else if (i == 6 || i == 0) {
                            stringBuilder.append("один");
                        } else {                          //if i == 3
                            stringBuilder.append("одна");
                        }
                        break;
                case 2: if (i == 8 || i == 5 || i == 2) {
                            stringBuilder.append("двести");
                        } else if (i == 7 || i == 4 || i == 1) {
                            stringBuilder.append("двадцать");
                        } else if (i == 6 || i == 0) {
                                stringBuilder.append("два");
                        } else {                          //if i == 3
                            stringBuilder.append("две");
                        }
                        break;
                case 3: if (i == 8 || i == 5 || i == 2) {
                            stringBuilder.append("триста");
                        } else if (i == 7 || i == 4 || i == 1) {
                            stringBuilder.append("тридцать");
                        } else {    //if (i == 6 || i == 3 || i == 0)
                            stringBuilder.append("три");
                        }
                        break;
                case 4: if (i == 8 || i == 5 || i == 2) {
                            stringBuilder.append("четыреста");
                        } else if (i == 7 || i == 4 || i == 1) {
                            stringBuilder.append("сорок");
                        } else {    //if (i == 6 || i == 3 || i == 0)
                            stringBuilder.append("четыре");
                        }
                        break;
                case 5: if (i == 8 || i == 5 || i == 2) {
                            stringBuilder.append("пятьсот");
                        } else if (i == 7 || i == 4 || i == 1) {
                            stringBuilder.append("пятьдесят");
                        } else {    //if (i == 6 || i == 3 || i == 0)
                            stringBuilder.append("пять");
                        }
                        break;
                case 6: if (i == 8 || i == 5 || i == 2) {
                            stringBuilder.append("шестьсот");
                        } else if (i == 7 || i == 4 || i == 1) {
                            stringBuilder.append("шестьдесят");
                        } else {    //if (i == 6 || i == 3 || i == 0)
                            stringBuilder.append("шесть");
                        }
                        break;
                case 7: if (i == 8 || i == 5 || i == 2) {
                            stringBuilder.append("семьсот");
                        } else if (i == 7 || i == 4 || i == 1) {
                            stringBuilder.append("семьдесят");
                        } else {    //if (i == 6 || i == 3 || i == 0)
                            stringBuilder.append("семь");
                        }
                        break;
                case 8: if (i == 8 || i == 5 || i == 2) {
                            stringBuilder.append("восемьсот");
                        } else if (i == 7 || i == 4 || i == 1) {
                            stringBuilder.append("восемьдесят");
                        } else { //if (i == 6 || i == 3 || i == 0)
                            stringBuilder.append("восемь");
                        }
                        break;
                case 9: if (i == 8 || i == 5 || i == 2) {
                            stringBuilder.append("девятьсот");
                        } else if (i == 7 || i == 4 || i == 1) {
                            stringBuilder.append("девяносто");
                        } else {    //if (i == 6 || i == 3 || i == 0)
                            stringBuilder.append("девять");
                        }
                        break;
                default:
                        stringBuilder.append("error with digit");
                        break;
            }
            stringBuilder.append(" ");
        }
        String result = stringBuilder.toString();
        if (result.equals("")) {
            result = "ноль ";
        }
        return toUpperCaseFirstLetter(result);
    }
    
    /**
     * Преобразует любое дробное число в диапазоне от - 999 999 999.99
     * до 999 999 999.99 в число прописью. Дробная часть с точностью
     * до сотых без округления.
     * @param number целое число для преобразования.
     * @return строка с прописью числа с заглавной буквой.
     */
    public static String toString(double number) {
        StringBuilder stringBuilder = new StringBuilder();
        if (number < 0) {
            stringBuilder.append("минус ");
            number = -number;
        }
        int integerPart = (int) number;
        stringBuilder.append(toLowerCaseFirstLetter(toString(integerPart)));
        stringBuilder.append("целых ");
        int fractionalPart = (int) (number * 100 % 100);
        stringBuilder.append(toLowerCaseFirstLetter(toString(fractionalPart)));
        stringBuilder.append("сотых");
        return toUpperCaseFirstLetter(stringBuilder.toString());
    }
    
    /**
     * Метод подсчитывает количество прошедших недель
     * по переданному числу дней.
     * @param day Число прошедших дней.
     * @return  Строка с числом прошедших недель записанным цифрой
     *          и словом недель с соответствующим цифре окончанием.
     */
    public static String toWeek(int day) {
        int weeks = day / 7;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(weeks);
        switch (weeks % 10) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                stringBuilder.append(" недель");
                break;
            case 1:
                stringBuilder.append(" неделя");
                break;
            case 2:
            case 3:
            case 4:
                stringBuilder.append(" недели");
                break;
            default:
                stringBuilder.append(" error in weeks");
                break;
        }
        return stringBuilder.toString();
    }
    
    /**
     *  Метод конвертирует переданные миллисекунды в
     *  количество часов, минут, секунд и миллисекунд.
     *  В зависимости от параметра shortFormat возвращает
     *  либо короткое написание в формате HH:mm:ss.SSS,
     *  где HH - это часы,
     *  mm - это минуты, ss - это секунды, SSS - это миллисекунды.
     *  Либо полное написание.
     *  Например, передали: 7789001, true. Получили 02:09:49.001.
     *  Например, передали: 7789001, false. Получили 2 часа 9 минут
     *  49 секунд 1 миллисекунда.
     * @param millisecond Количество миллисекунд дял перевода.
     * @param shortFormat Формат написания возвращаемой строки.
     * @return  Строка в полном или сокращенном формате с указанием
     *          часов, минут, секунд, миллисекунд
     *          в переданном количестве миллисекунд.
     */
    public static String toHoursMinuteSecondMillisecond(
            long millisecond, boolean shortFormat) {
        short SSS = (short) (millisecond % 1000);
        millisecond /= 1000;
        byte ss = (byte) (millisecond % 60);
        millisecond /= 60;
        byte mm = (byte) (millisecond % 60);
        millisecond /= 60;
        long hh = millisecond;
        StringBuilder stringBuilder = new StringBuilder();
        if (shortFormat) {
            stringBuilder.append(String.format("%02d", hh));
            stringBuilder.append(':');
            stringBuilder.append(String.format("%02d", mm));
            stringBuilder.append(':');
            stringBuilder.append(String.format("%02d", ss));
            stringBuilder.append('.');
            stringBuilder.append(String.format("%03d", SSS));
        } else {
            stringBuilder.append(hh);
            stringBuilder.append(" час");
            byte remainder = (byte) (hh % 10);
            if (remainder >= 2 && remainder <= 4) {
                stringBuilder.append("а");
            } else if (remainder != 1) {
                stringBuilder.append("ов");
            }
            stringBuilder.append(' ');
            stringBuilder.append(returnMinutesSecondsWithSuffix(mm, "минут"));
            stringBuilder.append(' ');
            stringBuilder.append(returnMinutesSecondsWithSuffix(ss, "секунд"));
            stringBuilder.append(' ');
            stringBuilder.append(returnMinutesSecondsWithSuffix(SSS,
                    "миллисекунд"));
        }
        return stringBuilder.toString();
    }
    
    /**
     * Возвращает строку прописью для чисел 10..19.
     * @param i число единиц для "надцать"
     * @return строка с прописью числа
     */
    private static String returnTensString(int i) {
        switch (i) {
            case 0:
                return "десять";
            case 1:
                return "одинадцать";
            case 2:
                return "двенадцать";
            case 3:
                return "тринадцать";
            case 4:
                return "четырнадцать";
            case 5:
                return "пятнадцать";
            case 6:
                return "шестнадцать";
            case 7:
                return "семнадцать";
            case 8:
                return "восемнадцать";
            case 9:
                return "девятнадцать";
            default:
                return "error in units return";
        }
    }
    
    /**
     * Преобразует первую букву строки в верхний регистр.
     * @param str Строка для изменения первой буквы.
     * @return Строка с заглавной первой буквой.
     */
    private static String toUpperCaseFirstLetter(String str) {
        String result = str.substring(0, 1).toUpperCase()
                +  str.substring(1);
        return result;
    }
    
    /**
     * Преобразует первую букву строки в нижний регистр.
     * @param str Строка для изменения первой буквы.
     * @return Строка с первой буквой низкого регистра.
     */
    private static String toLowerCaseFirstLetter(String str) {
        String result = str.substring(0, 1).toLowerCase()
                +  str.substring(1);
        return result;
    }
    
    /**
     * Метод формирует строку с окончанием переданного слова
     * соответствующего количеству переданных секунд
     * (милли-, микро-, нано- и т.д.) или минут.
     * @param value целое значение переданных секунд.
     * @param word слово, для которого необходим подбор окончания.
     *             Например литералом "минут" или "секунд".
     * @return Строку с переданным словом с правильным окончанием
     *          по количеству переданного числа.
     *          Например: "2 минуты".
     */
    private static String returnMinutesSecondsWithSuffix(int value,
                                                         String word) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(value);
        stringBuilder.append(' ');
        stringBuilder.append(word);
        String suffix;
        switch (value % 10) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                suffix = "";
                break;
            case 1:
                suffix = "а";
                break;
            case 2:
            case 3:
            case 4:
                suffix = "ы";
                break;
            default:
                suffix = " error in suffix ";
                break;
        }
        stringBuilder.append(suffix);
        return stringBuilder.toString();
    }
}
