package products;

public class Jeans implements interfaceIdProduct, interfacePants{

    private int id;
    private double weight;
    private int stock;
    private int Inseam;
    private double waistSize;
    public Jeans(int id, double weight, int stock, int Inseam, double waistSize) {
        this.id = id;
        this.weight = weight;
        this.stock = stock;
        this.Inseam = Inseam;
        this.waistSize = waistSize;
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
    public void setInseam(int Inseam) {
        this.Inseam = Inseam;
    }

    @Override
    public int getInseam() {
        return this.Inseam;
    }

    @Override
    public void setWaistsSze(double waistSize) {
        this.waistSize = waistSize;
    }

    @Override
    public double getWaistSize() {
        return this.waistSize;
    }
}
