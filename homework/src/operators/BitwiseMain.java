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
 * Класс, показывающий применение всех побитовых операторов
 * с отрицательными и положительными числами.
 *
 * @version   1.00 29.08.2020
 * @author    Сергей Шпаковский
 */
public class BitwiseMain {
    
    /**
     * Точка входа и вызова всех функций с побитовыми операторами.
     *
     * @param args - передаваемые строкой параметры с консоли
     */
    public static void main(String[] args) {
        /*
         * Комментарии с числами в двоичном виде смотреть
         * в документации к вызываемым методам.
         */
        
        int firstPositive = 42;
        int secondPositive = 15;
        int firstNegative = -42;
        int secondNegative = -15;
        
        BitwiseMain Example = new BitwiseMain();
        
        Example.showBitwiseNotResult(firstPositive, secondPositive);
        Example.showBitwiseAndResult(firstPositive,secondPositive);
        Example.showBitwiseAndEqualResult(firstPositive, secondPositive);
        Example.showBitwiseOrResult(firstPositive, secondPositive);
        Example.showBitwiseOrEqualResult(firstPositive, secondPositive);
        Example.showBitwiseXOrResult(firstPositive, secondPositive);
        Example.showBitwiseXOrEqualResult(firstPositive, secondPositive);
        Example.showBitwiseRightShift(firstPositive, secondPositive);
        Example.showBitwiseRightShiftEqual(firstPositive, secondPositive);
        Example.showBitwiseRightShiftWithZero(firstPositive, secondPositive);
        Example.showBitwiseLeftShift(firstPositive, secondPositive);
        Example.showBitwiseLeftShiftEqual(firstPositive, secondPositive);
        Example.showBitwiseRightShiftZeroEqual(firstPositive, secondPositive);
    
        Example.showBitwiseNotResult(firstNegative, secondNegative);
        Example.showBitwiseAndResult(firstNegative,secondNegative);
        Example.showBitwiseAndEqualResult(firstNegative, secondNegative);
        Example.showBitwiseOrResult(firstNegative, secondNegative);
        Example.showBitwiseOrEqualResult(firstNegative, secondNegative);
        Example.showBitwiseXOrResult(firstNegative, secondNegative);
        Example.showBitwiseXOrEqualResult(firstNegative, secondNegative);
        Example.showBitwiseRightShift(firstNegative, secondNegative);
        Example.showBitwiseRightShiftEqual(firstNegative, secondNegative);
        Example.showBitwiseRightShiftWithZero(firstNegative, secondNegative);
        Example.showBitwiseLeftShift(firstNegative, secondNegative);
        Example.showBitwiseLeftShiftEqual(firstNegative, secondNegative);
        Example.showBitwiseRightShiftZeroEqual(firstNegative, secondNegative);
    }
    
    /**
     * Применяет побитовый унарный оператор NOT ~.
     *
     * В двоичном виде для чисел 42 и 15:
     * 0010 1010‬ и 0000 1111
     * Результаты для них:
     * 1101 0101‬ и 1111 0000  (-43 и -16)
     *
     * В двоичном виде для чисел -42 и -15:
     * 1101 0110‬‬ и 1111 0001
     * Результат для них:
     * 0010 1001 и 0000 1110‬ (41 и 14)
     *
     * @param numberOne
     *          первое число для применения побитового оператора
     * @param numberTwo
     *          второе число для применения побитового оператора
     */
    private void showBitwiseNotResult(int numberOne, int numberTwo) {
        int notOne = ~numberOne;
        int notTwo = ~numberTwo;
        System.out.println("NOT " + numberOne + " is " + notOne);
        System.out.println("NOT " + numberTwo + " is " + notTwo);
    }
    
    /**
     * Применяет побитовое AND между двумя числами.
     *
     * В двоичном виде для чисел 42 и 15:
     * 0010 1010‬ и 0000 1111
     * Результат для них:
     * 0000 1010  (10)
     *
     * В двоичном виде для чисел -42 и -15:
     * 1101 0110‬‬ и 1111 0001
     * Результат для них:
     * 1101 0000 (-48)
     *
     * @param numberOne
     *          первое число для применения побитового оператора
     *          одновременно со вторым числом.
     * @param numberTwo
     *          второе число для применения побитового оператора
     *          одновременно со первым числом.
     */
    private void showBitwiseAndResult(int numberOne, int numberTwo) {
        int andResult = numberOne & numberTwo;
        System.out.println("Bitwise AND between " + numberOne + " and "
                + numberTwo + " is " + andResult);
    }
    
    /**
     * Применяет побитовое AND с присваиванием между двумя числами.
     *
     * В двоичном виде для чисел 42 и 15:
     * 0010 1010‬ и 0000 1111
     * Результат для них:
     * 0000 1010  (10)
     *
     * В двоичном виде для чисел -42 и -15:
     * 1101 0110‬‬ и 1111 0001
     * Результат для них:
     * 1101 0000 (-48)
     *
     * @param numberOne
     *          первое число для применения побитового оператора
     * @param numberTwo
     *          второе число для применения побитового оператора
     */
    private void showBitwiseAndEqualResult(int numberOne, int numberTwo) {
        int andEqualBothNumbers = numberOne;
        andEqualBothNumbers &= numberTwo;
        System.out.println("Result of " + numberOne + " &= " + numberTwo
                + " is " + andEqualBothNumbers);
    }
    
