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
        //better for less ROM usage (can be used
        // when getAllPassports called seldom.
//        Bank bank = new Bank(new MapBankStorage());
        
        //better for RAM when getAllPassports called often.
        Bank bank = new Bank(new MapBankStorageNew());
        
//        //describe what you want to do with bank
//        bank.saveNewClient(passport);
//
//        bank.getClient(id);
//
//        bank.getPassportsByClientId(id);
//
//        bank.getPassports();
//        //firstly separate unique and not unique data in business logic
//        //Second: all that we do must have interface.
//        // For example usage must be through interface layer.
    
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
