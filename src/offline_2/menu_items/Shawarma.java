package offline_2.menu_items;

public class Shawarma extends MenuItem {
    public Shawarma(String name, int price) {
        super(name, price);
    }

    @Override
    public int calculateCost() {
        return getPrice();
    }
}
