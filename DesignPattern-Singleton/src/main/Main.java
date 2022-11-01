package main;

import singleton.EarlySingleton;
import singleton.LazySingleton;

public class Main {

    /*
    Singleton are good for when only one instance of a class is needed.
    For example database connections or multithread applications.
     */
    public static void main(String[] args) {

        EarlySingleton earlyOne = EarlySingleton.getSingleton();
        EarlySingleton earlyTwo = EarlySingleton.getSingleton();

        System.out.println(earlyOne.getMessage());
        System.out.println(earlyTwo.getMessage());

        LazySingleton lazyOne = LazySingleton.getLazySingleton();
        LazySingleton lazyTwo = LazySingleton.getLazySingleton();

        System.out.println(lazyOne.getMessage());
        System.out.println(lazyTwo.getMessage());


    }

}
