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
 * @version 1.00 28.09.2020
 * @author Сергей Шпаковский
 */
public class TimeInWords {

    /**
     * Точка входа и проверка работы методов.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(toString(321504600));
        System.out.println(toString(789014010));
        System.out.println(toString(223));
        System.out.println(toString(-15));
        System.out.println(toString(0));
    }

    // 1.1 В данном методе произвести конвертацию переданного
    // числа в число прописью. Числа от - 999 999 999 до 999 999 999
    // 1.2 Пример передали: 223. Получили "Двести двадцать три"
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
            if (i != 0) {
                stringBuilder.append(" ");
            }
        }
        String buffer = stringBuilder.toString();
        if (buffer.equals("")) {
            buffer = "ноль";
        }
        String result = buffer.substring(0, 1).toUpperCase()
            +  buffer.substring(1);
        return result;
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




}
