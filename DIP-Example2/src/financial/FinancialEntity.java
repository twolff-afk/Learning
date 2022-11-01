package financial;

import main.FinancialEntityInterface;

public class FinancialEntity implements FinancialEntityInterface {

    private int id;
    private double amount;
    private String stakeholder;

    public FinancialEntity(int id, double amount, String stakeholder) {
        this.id = id;
        this.amount = amount;
        this.stakeholder = stakeholder;
    }

    @Override
    public void setEntityId(int id) {
        this.id = id;
    }

    @Override
    public int getEntityId() {
        return this.id;
    }

    @Override
    public void setEntityAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public double getEntityAmount() {
        return this.amount;
    }

    @Override
    public void setEntityStakeholder(String stakeholder) {
        this.stakeholder = stakeholder;
    }

    @Override
    public String getEntityStakeholder() {
        return this.stakeholder;
    }
}
