package collections.service;

import collections.dto.Client;
import collections.dto.Passport;

import java.util.List;

public class Bank {
    private IBankStorage storage;

    public Bank(IBankStorage storage) {
        this.storage = storage;
    }

    public void saveNewClient(Passport passport){
        this.storage.saveNewClient(passport);
    }

    public Client getClient(String id){
        return this.storage.getClient(id);
    }

    public List<Passport> getPassportsByClientId(String id){
        return this.storage.getPassportsByClientId(id);
    }

    public List<Passport> getPassports(){
        return this.storage.getPassports();
    }
}
