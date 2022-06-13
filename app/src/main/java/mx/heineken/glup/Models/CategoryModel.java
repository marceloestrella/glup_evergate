package mx.heineken.glup.Models;

import java.util.List;

public class CategoryModel extends BaseModel{
    private List<ProductModel> Products;
    public CategoryModel() {
    }

    public CategoryModel(int id, String name, List<ProductModel> products) {
        super(id, name);
        Products = products;
    }

    public List<ProductModel> getProducts() {
        return Products;
    }

    public void setProducts(List<ProductModel> products) {
        Products = products;
    }
}
