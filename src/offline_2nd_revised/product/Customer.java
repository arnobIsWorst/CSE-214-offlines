package offline_2nd_revised.product;

public class Customer{
    protected double interestRate;

    public Customer(double rate){
        this.interestRate = rate;
    }

    public void setInterestRate(double rate){
        this.interestRate = rate;
    }

    public double getInterestRate(){
        return interestRate;
    }
}
