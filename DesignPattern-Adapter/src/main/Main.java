package main;

import bank.BankCustomer;
import bank.CreditCard;

/*
The adapter pattern is used to make an object or else compatible with something
Here the bankDetails class provides a lot of information, but we need something like a credit card
so we create the interface creditCard and the new class bankcustomer and implement some new methods
which fulfill our needs.
Which is an adapter
 */
public class Main {

    public static void main(String args[]){

        CreditCard targetInterface = new BankCustomer();
        targetInterface.giveBankDetails();
        System.out.print(targetInterface.getCreditCard());

    }

}
