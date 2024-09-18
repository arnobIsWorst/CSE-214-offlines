package offline_2nd_revised.singleton;

import java.util.HashMap;
import offline_2nd_revised.factory.*;

public class Bank {
    private static volatile Bank instance;
    private HashMap<String, Operations> allAccounts;

    private Bank() {
        allAccounts = new HashMap<>();
        System.out.println("Banking system created");
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

    public Operations getAccount(String accountNumber) {
        return allAccounts.get(accountNumber);
    }

    public void addAccount(Operations account) {
        allAccounts.put(account.getAccountNumber(), account);
    }

    public Operations createSavingsAccount(String accountNumber, double amount) {
        Savings savings = new Savings(accountNumber, amount);
        return savings;
    }

    public Operations createLoanAccount(String accountNumber, double amount) {
        Loan loan = new Loan(accountNumber, amount);
        return loan;
    }

    public void createRegularAccount(Operations account) {
        account.createRegularAccount();
    }

    public void createPremiumAccount(Operations account) {
        account.createPremiumAccount();
    }

    public void createVipAccount(Operations account) {
        account.createVipAccount();
    }
}
