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
package homework3;

import oop.calc.dto.ICalc;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This class can calc mathematical expression in string
 * and shows the result in double.
 * Acceptable operators - * / + - ^ and ( ).
 * Acceptable constants - PI, E.
 * Numbers - any not negative integer or float.
 *
 * @version   1.0 09.10.2020
 * @author    Сергей Шпаковский
 */
public class StringCalc {
    private Calculator calc;

    public StringCalc(Calculator calc) {
        this.calc = calc;
    }

    /**
     * Entrance point.
     */
    public void solveEquation(String str) {

        //str -> char array -> replace in char array PI by 3.142 ->
        //-> replace in char array E by 2.718 -> char array back to str
        str = str.replaceAll("\\s+","");
        ArrayList<Character> charList = stringToCharacterList(str);

        for (int i = 0; i < charList.size() - 1; i++) {
            if (charList.get(i).equals('P') && charList.get(i + 1).equals('I')) {
                insertPI(charList, i);
            }
        }
        for (int i = 0; i < charList.size() - 1; i++) {
            if (charList.get(i).equals('E')) {
                insertE(charList, i);
            }
        }
        str = getStringFromCharacterList(charList);
        ArrayList<String> arrStr = parseEquation(str);
        calcAll(arrStr);
        System.out.println("Result: ");
        print(arrStr);
    }

    private String getStringFromCharacterList(
            ArrayList<Character> list) {
        StringBuilder builder = new StringBuilder(list.size());
        for (Character ch: list) {
            builder.append(ch);
        }
        return builder.toString();
    }
    
    private void insertPI(ArrayList<Character> charList,
                                 int startIndex) {
        charList.set(startIndex, '3');
        charList.set(startIndex + 1, '.');
        charList.add(startIndex + 2, '1');
        charList.add(startIndex + 3, '4');
        charList.add(startIndex + 4, '2');
    }
    
    private void insertE(ArrayList<Character> charList,
                                 int startIndex) {
        charList.set(startIndex, '2');
        charList.add(startIndex + 1, '.');
        charList.add(startIndex + 2, '7');
        charList.add(startIndex + 3, '1');
        charList.add(startIndex + 4, '8');
    }
    
    private ArrayList<Character> stringToCharacterList(String str) {
        if ( str == null ) {
            return null;
        }
        int len = str.length();
        ArrayList<Character> array = new ArrayList<>(len);
        for (int i = 0; i < len ; i++) {
            array.add(str.charAt(i));
        }
        return array;
    }
    
    /**
     * It prints
     * mathematical expression as is.
     * @param arrStr arrayList with
     * mathematical expression.
     */
    private void print(ArrayList<String> arrStr) {
        for (String s : arrStr) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
    
    /**
     * It parses
     * mathematical expression to array with operators and numbers.
     * @param str String with mathematical expression.
     * @return  ArrayList with operators and numbers.
     */
    private ArrayList<String> parseEquation(String str) {
        ArrayList<String> arrStr = new ArrayList<>();
        Scanner buf = new Scanner(str);
        Pattern pattern = Pattern.compile(
            "[\\d]+\\.?[\\d]*|\\+|-|\\*|/|[)]|[(]|[\\^]");
        String result;
        do {
            result = buf.findInLine(pattern);
            if (result != null) {
                arrStr.add(result);
            }
        } while (result != null);
        return arrStr;
    }
    
    /**
     * It calcs any mathematical expression from console input with
     * + - / * ^ operators, integer and float digits,
     * brackets '(' and ')'.
     * @param allStr arrayList with mathematical expression to calc.
     */
    private void calcAll(ArrayList<String> allStr) {
        if (allStr.size() == 0) {
            System.out.println("Wrong mathematical expression length!");
            return;
        }
        int startIndex = 0;
        int stopIndex = 0;
        do {
            stopIndex = allStr.indexOf(")");
            if (stopIndex > 0) {
                for (int i = stopIndex - 1; i >= 0; i--) {
                    if (allStr.get(i).equals("(")) {
                        startIndex = i;
                        break;
                    }
                }
                calcPart(startIndex, stopIndex, allStr, true);
                allStr.remove(startIndex);
                allStr.remove(startIndex + 1);
                print(allStr);
                startIndex = 0;
            } else if (stopIndex < 0 && allStr.size() > 2) {
                startIndex = 0;
                stopIndex = allStr.size() - 1;
                calcPart(startIndex, stopIndex, allStr, false);
            }
        } while (stopIndex != -1);
    }
    
    /**
     * It calculates any part in brackets or
     * mathematical expression without them.
     * @param start index of beginning for calculation
     *              in main string array of mathematical expression.
     * @param stop  index of end for calculation
     *              in main string array of mathematical expression.
     * @param allStr string arrayList of all mathematical expression.
     * @param borders is brackets as borders in calculated part?
     */
    private void calcPart(int start, int stop, ArrayList<String> allStr,
                          boolean borders) {
        if (stop == 0) {
            System.out.println("Wrong ) in mathematical expression!");
            return;
        }
        double result = 0;
        int i = borders? start + 1 : start;
        for (; i < stop; i++) {
            if (allStr.get(i).equals("^")) {
                result = this.calc.powerDouble(
                    Double.parseDouble(allStr.get(i - 1)),
                    (int)Double.parseDouble(allStr.get(i + 1)));
                allStr.set(i - 1, String.format(Locale.ROOT, "%.3f", result));
                allStr.remove(i);
                allStr.remove(i);
                i = borders ? start + 1 : start;
                stop -= 2;
            }
        }

        result = 0;
        i = borders? start + 1 : start;
        for (; i < stop; i++) {
            if (allStr.get(i).equals("*")) {
                result = this.calc.multiplication(
                        Double.parseDouble(allStr.get(i - 1)),
                        Double.parseDouble(allStr.get(i + 1)));
                allStr.set(i - 1, String.format(Locale.ROOT, "%.3f", result));
                allStr.remove(i);
                allStr.remove(i);
                i = borders ? start + 1 : start;
                stop -= 2;
            } else if (allStr.get(i).equals("/")) {
                result = this.calc.division(
                    Double.parseDouble(allStr.get(i - 1)),
                    Double.parseDouble(allStr.get(i + 1)));
                allStr.set(i - 1, String.format(Locale.ROOT, "%.3f", result));
                allStr.remove(i);
                allStr.remove(i);
                i = borders ? start + 1 : start;
                stop -= 2;
            }
        }
    
        result = 0;
        i = borders? start + 1 : start;
        for (; i < stop; i++) {
            if (allStr.get(i).equals("+")) {
                result = this.calc.addition(
                    Double.parseDouble(allStr.get(i - 1)),
                    Double.parseDouble(allStr.get(i + 1)));
                allStr.set(i - 1, String.format(Locale.ROOT, "%.3f", result));
                allStr.remove(i);
                allStr.remove(i);
                i = borders? start + 1 : start;
                stop -= 2;
            } else if (allStr.get(i).equals("-")) {
                result = this.calc.subtraction(
                    Double.parseDouble(allStr.get(i - 1)),
                    Double.parseDouble(allStr.get(i + 1)));
                allStr.set(i - 1, String.format(Locale.ROOT, "%.3f", result));
                allStr.remove(i);
                allStr.remove(i);
                i = borders? start + 1 : start;
                stop -= 2;
            }
        }
    }
}
