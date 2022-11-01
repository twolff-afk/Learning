package interactor;

/**
 * This class acts as a object class which is used by FinancialReportGenerator
 * and the FinancialDataMapper and appears in functions as parameters and return values
 */
public class FinancialEntities {

    private int amount;
    private String owner;

    public FinancialEntities() {
        this.amount = 0;
        this.owner = "";
    }

    public FinancialEntities(int amount, String owner) {
        this.amount = amount;
        this.owner = owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }


}
