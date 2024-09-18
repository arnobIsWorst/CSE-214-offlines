package offline_2nd_revised.factory;

import offline_2nd_revised.product.*;

public class Loan extends Operations{
    public Loan(String accNumber,double price) {
        super(accNumber,price);
    }

    public void createRegularAccount(){
        this.instance = new Regular(Rate.REGULAR.getLoanRate());
    }

    public void createPremiumAccount(){
        this.instance = new Premium(Rate.PREMIUM.getLoanRate());
    }

    public void createVipAccount(){
        this.instance = new Vip(Rate.VIP.getLoanRate());
    }

    public double calculateInterest(double time) {
        return this.amount * Math.pow((1 + (this.instance.getInterestRate()/100)), time) - this.amount;
    }
}
