package main;

import iteratorExample.CollectionOfNames;
import iteratorExample.Iterator;

/*
Man erstellt eine Klasse, hier eine Collection und kreiert in dieser eine inner class, die ein Iterator ist
Wenn man nun darauf zugreifen will, dann ruft man die Methode getIterator auf und diese erzeugt eine neue Instanz des Iterators
Anschließend benutzt man die üblichen Methoden wie hasNext oder next, um durch die Collection durch zu steppen

 */
public class Main {

    public static void main(String[] args) {

        CollectionOfNames companyRepository = new CollectionOfNames();

        for (Iterator iterator = companyRepository.getIterator(); iterator.hasNext(); ) {
            String name = (String) iterator.next();

            System.out.println(name);

        }

    }

}
