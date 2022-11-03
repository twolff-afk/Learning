package pizza;

public class LargeCheese extends VegetarianPizza {

    @Override
    public String getName() {
        return "Large cheese pizza";
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
