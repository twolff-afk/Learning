package main;

import birds.Bird;
import birds.FlyingBird;
import birds.Penguin;
import license.BusinessLicense;
import license.PersonalLicense;

public class Main {

    public static void main(String[] args) {

        /*
        This is a bad example. The Liskov substitution principle says
        that Subtype and Supertype have to have the same behavior so that
        they are interchangeable.
        This is true for inheritance and code, but it is also true
        on an architectural level.
        So like using MySQL as database should have the same behavior like
        using another database service.
         */
        Bird bird = new Bird("black", "default");
        bird.layingEggs();

        FlyingBird raven = new FlyingBird("black", "raven");
        raven.flying();

        Penguin penguin = new Penguin("black, white", "penguin");
        penguin.swimming();


        /*
        This example is better. BusinessLicense, PersonalLicense and License have all the
        same methods so the behavior is the same.
        Here you could replace an object of type license by an object of type BusinessLicense,
        because businesslicense has the same functions and some in addition.
        So everything in license is still in businesslicense
         */
        BusinessLicense businessLicense = new BusinessLicense("Tobi");
        businessLicense.calcLicenseFee();

        PersonalLicense personalLicense = new PersonalLicense();
        personalLicense.calcLicenseFee();

    }
}
