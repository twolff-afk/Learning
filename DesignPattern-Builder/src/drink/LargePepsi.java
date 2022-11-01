package drink;

public class LargePepsi extends Pepsi {

    @Override
    public String getName() {
        return "500 ml Pepsi";
    }

    @Override
    public String getSize() {
        return "Large size";
    }

    @Override
    public float getPrice() {
        return 25.0f;
    }
}
