package pizza;

public class SmallSalami extends NonVegetarianPizza {

    @Override
    public String getName() {
        return "Small salami pizza";
    }

    @Override
    public String getSize() {
        return "Small pizza";
    }

    @Override
    public float getPrice() {
        return 62.5f;
    }

}
