package offline_2nd.products;

public abstract class Accounts {
    public double interestRate ;
    public String accountNumber;
    public double amount;

    public Accounts(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public abstract double calculateInterest(double time);
}