package main;

import financial.FinancialDataMapper;

public class Main {

    public static void main(String[] args) {

        FinancialDataGateway financialDataGateway = new FinancialDataMapper();

        financialDataGateway.getFinancialEntities();

    }
}
