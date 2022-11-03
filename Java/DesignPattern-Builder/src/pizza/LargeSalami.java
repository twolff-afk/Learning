package pizza;

public class LargeSalami extends NonVegetarianPizza {

    @Override
    public String getName() {
        return "Large salami pizza";
    }

    @Override
    public String getSize() {
        return "Large pizza";
    }

    @Override
    public float getPrice() {
        return 125.0f;
    }
}
