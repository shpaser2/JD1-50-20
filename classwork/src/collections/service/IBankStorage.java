package collections.service;

import collections.dto.Passport;
import java.util.List;

//Not to be implemented in Bank, because Bank manipulates data,
//not storage it.
public interface IBankStorage {
    
    public void saveNewClient(Passport passport);
    
    public Client getClient(String id);
    
    public List<Passport> getPassportsByClientId(String id);
    
    public List<Passport> getPassports();
}
