package main;

import calculator.Calculator;

public class Main {

    public static void main(String[] args) {

        Thread calculatorThread = new Thread(new Calculator());
        calculatorThread.start();

    }

}
