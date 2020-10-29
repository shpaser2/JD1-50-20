package collections;

import collections.dto.Client;
import collections.dto.Gender;
import collections.dto.Passport;
import collections.service.Bank;
import collections.service.MapBankStorage;
import collections.service.MapBankStorageNew;

import java.util.Date;
import java.util.List;

public class BankMain {
    public static void main(String[] args) {
//        Bank bank = new Bank(new MapBankStorage());
        Bank bank = new Bank(new MapBankStorageNew());

        Passport passport = new Passport();
        passport.setId("123542678");
        passport.setName("Илья");
        passport.setNumber("ЬЗФЫВ12345");
        passport.setGender(Gender.МУЖЧИНА);
        passport.setStartDay(new Date());
        passport.setRegDate(new Date());

        bank.saveNewClient(passport);

        Client client = bank.getClient("123542678");

        System.out.println(client);

        List<Passport> passportsByClientId = bank.getPassportsByClientId("123542678");

        System.out.println(passportsByClientId);

        List<Passport> passports = bank.getPassports();

        System.out.println(passports);
    }
}