    /**
     * Применяет побитовое OR между двумя числами.
     *
     * В двоичном виде для чисел 42 и 15:
     * 0010 1010‬ и 0000 1111
     * Результат для них:
     * 0010 1111  (47)
     *
     * В двоичном виде для чисел -42 и -15:
     * 1101 0110‬‬ и 1111 0001
     * Результат для них:
     * 1111 0111 (-9)
     *
     * @param numberOne
     *          первое число для применения побитового оператора.
     * @param numberTwo
     *          второе число для применения побитового оператора.
     */
    private void showBitwiseOrResult(int numberOne, int numberTwo) {
        int result = numberOne | numberTwo;
        System.out.println("Result of " + numberOne + " | " + numberTwo
                + " is " + result);
    }
    
    /**
     * Применяет побитовое OR с присваиванием между двумя числами.
     *
     * В двоичном виде для чисел 42 и 15:
     * 0010 1010‬ и 0000 1111
     * Результат для них:
     * 0010 1111  (47)
     *
     * В двоичном виде для чисел -42 и -15:
     * 1101 0110‬‬ и 1111 0001
     * Результат для них:
     * 1111 0111 (-9)
     *
     * @param numberOne
     *          первое число для применения побитового оператора
     * @param numberTwo
     *          второе число для применения побитового оператора
     */
    private void showBitwiseOrEqualResult(int numberOne, int numberTwo) {
        int resultBothNumbers = numberOne;
        resultBothNumbers |= numberTwo;
        System.out.println("Result of " + numberOne + " |= " + numberTwo
                + " is " + resultBothNumbers);
    }
    
    /**
     * Применяет побитовое XOR между двумя числами.
     *
     * В двоичном виде для чисел 42 и 15:
     * 0010 1010‬ и 0000 1111
     * Результат для них:
     * 0010 0101  (37)
     *
     * В двоичном виде для чисел -42 и -15:
     * 1101 0110‬‬ и 1111 0001
     * Результат для них:
     * 0010 0111 (39)
     *
     * @param numberOne
     *          первое число для применения побитового оператора
     * @param numberTwo
     *          второе число для применения побитового оператора
     */
    private void showBitwiseXOrResult(int numberOne, int numberTwo) {
        int resultBothNumbers = numberOne ^ numberTwo;
        System.out.println("Result of " + numberOne + " ^ " + numberTwo
                + " is " + resultBothNumbers);
    }
    
    /**
     * Применяет побитовое XOR с присваиванием между двумя числами.
     *
     * В двоичном виде для чисел 42 и 15:
     * 0010 1010‬ и 0000 1111
     * Результат для них:
     * 0010 0101  (37)
     *
     * В двоичном виде для чисел -42 и -15:
     * 1101 0110‬‬ и 1111 0001
     * Результат для них:
     * 0010 0111 (39)
     *
     * @param numberOne
     *          первое число для применения побитового оператора
     * @param numberTwo
     *          второе число для применения побитового оператора
     */
    private void showBitwiseXOrEqualResult(int numberOne, int numberTwo) {
        int resultBothNumbers = numberOne;
        resultBothNumbers ^= numberTwo;
        System.out.println("Result of " + numberOne + " ^= " + numberTwo
                + " is " + resultBothNumbers);
    }
    
    /**
     * Применяет побитовый сдвиг вправо двух чисел на 1.
     *
     * В двоичном виде для чисел 42 и 15:
     * 0010 1010‬ и 0000 1111
     * Результат для них:
     * 0001 0101 и 0000 0111 (21 и 7)
     *
     * В двоичном виде для чисел -42 и -15:
     * 1101 0110‬‬ и 1111 0001
     * Результат для них:
     * 1110 1011 и 1111 1000 (-21 и -8)
     *
     * @param numberOne
     *          первое число для применения побитового оператора
     * @param numberTwo
     *          второе число для применения побитового оператора
     */
    private void showBitwiseRightShift(int numberOne, int numberTwo) {
        int resultFirstByOne = numberOne >> 1;
        int resultSecondByOne = numberTwo >> 1;
        System.out.println("Result of " + numberOne + " >> 1 "
                + " is " + resultFirstByOne);
        System.out.println("Result of " + numberTwo + " >> 1 "
                + " is " + resultSecondByOne);
    }
    
