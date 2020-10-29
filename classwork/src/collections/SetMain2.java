package collections;

import collections.dto.Passport;
import collections.utils.AnyRandom;

import java.util.HashSet;
import java.util.Set;

public class SetMain2 {
    public static void main(String[] args) {
        Set<Passport> passports = new HashSet<>();
        passports.add(new Passport(AnyRandom.nextString(15),
                                    "1234567890",
                                    AnyRandom.nextString(9)
                                )
        );
        passports.add(new Passport(AnyRandom.nextString(15),
                    "1234567890",
                        AnyRandom.nextString(9)
                )
        );
        passports.add(new Passport(AnyRandom.nextString(15),
                    "1234567890",
                        AnyRandom.nextString(9)
                )
        );
        passports.add(new Passport(AnyRandom.nextString(15),
                    "1234567890",
                        AnyRandom.nextString(9)
                )
        );

        for (Passport passport : passports) {
            System.out.println(passport);
        }
    }
}
