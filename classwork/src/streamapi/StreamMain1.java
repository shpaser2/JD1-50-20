package streamapi;

import java.util.stream.IntStream;

public class StreamMain1 {
    public static void main(String[] args) {
        double count = IntStream
                .range(1, 100)
//                .peek(System.out::println)
                .limit(10)
                .peek((number) -> {
                    System.out.println("limit: " + number);
                })
                .filter((number) -> {
                    return number % 2 == 0;
                })
                .peek((number) -> {
                    System.out.println("filter: " + number);
                })
                .average().orElse(0);

        System.out.println(count);
    }
}
