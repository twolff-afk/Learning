package database;

import interactor.FinancialDataGateway;
import interactor.FinancialEntities;

/**
 * Getting the information from the database, wrap it around it FinancialEntities
 * and give it back to FinancialReportGenerator
 */
public class FinancialDataMapper implements FinancialDataGateway {

    @Override
    public FinancialEntities getOneFinancialEntity() {

        int amount = FinancialDatabase.getSomeAmount();
        String owner = FinancialDatabase.getSomeOwner();

        FinancialEntities entity;
        entity = new FinancialEntities(amount, owner);

        return entity;
    }
}
