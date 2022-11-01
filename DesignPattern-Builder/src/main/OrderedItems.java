package main;

import java.util.ArrayList;
import java.util.List;

public class OrderedItems {
    List<Item> items = new ArrayList<Item>();

    public void addItems(Item item){
        items.add(item);
    }

    /**
     * To get the total cost of such a order, go through the order and get each item
     * Then add the price of each item and return the cost
     * @return
     */
    public float getCost(){

        float cost = 0.0f;
        for (Item item : items) {
            cost = cost + item.getPrice();
        }
        return cost;
    }

    public void showItems(){

        for (Item item : items) {
            System.out.println("Item is:" + item.getName());
            System.out.println("Size is:" + item.getSize());
            System.out.println("Price is: " + item.getPrice());
        }
    }

}
