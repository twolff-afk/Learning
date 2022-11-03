package pizza;

public class SmallOnion extends VegetarianPizza {

    @Override
    public String getName() {
        return "Small onion pizza";
    }

    @Override
    public String getSize() {
        return "Small pizza";
    }

    @Override
    public float getPrice() {
        return 50.0f;
    }

}
