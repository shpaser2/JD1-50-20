package collections;

import collections.dto.Passport;
import collections.service.Bank;
import collections.service.Client;
import collections.service.Gender;
import collections.service.MapBankStorage;

import java.util.Date;
import java.util.List;

public class BankMain {
    public static void main(String[] args) {
        Bank bank = new Bank(new MapBankStorage());
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
        passport.setId("1234567890");
        passport.setName("Иван");
        passport.setNumber("21314135354124fdsffsd");
        passport.setGender(Gender.МУЖЧИНА);
        passport.setRegDate(new Date());
        passport.setStartDay(new Date());
        
        bank.saveNewClient(passport);
    
        Client client = bank.getClient("1234567890");
    
        System.out.println(client);
    
        List<Passport> passportsByClientId = bank.getPassportsByClientId(
                "1234567890");
    
        System.out.println(passportsByClientId.toString());
        
        List<Passport> passports = bank.getPassports();
    
        System.out.println(passports);
        
    }
}
