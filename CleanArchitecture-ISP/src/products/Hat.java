package products;

public class Hat implements interfaceIdProduct, interfaceHat{

    private int id;
    private double weight;
    private int stock;
    private int hatSize;

    public Hat(int id, double weight, int stock, int hatSize) {
        this.id = id;
        this.weight = weight;
        this.stock = stock;
        this.hatSize = hatSize;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public int getStock() {
        return this.stock;
    }

    @Override
    public void setHatSize(int hatSize) {
        this.hatSize = hatSize;
    }

    @Override
    public int getHatSize() {
        return this.hatSize;
    }

}
