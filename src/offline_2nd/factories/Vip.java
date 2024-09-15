package offline_2nd.factories;
import offline_2nd.products.Loan;
import offline_2nd.products.Savings;

public class Vip extends Customer {
    public Vip(String accNumber) {
        super(accNumber);
    }

    public void createSavingAccounts() {
        instance = new Savings(this.accountNumber);
        instance.setInterestRate(Rate.VIP.getSavingRate());
    }

    public void createLoanAccounts() {
        instance = new Loan(this.accountNumber);
        instance.setInterestRate(Rate.VIP.getLoanRate());
    }
}
