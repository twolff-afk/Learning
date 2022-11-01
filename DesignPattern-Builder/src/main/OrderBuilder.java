package main;

import drink.LargeCoke;
import drink.LargePepsi;
import drink.SmallCoke;
import drink.SmallPepsi;
import pizza.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * OrderBuilder has a list of type item and a method to prepare the pizza and cold drink order.
 * Everytime you select something this item is added to the order
 */
public class OrderBuilder {

    public OrderedItems preparePizza() throws IOException {

        OrderedItems itemsOrder = new OrderedItems();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(" Enter the choice of Pizza ");
        System.out.println("============================");
        System.out.println("        1. Veg-Pizza       ");
        System.out.println("        2. Non-Veg Pizza   ");
        System.out.println("        3. Exit            ");
        System.out.println("============================");


        int pizzaAndColdDrinkChoice = Integer.parseInt(bufferedReader.readLine());
        switch(pizzaAndColdDrinkChoice)
        {

            case 1:
            {

                System.out.println("You ordered Veg Pizza");
                System.out.println("\n\n");
                System.out.println(" Enter the types of Veg-Pizza ");
                System.out.println("------------------------------");
                System.out.println("        1.Cheese Pizza        ");
                System.out.println("        2.Onion Pizza        ");
                System.out.println("        4.Exit            ");
                System.out.println("------------------------------");
                int vegetarianPizzaChoice = Integer.parseInt(bufferedReader.readLine());

                switch(vegetarianPizzaChoice)
                {
                    case 1:
                    {
                        System.out.println("You ordered Cheese Pizza");

                        System.out.println("Enter the cheese pizza size");
                        System.out.println("------------------------------------");
                        System.out.println("    1. Small Cheese Pizza ");
                        System.out.println("    2. Large Cheese Pizza ");
                        System.out.println("------------------------------------");
                        int cheesePizzaSize = Integer.parseInt(bufferedReader.readLine());

                        switch (cheesePizzaSize)
                        {
                            case 1:
                                itemsOrder.addItems(new SmallCheese());
                                break;
                            case 2:
                                itemsOrder.addItems(new LargeCheese());
                                break;
                        }

                    }
                    break;

                    case 2:
                    {
                        System.out.println("You ordered Onion Pizza");
                        System.out.println("Enter the Onion pizza size");
                        System.out.println("----------------------------------");
                        System.out.println("    1. Small Onion Pizza ");
                        System.out.println("    2. Large Onion Pizza ");
                        System.out.println("----------------------------------");
                        int onionPizzaSize = Integer.parseInt(bufferedReader.readLine());

                        switch(onionPizzaSize)
                        {
                            case 1:
                                itemsOrder.addItems(new SmallOnion());
                                break;

                            case 2:
                                itemsOrder.addItems(new LargeOnion());
                                break;

                        }
                    }
                    break;


                }

            }
            break;

            case 2:
            {
                System.out.println("You ordered Non-Veg Pizza");
                System.out.println("\n\n");

                System.out.println("Enter the Non-Veg pizza size");
                System.out.println("------------------------------------");
                System.out.println("    1. Small Non-Veg  Pizza ");
                System.out.println("    2. Large Non-Veg  Pizza ");
                System.out.println("------------------------------------");


                int nonVegetarianPizzaSize = Integer.parseInt(bufferedReader.readLine());

                switch(nonVegetarianPizzaSize)
                {

                    case 1:
                        itemsOrder.addItems(new SmallSalami());
                        break;

                    case 2:
                        itemsOrder.addItems(new LargeSalami());
                        break;

                }

            }
            break;
            default:
            {
                break;

            }

        }

            System.out.println(" Enter the choice of ColdDrink ");
            System.out.println("============================");
            System.out.println("        1. Pepsi            ");
            System.out.println("        2. Coke             ");
            System.out.println("        3. Exit             ");
            System.out.println("============================");
            int coldDrink=Integer.parseInt(bufferedReader.readLine());
            switch (coldDrink)
            {
                case 1:
                {
                    System.out.println("You ordered Pepsi ");
                    System.out.println("Enter the  Pepsi Size ");
                    System.out.println("------------------------");
                    System.out.println("    1. Small Pepsi ");
                    System.out.println("    2. Large Pepsi ");
                    System.out.println("------------------------");
                    int pepsiSizeChoice = Integer.parseInt(bufferedReader.readLine());

                    switch(pepsiSizeChoice)
                    {
                        case 1:
                            itemsOrder.addItems(new SmallPepsi());
                            break;

                        case 2:
                            itemsOrder.addItems(new LargePepsi());
                            break;

                    }
                }
                break;
                case 2:
                {
                    System.out.println("You ordered Coke");
                    System.out.println("Enter the Coke Size");
                    System.out.println("------------------------");
                    System.out.println("    1. Small Coke ");
                    System.out.println("    2. Large Coke ");
                    System.out.println("------------------------");

                    int cokesize=Integer.parseInt(bufferedReader.readLine());
                    switch(cokesize)
                    {
                        case 1:
                            itemsOrder.addItems(new SmallCoke());
                            break;

                        case 2:
                            itemsOrder.addItems(new LargeCoke());
                            break;


                    }

                }
                break;
                default:
                {
                    break;

                }

            }
            return itemsOrder;

        }

}
