package main;

import products.Hat;
import products.Jeans;

public class Main {

    /*
    Here is an example for the interface segregation principle. It simple means that you should
    not develop one big interface and the class who implements this interfaces relies on things
    that this class does not need.
    It is better to separate those things into more interfaces and let the class implements all of them

    Here IdProduct are general things about a product, but more specific there are things for jeans and hats
    those specific things are implemented into several interfaces
     */
    public static void main(String[] args) {

        Jeans jeans = new Jeans(10, 10.1, 1, 5, 99.0);
        jeans.setWeight(20.2);
        System.out.println(jeans.getWeight());

        Hat hat = new Hat(5, 1.0, 100, 3);
        System.out.println(hat.getWeight());

    }

}
