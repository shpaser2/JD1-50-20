package collections.service;

import collections.dto.Client;
import collections.dto.Passport;

import java.util.*;

public class MapBankStorage implements IBankStorage{
    private Map<String, Client> clients = new HashMap<>();
    private Map<String, List<Passport>> passports = new HashMap<>();

    @Override
    public void saveNewClient(Passport passport) {
        this.clients.put(passport.getId(), new Client(passport));
        this.passports.put(passport.getId(), Arrays.asList(passport));
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
        List<Passport> tmp = new LinkedList<>();
        Collection<List<Passport>> values = this.passports.values();
        for (List<Passport> value : values) {
//            tmp.addAll(value);
            for (Passport passport : value) {
                tmp.add(passport);
            }
        }

        return tmp;
    }
}
