package repeats;

import java.util.Arrays;
import java.util.Random;

public class ArrayMain1 {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(10);
        }
        System.out.println("init array");
        for (int value : array) {
            System.out.println(value);
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            array[i] += 10;
        }
        System.out.println("new array");
        System.out.println(Arrays.toString(array));
    }
}
