package collections;

import collections.dto.Passport;
import collections.utils.RandomString;

import java.util.HashSet;
import java.util.Set;

public class SetMain3 {
    
    public static void main(String[] args) {
        Set<Passport> passports = new HashSet<>();
        Passport passport1 = new Passport(RandomString.nextString(15),
                "id1234567890",
                RandomString.nextString(9));
        passports.add(passport1);
        passports.add(passport1);
        passports.add(passport1);
        for (Passport passport : passports) {
            System.out.println(passport.toString());
        }
    }
}
