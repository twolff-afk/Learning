package pizza;

public class SmallCheese extends VegetarianPizza {

    @Override
    public String getName() {
        return "Small cheese pizza";
    }

    @Override
    public String getSize() {
        return "Small pizza";
    }

    @Override
    public float getPrice() {
        return 60.0f;
    }

}
