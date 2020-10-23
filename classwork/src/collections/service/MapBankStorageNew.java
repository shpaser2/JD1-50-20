package collections.service;

import collections.dto.Client;
import collections.dto.Passport;

import java.util.*;

public class MapBankStorageNew implements IBankStorage{
    private Map<String, Client> clients = new HashMap<>();
    private Map<String, List<Passport>> passports = new HashMap<>();
    private List<Passport> allPassports = new LinkedList<>();

    @Override
    public void saveNewClient(Passport passport) {
        this.clients.put(passport.getId(), new Client(passport));
        this.passports.put(passport.getId(), Arrays.asList(passport));
        this.allPassports.add(passport);
    }

    @Override
    public Client getClient(String id) {
        return this.clients.get(id);
    }

    @Override
    public List<Passport> getPassportsByClientId(String id) {
        return this.passports.get(id);
    }

    @Override
    public List<Passport> getPassports() {
        return this.allPassports;
    }
}
