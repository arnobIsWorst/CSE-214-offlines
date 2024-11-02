package offline_2.menu_items;

public class Fries extends MenuItem {
    public Fries(String name, int price) {
        super(name, price);
    }

    @Override
    public int calculateCost() {
        return getPrice();
    }
}
