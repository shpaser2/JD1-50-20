package collections.utils;

import java.util.Random;

public class AnyRandom {
    private static final char[] allLetters = ("qwertyuiopasdfghjklzxcvbnm" +
                                        "QWERTYUIOPASDFGHJKLZXCVBNM" +
                                      "йцукенгшщзхъфывапролджэячсмитьбю" +
                                        "ЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ").toCharArray();
    private static final Random random = new Random();

    public static String nextString(int length) {
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append(allLetters[random.nextInt(allLetters.length)]);
        }
        return builder.toString();
    }
}
