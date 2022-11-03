package drink;

public class SmallPepsi extends Pepsi {


    @Override
    public String getName() {
        return "300 ml Pepsi";
    }

    @Override
    public String getSize() {
        return "Small size";
    }

    @Override
    public float getPrice() {
        return 12.5f;
    }
}
