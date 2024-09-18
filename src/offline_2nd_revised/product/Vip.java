package offline_2nd_revised.product;

public class Vip extends Customer{
    public Vip(double rate) {
        super(rate);
    }
    
    @Override
    public String toString() {
        return "This is a VIP account.";
    }
    
}
