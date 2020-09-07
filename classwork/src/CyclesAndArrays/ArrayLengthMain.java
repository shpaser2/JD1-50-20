package CyclesAndArrays;

import java.util.Arrays;
import java.util.Random;

public class ArrayLengthMain {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random rand = new Random();
        //чтобы сгенерировать for c i достаточно набрать array.fori
        // + нажать Enter
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(10);
        }
        System.out.println("Initial array:");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            array[i] += 10;
        }
        System.out.println("new array:");
        //вариант вывода массива
        System.out.println(Arrays.toString(array));
//        for (int value : array) {
//            System.out.println(value + " ");
//        }
    }
}
