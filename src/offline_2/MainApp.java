package offline_2;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import offline_2.combos.Combo;
import offline_2.menu_items.Burger;
import offline_2.menu_items.Drink;
import offline_2.menu_items.Fries;
import offline_2.menu_items.Shawarma;
import offline_2.menu_items.Wedges;

public class MainApp {
    private static Map<String, Item> menu = new LinkedHashMap<>();

    static{
        menu.put("Burger", new Burger("Burger", 300));
        menu.put("Fries", new Fries("Fries", 100));
        menu.put("Wedges", new Wedges("Wedges", 150));
        menu.put("Shawarma", new Shawarma("Shawarma", 200));
        menu.put("Drink", new Drink("Drink", 25));
    
        Combo comboOne = new Combo("Combo1");
        comboOne.addItem(menu.get("Burger"));
        comboOne.addItem(menu.get("Fries"));
        comboOne.addFreeItem(menu.get("Drink"));
        menu.put("Combo1", comboOne);
        
        Combo comboTwo = new Combo("Combo2");
        comboTwo.addItem(menu.get("Shawarma"));
        comboTwo.addItem(menu.get("Drink"));
        comboTwo.setDiscount((40/9));
        menu.put("Combo2", comboTwo);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu:");
        System.out.println();

        for(String key: menu.keySet()){
            System.out.println(menu.get(key).getDescription());
        }

        while(true) {
            System.out.println("\nPress 1 to create a combo, 2 to view menu, 0 to exit");
            int choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 0) break;
            else if(choice == 1){
                System.out.print("Enter the name of the combo: ");
                String comboName = sc.nextLine();
                Combo customCombo = new Combo(comboName);

                while (true) {
                    System.out.println("\nAvailable commands:");
                    System.out.println("Add [item], \nRemove [item], \nFree [item], \nDiscount [percentage], \nDone");
                    String command = sc.nextLine();

                    if (command.startsWith("Add ")) {
                        String itemName = command.substring(4);
                        Item item = menu.get(itemName);
                        if (item == null) {
                            System.out.println("Item not found");
                        } else {
                            customCombo.addItem(item);
                        }
                    } else if (command.startsWith("Remove ")) {
                        String itemName = command.substring(7);
                        Item item = menu.get(itemName);
                        if (item == null) {
                            System.out.println("Item not found");
                        } else {
                            customCombo.removeItem(item);
                        }
                    } else if (command.startsWith("Free ")) {
                        String itemName = command.substring(5);
                        Item item = menu.get(itemName);
                        if (item == null) {
                            System.out.println("Item not found");
                        } else {
                            customCombo.addFreeItem(item);
                        }
                    } else if (command.startsWith("Discount ")) {
                        double discount = Double.parseDouble(command.substring(9));
                        customCombo.setDiscount(discount);
                    } else if (command.equals("Done")) {
                        menu.put(comboName, customCombo);
                        break;
                    } else{
                        System.out.println("Invalid command");
                    }
                }
                System.out.println("Your combo: ");
                System.out.println();
                System.out.print(customCombo.getFormattedDescription());
            }else if(choice == 2){
                System.out.println("Menu:");
                System.out.println();
                for(String key: menu.keySet()){
                    System.out.println(menu.get(key).getDescription());
                }
            }
        }
        sc.close();
    }
}
