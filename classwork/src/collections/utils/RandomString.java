package collections.utils;

import java.util.Random;

/**
 * 1 Cyrillic
 * 2 Latin
 * 3 Big letters
 * 4 Small letters
 *
 * one big string, random and one parameter
 */
public class RandomString {
    private final static Random rnd = new Random();
    // ABCD = 65 + 25
    // abcd = 97 + 25
    // АБВГ = 1040 + 31
    // абвг = 1072 + 31
    private final static int latinLength = 25;
    private final static int offsetABCD = 65;
    private final static int offsetAbcd = 97;
    private final static int cyrillicLength = 31;
    private final static int cyrillicBigOffset = 1040;
    private final static int cyrillicSmallOffset = 1072;
    
    public static String nextString(int length) {
        boolean isBigChar = false;
        boolean isCyrillicChar = false;
        int[][] params = new int[length][2];
        for (int i = 0; i < length; i++) {
            isBigChar = rnd.nextInt(10) % 2 == 1;
            isCyrillicChar = rnd.nextInt(10) % 2 == 1;
            if (isCyrillicChar) {
                params[i][0] = cyrillicLength;
                if (isBigChar) {
                    params[i][1] = cyrillicBigOffset;
                } else {
                    params[i][1] = cyrillicSmallOffset;
                }
            } else {
                params[i][0] = latinLength;
                if (isBigChar) {
                    params[i][1] = offsetABCD;
                } else {
                    params[i][1] = offsetAbcd;
                }
            }
        }
        return RandomString.makeStringWithParams(rnd, length, params);
    }
    
    private static String makeStringWithParams(Random rnd, int length,
                                        int[][] params) {
        char[] chArr = new char[length];
        for (int i = 0; i < chArr.length; i++) {
            chArr[i] = (char) (params[i][1] + rnd.nextInt(params[i][0] + 1));
        }
        return new String(chArr);
    }
}
