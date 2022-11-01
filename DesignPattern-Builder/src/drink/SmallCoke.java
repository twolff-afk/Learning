package drink;

public class SmallCoke extends Coke {


    @Override
    public String getName() {
        return "Small Coke";
    }

    @Override
    public String getSize() {
        return "Small size";
    }

    @Override
    public float getPrice() {
        return 15.0f;
    }
}
