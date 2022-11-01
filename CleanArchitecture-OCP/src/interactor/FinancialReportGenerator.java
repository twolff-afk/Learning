package interactor;

import database.FinancialDataMapper;

public class FinancialReportGenerator implements FinancialReportRequester {

    @Override
    public FinancialReportResponseDS getSomeFinancialReport(FinancialReportRequestDS request) {

        FinancialEntities entity;
        if (request.isWannaReport()) {
            entity = generateSomeReport();
        } else {
            entity = new FinancialEntities();
        }

        FinancialReportResponseDS response = new FinancialReportResponseDS("Report of: " + entity.getOwner() + ", Amount: " + entity.getAmount());

        return response;
    }

    public FinancialEntities generateSomeReport() {

        FinancialDataGateway gateway = new FinancialDataMapper();
        FinancialEntities entity = gateway.getOneFinancialEntity();
        return entity;

    }

}
