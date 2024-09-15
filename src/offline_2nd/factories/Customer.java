package offline_2nd.factories;

import offline_2nd.products.Accounts;

enum Rate{
    VIP(10,5), REGULAR(14,2.5), PREMIUM(12,3.5);
    private double loanRate;
    private double savingRate;

    Rate(double loanRate, double savingRate){
        this.loanRate = loanRate;
        this.savingRate = savingRate;
    }

    public double getLoanRate(){
        return loanRate;
    }

    public void setLoanRate(double loanRate){
        this.loanRate = loanRate;
    }

    public double getSavingRate(){
        return savingRate;
    }

    public void setSavingRate(double savingRate){
        this.savingRate = savingRate;
    }
}

public abstract class Customer {
    public String accountNumber;
    public Accounts instance;

    public Customer(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public Accounts getAccountInstance(){
        return instance;
    }

    public abstract void createSavingAccounts();

    public abstract void createLoanAccounts();
}