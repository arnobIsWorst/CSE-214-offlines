package offline_2.menu_items;

public class Drink extends MenuItem{
    public Drink(String name, int price) {
        super(name, price);
    }

    @Override
    public int calculateCost() {
        return getPrice();
    }
}
