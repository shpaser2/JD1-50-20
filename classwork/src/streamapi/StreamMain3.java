package streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamMain3 {
    public static void main(String[] args) {
       final Random random = new Random();

       List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 10_000; i++) {
            persons.add(new Person(String.valueOf(random.nextInt())));
        }

        long count = persons.stream()
                .filter(person -> person.getPassword().length() >= 10)
                .count();

        List<Person> collect = persons.stream()
                .filter(person -> person.getPassword().length() >= 10)
                .collect(Collectors.toList());

        System.out.println(count);
        System.out.println(collect.size());
        System.out.println(persons.size());
    }
}
