package collections;

import collections.dto.Passport;
import collections.dto.PassportIdUnique;
import collections.utils.RandomString;

import java.util.HashSet;
import java.util.Set;

public class SetMain4 {
    
    public static void main(String[] args) {
        
        Set<PassportIdUnique> passports = new HashSet<>();
    
//        unique by java, not unique by business
//        - with new hash is equal to java too.
        passports.add(new PassportIdUnique(RandomString.nextString(15),
                "id1234567890",
                RandomString.nextString(9)));

        passports.add(new PassportIdUnique(RandomString.nextString(15),
                "id1234567890",
                RandomString.nextString(9)));

        passports.add(new PassportIdUnique(RandomString.nextString(15),
                "id1234567890",
                RandomString.nextString(9)));

        passports.add(new PassportIdUnique(RandomString.nextString(15),
                "id1234567890",
                RandomString.nextString(9)));
        for (PassportIdUnique passport : passports) {
            System.out.println(passport.toString());
        }
    }
}
