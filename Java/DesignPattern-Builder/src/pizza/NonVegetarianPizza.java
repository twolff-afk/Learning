package pizza;

public abstract class NonVegetarianPizza extends Pizza {

    @Override
    public abstract String getName();

    @Override
    public abstract String getSize();

    @Override
    public abstract float getPrice();

}
