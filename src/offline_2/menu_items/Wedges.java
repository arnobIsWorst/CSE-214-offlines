package offline_2.menu_items;

public class Wedges extends MenuItem {
    public Wedges(String name, int price) {
        super(name, price);
    }

    @Override
    public int calculateCost() {
        return getPrice();
    }
}
