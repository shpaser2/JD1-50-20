package collections.service;

import collections.dto.Client;
import collections.dto.Passport;

import java.util.List;

public interface IBankStorage {
    void saveNewClient(Passport passport);

    Client getClient(String id);

    List<Passport> getPassportsByClientId(String id);


    List<Passport> getPassports();
}
