package calculator;

import java.util.Scanner;

public class Calculator implements Runnable {

    @Override
    public void run() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number: ");
        int firstNumber = scanner.nextInt();

        System.out.println("Enter the next number: ");
        int secondNumber = scanner.nextInt();

        System.out.println("Enter the operation, e.g. +, -, / : ");

        String operation = scanner.nextLine();

        switch (operation) {

            case "+":
                int sum = add(firstNumber, secondNumber);
                System.out.print(sum);
                break;

            case "-":
                int minuend = subtract(firstNumber, secondNumber);
                System.out.println(minuend);


        }

    }

    public int add(int firstAddend, int secondAddend) {
        return firstAddend + secondAddend;
    }

    public int subtract(int firstSubtrahend, int secondSubtrahend) {
        return firstSubtrahend - secondSubtrahend;
    }

}
