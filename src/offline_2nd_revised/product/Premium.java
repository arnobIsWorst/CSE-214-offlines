package offline_2nd_revised.product;

public class Premium extends Customer{
    public Premium(double rate) {
        super(rate);
    }
    
    @Override
    public String toString() {
        return "This is a Premium account.";
    }
}
