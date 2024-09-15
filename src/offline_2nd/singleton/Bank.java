package offline_2nd.singleton;

import java.util.HashMap;
import offline_2nd.products.Accounts;
import offline_2nd.factories.*;

public class Bank {
    private static volatile Bank instance;
    public HashMap<String, Customer> allAccounts;

    private Bank() {
        allAccounts = new HashMap<>();
        System.out.println("Bank instance created");
    }
    public static Bank getInstance() {
        Bank localInstance = instance;

        if (localInstance == null) {
            synchronized (Bank.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Bank();
                }
            }
        }
        return instance;
    }
    
    public boolean checkAccount(String accountNumber) {
        return allAccounts.containsKey(accountNumber);
    }

    public Accounts getAccount(String accountNumber) {
        return allAccounts.get(accountNumber).getAccountInstance();
    }

    public void addAccount(Customer account) {
        allAccounts.put(account.accountNumber, account);
    }

    public Customer createRegularAccount(String accountNumber) {
        return new Regular(accountNumber);
    }

    public Customer createVipAccount(String accountNumber) {
        return new Vip(accountNumber);
    }

    public Customer createPremiumAccount(String accountNumber) {
        return new Premium(accountNumber);
    }

    public Customer createSavingsAccount(Customer customer) {
        customer.createSavingAccounts();
        return customer;
    }

    public Customer createLoanAccount(Customer customer) {
        customer.createLoanAccounts();
        return customer;
    }
}
