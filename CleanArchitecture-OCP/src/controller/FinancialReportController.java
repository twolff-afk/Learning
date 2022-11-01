package controller;

import interactor.FinancialReportGenerator;
import interactor.FinancialReportRequestDS;
import interactor.FinancialReportRequester;
import interactor.FinancialReportResponseDS;
import printPresenter.PrintPresenter;

/**
 * The Controller controls the whole application by sending request
 * to FinancialReportGenerator
 * Interactor and Controller using FinancialReportRequester as interface
 * and two datastructures for exchanging information
 *
 * after getting the financial data the controller calls some methods in direction of
 * the presenter and starts another flow of control to present the data as pdf or on the screen
 */
public class FinancialReportController {

    public static void main(String[] args) {

        FinancialReportRequester requester = new FinancialReportGenerator();
        FinancialReportRequestDS request = new FinancialReportRequestDS(true);
        FinancialReportResponseDS response = requester.getSomeFinancialReport(request);

        FinancialReportPresenter printPresenter = new PrintPresenter();
        printPresenter.presentReport(response);

    }


}
