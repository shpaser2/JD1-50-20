package CyclesAndArrays;

public class ArraysMain1 {
    public static void main(String[] args) {
        int values[] = new int[10];       //do same
        int []valuesUsed = new int[10];       //do same
        int[][] array = {{1,2}, {3,4},{5,6}};
        for (int[] subArray:array) {
            for (int element:subArray) {
                System.out.println(element);
            }
        }
    }
}
