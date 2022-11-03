package drink;

public class LargeCoke extends Coke {

    @Override
    public String getName() {
        return "Large Coke";
    }

    @Override
    public String getSize() {
        return "Large size";
    }

    @Override
    public float getPrice() {
        return 30.0f;
    }
}
