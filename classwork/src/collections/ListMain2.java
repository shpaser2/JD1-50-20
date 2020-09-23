package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListMain2 {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
//        Random rnd = new Random();
        for (int i = 0; i < 1000; i++) {
            data.add(i);
        }

        List<Integer> dataCopy1 = data.subList(0, 100);
        List<Integer> dataCopy2 = data.subList(100, 500);
        List<Integer> dataCopy3 = data.subList(500, 1000);

//        for (int i = 0; i < dataCopy1.size(); i++) {
//            System.out.print("i = " + i + ", ");
//            System.out.println(data.get(i) == dataCopy1.get(i));
//        }
//
//        for (int i = 100; i < 100 + dataCopy2.size(); i++) {
//            System.out.print("i = " + i + ", ");
//            System.out.println(data.get(i) == dataCopy2.get(i - 100));
//        }
//
//        for (int i = 500; i < 500 + dataCopy3.size(); i++) {
//            System.out.print("i = " + i + ", ");
//            System.out.println(data.get(i) == dataCopy3.get(i - 500));
//        }

        for (int i = 0; i < dataCopy2.size(); i++) {
            System.out.print("i = " + i + ", ");
            System.out.println(data.get(i) == dataCopy2.get(i));
        }

    }
}
