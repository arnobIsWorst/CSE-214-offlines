package offline_2nd_revised.factory;

import offline_2nd_revised.product.*;

public class Savings extends Operations{
    public Savings(String accNumber,double price) {
        super(accNumber,price);
    }

    public void createRegularAccount(){
        this.instance = new Regular(Rate.REGULAR.getSavingRate());
    }

    public void createPremiumAccount(){
        this.instance = new Premium(Rate.PREMIUM.getSavingRate());
    }

    public void createVipAccount(){
        this.instance = new Vip(Rate.VIP.getSavingRate());
    }

    public double calculateInterest(double time) {
        return this.amount * this.instance.getInterestRate() * time / 100;
    }
    
    @Override
    public String toString() {
        return "This is a Savings account.";
    }
}
