package mx.heineken.glup.Models;

public class ProductModel extends BaseModel{
    private double Price;

    public ProductModel() {
    }

    public ProductModel(int id, String name, double price) {
        super(id, name);
        Price = price;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
