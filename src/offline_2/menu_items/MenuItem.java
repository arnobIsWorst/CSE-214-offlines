package offline_2.menu_items;
import offline_2.Item;

public abstract class MenuItem implements Item {
    private final String name;
    private final int price;

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription(){
        return name + " - " + price+"tk";
    }
}
