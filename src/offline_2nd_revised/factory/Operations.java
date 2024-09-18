package offline_2nd_revised.factory;

import offline_2nd_revised.product.Customer;

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

public abstract class Operations {
    protected String accountNumber;
    protected Customer instance;
    protected double amount;

    public Operations(String accountNumber, double amount){
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public Customer getAccountInstance(){
        return instance;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }

    public double getAmount(){
        return amount;
    }

    public abstract void createRegularAccount();
    public abstract void createPremiumAccount();
    public abstract void createVipAccount();
    public abstract double calculateInterest(double time);
}
