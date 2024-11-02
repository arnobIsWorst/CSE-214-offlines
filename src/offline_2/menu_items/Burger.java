package offline_2.menu_items;

public class Burger extends MenuItem {
    public Burger(String name, int price) {
        super(name, price);
    }
    
    @Override
    public int calculateCost() {
        return getPrice();
    }
}
