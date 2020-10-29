package streamapi;

import generics.Generator;

import java.util.Random;
import java.util.stream.Stream;

public class StreamMain2 {
    public static void main(String[] args) {
       final Random random = new Random();
        Stream
            .generate(() -> random.nextInt(255)).limit(100)
            .filter(intValue -> intValue != 0)
            .map(intValue -> (char) intValue.intValue())
            .peek(Generator::lllllll)
//            .count();     //завершающая операция
            ;
    }
}
