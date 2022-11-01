package bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BankCustomer extends BankDetails implements CreditCard {

    @Override
    public void giveBankDetails() {

        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter the account holder name :");
            String customerName = bufferedReader.readLine();
            System.out.print("\n");

            System.out.print("Enter the account number:");
            int accountNumber = Integer.parseInt(bufferedReader.readLine());
            System.out.print("\n");

            System.out.print("Enter the bank name :");
            String bankName = bufferedReader.readLine();

            setAccountHolder(customerName);
            setAccountNumber(accountNumber);
            setBankName(bankName);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public String getCreditCard() {

        int accountNumber = getAccountNumber();
        String accountHolder = getAccountHolder();
        String bankName = getBankName();

        return ("The Account number " + accountNumber + " of " + accountHolder + " in " + bankName + " bank is valid and authenticated for issuing the credit card. ");
    }
}