    /**
     * Применяет побитовый сдвиг вправо c присваиванием
     * двух чисел на 1.
     *
     * В двоичном виде для чисел 42 и 15:
     * 0010 1010‬ и 0000 1111
     * Результат для них:
     * 0001 0101 и 0000 0111 (21 и 7)
     *
     * В двоичном виде для чисел -42 и -15:
     * 1101 0110‬‬ и 1111 0001
     * Результат для них:
     * 1110 1011 и 1111 1000 (-21 и -8)
     *
     * @param numberOne
     *          первое число для применения побитового оператора
     * @param numberTwo
     *          второе число для применения побитового оператора
     */
    private void showBitwiseRightShiftEqual(int numberOne, int numberTwo) {
        int resultFirst = numberOne;
        int resultSecond = numberTwo;
        resultFirst >>= 1;
        resultSecond >>= 1;
        System.out.println("Result of " + numberOne + " >>= 1 "
                + " is " + resultFirst);
        System.out.println("Result of " + numberTwo + " >>= 1 "
                + " is " + resultSecond);
    }
    
    /**
     * Применяет побитовый сдвиг вправо c заполнением нулями
     * двух чисел на 1.
     *
     * В двоичном виде для чисел 42 и 15:
     * 0010 1010‬ и 0000 1111
     * Результат для них:
     * 0001 0101 и 0000 0111 (21 и 7)
     *
     * В двоичном виде для чисел -42 и -15:
     * 1101 0110‬‬ и 1111 0001
     * Результат для них:
     * 0111 1111 1111 1111 1111 1111 1110 1011 (2147483627) и
     * 0111 1111 1111 1111 1111 1111 1111 1000 (2147483640)
     *
     * @param numberOne
     *          первое число для применения побитового оператора
     * @param numberTwo
     *          второе число для применения побитового оператора
     */
    private void showBitwiseRightShiftWithZero(int numberOne, int numberTwo) {
        int resultFirst = numberOne >>> 1;
        int resultSecond = numberTwo >>> 1;
        System.out.println("Result of " + numberOne + " >>> 1 "
                + " is " + resultFirst);
        System.out.println("Result of " + numberTwo + " >>> 1 "
                + " is " + resultSecond);
    }
    
    /**
     * Применяет побитовый сдвиг влево двух чисел на 1.
     *
     * В двоичном виде для чисел 42 и 15:
     * 0010 1010‬ и 0000 1111
     * Результат для них:
     * 0101 0100 и 0001 1110 (84 и 30)
     *
     * В двоичном виде для чисел -42 и -15:
     * 1101 0110‬‬ и 1111 0001
     * Результат для них:
     * 1010 1100 и 1110 0010 (-84 и -30)
     *
     * @param numberOne
     *          первое число для применения побитового оператора
     * @param numberTwo
     *          второе число для применения побитового оператора
     */
    private void showBitwiseLeftShift(int numberOne, int numberTwo) {
        int resultFirst = numberOne << 1;
        int resultSecond = numberTwo << 1;
        System.out.println("Result of " + numberOne + " << 1 "
                + " is " + resultFirst);
        System.out.println("Result of " + numberTwo + " << 1 "
                + " is " + resultSecond);
    }
    
    /**
     * Применяет побитовый сдвиг влево на 1 двух чисел
     * c приравниванием.
     *
     * В двоичном виде для чисел 42 и 15:
     * 0010 1010‬ и 0000 1111
     * Результат для них:
     * 0101 0100 и 0001 1110 (84 и 30)
     *
     * В двоичном виде для чисел -42 и -15:
     * 1101 0110‬‬ и 1111 0001
     * Результат для них:
     * 1010 1100 и 1110 0010 (-84 и -30)
     *
     * @param numberOne
     *          первое число для применения побитового оператора
     * @param numberTwo
     *          второе число для применения побитового оператора
     */
    private void showBitwiseLeftShiftEqual(int numberOne, int numberTwo) {
        int resultFirst = numberOne;
        int resultSecond = numberTwo;
        resultFirst <<= 1;
        resultSecond <<= 1;
        System.out.println("Result of " + numberOne + " <<= 1 "
                + " is " + resultFirst);
        System.out.println("Result of " + numberTwo + " <<= 1 "
                + " is " + resultSecond);
    }
    
    /**
     * Применяет побитовый сдвиг вправо c приравниванием
     * c заполнением нулями двух чисел на 1.
     *
     * В двоичном виде для чисел 42 и 15:
     * 0010 1010‬ и 0000 1111
     * Результат для них:
     * 0001 0101 и 0000 0111 (21 и 7)
     *
     * В двоичном виде для чисел -42 и -15:
     * 1101 0110‬‬ и 1111 0001
     * Результат для них:
     * 0111 1111 1111 1111 1111 1111 1110 1011 (2147483627) и
     * 0111 1111 1111 1111 1111 1111 1111 1000 (2147483640)
     *
     * @param numberOne
     *          первое число для применения побитового оператора
     * @param numberTwo
     *          второе число для применения побитового оператора
     */
    private void showBitwiseRightShiftZeroEqual(int numberOne,
                                                int numberTwo) {
        int resultFirst = numberOne;
        int resultSecond = numberTwo;
        resultFirst >>>= 1;
        resultSecond >>>= 1;
        System.out.println("Result of " + numberOne + " >>>= 1 "
                + " is " + resultFirst);
        System.out.println("Result of " + numberTwo + " >>>= 1 "
                + " is " + resultSecond);
    }
}
