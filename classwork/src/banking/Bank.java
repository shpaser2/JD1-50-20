package banking;

import java.math.BigDecimal;
import java.util.*;

public class Bank implements IBank{
    private final String name;
    private Map<Person, List<Account>> data = new HashMap<>();

    public Bank(String name) {
        this.name = name;
    }

    public void addClient(Person p) throws IllegalArgumentException{
        if(!data.containsKey(p)){
            data.put(p, new ArrayList<>());
        } else {
            throw new IllegalArgumentException("Клиент уже имеет счета в банке");
        }
    }

    public Account createAccountForPerson(Person p, double startAmount){
        Account account = new Account(UUID.randomUUID().toString(), startAmount);
        addAccount(p, account);

        return account;
    }

    private void addAccount(Person p, Account account) throws IllegalArgumentException{
        try {
            this.addClient(p);
        } catch (IllegalArgumentException ignored){
            //У пользователя уже есть учетка
        }
        //TODO проверить что счета с таким номером в банке больше уже нет
        List<Account> accounts = this.data.get(p);
        accounts.add(account);
    }

    public void delClient(Person p) throws IllegalStateException{
        if(!data.containsKey(p)){
            throw new IllegalArgumentException(String.format("Данный человек не имеет счетов в банке %s", this.name));
        } else {
            //TODO Впилить проверку что нельзя удалить клиента пока у него есть деньги на счету
            data.remove(p);
        }
    }

    public void transfer(final Account from, final Account to, double sum){
        synchronized (from){
            synchronized (to){
                if(from.getBalance() > sum){
                    from.withdraw(sum);
                    to.deposit(sum);
                }
            }
        }
    }

    public String getName() {
        return name;
    }
}
