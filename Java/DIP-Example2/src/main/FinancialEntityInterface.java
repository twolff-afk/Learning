package main;

public interface FinancialEntityInterface {

    void setEntityId(int id);
    int getEntityId();

    void setEntityAmount(double amount);
    double getEntityAmount();

    void setEntityStakeholder(String stakeholder);
    String getEntityStakeholder();

}
