package collections;

import collections.dto.Passport;
import collections.dto.PassportIdUnique;
import collections.utils.AnyRandom;

import java.util.HashSet;
import java.util.Set;

public class SetMain4 {
    public static void main(String[] args) {
        Set<PassportIdUnique> passports = new HashSet<>();
        passports.add(new PassportIdUnique(AnyRandom.nextString(15),
                        "1234567890",
                        AnyRandom.nextString(9)
                )
        );
        passports.add(new PassportIdUnique(AnyRandom.nextString(15),
                        "1234567890",
                        AnyRandom.nextString(9)
                )
        );
        passports.add(new PassportIdUnique(AnyRandom.nextString(15),
                        "1234567890",
                        AnyRandom.nextString(9)
                )
        );
        passports.add(new PassportIdUnique(AnyRandom.nextString(15),
                        "1234567890",
                        AnyRandom.nextString(9)
                )
        );

        for (PassportIdUnique passport : passports) {
            System.out.println(passport);
        }
    }
}
