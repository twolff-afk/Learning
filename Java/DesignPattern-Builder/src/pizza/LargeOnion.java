package pizza;

public class LargeOnion extends VegetarianPizza {

    @Override
    public String getName() {
        return "Large onion pizza";
    }

    @Override
    public String getSize() {
        return "Large pizza";
    }

    @Override
    public float getPrice() {
        return 112.5f;
    }

}
