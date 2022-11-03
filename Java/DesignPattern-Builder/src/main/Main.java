package main;

import java.io.IOException;

/*
The Builder design pattern is good for separation of construction and representation of objects
Here we have on one side the construction process (OrderBuilder and OrderItems) and on the
other side the representation of these objects.
 */

public class Main {

    public static void main(String[] args) throws IOException {

        OrderBuilder builder = new OrderBuilder();

        OrderedItems orderedItems = builder.preparePizza();

        orderedItems.showItems();

        System.out.println("\n");
        System.out.println("Total Cost : "+ orderedItems.getCost());

    }

}
