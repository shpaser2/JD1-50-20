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
package operators;

/**
 * Класс - пример использования switch
 * и создания строки из массива символов.
 *
 * @version   1.00 30.08.2020
 * @author    Сергей Шпаковский
 */
public class PhoneNumberMain {
    
    /**
     * Точка входа.
     *
     * @param args строковая переменная для ввода данных.
     */
    public static void main(String[] args) {
        int[] phoneNumberArray = {0, 2, 9, 3, 3, 0, 8, 6, 9, 2};
        String str = createPhoneNumber(phoneNumberArray);
        System.out.println(str);
    }
    
    /**
     * Преобразует массив из 10 цифр (от 0 до 9)
     * в строку с заданным форматом.
     *
     * @param numbers массив цифр от 0 до 9
     * @return строка цифр с исходной последовательностью
     * и с форматированием типа (XXX) XXX-XXXX
     */
    static String createPhoneNumber(int[] numbers) {
        int ASCII_NUMBERS_SHIFT = 48;
        char[] ch = new char[14];
        int j = 0;
        for (int i = 0; i < 14; i++) {
            switch (i) {
                case 0:
                    ch[i] = '(';
                    break;
                case 4:
                    ch[i] = ')';
                    break;
                case 5:
                    ch[i] = ' ';
                    break;
                case 9:
                    ch[i] = '-';
                    break;
                default:
                    ch[i] = (char) (numbers[j] + ASCII_NUMBERS_SHIFT);
                    j++;
                    break;
            }
        }
        String str = new String(ch);
        return str;
    }
}
