package offline_2.combos;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import offline_2.Item;
import offline_2.menu_items.MenuItem;

public class Combo implements Item{
    private final String name;
    private List<Item> children;
    private List<Item> freeItems;
    private double discount;

    public Combo(String name){
        this.name = name;
        this.children = new ArrayList<>();
        this.freeItems = new ArrayList<>();
        this.discount = 0;
    }

    public void addItem(Item item){
        children.add(item);
    }

    public void removeItem(Item item){
        children.remove(item);
    }

    public void addFreeItem(Item item){
        freeItems.add(item);
    }

    public void setDiscount(double discount){
        this.discount = discount;
    }

    private String getDescriptionBoilerPlate(){
        StringBuilder description = new StringBuilder(name + "(");
        Iterator<Item> iterator = children.iterator();
        while (iterator.hasNext()){
            Item item = iterator.next();
                if (item instanceof Combo){ 
                    description.append(((Combo) item).name);
                }else{
                    description.append(((MenuItem) item).getName());
                }
            if (iterator.hasNext() || !freeItems.isEmpty()){
                description.append(" + ");
            }
        }

        iterator = freeItems.iterator();
        while (iterator.hasNext()){
            Item item = iterator.next();
            description.append(((MenuItem) item).getName());
            if (iterator.hasNext()){
                description.append(" + ");
            }
        }
        description.append(")");
        return description.toString();
    }

    private double totalCost(){
        double cost = 0;
        for (Item item : children) {
            cost += item.calculateCost();
        }
        return cost;
    }

    @Override
    public String getDescription(){
        StringBuilder description = new StringBuilder(getDescriptionBoilerPlate());
        description.append(" - " + calculateCost() + "tk");
        return description.toString();
    }

    public String getFormattedDescription(){
        StringBuilder description = new StringBuilder(this.name+"\n");
        for (Item item : this.children) {
            description.append("\t- ");
            if (item instanceof Combo){
                description.append(((Combo) item).getDescriptionBoilerPlate());
            } else {
                description.append(((MenuItem) item).getName());
            }
            description.append("\n");
        }

        for (Item item : this.freeItems) {
            description.append("\t- ");
            description.append(((MenuItem) item).getName()+" (Free!!!)\n");
        }
        description.append("Total - " + (int)totalCost() + "\n");
        description.append("Discount - " + (int)discount + "%\n");
        description.append("Discounted Total - " + calculateCost() + "\n");
        return description.toString();
    }

    @Override
    public int calculateCost(){
        double cost = totalCost();
        int netCost = (int) Math.ceil(cost * (1 - discount / 100));
        return netCost;
    }
}
