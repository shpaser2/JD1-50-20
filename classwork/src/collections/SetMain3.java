package collections;

import collections.dto.Passport;
import collections.utils.AnyRandom;

import java.util.HashSet;
import java.util.Set;

public class SetMain3 {
    public static void main(String[] args) {
        Set<Passport> passports = new HashSet<>();
        Passport passport1 = new Passport(AnyRandom.nextString(15),
                "1234567890",
                AnyRandom.nextString(9)
        );
        passports.add(passport1);
        passports.add(passport1);
        passports.add(passport1);
        passports.add(passport1);

        for (Passport passport : passports) {
            System.out.println(passport);
        }
    }
}
