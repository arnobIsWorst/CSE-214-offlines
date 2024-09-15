package offline_2nd.factories;
import offline_2nd.products.Loan;
import offline_2nd.products.Savings;

public class Regular extends Customer {
    public Regular(String accNumber) {
        super(accNumber);
    }

    public void createSavingAccounts() {
        instance = new Savings(this.accountNumber);
        instance.setInterestRate(Rate.REGULAR.getSavingRate());
    }

    public void createLoanAccounts() {
        instance = new Loan(this.accountNumber);
        instance.setInterestRate(Rate.REGULAR.getLoanRate());
    }
}
