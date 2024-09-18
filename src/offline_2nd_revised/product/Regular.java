package offline_2nd_revised.product;

public class Regular extends Customer{
    public Regular(double rate) {
        super(rate);
    }
    
    @Override
    public String toString() {
        return "This is a Regular account.";
    }
}
