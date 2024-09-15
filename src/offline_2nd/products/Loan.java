package offline_2nd.products;

public class Loan extends Accounts {
    
    public Loan(String accountNumber) {
        super(accountNumber);
        System.out.println("Loan Account Created");
    }

    public double calculateInterest(double time) {
        return this.amount * Math.pow((1 + (this.interestRate/100)), time) - this.amount;
    }
    
}