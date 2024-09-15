package offline_2nd.products;

public class Savings extends Accounts {

    public Savings(String accountNumber) {
        super(accountNumber);
        System.out.println("Savings Account Created");
    }

    public double calculateInterest(double time) {
        return this.amount * this.interestRate * time / 100;
    }
}
