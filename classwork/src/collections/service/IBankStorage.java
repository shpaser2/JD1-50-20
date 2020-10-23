package collections.service;

import collections.dto.Client;
import collections.dto.Passport;

import java.util.List;

//Not to be implemented in Bank, because Bank manipulates data,
//not storage it.
public interface IBankStorage {
    void saveNewClient(Passport passport);

    Client getClient(String id);

    List<Passport> getPassportsByClientId(String id);


    List<Passport> getPassports();
}
