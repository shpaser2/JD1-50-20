package collections;

import collections.dto.Passport;
import collections.utils.RandomString;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SetMain2 {
    
    public static void main(String[] args) {
        //randomString test
//        System.out.println(RandomString.nextString(10));
        
        Set<Passport> passports = new HashSet<>();
        passports.add(new Passport(RandomString.nextString(15),
                    RandomString.nextString(10),
                    RandomString.nextString(9)));
        passports.add(new Passport(RandomString.nextString(15),
                RandomString.nextString(10),
                RandomString.nextString(9)));
        passports.add(new Passport(RandomString.nextString(15),
                RandomString.nextString(10),
                RandomString.nextString(9)));
        passports.add(new Passport(RandomString.nextString(15),
                RandomString.nextString(10),
                RandomString.nextString(9)));
        for (Passport passport : passports) {
            System.out.println(passport.toString());
        }
    
//        unique by java, not unique by business
        passports.add(new Passport(RandomString.nextString(15),
                "id1234567890",
                RandomString.nextString(9)));

        passports.add(new Passport(RandomString.nextString(15),
                "id1234567890",
                RandomString.nextString(9)));

        passports.add(new Passport(RandomString.nextString(15),
                "id1234567890",
                RandomString.nextString(9)));

        passports.add(new Passport(RandomString.nextString(15),
                "id1234567890",
                RandomString.nextString(9)));
        for (Passport passport : passports) {
            System.out.println(passport.toString());
        }
    
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
